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
import mujigue.config.PelangganTableModel;
import mujigue.model.Pelanggan;
import mujigue.utils.SMSGateway;
import mujigue.view.WaitingListForm;
import org.smslib.OutboundMessage;

/**
 *
 * @author herma
 */
public class WaitingListController {

    private final WaitingListForm wlf;
    private List<Pelanggan> listPelanggan;

    public WaitingListController(WaitingListForm wlf) {
        this.wlf = wlf;
    }

    public void showData() {
        listPelanggan = App.getPelangganService().getDaftarPelanggan();
        this.wlf.getTblWaitingList().setModel(new PelangganTableModel(listPelanggan));
        System.out.println(listPelanggan.size());
    }

    public void savePelanggan() {
        Pelanggan p = new Pelanggan();
        p.setNamaPelanggan(this.wlf.getEdtNamaPel().getText().toString().trim());
        p.setTotalPelanggan(Integer.parseInt(this.wlf.getEdtTotalPel().getText().toString().trim()));
        p.setNoTelp(this.wlf.getEdtNoPel().getText().toString().trim());
        p.setWaktuBooking(new Date());
        App.getPelangganService().savePelanggan(p);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        showData();
        resetform();

    }

    public void editPelanggan() {
        Pelanggan p = new Pelanggan();
        p.setId_pelanggan(listPelanggan.get(this.wlf.getTblWaitingList().getSelectedRow()).getId_pelanggan());
        p.setNamaPelanggan(this.wlf.getEdtNamaPel().getText().toString().trim());
        p.setTotalPelanggan(Integer.parseInt(this.wlf.getEdtTotalPel().getText().toString().trim()));
        p.setNoTelp(this.wlf.getEdtNoPel().getText().toString().trim());
        App.getPelangganService().updatePelanggan(p);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        showData();
        resetform();
    }

    public void deletePelanggan() {
        listPelanggan = App.getPelangganService().getDaftarPelanggan();
        Pelanggan p = listPelanggan.get(this.wlf.getTblWaitingList().getSelectedRow());
        int confirm = JOptionPane.showConfirmDialog(this.wlf, "Apakah anda yakin ingin menghapus data dengan nama : " + p.getNamaPelanggan(),
                "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            App.getPelangganService().deletePelanggan(p);
            JOptionPane.showMessageDialog(this.wlf, "Buku Telah Berhasil Dihapus !", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        resetform();
        showData();

    }

    public void getPelannggan() throws ParseException {
        //this.pasienView.getBtnInputPasien().setEnabled(false);
        this.wlf.getBtnTambahAntrian().setEnabled(false);
        this.wlf.getBtnEditAntrian().setEnabled(true);
        this.wlf.getBtnHapusAntrian().setEnabled(true);
        this.wlf.getBtnInfokanPel().setEnabled(true);

        int idx = this.wlf.getTblWaitingList().getSelectedRow();
        this.wlf.getEdtNamaPel().setText(
                String.valueOf(this.wlf.getTblWaitingList()
                        .getValueAt(idx, 0)));
        this.wlf.getEdtTotalPel().setText(
                String.valueOf(this.wlf.getTblWaitingList()
                        .getValueAt(idx, 1)));
        this.wlf.getEdtNoPel().setText(
                String.valueOf(this.wlf.getTblWaitingList()
                        .getValueAt(idx, 2)));
    }

    public void infokanPelanggan() {
        SMSGateway app = new SMSGateway();
        String message = "Halo, " + this.wlf.getEdtNamaPel().getText().trim()
                + " Terimakasih telah menunggu sebagai Waiting List pada Mujigue. Meja Kosong sudah menanti anda :)";
        int confirm = JOptionPane.showConfirmDialog(this.wlf, "Infokan Pelanggan ada Bangku Kosong ? : ",
                "Confirm Send Message", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                app.setConfiguration("COM11", 9600, "Huawei", "E153", "0000", "+628315000032");
                OutboundMessage msg = app.sendMessage(this.wlf.getEdtNoPel().getText().trim(), message);
                System.out.println("Status SMS : " + msg.getMessageStatus());
                JOptionPane.showMessageDialog(this.wlf, "Status Pesan : " + msg.getMessageStatus(), "Status Pengiriman Pesan", JOptionPane.INFORMATION_MESSAGE);
                Pelanggan p = listPelanggan.get(this.wlf.getTblWaitingList().getSelectedRow());
                App.getPelangganService().deletePelanggan(p);
                resetform();
                showData();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resetform() {
        this.wlf.getBtnTambahAntrian().setEnabled(true);
        this.wlf.getBtnEditAntrian().setEnabled(false);
        this.wlf.getBtnHapusAntrian().setEnabled(false);
        this.wlf.getBtnInfokanPel().setEnabled(false);

        this.wlf.getEdtNamaPel().setText("");
        this.wlf.getEdtNoPel().setText("");
        this.wlf.getEdtTotalPel().setText("");
    }

}
