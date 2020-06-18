/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hoadon;

import dao.ThaoTacDB;
import entity.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ĐỨC DUY
 */
public class HoaDonDAO {

    ThaoTacDB hoaDonDB = new ThaoTacDB();

    public boolean insertHoaDon(HoaDon hoaDon) {
        try {
            String sql = "insert into HoaDon(makh,ngayban,manv)"
                    + "values(" + hoaDon.getMakh() + ",N'" + hoaDon.getNgayBan() + "'," + hoaDon.getManv() + ")";

            return hoaDonDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateHoaDon(HoaDon hoaDon) {
        try {
            String sql = "update HoaDon set makh=" + hoaDon.getMakh()
                    + ",ngayban=N'" + hoaDon.getNgayBan()
                    + "',manv=" + hoaDon.getManv()
                    + " where mahd=" + hoaDon.getMahd();

            return hoaDonDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteHoaDon(int mahoaDon) {
        try {
            String sql = "DELETE FROM HoaDon WHERE mahd=" + mahoaDon;
            return hoaDonDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<HoaDon> selectAllHoaDon() {
        try {
            ArrayList<HoaDon> list = new ArrayList<>();
            String sql = "select * from HoaDon";
            ResultSet rs = hoaDonDB.queryData(sql);
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMahd(rs.getInt("mahd"));
                hoaDon.setMakh(rs.getInt("makh"));
                hoaDon.setNgayBan(rs.getString("ngayban"));
                hoaDon.setManv(rs.getInt("manv"));
                list.add(hoaDon);
            }

            return list;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public HoaDon gethoadon(int makh, String ngayban, int manv) {
        try {
            String sql = "select * from HoaDon where makh=" + makh + " and ngayBan='" + ngayban + "' and manv=" + manv + "";

            ResultSet rs = hoaDonDB.queryData(sql);
            HoaDon hd = null;
            while (rs.next()) {
                hd = new HoaDon(rs.getInt("mahd"), rs.getInt("makh"), rs.getString("ngayBan"), rs.getInt("manv"));
            }

            return hd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new HoaDon();

    }

    public HoaDon getId(int mahd) throws SQLException {
        try {
            String sql = "select * from HoaDon where mahd=" + mahd + "";
            System.out.println("chay vao day la hoa don dao ");
            ResultSet rs = hoaDonDB.queryData(sql);
            HoaDon hd = new HoaDon();
            System.out.println("chay den truoc vong while id hoa don la :" + mahd);
            int i = 0;
            while (rs.next()) {
                i++;
                System.out.println("get du lieu trong get id hoa don ");
                hd = new HoaDon(rs.getInt("mahd"), rs.getInt("makh"), rs.getString("ngayBan"), rs.getInt("manv"));
            }

            System.out.println("gia tri cua i  la :" + i);

            return hd;
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new HoaDon();
    }
}
