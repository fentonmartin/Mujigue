/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author herma
 */
@Entity
@Table(name = "DaftarMeja")
public class DaftarMeja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_meja")
    private int id_meja;
    @Column(name = "no_meja")
    private int no_meja;
    @Column(name = "kapasitas_meja")
    private int kapasitas_meja;
    @Column(name = "lokasiMeja", length = 700)
    private String lokasiMeja;
    @Column(nullable = false, columnDefinition = "TINYINT default = 0", length = 1)
    private boolean terisi;

    /**
     * @return the id_meja
     */
    public int getId_meja() {
        return id_meja;
    }

    /**
     * @param id_meja the id_meja to set
     */
    public void setId_meja(int id_meja) {
        this.id_meja = id_meja;
    }

    /**
     * @return the no_meja
     */
    public int getNo_meja() {
        return no_meja;
    }

    /**
     * @param no_meja the no_meja to set
     */
    public void setNo_meja(int no_meja) {
        this.no_meja = no_meja;
    }

    /**
     * @return the kapasitas_meja
     */
    public int getKapasitas_meja() {
        return kapasitas_meja;
    }

    /**
     * @param kapasitas_meja the kapasitas_meja to set
     */
    public void setKapasitas_meja(int kapasitas_meja) {
        this.kapasitas_meja = kapasitas_meja;
    }

    /**
     * @return the lokasiMeja
     */
    public String getLokasiMeja() {
        return lokasiMeja;
    }

    /**
     * @param lokasiMeja the lokasiMeja to set
     */
    public void setLokasiMeja(String lokasiMeja) {
        this.lokasiMeja = lokasiMeja;
    }

    /**
     * @return the terisi
     */
    public boolean isTerisi() {
        return terisi;
    }

    /**
     * @param terisi the terisi to set
     */
    public void setTerisi(boolean terisi) {
        this.terisi = terisi;
    }

}
