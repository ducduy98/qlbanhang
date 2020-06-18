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
public class NhaCungCap {

    private String tenNCC;
    private String diachi;
    private int maNCC;

    public NhaCungCap() {
    }

    public NhaCungCap(String tenNCC, int maNCC) {
        this.tenNCC = tenNCC;
        this.maNCC = maNCC;
    }

    public NhaCungCap(int maNCC, String tenNCC, String diachi) {
        this.tenNCC = tenNCC;
        this.diachi = diachi;
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    @Override
    public String toString() {
        return tenNCC;
    }

    
    
}
