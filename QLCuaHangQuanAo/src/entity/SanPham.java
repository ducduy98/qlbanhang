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
public class SanPham {

    private int masp;
    private String tensp;
    private int soluong;
    private float dongia;
    private int soluongTon;
    private float chietkhau;
    private int maLoaiHang;
    private int maNCC;

    public SanPham(int masp, String tensp, int soluong, float dongia, int soluongTon, float chietkhau, int maLoaiHang, int maNCC) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.soluongTon = soluongTon;
        this.chietkhau = chietkhau;
        this.maLoaiHang = maLoaiHang;
        this.maNCC = maNCC;
    }

    public SanPham(String tensp, int soluong, float dongia, int soluongTon, float chietkhau, int maLoaiHang, int maNCC) {
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.soluongTon = soluongTon;
        this.chietkhau = chietkhau;
        this.maLoaiHang = maLoaiHang;
        this.maNCC = maNCC;
    }

    public SanPham() {
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public int getSoluongTon() {
        return soluongTon;
    }

    public void setSoluongTon(int soluongTon) {
        this.soluongTon = soluongTon;
    }

    public float getChietkhau() {
        return chietkhau;
    }

    public void setChietkhau(float chietkhau) {
        this.chietkhau = chietkhau;
    }

    public int getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(int maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    @Override
    public String toString() {
        return "SanPham{" + "masp=" + masp + ", tensp=" + tensp + ", soluong=" + soluong + ", dongia=" + dongia + ", soluongTon=" + soluongTon + ", chietkhau=" + chietkhau + ", maLoaiHang=" + maLoaiHang + ", maNCC=" + maNCC + '}';
    }
    
}
