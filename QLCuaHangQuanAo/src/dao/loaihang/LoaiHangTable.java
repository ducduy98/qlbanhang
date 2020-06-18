package dao.loaihang;

import entity.LoaiHang;
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
public class LoaiHangTable extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Loại Hàng","Tên Loại hàng"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={Integer.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<LoaiHang> dsLoaiHang=new ArrayList<LoaiHang>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public LoaiHangTable(ArrayList<LoaiHang> list)
   {
       this.dsLoaiHang=list;
   }
   
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        return dsLoaiHang.size();
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
            case 0: return dsLoaiHang.get(rowIndex).getMaLoaiHang();
            
            case 1: return dsLoaiHang.get(rowIndex).getTenLoaiHang();
            
            
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
