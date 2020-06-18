/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ĐỨC DUY
 */
public class HoaDon {

    private int mahd;
    private String ngayBan;
    private int manv;
    private int makh;

    public HoaDon(int mahd, int makh, String ngayBan, int manv) {
        this.mahd = mahd;
        this.makh = makh;
        this.ngayBan = ngayBan;
        this.manv = manv;
    }

    public HoaDon() {

    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }
}
