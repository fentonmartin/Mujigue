/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.controller;

import javax.swing.JOptionPane;
import mujigue.app.App;
import mujigue.model.DaftarMeja;
import mujigue.view.MejaForm;

/**
 *
 * @author herma
 */
public class MejaFormController {

    private final MejaForm mf;

    public MejaFormController(MejaForm mf) {
        this.mf = mf;
    }

    public void saveMeja() {
        DaftarMeja dm = new DaftarMeja();
        dm.setNo_meja(Integer.parseInt(this.mf.getEdtNoMeja().getText().toString()));
        dm.setKapasitas_meja(Integer.parseInt(this.mf.getEdtKapasitasMeja().getText().toString()));
        dm.setLokasiMeja(this.mf.getEdtLokasiMeja().getText().toString());
        App.getDaftarMejaService().saveDaftarMeja(dm);
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
        mf.dispose();
    }
}
