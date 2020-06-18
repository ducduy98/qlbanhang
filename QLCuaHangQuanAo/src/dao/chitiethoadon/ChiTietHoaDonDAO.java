/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.chitiethoadon;

import dao.ThaoTacDB;
import entity.ChiTietHoaDon;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ĐỨC DUY
 */
public class ChiTietHoaDonDAO {

    ThaoTacDB chitiethoaDonDB = new ThaoTacDB();

    public boolean insert(ChiTietHoaDon hd) {
        String check = "Select soluongTon  from SanPham where masp =" + hd.getMasp() + "";

        try {
            ResultSet res = null;
            res = chitiethoaDonDB.queryData(check);

            if (null != res) {
                int slTon = -1;
                while (res.next()) {
                    slTon = res.getInt("soluongTon");
//                    System.out.println("Số lượng tồn query :==== " + res.getInt("soluongTon"));
                }
//                System.out.println("So luong ton=========: " + slTon);
                if (slTon < hd.getSoluongban() || slTon <= 0) {
                    return false;
                } else {
                    //tru di so luong sp ban trong kho
                    slTon = slTon - hd.getSoluongban();
                    String sqlUpdateSP = "update SanPham set soluongTon= " + slTon + " where masp=" + hd.getMasp();
                    //insert vao CHI TIET HOA DON
                    chitiethoaDonDB.updateData(sqlUpdateSP);
                    String sql = "insert into ChiTietHoaDon(mahd,masp,soluongban) values(" + hd.getMahd() + "," + hd.getMasp() + "," + hd.getSoluongban() + ")";
                    return chitiethoaDonDB.updateData(sql);
                }
            } else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean deleteChiTietHoaDonByMaSP(int maSP) {
        try {
            String sql = "DELETE FROM ChiTietHoaDon WHERE masp=" + maSP;
            return chitiethoaDonDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     public boolean deleteChiTietHoaDonByMaHoaDon(int maHD) {
        try {
            String sql = "DELETE FROM ChiTietHoaDon WHERE mahd=" + maHD;
            return chitiethoaDonDB.updateData(sql);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean update(ChiTietHoaDon hd, int soluongBanCu) {
        try {
            String getSlTon = "select soluongTon from SanPham where masp=" + hd.getMasp();
            ResultSet rsSLTon = chitiethoaDonDB.queryData(getSlTon);
            int slTonCu = -1;
            while (rsSLTon.next()) {
                slTonCu = rsSLTon.getInt("soluongTon");
            }
            int sl = slTonCu + soluongBanCu;

            String backSoluongcu = "update SanPham set soluongTon=" + sl;
            chitiethoaDonDB.updateData(backSoluongcu);

            if (sl < hd.getSoluongban() || sl <= 0) {
                return false;
            } else {
                sl = sl - hd.getSoluongban();
                String sqlUpdateSP = "update SanPham set soluongTon= " + sl + " where masp=" + hd.getMasp();
                chitiethoaDonDB.updateData(sqlUpdateSP);
                String sql = "update ChiTietHoaDon set soluongban = " + hd.getSoluongban()
                        + " where mahd =" + hd.getMahd() + " and masp =" + hd.getMasp();
                return chitiethoaDonDB.updateData(sql);
            }

        } catch (Exception ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ChiTietHoaDon getChiTietHoaDon(int mahd) {
        try {
            String sql = "select * from ChiTietHoaDon where mahd=" + mahd;
            ResultSet res = chitiethoaDonDB.queryData(sql);
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            while (res.next()) {
                chiTietHoaDon.setMahd(res.getInt("mahd"));
                chiTietHoaDon.setMasp(res.getInt("masp"));
                chiTietHoaDon.setSoluongban(res.getInt("soluongban"));
            }
            return chiTietHoaDon;

        } catch (Exception e) {
        }
        return null;
    }

//     public void gettable(JTable jtable) throws SQLException{
//         String sql="select * from ChiTietHoaDon";
//        String[] tencot={"ten khach hang","ten san pham","ten nhan vien","so luong ban","thanh tien"};
//        HoaDonDAO hdd=new HoaDonDAO();
//        SanPhamDAO spd=new SanPhamDAO();
//        KhachHangDAO khd=new KhachHangDAO();
//         NhanVienDAO xl=new NhanVienDAO();
//        ResultSet rs=chitiethoaDonDB.queryData(sql);
//       int count=thaotac.soluong(sql);
//        System.out.println("so hang"+count);
//         String[][] data=new String[count][5];
//         int i=0;
//         System.out.println("chay vao day");
//        while(rs.next()){
//            System.out.println("chay vao while chi tiet hoa don ");
//            HoaDon hoadon=hdd.getId(rs.getInt("mahd"));
//            System.out.println("ma khach hang la :"+hoadon.getMakh());
//            KhachHang kh=khd.getId(hoadon.getMakh());
//           data[i][0]=kh.getTenkh();
//           SanPham sp=spd.findById(rs.getInt("masp"));
//            data[i][1]=sp.getTensp();
//            NhanVien nv=xl.findById(hoadon.getManv());
//            data[i][2]=nv.getTennv();
//            data[i][3]=rs.getString("soluongBan");
//            double thanhtien=(sp.getDongia()+(sp.getDongia()*sp.getChietkhau()/100))*rs.getInt("soluongBan");
//            data[i][4]=String.valueOf(thanhtien);
//            i++;
//            
//        }
//        
//        TableModel tableModel=new DefaultTableModel(data, tencot);
//        jtable.setModel(tableModel);
//     }
}
