/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.loaihang;

import dao.NCC.NCCDAO;
import dao.ThaoTacDB;
import entity.LoaiHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ĐỨC DUY
 */
public class LoaiHangDAO {

    ThaoTacDB loaihangDB = new ThaoTacDB();

    public boolean insertLoaiHang(LoaiHang loaiHang) {
        try {
            String sql = "insert into LoaiHang(tenLoaiHang)"
                    + "values(N'" + loaiHang.getTenLoaiHang()+ "')";

            return loaihangDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateLoaiHang(LoaiHang loaiHang) {
        try {
            String sql = "update LoaiHang set tenLoaiHang=N'" + loaiHang.getTenLoaiHang()
                    + "' where maLoaiHang=" + loaiHang.getMaLoaiHang();

            return loaihangDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteLoaiHang(int maloaiHang) {
        try {
            String sql = "DELETE FROM LoaiHang WHERE maLoaiHang=" + maloaiHang;
            return loaihangDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<LoaiHang> selectAllLoaiHang() {
        try {
            ArrayList<LoaiHang> list = new ArrayList<>();
            String sql = "select * from LoaiHang";
            ResultSet rs = loaihangDB.queryData(sql);
            while (rs.next()) {
                LoaiHang loaiHang = new LoaiHang();
                loaiHang.setMaLoaiHang(rs.getInt("maLoaiHang"));
                loaiHang.setTenLoaiHang(rs.getString("tenLoaiHang"));
                
                list.add(loaiHang);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<LoaiHang> selectForCombo() {
        try {
            ArrayList<LoaiHang> list = new ArrayList<>();
            String sql = "select * from LoaiHang";
            ResultSet rs = loaihangDB.queryData(sql);
            while (rs.next()) {
                LoaiHang loaiHang = new LoaiHang();
                loaiHang.setMaLoaiHang(rs.getInt("maLoaiHang"));
                loaiHang.setTenLoaiHang(rs.getString("tenLoaiHang"));
                
                list.add(loaiHang);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Map<Integer,String> selectLHForTable() {
        try {
            Map<Integer,String> map = new HashMap<>();
            String sql = "select * from LoaiHang";
            ResultSet rs = loaihangDB.queryData(sql);
            while (rs.next()) {
                map.put(rs.getInt("maLoaiHang"), rs.getString("tenLoaiHang"));                
            }

            return map;
        } catch (Exception ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<LoaiHang> findLoaiHang(String key) {
        try {
            ArrayList<LoaiHang> list = new ArrayList<>();
            String sql = "select * from LoaiHang where tenLoaiHang like '%"+key+"%'";
            ResultSet rs = loaihangDB.queryData(sql);
            while (rs.next()) {
                LoaiHang loaiHang = new LoaiHang();
                loaiHang.setMaLoaiHang(rs.getInt("maLoaiHang"));
                loaiHang.setTenLoaiHang(rs.getString("tenLoaiHang"));
                
                list.add(loaiHang);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        LoaiHangDAO spdao = new LoaiHangDAO();
//        LoaiHang sp=new LoaiHang(10,"Tesst",100,3204,300,0,1,1);
//        boolean check= spdao.insertLoaiHang(sp);
//        System.out.println("check"+check);
        List<LoaiHang>sps=spdao.selectAllLoaiHang();
        for (LoaiHang sp : sps) {
            System.out.println(sp);
        }
    }
}
