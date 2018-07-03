/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.app;

import mujigue.service.AdminService;
import mujigue.service.DaftarMejaService;
import mujigue.service.PelangganService;
import mujigue.view.MainForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author herma
 */ 
public class App {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext
                = new ClassPathXmlApplicationContext("spring-configuration.xml");
       new MainForm().setVisible(true);

    }

    public static PelangganService getPelangganService() {
        return (PelangganService) applicationContext.getBean("PelangganService");
    }
    public static DaftarMejaService getDaftarMejaService() {
        return (DaftarMejaService) applicationContext.getBean("DaftarMejaService");
    }
    public static AdminService getAdminService() {
        return (AdminService) applicationContext.getBean("AdminService");
    }

}
