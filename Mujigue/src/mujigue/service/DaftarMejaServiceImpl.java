/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.service;

import java.util.List;
import mujigue.dao.DaftarMejaDao;
import mujigue.dao.DaftarMejaDao;
import mujigue.model.DaftarMeja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author herma
 */
@Service("DaftarMejaService")
@Transactional(readOnly = false)
public class DaftarMejaServiceImpl implements DaftarMejaService{
    @Autowired
    private DaftarMejaDao daftarMejaDao;
    @Override
    public void saveDaftarMeja(DaftarMeja daftarMeja) {
        daftarMejaDao.saveDaftarMeja(daftarMeja);
    }

    @Override
    public void updateDaftarMeja(DaftarMeja daftarMeja) {
        daftarMejaDao.updateDaftarMeja(daftarMeja);
    }

    @Override
    public void deleteDaftarMeja(DaftarMeja daftarMeja) {
        daftarMejaDao.deleteDaftarMeja(daftarMeja);
    }

    @Override
    public List<DaftarMeja> getDaftarMeja() {
        return daftarMejaDao.getDaftarMeja();
    }
    
}
