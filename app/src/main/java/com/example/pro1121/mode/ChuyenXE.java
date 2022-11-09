package com.example.pro1121.mode;

import java.io.Serializable;

public class ChuyenXE implements Serializable {
    int id;
    String idchuyenxe,diemden,diemdi,gio,soxe;


    public ChuyenXE() {
    }

    public ChuyenXE(int id, String diemden, String diemdi, String gio, String soxe) {
        this.id = id;
        this.diemden = diemden;
        this.diemdi = diemdi;
        this.gio = gio;
        this.soxe = soxe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdchuyenxe() {
        return idchuyenxe;
    }

    public void setIdchuyenxe(String idchuyenxe) {
        this.idchuyenxe = idchuyenxe;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

    public String getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getSoxe() {
        return soxe;
    }

    public void setSoxe(String soxe) {
        this.soxe = soxe;
    }
}
