/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.NCC;

import dao.sanpham.*;
import dao.ThaoTacDB;
import entity.NhaCungCap;
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
public class NCCDAO {

    ThaoTacDB nhacungcapDB = new ThaoTacDB();

    public boolean insertNCC(NhaCungCap ncc) {
        try {
            String sql = "insert into NhaCungCap(tenNCC,diachi)"
                    + "values(N'" + ncc.getTenNCC() + "',N'"+ncc.getDiachi()+ "')";

            return nhacungcapDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(NCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateNCC(NhaCungCap ncc) {
        try {
            String sql = "update NhaCungCap set tenNCC=N'" + ncc.getTenNCC()+ "',diachi=N'" +ncc.getDiachi()
                    + "' where maNCC=" + ncc.getMaNCC();

            return nhacungcapDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(NCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteNCC(int mancc) {
        try {
            String sql = "DELETE FROM NhaCungCap WHERE maNCC=" + mancc;
            return nhacungcapDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(NCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<NhaCungCap> selectAllNCC() {
        try {
            ArrayList<NhaCungCap> list = new ArrayList<>();
            String sql = "select * from NhaCungCap";
            ResultSet rs = nhacungcapDB.queryData(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("maNCC"));
                ncc.setTenNCC(rs.getString("tenNCC"));
                ncc.setDiachi(rs.getString("diachi"));
                
                list.add(ncc);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(NCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<NhaCungCap> findNCC(String key) {
        try {
            ArrayList<NhaCungCap> list = new ArrayList<>();
            String sql = "select * from NhaCungCap where maNCC like '%"+key+"%'";
            ResultSet rs = nhacungcapDB.queryData(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("maNCC"));
                ncc.setTenNCC(rs.getString("tenNCC"));
                ncc.setDiachi(rs.getString("diachi"));
                
                list.add(ncc);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(NCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<NhaCungCap> selectForCombo() {
        try {
            ArrayList<NhaCungCap> list = new ArrayList<>();
            String sql = "select * from NhaCungCap";
            ResultSet rs = nhacungcapDB.queryData(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("maNCC"));
                ncc.setTenNCC(rs.getString("tenNCC"));
                
                list.add(ncc);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(NCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Map<Integer,String> selectNCCForTable() {
        try {
            Map<Integer,String> map = new HashMap<>();
            String sql = "select * from NhaCungCap";
            ResultSet rs = nhacungcapDB.queryData(sql);
            while (rs.next()) {
                map.put(rs.getInt("maNCC"), rs.getString("tenNCC"));                
            }

            return map;
        } catch (Exception ex) {
            Logger.getLogger(NCCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        NCCDAO spdao = new NCCDAO();
//        NhaCungCap sp=new NhaCungCap(10,"Tesst",100,3204,300,0,1,1);
//        boolean check= spdao.insertNCC(sp);
//        System.out.println("check"+check);
        List<NhaCungCap>sps=spdao.selectAllNCC();
        for (NhaCungCap sp : sps) {
            System.out.println(sp);
        }
    }
}
