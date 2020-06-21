/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.chitiethoadon.ChiTietHoaDonDAO;
import dao.hoadon.HoaDonDAO;
import dao.khachhang.KhachHangDAO;
import dao.sanpham.SanPhamDAO;
import entity.ChiTietHoaDon;
import entity.DateTimeHD;
import entity.HoaDon;
import entity.KhachHang;
import entity.AccountSession;
import entity.SanPham;
import entity.Money;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ĐỨC DUY
 */
public class BanHangScreen extends javax.swing.JFrame {

    public static int maHD;
    HoaDonDAO hoadonDAO = new HoaDonDAO();
    ChiTietHoaDonDAO chitietdao = new ChiTietHoaDonDAO();
    AccountSession lb = new AccountSession();
    DateTimeHD dateTimeHD = new DateTimeHD();

    private ArrayList<String> listsanpham = new ArrayList<>();

    private ArrayList<String> listkhachhang = new ArrayList<>();
    Money money = new Money();
    // đầu tiên phải tạo 1 row có sẵn ngoài contructor để nó lưu biến row , số 8 bên trong tương đương với số cột;
    Object[] row = new Object[8];

    // tạo 1 biến defaultablemodel là thuộc tính chứa các row và cột 
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form BanHangScreen
     */
    public BanHangScreen() {
        initComponents();

        txtTenNV.setText(lb.getTaikhoan().toUpperCase());
        txtSdtKH.setText("");
        txtTenKH.setText("GUEST");
        txtMaKH.setText("3");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int sw = (int) d.getWidth();
        int sh = (int) d.getHeight();
        int fw = this.getWidth();
        int fh = this.getHeight();
        int xpos = (sw - fw) / 2;
        int ypos = (sh - fh) / 2;
        this.setLocation(xpos, ypos);

        listsanpham = new SanPhamDAO().getlist();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        txtThoiGian.setText(format.format(date));
        //luu thoi gian tao hoa don
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateTimeHD.setTime(dateFormat.format(date));

        hoadonDAO.insertHoaDon(new HoaDon(0, 3, dateTimeHD.getTime(), lb.getManv()));
        HoaDon hd = hoadonDAO.gethoadon(3, dateTimeHD.getTime(), lb.getManv());
        maHD = hd.getMahd();

        // tạo 1 mảng 1 chiều chứa các tên cột có trong jtable đó
        String[] cot = {"STT", "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá", "Thành tiền ", "Chiết khấu ", "Thanh toán"};
        listkhachhang = new KhachHangDAO().listkhachang();

        // add tên các cột vào trong model 
        model.setColumnIdentifiers(cot);

        tblDanhSach.setModel(model);

        tblDanhSach.setRowHeight(30);

        setWidthCol();

    }

    public void setWidthCol() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblDanhSach.setDefaultRenderer(Object.class, centerRenderer);
        tblDanhSach.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblDanhSach.getColumnModel().getColumn(1).setPreferredWidth(35);
        tblDanhSach.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblDanhSach.getColumnModel().getColumn(3).setPreferredWidth(35);
        tblDanhSach.getColumnModel().getColumn(4).setPreferredWidth(35);
        tblDanhSach.getColumnModel().getColumn(5).setPreferredWidth(35);
        tblDanhSach.getColumnModel().getColumn(6).setPreferredWidth(35);
        tblDanhSach.getColumnModel().getColumn(7).setPreferredWidth(35);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        txtTienNhan = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        txtSdtKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtSoLuongSP = new javax.swing.JTextField();
        txtChietKhau = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        btnThemVaoHoaDon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btnUpdateHD = new javax.swing.JButton();
        btnTaoHDMoi = new javax.swing.JButton();
        btnXoaSPHoaDon = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cashier.png"))); // NOI18N
        jLabel3.setText("BÁN HÀNG");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thời gian");

