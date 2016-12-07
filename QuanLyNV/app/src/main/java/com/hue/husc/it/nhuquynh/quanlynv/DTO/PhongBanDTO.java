package com.hue.husc.it.nhuquynh.quanlynv.DTO;

/**
 * Created by Admin on 10/20/2016.
 */
public class PhongBanDTO {
    private String maPhongBan;
    private String tenPhongBan;
    private int soNhanVien;

    public PhongBanDTO(){

    }

    public PhongBanDTO(String maPhongBan, String tenPhongBan, int soNhanVien) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.soNhanVien = soNhanVien;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public int getSoNhanVien() {
        return 0;
    }


}
