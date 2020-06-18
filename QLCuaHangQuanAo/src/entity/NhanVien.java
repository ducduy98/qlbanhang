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
public class NhanVien {

    private int manv;
    private String tennv;
    private String diachi;
    private String sdt;
    private String tentk;
    private String pass;
    private boolean isadmin;

    public NhanVien() {
    }

    public NhanVien(int manv, String tentk, boolean isadmin) {
        this.manv = manv;
        this.tentk = tentk;
        this.isadmin = isadmin;
    }

    public NhanVien(int manv, String tennv, String diachi, String sdt, String tentk, String pass, boolean isadmin) {
        this.manv = manv;
        this.tennv = tennv;
        this.diachi = diachi;
        this.sdt = sdt;
        this.tentk = tentk;
        this.pass = pass;
        this.isadmin = isadmin;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
    
}
