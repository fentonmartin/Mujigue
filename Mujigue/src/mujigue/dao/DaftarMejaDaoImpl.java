/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.dao;

import java.util.List;
import mujigue.model.DaftarMeja;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author herma
 */
@Repository
public class DaftarMejaDaoImpl implements DaftarMejaDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void saveDaftarMeja(DaftarMeja daftarMeja) {
        sessionFactory.getCurrentSession().save(daftarMeja);
    }

    @Override
    public void updateDaftarMeja(DaftarMeja daftarMeja) {
        sessionFactory.getCurrentSession().update(daftarMeja);
    }

    @Override
    public void deleteDaftarMeja(DaftarMeja daftarMeja) {
        sessionFactory.getCurrentSession().delete(daftarMeja);
    }

    @Override
    public List<DaftarMeja> getDaftarMeja() {
        return sessionFactory.getCurrentSession().createCriteria(DaftarMeja.class).list();
    }
    
}
