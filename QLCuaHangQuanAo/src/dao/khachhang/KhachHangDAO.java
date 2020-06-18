/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.khachhang;

import dao.loaihang.*;
import dao.ThaoTacDB;
import entity.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ĐỨC DUY
 */
public class KhachHangDAO {

    ThaoTacDB khachHangDB = new ThaoTacDB();

    public boolean insertKhachHang(KhachHang khachHang) {
        try {
            String sql = "insert into KhachHang(tenkh,sdt,diachi)"
                    + "values(N'" + khachHang.getTenkh() + "',N'" + khachHang.getSdt() + "',N'" + khachHang.getDiachi() + "')";

            return khachHangDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateKhachHang(KhachHang khachHang) {
        try {
            String sql = "update KhachHang set tenkh=N'" + khachHang.getTenkh()
                    + "',sdt=N'" + khachHang.getSdt()
                    + "',diachi=N'" + khachHang.getDiachi()
                    + "' where makh=" + khachHang.getMakh();

            return khachHangDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteKhachHang(int makhachHang) {
        try {
            String sql = "DELETE FROM KhachHang WHERE makh=" + makhachHang;
            return khachHangDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<KhachHang> selectAllKhachHang() {
        try {
            ArrayList<KhachHang> list = new ArrayList<>();
            String sql = "select * from KhachHang";
            ResultSet rs = khachHangDB.queryData(sql);
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMakh(rs.getInt("makh"));
                khachHang.setTenkh(rs.getString("tenkh"));
                khachHang.setSdt(rs.getString("sdt"));
                khachHang.setDiachi(rs.getString("diachi"));
                list.add(khachHang);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public KhachHang getId(String id) throws SQLException {
        try {
            String sql = "select * from KhachHang where makh='" + id + "'";
            ResultSet rs = khachHangDB.queryData(sql);
            KhachHang kh = new KhachHang();
            while (rs.next()) {
                kh.setTenkh(rs.getString("tenkh"));
                kh.setSdt(rs.getString("sdt"));
            }
            return kh;
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<KhachHang> findKhachHang(String key) {
        try {
            ArrayList<KhachHang> list = new ArrayList<>();
            String sql = "select * from KhachHang where tenkh like '%" + key + "%'";
            ResultSet rs = khachHangDB.queryData(sql);
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMakh(rs.getInt("makh"));
                khachHang.setTenkh(rs.getString("tenkh"));
                khachHang.setSdt(rs.getString("sdt"));
                khachHang.setDiachi(rs.getString("diachi"));
                list.add(khachHang);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<String> listkhachang() {
        try {
            String sql = "select * from KhachHang";
            ArrayList<String> list = new ArrayList<>();
            ResultSet rs = khachHangDB.queryData(sql);
            while (rs.next()) {
                list.add(String.valueOf(rs.getInt("makh")));
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean findByPhone(String phone){
        try {
            String sql = "select * from KhachHang where sdt = '" + phone + "'";
            ResultSet rs = khachHangDB.queryData(sql);
//            if (rs.next()) {
//                return true;
//            }else return false;
            return rs.next();
                
//            KhachHang khachHang = new KhachHang();
//            while (rs.next()) {
//                
//                khachHang.setMakh(rs.getInt("makh"));
//                khachHang.setTenkh(rs.getString("tenkh"));
//                khachHang.setSdt(rs.getString("sdt"));
//                khachHang.setDiachi(rs.getString("diachi"));
//
//            }

        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        KhachHangDAO spdao = new KhachHangDAO();
//        KhachHang sp=new KhachHang(10,"Tesst",100,3204,300,0,1,1);
//        boolean check= spdao.insertKhachHang(sp);
//        System.out.println("check"+check);
        List<KhachHang> sps = spdao.selectAllKhachHang();
        for (KhachHang sp : sps) {
            System.out.println(sp);
        }
    }
}
