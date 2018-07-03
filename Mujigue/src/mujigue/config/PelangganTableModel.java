package mujigue.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import mujigue.model.Pelanggan;

public class PelangganTableModel extends AbstractTableModel {

    private List<Pelanggan> listPelanggan = new ArrayList<>();
    private final String HEADER[] = {"Nama Pelanggan", "Total Pelanggan", "No. HP", "Waktu Booking"};

    public PelangganTableModel(List<Pelanggan> listPelanggan) {
        this.listPelanggan = listPelanggan;
    }

    @Override
    public int getRowCount() {
        return listPelanggan.size();
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
        Pelanggan pelanggan = listPelanggan.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return pelanggan.getNamaPelanggan();
            case 1:
                return pelanggan.getTotalPelanggan();
            case 2:
                return pelanggan.getNoTelp();
            case 3:
                return pelanggan.getWaktuBooking();

            default:
                return null;
        }
    }

}
