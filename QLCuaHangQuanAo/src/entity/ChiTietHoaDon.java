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
public class ChiTietHoaDon {

    private int mahd;
    private int masp;
    private int soluongban;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int mahd, int masp, int soluongban) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluongban = soluongban;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }

}
