package dao.khachhang;

import dao.loaihang.*;
import entity.KhachHang;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
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
public class KhachHangTable extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Khách hàng","Tên Khách hàng","Số điện thoại","Địa chỉ"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={Integer.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<KhachHang> dsKhachHang=new ArrayList<KhachHang>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public KhachHangTable(ArrayList<KhachHang> list)
   {
       this.dsKhachHang=list;
   }
   
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        return dsKhachHang.size();
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
            case 0: return dsKhachHang.get(rowIndex).getMakh();
            
            case 1: return dsKhachHang.get(rowIndex).getTenkh();
            
            case 2: return dsKhachHang.get(rowIndex).getSdt();
            
            case 3: return dsKhachHang.get(rowIndex).getDiachi();
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
