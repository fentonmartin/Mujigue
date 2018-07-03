/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.dao;

import java.util.List;
import mujigue.model.DaftarMeja;

/**
 *
 * @author herma
 */
public interface DaftarMejaDao {
    public void saveDaftarMeja(DaftarMeja daftarMeja);
    public void updateDaftarMeja(DaftarMeja daftarMeja);
    public void deleteDaftarMeja(DaftarMeja daftarMeja);
    public List<DaftarMeja> getDaftarMeja();
}
