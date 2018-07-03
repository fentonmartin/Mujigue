/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.dao;

import java.util.List;
import mujigue.model.Pelanggan;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author herma
 */
@Repository
public class PelangganDaoImpl implements PelangganDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void savePelanggan(Pelanggan pelanggan) {
        sessionFactory.getCurrentSession().save(pelanggan);
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) {
        sessionFactory.getCurrentSession().update(pelanggan);
    }

    @Override
    public void deletePelanggan(Pelanggan pelanggan) {
        sessionFactory.getCurrentSession().delete(pelanggan);
    }

    @Override
    public List<Pelanggan> getDaftarPelanggan() {
        return sessionFactory.getCurrentSession().createCriteria(Pelanggan.class).addOrder(Order.desc("waktuBooking")).list();
    }
    
}
