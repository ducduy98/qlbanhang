package dao.sanpham;

import dao.NCC.NCCDAO;
import dao.ThaoTacDB;
import dao.loaihang.LoaiHangDAO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import entity.SanPham;
import java.util.Map;
/**
 *Data model đảm nhận nhiệm vụ cung cấp dữ liệu hiển thị cho JTable. 
 * Sử dụng data model giúp ứng dụng “MVC” hơn bằng việc tách riêng phần 
 * data và phần UI, tạo ra sự custom tốt hơn cho những bài toán phức tạp.
 Về cơ bản, một data model được cài đặt 9 phương thức do interface TableModel 
 * định nghĩa. Các phương thức đó được liệt kê trong hình dưới đây:
 getRowCout():int
 * getColumnCount():int
 * getValueAt(row, column): object
 * getColumnName(column:int):String
 * getColumnClass(column:int):class
 * isCellEditable(row:int, column:int):boolean
 * addTableModelListener(listener:TableModelListener):void
 * removeTableeModelListener(listener:tablleModelListener):void
 * @author Duong
 */
public class SanPhamTable extends AbstractTableModel
{
    NCCDAO nccDAO=new NCCDAO();
    LoaiHangDAO loaiHangDAO=new LoaiHangDAO();
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã sản phẩm","Tên sản phẩm","Đơn giá","Số lượng trong kho","Chiết khấu","Nhà cung cấp","Loại hàng"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={Integer.class,String.class,Float.class,Integer.class,Float.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<SanPham> dsSP=new ArrayList<SanPham>();
    
    Map<Integer, String> mapNCC=nccDAO.selectNCCForTable();
    Map<Integer,String> mapLH=loaiHangDAO.selectLHForTable();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public SanPhamTable(ArrayList<SanPham> listSP)
   {
       this.dsSP=listSP;
   }
   
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        return dsSP.size();
    }
    //Lấy số lượng tiêu để của mảng.
    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            //Cột mã sp
            case 0: return dsSP.get(rowIndex).getMasp();
            //Cột họ tên
            case 1: return dsSP.get(rowIndex).getTensp();
            //cột điểm toán
//            case 2: return dsSP.get(rowIndex).getSoluong();
            //cột điểm lý
            case 2: return dsSP.get(rowIndex).getDongia();
            //cột điểm hóa
            case 3: return dsSP.get(rowIndex).getSoluongTon();
            
            case 4: return dsSP.get(rowIndex).getChietkhau();
            
            case 5: return mapNCC.get(dsSP.get(rowIndex).getMaNCC());
            
            case 6: return mapLH.get(dsSP.get(rowIndex).getMaLoaiHang());          
                        
            default :return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
}
