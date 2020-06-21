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
public class AccountSession {
    
    public static int manv;
    public static String taikhoan;
    public static boolean admin;

    public static boolean isAdmin() {
        return admin;
    }

    public static void setAdmin(boolean admin) {
        AccountSession.admin = admin;
    }

    

    public static int getManv() {
        return manv;
    }

    public static void setManv(int manv) {
        AccountSession.manv = manv;
    }
    public static String getTaikhoan() {
        return taikhoan;
    }

    public static void setTaikhoan(String taikhoan) {
        AccountSession.taikhoan = taikhoan;
    }
    
}
