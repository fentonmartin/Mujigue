/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author herma
 */
@Entity
@Table(name = "Pelanggan")
public class Pelanggan implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pelanggan")
    private int id_pelanggan;
    
    @Column(name = "namaPelanggan", length = 700)
    private String namaPelanggan;
    
    @Column(name = "totalPelanggan")
    private int totalPelanggan;
    
    @Column(name = "noTelp",length = 12)
    private String noTelp;
    
    @CreationTimestamp
    @Column(name = "waktuBooking",updatable=false,nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuBooking;

    
    /**
     * @return the id_pelanggan
     */
    public int getId_pelanggan() {
        return id_pelanggan;
    }

    /**
     * @param id_pelanggan the id_pelanggan to set
     */
    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    /**
     * @return the namaPelanggan
     */
    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    /**
     * @param namaPelanggan the namaPelanggan to set
     */
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    /**
     * @return the totalPelanggan
     */
    public int getTotalPelanggan() {
        return totalPelanggan;
    }

    /**
     * @param totalPelanggan the totalPelanggan to set
     */
    public void setTotalPelanggan(int totalPelanggan) {
        this.totalPelanggan = totalPelanggan;
    }

    /**
     * @return the noTelp
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * @param noTelp the noTelp to set
     */
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    /**
     * @return the waktuBooking
     */
    public Date getWaktuBooking() {
        return waktuBooking;
    }

    /**
     * @param waktuBooking the waktuBooking to set
     */
    public void setWaktuBooking(Date waktuBooking) {
        this.waktuBooking = waktuBooking;
    }


    
}