        txtThoiGian.setEditable(false);
        txtThoiGian.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianActionPerformed(evt);
            }
        });

        txtTenNV.setEditable(false);
        txtTenNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nhân viên");

        btnDangXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logOut.png"))); // NOI18N
        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDangXuat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDoiMatKhau))
                            .addComponent(jLabel3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("TỔNG HỢP THANH TOÁN");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Số Lượng SP");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Thành Tiền");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Tiền nhận");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Tiền thừa");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 153));
        jLabel18.setText("THÔNG TIN KHÁCH HÀNG");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Mã KH");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Tên KH");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("SĐT");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Mã sản phẩm");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Tên sản phẩm");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Số lượng");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Chiết khấu");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Đơn giá");

        txtSoluong.setEditable(false);

        txtTienNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienNhanKeyPressed(evt);
            }
        });

        txtThanhTien.setEditable(false);

        txtTienThua.setEditable(false);

        txtSdtKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSdtKHKeyPressed(evt);
            }
        });

        txtTenKH.setEditable(false);

        txtMaKH.setEditable(false);

        txtMaSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaSanPhamKeyPressed(evt);
            }
        });

        txtTenSanPham.setEditable(false);

        txtChietKhau.setEditable(false);

        txtDonGia.setEditable(false);

        btnThemVaoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnThemVaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addbill.png"))); // NOI18N
        btnThemVaoHoaDon.setText("Thêm vào hóa đơn");
        btnThemVaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoHoaDonActionPerformed(evt);
            }
        });

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        btnUpdateHD.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnUpdateHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnUpdateHD.setText("Cập nhật hóa đơn");
        btnUpdateHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateHDActionPerformed(evt);
            }
        });

        btnTaoHDMoi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTaoHDMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addNewBill.png"))); // NOI18N
        btnTaoHDMoi.setText("Tạo hóa đơn mới");
        btnTaoHDMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDMoiActionPerformed(evt);
            }
        });

        btnXoaSPHoaDon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnXoaSPHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/create_tick.png"))); // NOI18N
        btnXoaSPHoaDon.setText("Xóa khỏi hóa đơn");
        btnXoaSPHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPHoaDonActionPerformed(evt);
            }
        });

        btnInHoaDon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill.png"))); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaSPHoaDon)
                            .addGap(69, 69, 69)
                            .addComponent(btnUpdateHD)
                            .addGap(83, 83, 83)
                            .addComponent(btnInHoaDon)
                            .addGap(79, 79, 79)
                            .addComponent(btnTaoHDMoi))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                        .addComponent(txtTienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(8, 8, 8))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoluong)
                                            .addComponent(txtThanhTien)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel8))
                                    .addGap(49, 49, 49)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addGap(27, 27, 27)
                                            .addComponent(txtTenSanPham))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(32, 32, 32)
                                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel14))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(49, 49, 49)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnThemVaoHoaDon)))
                                .addComponent(jScrollPane1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemVaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHDMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSPHoaDon)
                    .addComponent(btnUpdateHD)
                    .addComponent(btnInHoaDon))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhapScreen dangNhapScreen = new DangNhapScreen();
        dangNhapScreen.setVisible(true);
        dangNhapScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void txtSdtKHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSdtKHKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                break;
            case KeyEvent.VK_ENTER:
                txtSdtKH.setText(txtSdtKH.getText());
                String sdtkh = txtSdtKH.getText();
                KhachHangDAO khd = new KhachHangDAO();

                try {
                    KhachHang kh = khd.getKHBySDT(sdtkh);
                    if (null == kh) {
                        int input = JOptionPane.showConfirmDialog(rootPane,
                                "Không tìm thấy khách hàng. Thêm khách hàng??", "Không tìm thấy khách hàng!", JOptionPane.YES_NO_OPTION);
                        if (input == 0) {
                            ThemKhachHangScreen khachHangScreen = new ThemKhachHangScreen();
                            khachHangScreen.setVisible(true);
                            khachHangScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        }
                    } else {
                        HoaDon hoaDon = new HoaDon(maHD, kh.getMakh(), dateTimeHD.getTime(), lb.getManv());
                        hoadonDAO.updateHoaDon(hoaDon);
                        System.out.println("Update makh okkkk");
                        txtTenKH.setText(kh.getTenkh());
                        txtMaKH.setText(String.valueOf(kh.getMakh()));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BanHangScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            default:
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String text = txtSdtKH.getText();
                        timkiemkhachhang(text);
                    }
                });
        }
    }//GEN-LAST:event_txtSdtKHKeyPressed

    private void txtTienNhanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKeyPressed
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                break;
            case KeyEvent.VK_ENTER:
                double tiennhan = Double.parseDouble(txtTienNhan.getText());
                double thanhtien = money.getThanhTien();

                double tienthua = tiennhan - thanhtien;
                txtTienThua.setText(String.valueOf(tienthua));
                break;
            default:
                break;
        }
    }//GEN-LAST:event_txtTienNhanKeyPressed

    private void btnXoaSPHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPHoaDonActionPerformed
        // TODO add your handling code here:
        if (txtMaSanPham.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không thể xóa!!!");
        } else {
            int row = -1;

            row = tblDanhSach.getSelectedRow();
            if (row != -1) {
                String[] cot = {"STT", "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá", "Thành tiền ", "Chiết khấu (%)", "Thanh toán"};
                int masp = Integer.parseInt(txtMaSanPham.getText());
                int soluong = Integer.parseInt(String.valueOf(model.getValueAt(row, 3)));

                boolean kq = chitietdao.deleteChiTietHoaDonByMaHoaDonAndMaSP(maHD, masp, soluong);

                if (kq) {

                    int soluongHang = tblDanhSach.getRowCount() - 1;
                    txtSoluong.setText(String.valueOf(soluongHang));
                    model.removeRow(row);
                    updateTongTien();
                    model.setColumnIdentifiers(cot);
                    tblDanhSach.setModel(model);
                    JOptionPane.showMessageDialog(rootPane, "Xóa thành công!!!");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không thể xóa!!!");
                }
            }

        }

    }//GEN-LAST:event_btnXoaSPHoaDonActionPerformed
    public void updateTongTien() {
        setWidthCol();
        Money money = new Money();
        int sohang = model.getRowCount();
        txtSoluong.setText(String.valueOf(sohang));
        double thanhtien = 0;
        for (int i = 0; i < sohang; i++) {
            thanhtien += Double.parseDouble(model.getValueAt(i, 7).toString().replaceAll(",", ""));

        }
        money.setThanhTien(thanhtien);
        DecimalFormat df = new DecimalFormat("###,###,###");
        String tongtien = df.format(thanhtien);

//        txtThanhTien.setText(String.valueOf(thanhtien));
        txtThanhTien.setText(tongtien);
    }
    private void btnThemVaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoHoaDonActionPerformed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("###,###,###");
        setWidthCol();
        int soluong = tblDanhSach.getRowCount() + 1;

        double dongia = Double.parseDouble(txtDonGia.getText().replaceAll(",", ""));

        int soluongban = Integer.parseInt(txtSoLuongSP.getText());

        double thanhtien = soluongban * dongia;

        double chietkhau = Double.parseDouble(txtChietKhau.getText());
        double thanhtoan = thanhtien - (thanhtien * chietkhau / 100);
        String thanhtoantext = String.valueOf(thanhtoan);
        String thanhtientext = String.valueOf(thanhtien);
        String soluongtext = String.valueOf(soluong);
        row[0] = soluongtext;
        row[1] = txtMaSanPham.getText();
        row[2] = txtTenSanPham.getText();
        row[3] = txtSoLuongSP.getText();
        row[4] = df.format(dongia);
        row[5] = df.format(thanhtien);
        row[6] = txtChietKhau.getText();
        row[7] = df.format(thanhtoan);

        AccountSession lb = new AccountSession();
        int mnv = lb.getManv();

        String dateHD = dateTimeHD.getTime();
