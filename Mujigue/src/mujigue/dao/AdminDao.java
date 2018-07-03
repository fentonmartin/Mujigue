/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.dao;

import java.util.List;
import mujigue.model.Admin;

/**
 *
 * @author herma
 */
public interface AdminDao {

    public void saveAdmin(Admin admin);

    public void updateAdmin(Admin admin);

    public void deleteAdmin(Admin admin);

    public List<Admin> getAdmin();
    
    public void loginAdmin(String username,String Password);
}
