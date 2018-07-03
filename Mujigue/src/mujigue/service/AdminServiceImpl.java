/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.service;

import java.util.List;
import mujigue.dao.AdminDao;
import mujigue.dao.AdminDao;
import mujigue.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author herma
 */
@Service("AdminService")
@Transactional(readOnly = false)
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    public void saveAdmin(Admin admin) {
        adminDao.saveAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDao.deleteAdmin(admin);
    }

    @Override
    public List<Admin> getAdmin() {
        return adminDao.getAdmin();
    }
    
}