//        HoaDon hd = new HoaDon(0, Integer.parseInt(txtMaKH.getText()), dateHD, mnv);
//        HoaDonDAO hdd = new HoaDonDAO();

        // ddaay laf them cac thuộc tính trên vào trong database;
//        boolean ketqua = hdd.insertHoaDon(hd);
//        if (ketqua == true) {
//            HoaDon hoadon = hdd.gethoadon(Integer.parseInt(txtMaKH.getText()), dateHD, mnv);
        ChiTietHoaDon cthd = new ChiTietHoaDon(maHD, Integer.parseInt(txtMaSanPham.getText()), Integer.parseInt(txtSoLuongSP.getText()));
        ChiTietHoaDonDAO chitietdao = new ChiTietHoaDonDAO();

        boolean ketqua2 = chitietdao.insert(cthd);
        if (ketqua2 == true) {
            txtSoluong.setText(String.valueOf(soluong));
            //JOptionPane.showMessageDialog(rootPane, "them hoa don thanh cong");
            txtMaSanPham.setText("");
            txtTenSanPham.setText("");
            txtSoLuongSP.setText("");
            txtDonGia.setText("");
            txtChietKhau.setText("");

            // them hang vao trong model 
            model.addRow(row);
//            setWidthCol();
//            Money money = new Money();
//            int sohang = model.getRowCount();
//            txtSoluong.setText(String.valueOf(sohang));
//            double thanhtienAll = 0;
//            for (int i = 0; i < sohang; i++) {
//                thanhtienAll += Double.parseDouble(model.getValueAt(i, 7).toString().replaceAll(",", ""));
//
//            }
//            money.setThanhTien(thanhtienAll);
//            String tongtien = df.format(thanhtienAll);
//
////        txtThanhTien.setText(String.valueOf(thanhtien));
//            txtThanhTien.setText(tongtien);
            updateTongTien();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ko insert vào chi tiet được");
        }

