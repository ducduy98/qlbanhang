/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.nhanvien;

import dao.ThaoTacDB;
import dao.sanpham.SanPhamDAO;
import entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ĐỨC DUY
 */
public class NhanVienDAO {

    ThaoTacDB nhanvienDB = new ThaoTacDB();

    public boolean insertNV(NhanVien nv) {
        try {
            String sql = "insert into NhanVien(tennv,diachi,sdt,tentk,pass,isadmin)"
                    + "values(N'" + nv.getTennv() + "',N'" + nv.getDiachi() + "',N'"
                    + nv.getSdt() + "',N'" + nv.getTentk() + "',N'" + nv.getPass()
                    + "'," + 0 + ")";

            return nhanvienDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateNV(NhanVien nv) {
        try {
            String sql = "update NhanVien set tennv=N'" + nv.getTennv() + "',diachi=N'" + nv.getDiachi()
                    + "',sdt=N'" + nv.getSdt() + "',tentk=N'" + nv.getTentk()
                    + "' where manv=" + nv.getManv();

            return nhanvienDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteNV(int manv) {
        try {
            String sql = "DELETE FROM NhanVien WHERE manv=" + manv;
            return nhanvienDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<NhanVien> selectAllNV() {
        try {
            ArrayList<NhanVien> list = new ArrayList<>();
            String sql = "select * from NhanVien where isadmin=0";
            ResultSet rs = nhanvienDB.queryData(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getInt("manv"));
                nv.setTennv(rs.getString("tennv"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTentk(rs.getString("tentk"));
                nv.setPass(rs.getString("pass"));
                nv.setIsadmin(rs.getBoolean("isadmin"));
                list.add(nv);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public NhanVien findNV(String tentk, String pass) {
        try {
            String sql = "select * from NhanVien where tentk=N'" + tentk + "' and pass=N'" + pass + "'";

            ResultSet rs = nhanvienDB.queryData(sql);
            NhanVien nv = new NhanVien();
            while (rs.next()) {
                nv.setManv(rs.getInt("manv"));
                nv.setTennv(rs.getString("tennv"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTentk(rs.getString("tentk"));
                nv.setPass(rs.getString("pass"));
                nv.setIsadmin(rs.getBoolean("isadmin"));
            }
            return nv;

//            if (nv.getManv() != 0) {
//                if (nv.isIsadmin() == true) {
//                    return 1;
//                } else {
////                LuuBien lb = new LuuBien();
////                lb.setManv(nv.getManv());
//                    return 2;
//                }
//            } else {
//                return 0;
//            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new NhanVien(0,"notfound",false);

    }
    
    public ArrayList<NhanVien> findNVTable(String key) {
        try {
            String sql = "select * from NhanVien where tentk like '%" + key + "%' and isadmin=0";
            ResultSet rs = nhanvienDB.queryData(sql);
            ArrayList<NhanVien> list=new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getInt("manv"));
                nv.setTennv(rs.getString("tennv"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setTentk(rs.getString("tentk"));
                nv.setPass(rs.getString("pass"));
                nv.setIsadmin(rs.getBoolean("isadmin"));
                list.add(nv);
            }
            return list;
            
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
