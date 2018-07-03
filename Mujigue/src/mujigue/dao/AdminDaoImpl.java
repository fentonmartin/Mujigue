/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.dao;

import java.util.List;
import mujigue.model.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author herma
 */
@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveAdmin(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        sessionFactory.getCurrentSession().update(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        sessionFactory.getCurrentSession().delete(admin);
    }

    @Override
    public List<Admin> getAdmin() {
        return sessionFactory.getCurrentSession().createCriteria(Admin.class).list();
    }

    @Override
    public void loginAdmin(String username, String Password) {
        
    }
    
    
}