//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Số lượng hàng trong kho không đủ");
//        }
    }//GEN-LAST:event_btnThemVaoHoaDonActionPerformed

    private void txtMaSanPhamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSanPhamKeyPressed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("###,###,###");
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                break;
            case KeyEvent.VK_ENTER:
                txtMaSanPham.setText(txtMaSanPham.getText());
                int masanpham = Integer.parseInt(txtMaSanPham.getText());
                SanPhamDAO spd = new SanPhamDAO();

                try {
                    SanPham sp = spd.findById(masanpham);
                    txtTenSanPham.setText(sp.getTensp());
                    txtDonGia.setText(df.format(sp.getDongia()));
                    txtChietKhau.setText(String.valueOf(sp.getChietkhau()));
                } catch (SQLException ex) {
                    Logger.getLogger(BanHangScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            default:
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String text = txtMaSanPham.getText();
                        timkiem(text);
                    }
                });
        }
    }//GEN-LAST:event_txtMaSanPhamKeyPressed

    private void btnTaoHDMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDMoiActionPerformed
        // TODO add your handling code here:
        setWidthCol();
        txtTenNV.setText(lb.getTaikhoan().toUpperCase());
        txtSdtKH.setText("");
        txtTenKH.setText("GUEST");
        txtMaKH.setText("3");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        txtThoiGian.setText(format.format(date));

        txtChietKhau.setText("");
        txtDonGia.setText("");
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");

        txtThanhTien.setText("");
        txtTienNhan.setText("");
        txtTienThua.setText("");

        txtSoLuongSP.setText("");
        txtSoluong.setText("");
        String[] cot = {"STT", "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá", "Thành tiền ", "Chiết khấu (%)", "Thanh toán"};

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);

        }

        model.setColumnIdentifiers(cot);
        tblDanhSach.setModel(model);
        //luu thoi gian tao hoa don
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        dateTimeHD.setTime(dateFormat.format(date));
        hoadonDAO.insertHoaDon(new HoaDon(0, 3, dateTimeHD.getTime(), lb.getManv()));
        HoaDon hd = hoadonDAO.gethoadon(3, dateTimeHD.getTime(), lb.getManv());
        maHD = hd.getMahd();
    }//GEN-LAST:event_btnTaoHDMoiActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        // TODO add your handling code here:
        String[] cot = {"STT", "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá", "Thành tiền ", "Chiết khấu ", "Thanh toán"};
        int row = tblDanhSach.getSelectedRow();

        txtMaSanPham.setText(String.valueOf(model.getValueAt(row, 1)));
        txtTenSanPham.setText(String.valueOf(model.getValueAt(row, 2)));
        txtSoLuongSP.setText(String.valueOf(model.getValueAt(row, 3)));
        txtDonGia.setText(String.valueOf(model.getValueAt(row, 4)));
        txtChietKhau.setText(String.valueOf(model.getValueAt(row, 6)));

    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnUpdateHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateHDActionPerformed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("###,###,###");
        setWidthCol();
        AccountSession lb = new AccountSession();
        int mnv = lb.getManv();

        String dateHD = dateTimeHD.getTime();
