package mujigue.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import mujigue.model.DaftarMeja;
import mujigue.model.Pelanggan;

public class MejaTableModel extends AbstractTableModel {

    private List<DaftarMeja> daftarMeja = new ArrayList<>();
    private final String HEADER[] = {"No Meja", "Kapasitas Meja", "Lokasi Meja", "Status Terisi"};

    public MejaTableModel(List<DaftarMeja> daftarMeja) {
        this.daftarMeja = daftarMeja;
    }


    @Override
    public int getRowCount() {
        return daftarMeja.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return HEADER[columnIndex];
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DaftarMeja dm = daftarMeja.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return dm.getNo_meja();
            case 1:
                return dm.getKapasitas_meja();
            case 2:
                return dm.getLokasiMeja();
            case 3:
                return dm.isTerisi();

            default:
                return null;
        }
    }

}
