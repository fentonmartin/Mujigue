/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.service;

import mujigue.dao.*;
import java.util.List;
import mujigue.model.Pelanggan;

/**
 *
 * @author herma
 */
public interface PelangganService {
    public void savePelanggan(Pelanggan pelanggan);
    public void updatePelanggan(Pelanggan pelanggan);
    public void deletePelanggan(Pelanggan pelanggan);
    public List<Pelanggan> getDaftarPelanggan();
}