//        HoaDon hd = new HoaDon(0, Integer.parseInt(txtMaKH.getText()), dateHD, mnv);
//        HoaDonDAO hoaDonDAO = new HoaDonDAO();

        // ddaay laf them cac thuộc tính trên vào trong database;
//        boolean ketqua = hoaDonDAO.updateHoaDon(hd);
//        if (ketqua == true) {
//        HoaDon hoadon = hoaDonDAO.gethoadon(Integer.parseInt(txtMaKH.getText()), dateHD, mnv);
        //lay ra chi tiet hoa don cu
        ChiTietHoaDon hdCu = chitietdao.getChiTietHoaDon(maHD, Integer.parseInt(txtMaSanPham.getText()));
        int soluongBanCu = hdCu.getSoluongban();
        //tao chi tiet hoa don moi
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        cthd = new ChiTietHoaDon(maHD, Integer.parseInt(txtMaSanPham.getText()), Integer.parseInt(txtSoLuongSP.getText()));

        boolean ketqua2 = chitietdao.update(cthd, soluongBanCu);

        //lay ra dong dang chon
        int row = tblDanhSach.getSelectedRow();

        int soluong = tblDanhSach.getRowCount() + 1;

        txtSoluong.setText(String.valueOf(soluong));

        double dongia = Double.parseDouble(model.getValueAt(row, 4).toString().replaceAll(",", ""));

        int soluongban = Integer.parseInt(txtSoLuongSP.getText());

        double thanhtien = soluongban * dongia;

        double chietkhau = Double.parseDouble(txtChietKhau.getText());
        double thanhtoan = thanhtien - (thanhtien * chietkhau / 100);
        String thanhtoantext = df.format(thanhtoan);
        String thanhtientext = df.format(thanhtien);

        tblDanhSach.setValueAt(txtSoLuongSP.getText(), row, 3);
        tblDanhSach.setValueAt(thanhtientext, row, 5);
        tblDanhSach.setValueAt(thanhtoantext, row, 7);
//        btnLuuHoaDonActionPerformed(evt);
        updateTongTien();

        if (ketqua2 == true) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật hóa đơn thành công");
            txtMaSanPham.setText("");
            txtTenSanPham.setText("");
            txtSoLuongSP.setText("");
            txtDonGia.setText("");
            txtChietKhau.setText("");

            // them hang vao trong model 
