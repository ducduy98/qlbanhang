/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ĐỨC DUY
 */
public class ThaoTacDB {

    private static ConnectDB connectDB = new ConnectDB();
    private static Connection connection = null;
    ResultSet rs = null;
    //Hàm truyền vào câu lệnh truy vấn, trả về đối tượng ResultSet chứa kết quả

    public ResultSet queryData(String query) throws Exception {
        try {
            connection=connectDB.getConnection();
            rs = connection.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            throw new Exception("Loi: Thuc thi cau lenh query khong thanh cong");
        }
        return rs;
    }

    //Hàm thực thi các lệnh update,insert,delete...
    public boolean updateData(String query) throws Exception {
        try {
            connection=connectDB.getConnection();
            int isSuccess=connection.createStatement().executeUpdate(query);
            if(isSuccess!=0) return true;
        } catch (SQLException ex) {
            System.out.println("Loi: Khong the update du lieu");
            ex.printStackTrace();
        }
        return false;
    }

    //Hàm đóng kết nối đến CSDL
    public void closeConnection() {
        try {
            if (connection!=null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Loi: Dong ket noi that bai, khong the ket noi den CSDL");
        }
    }

}
