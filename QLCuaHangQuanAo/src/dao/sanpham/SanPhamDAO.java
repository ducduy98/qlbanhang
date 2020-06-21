/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sanpham;

import dao.ThaoTacDB;
import entity.SanPham;
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
public class SanPhamDAO {

    ThaoTacDB sanPhamDB = new ThaoTacDB();

    public boolean insertSP(SanPham sp) {
        try {
            String sql = "insert into SanPham(tensp,soluong,dongia,soluongTon,chietkhau,maLoaiHang,maNCC)"
                    + "values(N'" + sp.getTensp() + "'," + 0 + ","
                    + sp.getDongia() + "," + sp.getSoluongTon() + "," + sp.getChietkhau()
                    + "," + sp.getMaLoaiHang() + "," + sp.getMaNCC() + ")";

            return sanPhamDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateSP(SanPham sp) {
        try {
            String sql = "update SanPham set tensp=N'" + sp.getTensp() + "',dongia=" + sp.getDongia() + ",soluongTon=" + sp.getSoluongTon()
                    + ",chietkhau=" + sp.getChietkhau() + ",maLoaiHang=" + sp.getMaLoaiHang() + ",maNCC=" + sp.getMaNCC()
                    + "where masp=" + sp.getMasp();

            return sanPhamDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteSP(int masp) {
        try {
            String sql = "DELETE FROM SanPham WHERE masp=" + masp;
            return sanPhamDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteSPByMaLoaiHang(int maLH) {
        try {
            String sql = "DELETE FROM SanPham WHERE maLoaiHang=" + maLH;
            return sanPhamDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteSPByMaNCC(int maNCC) {
        try {
            String sql = "DELETE FROM SanPham WHERE maNCC=" + maNCC;
            return sanPhamDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<SanPham> selectAllSP() {
        try {
            ArrayList<SanPham> list = new ArrayList<>();
            String sql = "select * from SanPham";
            ResultSet rs = sanPhamDB.queryData(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMasp(rs.getInt("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongia(rs.getFloat("dongia"));
                sp.setSoluongTon(rs.getInt("soluongton"));
                sp.setChietkhau(rs.getFloat("chietkhau"));
                sp.setMaLoaiHang(rs.getInt("maLoaiHang"));
                sp.setMaNCC(rs.getInt("maNCC"));
                list.add(sp);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<SanPham> findAllSPByMaLoaiHang(int maLH) {
        try {
            ArrayList<SanPham> list = new ArrayList<>();
            String sql = "select * from SanPham where maLoaiHang=" + maLH + "";
            ResultSet rs = sanPhamDB.queryData(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMasp(rs.getInt("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongia(rs.getFloat("dongia"));
                sp.setSoluongTon(rs.getInt("soluongton"));
                sp.setChietkhau(rs.getFloat("chietkhau"));
                sp.setMaLoaiHang(rs.getInt("maLoaiHang"));
                sp.setMaNCC(rs.getInt("maNCC"));
                list.add(sp);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<SanPham> findAllSPByMaNCC(int maNCC) {
        try {
            ArrayList<SanPham> list = new ArrayList<>();
            String sql = "select * from SanPham where maNCC=" + maNCC + "";
            ResultSet rs = sanPhamDB.queryData(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMasp(rs.getInt("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongia(rs.getFloat("dongia"));
                sp.setSoluongTon(rs.getInt("soluongton"));
                sp.setChietkhau(rs.getFloat("chietkhau"));
                sp.setMaLoaiHang(rs.getInt("maLoaiHang"));
                sp.setMaNCC(rs.getInt("maNCC"));
                list.add(sp);

            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<SanPham> findSanPham(String sql) {
        try {
            ArrayList<SanPham> list = new ArrayList<>();
//            String sql = "select * from SanPham where tensp like '%" + key + "%'";
            ResultSet rs = sanPhamDB.queryData(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMasp(rs.getInt("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setSoluong(rs.getInt("soluong"));
                sp.setDongia(rs.getFloat("dongia"));
                sp.setSoluongTon(rs.getInt("soluongton"));
                sp.setChietkhau(rs.getFloat("chietkhau"));
                sp.setMaLoaiHang(rs.getInt("maLoaiHang"));
                sp.setMaNCC(rs.getInt("maNCC"));
                list.add(sp);
            }

            return list;
        } catch (Exception ex) {
//            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getlist() {
        try {
            String sql = "select * from SanPham";
            ArrayList<String> list = new ArrayList<>();

            ResultSet rs = sanPhamDB.queryData(sql);
//        int count = thaotac.soluong(sql);
//        System.out.println("so hang" + count);

            while (rs.next()) {
                list.add(String.valueOf(rs.getInt("masp")));

            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public SanPham findById(int id) throws SQLException {
        try {
            String sql = "select * from SanPham where masp=" + id + "";

            ResultSet rs = sanPhamDB.queryData(sql);
            SanPham sp = new SanPham();
            while (rs.next()) {
                sp.setTensp(rs.getString("tensp"));
                sp.setDongia(rs.getInt("dongia"));
                sp.setChietkhau(rs.getInt("chietkhau"));

            }

            return sp;
        } catch (Exception ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        SanPhamDAO spdao = new SanPhamDAO();
//        SanPham sp=new SanPham(10,"Tesst",100,3204,300,0,1,1);
//        boolean check= spdao.insertSP(sp);
//        System.out.println("check"+check);
        List<SanPham> sps = spdao.selectAllSP();
        for (SanPham sp : sps) {
            System.out.println(sp);
        }
    }
}
