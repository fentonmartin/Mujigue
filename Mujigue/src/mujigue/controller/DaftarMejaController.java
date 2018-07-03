/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mujigue.app.App;
import mujigue.config.MejaTableModel;
import mujigue.config.PelangganTableModel;
import mujigue.model.DaftarMeja;
import mujigue.model.Pelanggan;
import mujigue.view.DaftarMejaForm;

/**
 *
 * @author herma
 */
public class DaftarMejaController {

    private final DaftarMejaForm dmf;
    private List<DaftarMeja> daftarMeja;

    public DaftarMejaController(DaftarMejaForm dmf) {
        this.dmf = dmf;
    }

    public void showData() {
        daftarMeja = App.getDaftarMejaService().getDaftarMeja();
        this.dmf.getTblDaftarMeja().setModel(new MejaTableModel(daftarMeja));
        System.out.println(daftarMeja.size());
    }

    public void saveMeja() {

        //  App.getPelangganService().savePelanggan(p);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        showData();
        //resetform();

    }

    public void getMeja() {
        //this.pasienView.getBtnInputPasien().setEnabled(false);
        this.dmf.getBtnTambahMeja().setEnabled(false);
        this.dmf.getBtnHapusMeja().setEnabled(true);
        this.dmf.getBtnUbahStatusTerisi().setEnabled(true);

//        int idx = this.dmf.getTblDaftarMeja().getSelectedRow();
//        this.dmf.get().setText(
//                String.valueOf(this.wlf.getTblWaitingList()
//                        .getValueAt(idx, 0)));
//        this.wlf.getEdtTotalPel().setText(
//                String.valueOf(this.wlf.getTblWaitingList()
//                        .getValueAt(idx, 1)));
//        this.wlf.getEdtNoPel().setText(
//                String.valueOf(this.wlf.getTblWaitingList()
//                        .getValueAt(idx, 2)));
    }

    public void editStatusMeja() {
        daftarMeja = App.getDaftarMejaService().getDaftarMeja();
        DaftarMeja dm = daftarMeja.get(this.dmf.getTblDaftarMeja().getSelectedRow());
        dm.setTerisi((dm.isTerisi()) ? false : true);
        App.getDaftarMejaService().updateDaftarMeja(dm);
        JOptionPane.showMessageDialog(null, "Status meja nomor " + dm.getNo_meja() + " Berhasil Diubah", "Info", JOptionPane.INFORMATION_MESSAGE);
        showData();
    }

    public void clear() {
        this.dmf.getBtnTambahMeja().setEnabled(true);
        this.dmf.getBtnHapusMeja().setEnabled(false);
        this.dmf.getBtnUbahStatusTerisi().setEnabled(false);
        this.dmf.getTblDaftarMeja().clearSelection();
    }

    public void deleteMeja() {
        daftarMeja = App.getDaftarMejaService().getDaftarMeja();
        DaftarMeja dm = daftarMeja.get(this.dmf.getTblDaftarMeja().getSelectedRow());
        int confirm = JOptionPane.showConfirmDialog(this.dmf, "Apakah anda yakin ingin menghapus data dengan nomor meja : " + dm.getNo_meja(),
                "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            App.getDaftarMejaService().deleteDaftarMeja(dm);
            JOptionPane.showMessageDialog(this.dmf, "Buku Telah Berhasil Dihapus !", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        showData();

    }

}