//                model.addRow(row);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Số lượng hàng trong kho không đủ");
        }


    }//GEN-LAST:event_btnUpdateHDActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        try {
            String time = txtThoiGian.getText();

            time = time.replaceAll(":", "");
            time = time.replaceAll("/", "");
            time = time.replaceAll(" ", "_");
            StringBuilder file = new StringBuilder("results/hoadon");
            file.append(time).append(".pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file.toString()));

            document.open();
            BaseFont baseFont = BaseFont.createFont("D:\\QLBanHang\\Arial.ttf",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 26, Font.BOLD);
            Font font2 = new Font(baseFont, 18, Font.BOLD);
            Font font3 = new Font(baseFont, 10, Font.NORMAL);
            Font font3_bold = new Font(baseFont, 10, Font.BOLD);
            Font font4 = new Font(baseFont, 8, Font.NORMAL);
            //Khai báo 2 paragraph
            Paragraph paragraph1 = new Paragraph("Cửa hàng thời trang Classic", font);
            Paragraph paragraph2 = new Paragraph("Hóa đơn chi tiết", font2);
            //Định dạng đoạn văn bản thứ nhất
            paragraph1.setIndentationLeft(80);
            paragraph1.setIndentationRight(80);
            paragraph1.setFont(font);
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingAfter(5);
            //Đinh dạng đoạn văn bản thứ 2
            paragraph2.setSpacingBefore(5);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            //Thêm nội dung cho cả 2 đoạn văn bản trên

            //Thêm 2 đoạn văn bản vào document
            document.add(paragraph1);
            document.add(paragraph2);
            PdfPTable table1 = new PdfPTable(2);
            Phrase tenNV = new Paragraph("Thu ngân : " + txtTenNV.getText(), font3);
            Phrase tenKH = new Paragraph("Khách hàng : " + txtTenKH.getText(), font3);
            Phrase ThoiGian = new Paragraph("Thời gian : " + txtThoiGian.getText(), font3);
            Phrase sdtKH = new Paragraph("Số điện thoại : " + txtSdtKH.getText(), font3);
            PdfPCell NV = new PdfPCell(tenNV);
            NV.setBorder(PdfPCell.NO_BORDER);
            PdfPCell KH = new PdfPCell(tenKH);
            KH.setBorder(PdfPCell.NO_BORDER);
            PdfPCell TG = new PdfPCell(ThoiGian);
            TG.setBorder(PdfPCell.NO_BORDER);
            PdfPCell SDT = new PdfPCell(sdtKH);
            SDT.setBorder(PdfPCell.NO_BORDER);

            table1.addCell(NV);
            table1.addCell(KH);
            table1.addCell(TG);
            table1.addCell(SDT);
            table1.setSpacingBefore(5);
            document.add(table1);

            //Khởi tạo một table
            PdfPTable table = new PdfPTable(8);
            float[] columnWidths = new float[]{20f, 40f, 60f, 30f, 40f, 40f, 35f, 40f};
            table.setWidths(columnWidths);
            //Khởi tạo header
            PdfPCell header1 = new PdfPCell(new Paragraph("STT", font3));
            PdfPCell header2 = new PdfPCell(new Paragraph("Mã sản phẩm", font3));
            PdfPCell header3 = new PdfPCell(new Paragraph("Tên sản phẩm", font3));
            PdfPCell header4 = new PdfPCell(new Paragraph("SL mua", font3));
            PdfPCell header5 = new PdfPCell(new Paragraph("Đơn giá", font3));
            PdfPCell header6 = new PdfPCell(new Paragraph("Thành tiền", font3));
            PdfPCell header7 = new PdfPCell(new Paragraph("Chiết khấu(%)", font3));
            PdfPCell header8 = new PdfPCell(new Paragraph("Thanh toán", font3));
            header1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            header8.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            header1.setIndent(5);
//            header2.setIndent(5);
//            header3.setIndent(5);
//            header4.setIndent(5);
//            header5.setIndent(5);
//            header6.setIndent(5);
//            header7.setIndent(5);
//            header8.setIndent(5);

            //Thêm 8 ô header vào table
            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);
            table.addCell(header4);
            table.addCell(header5);
            table.addCell(header6);
            table.addCell(header7);
            table.addCell(header8);

            //Khởi tạo các dòng dl sản phẩm
            addRows(table, font3);
            table.setSpacingBefore(10);
            table.setHorizontalAlignment((Element.ALIGN_CENTER));
            document.add(table);

            Paragraph paragraph3 = new Paragraph("Tổng tiền: " + txtThanhTien.getText(), font3_bold);
