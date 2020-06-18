/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlcuahangquanao;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import view.AdminScreen;
import view.DangNhapScreen;

/**
 *
 * @author ĐỨC DUY
 */
public class QLCuaHangQuanAo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DangNhapScreen dangNhapScreen=new DangNhapScreen();
            dangNhapScreen.setVisible(true);
            dangNhapScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
