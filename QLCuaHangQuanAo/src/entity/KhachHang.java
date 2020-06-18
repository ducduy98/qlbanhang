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
public class KhachHang {

    private int makh;
    private String tenkh;
    private String sdt;
    private String diachi;

    public KhachHang(int makh, String tenkh, String sdt, String diachi) {
        this.tenkh = tenkh;
        this.sdt = sdt;
        this.makh = makh;
        this.diachi = diachi;
    }

    public KhachHang() {

    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