//            paragraph3.setAlignment(Element.ALIGN_RIGHT);
            paragraph3.setIndentationLeft(350);

            Paragraph paragraph4 = new Paragraph("Tiền nhận: " + txtTienNhan.getText(), font3_bold);
//            paragraph4.setAlignment(Element.ALIGN_RIGHT);
            paragraph4.setIndentationLeft(350);

            Paragraph paragraph5 = new Paragraph("Tiền trả: " + txtTienThua.getText(), font3_bold);
//            paragraph5.setAlignment(Element.ALIGN_RIGHT);
            paragraph5.setIndentationLeft(350);

            document.add(paragraph3);
            document.add(paragraph4);
            document.add(paragraph5);

            document.close();

            btnTaoHDMoiActionPerformed(evt);
//show file            
            Desktop.getDesktop().open(new File(file.toString()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BanHangScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(BanHangScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BanHangScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:       
        DoiMatKhauScreen doiMatKhauScreen = new DoiMatKhauScreen();
        doiMatKhauScreen.setVisible(true);
        doiMatKhauScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        dispose();

    }//GEN-LAST:event_btnDoiMatKhauActionPerformed
    private void addRows(PdfPTable table, Font font) {
        int sohang = model.getRowCount();
        for (int i = 0; i < sohang; i++) {
            table.addCell(new Paragraph(model.getValueAt(i, 0).toString(), font));
            table.addCell(new Paragraph(model.getValueAt(i, 1).toString(), font));
            table.addCell(new Paragraph(model.getValueAt(i, 2).toString(), font));
            table.addCell(new Paragraph(model.getValueAt(i, 3).toString(), font));
            table.addCell(new Paragraph(model.getValueAt(i, 4).toString(), font));
            table.addCell(new Paragraph(model.getValueAt(i, 5).toString(), font));
            table.addCell(new Paragraph(model.getValueAt(i, 6).toString(), font));
            table.addCell(new Paragraph(model.getValueAt(i, 7).toString(), font));
        }

    }

    public void timkiem(String text) {
        String giatrithaythe = "";
        int batdau = text.length();

        System.out.println("do dai " + listsanpham.size());
        int ketthuc = text.length();
        for (int i = 0; i < listsanpham.size(); i++) {
            if (listsanpham.get(i).startsWith(text)) {
                giatrithaythe = listsanpham.get(i).toString();
                ketthuc = giatrithaythe.length();

                break;
            }
        }

        if (ketthuc > batdau) {

            txtMaSanPham.setText(giatrithaythe);
            txtMaSanPham.setCaretPosition(ketthuc);
            txtMaSanPham.moveCaretPosition(batdau);

        }

    }

    public void timkiemkhachhang(String text) {
        String giatrithaythe = "";
        int batdau = text.length();

        System.out.println("do dai " + listsanpham.size());
        int ketthuc = text.length();
        for (int i = 0; i < listkhachhang.size(); i++) {
            if (listkhachhang.get(i).startsWith(text)) {
                giatrithaythe = listkhachhang.get(i).toString();
                ketthuc = giatrithaythe.length();

                break;
            }
        }

        if (ketthuc > batdau) {

            txtSdtKH.setText(giatrithaythe);
            txtSdtKH.setCaretPosition(ketthuc);
            txtSdtKH.moveCaretPosition(batdau);

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BanHangScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnTaoHDMoi;
    private javax.swing.JButton btnThemVaoHoaDon;
    private javax.swing.JButton btnUpdateHD;
    private javax.swing.JButton btnXoaSPHoaDon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSdtKH;
    private javax.swing.JTextField txtSoLuongSP;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtThoiGian;
    private javax.swing.JTextField txtTienNhan;
    private javax.swing.JTextField txtTienThua;
    // End of variables declaration//GEN-END:variables
}
