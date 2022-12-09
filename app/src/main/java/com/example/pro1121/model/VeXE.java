package com.example.pro1121.model;

public class VeXe {
    private String idVeXe,diemDen,diemDi,gia,gioChuyenDi,gioDatVe,soLuongChoDat,soXe,viTriGhe;

    public VeXe() {
    }

    public VeXe(String idVeXe,String diemDen, String diemDi, String gia, String gioChuyenDi, String gioDatVe, String soLuongChoDat, String soXe, String viTriGhe) {
        this.idVeXe= idVeXe;
        this.diemDen = diemDen;
        this.diemDi = diemDi;
        this.gia = gia;
        this.gioChuyenDi = gioChuyenDi;
        this.gioDatVe = gioDatVe;
        this.soLuongChoDat = soLuongChoDat;
        this.soXe = soXe;
        this.viTriGhe = viTriGhe;
    }

    public String getIdVeXe() {
        return idVeXe;
    }

    public void setIdVeXe(String idVeXe) {
        this.idVeXe = idVeXe;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getGioChuyenDi() {
        return gioChuyenDi;
    }

    public void setGioChuyenDi(String gioChuyenDi) {
        this.gioChuyenDi = gioChuyenDi;
    }

    public String getGioDatVe() {
        return gioDatVe;
    }

    public void setGioDatVe(String gioDatVe) {
        this.gioDatVe = gioDatVe;
    }

    public String getSoLuongChoDat() {
        return soLuongChoDat;
    }

    public void setSoLuongChoDat(String soLuongChoDat) {
        this.soLuongChoDat = soLuongChoDat;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public String getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(String viTriGhe) {
        this.viTriGhe = viTriGhe;
    }
}
