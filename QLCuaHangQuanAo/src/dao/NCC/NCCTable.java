package dao.NCC;

import dao.sanpham.*;
import entity.NhaCungCap;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import entity.SanPham;
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
public class NCCTable extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã NCC","Tên NCC","Địa chỉ"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={Integer.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<NhaCungCap> dsNCC=new ArrayList<NhaCungCap>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public NCCTable(ArrayList<NhaCungCap> list)
   {
       this.dsNCC=list;
   }
   
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        return dsNCC.size();
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
            case 0: return dsNCC.get(rowIndex).getMaNCC();
            //Cột họ tên
            case 1: return dsNCC.get(rowIndex).getTenNCC();
            //cột điểm toán
            case 2: return dsNCC.get(rowIndex).getDiachi();
            
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
