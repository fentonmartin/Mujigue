/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.service;

import java.util.List;
import mujigue.dao.PelangganDao;
import mujigue.model.Pelanggan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author herma
 */
@Service("PelangganService")
@Transactional(readOnly = false)
public class PelangganServiceImpl implements PelangganService{
    @Autowired
    private PelangganDao pelangganDao;
    
    @Override
    public void savePelanggan(Pelanggan pelanggan) {
        pelangganDao.savePelanggan(pelanggan);
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) {
        pelangganDao.updatePelanggan(pelanggan);
    }

    @Override
    public void deletePelanggan(Pelanggan pelanggan) {
        pelangganDao.deletePelanggan(pelanggan);
    }

    @Override
    public List<Pelanggan> getDaftarPelanggan() {
        return pelangganDao.getDaftarPelanggan();
    }
    
}
