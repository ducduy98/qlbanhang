/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.NCC.NCCDAO;
import dao.NCC.NCCTable;
import dao.chitiethoadon.ChiTietHoaDonDAO;
import dao.khachhang.KhachHangDAO;
import dao.khachhang.KhachHangTable;
import dao.loaihang.LoaiHangDAO;
import dao.loaihang.LoaiHangTable;
import dao.nhanvien.NhanVienDAO;
import dao.nhanvien.NhanVienTable;
import dao.sanpham.SanPhamDAO;
import dao.sanpham.SanPhamTable;
import entity.KhachHang;
import entity.LoaiHang;
import entity.AccountSession;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ĐỨC DUY
 */
public class AdminScreen extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     */
    SanPhamDAO sanphamdao = new SanPhamDAO();
    ArrayList<SanPham> listSP = sanphamdao.selectAllSP();

    NCCDAO nccdao = new NCCDAO();
    ArrayList<NhaCungCap> listNCCFoCombo = nccdao.selectForCombo();
    ArrayList<NhaCungCap> listNCC = nccdao.selectAllNCC();

    KhachHangDAO khachHangDAO = new KhachHangDAO();
    ArrayList<KhachHang> listKH = khachHangDAO.selectAllKhachHang();

    LoaiHangDAO loaiHangDAO = new LoaiHangDAO();
    ArrayList<LoaiHang> listLoaiHang = loaiHangDAO.selectAllLoaiHang();

    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    ArrayList<NhanVien> listNV = nhanVienDAO.selectAllNV();

    public AdminScreen() {
        AccountSession lb = new AccountSession();
        initComponents();
        labelUser.setText(lb.getTaikhoan().toUpperCase());
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int sw = (int) d.getWidth();
        int sh = (int) d.getHeight();
        int fw = this.getWidth();
        int fh = this.getHeight();
        int xpos = (sw - fw) / 2;
        int ypos = (sh - fh) / 2;
        this.setLocation(xpos, ypos);

        panelSanPham.setVisible(true);
        panelLoaiHang.setVisible(false);
        panelNCC.setVisible(false);
        panelKH.setVisible(false);
        panelNV.setVisible(false);

        loadTableSanPham();
    }

    public void loadTableSanPham() {
        listNCCFoCombo = nccdao.selectForCombo();
        listLoaiHang = loaiHangDAO.selectAllLoaiHang();
        listSP = sanphamdao.selectAllSP();
        cboMaNCC.setModel(new DefaultComboBoxModel(listNCCFoCombo.toArray()));
        cboTimNCC.setModel(new DefaultComboBoxModel(listNCCFoCombo.toArray()));
        cboMaLoaiHang.setModel(new DefaultComboBoxModel(listLoaiHang.toArray()));
        cboTimLH.setModel(new DefaultComboBoxModel(listLoaiHang.toArray()));
        tblSanPham.setModel(new SanPhamTable(listSP));

        cboMaLoaiHang.setSelectedIndex(-1);
        cboMaNCC.setSelectedIndex(-1);
        cboTimLH.setSelectedIndex(-1);
        cboTimNCC.setSelectedIndex(-1);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblSanPham.setDefaultRenderer(String.class, centerRenderer);
        tblSanPham.setDefaultRenderer(Integer.class, centerRenderer);
        tblSanPham.setDefaultRenderer(Float.class, centerRenderer);

    }

    public void loadTableLoaiHang() {
        listLoaiHang = loaiHangDAO.selectAllLoaiHang();
        tblLoaiHang.setModel(new LoaiHangTable(listLoaiHang));
    }

    public void loadTableKhachHang() {
        listKH = khachHangDAO.selectAllKhachHang();
        tblKH.setModel(new KhachHangTable(listKH));
    }

    public void loadTableNCC() {
        listNCC = nccdao.selectAllNCC();
        tblNCC.setModel(new NCCTable(listNCC));
    }

    public void loadTableNhanVien() {
        listNV = nhanVienDAO.selectAllNV();
        tblNV.setModel(new NhanVienTable(listNV));
    }

    private void setSPDetail(SanPham sp) {
        txtMaSP.setText(String.valueOf(sp.getMasp()));
        txtTenSP.setText(sp.getTensp());
        txtDonGia.setText(String.valueOf(sp.getDongia()));
        txtSoLuongTon.setText(String.valueOf(sp.getSoluongTon()));
        txtChietKhau.setText(String.valueOf(sp.getChietkhau()));
        String NCCval = String.valueOf(sp.getMaNCC());
        for (int i = 0; i < listNCCFoCombo.size(); i++) {
            if (String.valueOf(listNCCFoCombo.get(i).getMaNCC()).equalsIgnoreCase(NCCval)) {

                System.out.println("cell=" + NCCval + " list=" + listNCCFoCombo.get(i).getMaNCC());

                cboMaNCC.setSelectedIndex(i);
            }

        }
        String loaiHangVal = String.valueOf(sp.getMaLoaiHang());
        for (int i = 0; i < listLoaiHang.size(); i++) {
            if (String.valueOf(listLoaiHang.get(i).getMaLoaiHang()).equalsIgnoreCase(loaiHangVal)) {

                System.out.println("cell=" + NCCval + " list=" + listLoaiHang.get(i).getMaLoaiHang());

                cboMaLoaiHang.setSelectedIndex(i);
            }

        }

//        cboMaNCC.setSelectedItem(sp.getMaNCC());
//        cboMaLoaiHang.
    }

    private void setLHDetail(LoaiHang lh) {
        txtMaLH.setText(String.valueOf(lh.getMaLoaiHang()));
        txtTenLH.setText(lh.getTenLoaiHang());
    }

    private void setKHDetail(KhachHang kh) {
        txtMaKH.setText(String.valueOf(kh.getMakh()));
        txtTenKH.setText(kh.getTenkh());
        txtSdtKH.setText(kh.getSdt());
        txtDiachiKH.setText(kh.getDiachi());
    }

    private void setNCCDetail(NhaCungCap ncc) {
        txtMaNCC.setText(String.valueOf(ncc.getMaNCC()));
        txtTenNCC.setText(ncc.getTenNCC());
        txtDiachiNCC.setText(ncc.getDiachi());
    }

    private void setNVDetail(NhanVien nv) {
        txtMaNV.setText(String.valueOf(nv.getManv()));
        txtTenNV.setText(nv.getTennv());
        txtSdtNV.setText(nv.getSdt());
        txtDiaChiNV.setText(nv.getDiachi());
        txtTaikhoanNV.setText(nv.getTentk());
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
        jLabel1 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnQuanLySP = new javax.swing.JButton();
        btnQuanLyLH = new javax.swing.JButton();
        btnQuanLyKH = new javax.swing.JButton();
        btnQuanLyNCC = new javax.swing.JButton();
        btnQuanLyNV = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelSanPham = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        btnTimSP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtSoLuongTon = new javax.swing.JTextField();
        txtChietKhau = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnSuaSp = new javax.swing.JButton();
        cboMaLoaiHang = new javax.swing.JComboBox<>();
        cboMaNCC = new javax.swing.JComboBox<>();
        cboTimLH = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cboTimNCC = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        btnHuyTimKiem = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtSoLuongNhap = new javax.swing.JTextField();
        btnNhapVaoKho = new javax.swing.JButton();
        panelLoaiHang = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTimLH = new javax.swing.JTextField();
        btnTimLH = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiHang = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaLH = new javax.swing.JTextField();
        txtTenLH = new javax.swing.JTextField();
        btnThemLH = new javax.swing.JButton();
        btnXoaLH = new javax.swing.JButton();
        btnSuaLH = new javax.swing.JButton();
        panelNCC = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtTimNCC = new javax.swing.JTextField();
        btnTimNCC = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        btnThemNCC = new javax.swing.JButton();
        btnXoaNCC = new javax.swing.JButton();
        btnSuaNCC = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtDiachiNCC = new javax.swing.JTextField();
        panelNV = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTimNV = new javax.swing.JTextField();
        btnTimNV = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtSdtNV = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtTaikhoanNV = new javax.swing.JTextField();
        btnSuaNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        btnThemNV = new javax.swing.JButton();
        panelKH = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtTimKH = new javax.swing.JTextField();
        btnCapNhatKH = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        jlabel15 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtSdtKH = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtDiachiKH = new javax.swing.JTextField();
        btnThemKH = new javax.swing.JButton();
        btnTimKH = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shopicon.png"))); // NOI18N
        jLabel1.setText("QUẢN TRỊ CỬA HÀNG");

        btnDangXuat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logOut.png"))); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnQuanLySP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/basketicon.png"))); // NOI18N
        btnQuanLySP.setText("QUẢN LÝ SẢN PHẨM");
        btnQuanLySP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLySPActionPerformed(evt);
            }
        });

        btnQuanLyLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/type_product.png"))); // NOI18N
        btnQuanLyLH.setText("QUẢN LÝ LOẠI HÀNG");
        btnQuanLyLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyLHActionPerformed(evt);
            }
        });

        btnQuanLyKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/shoppingicon.png"))); // NOI18N
        btnQuanLyKH.setText("QUẢN LÝ KHÁCH HÀNG");
        btnQuanLyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyKHActionPerformed(evt);
            }
        });

        btnQuanLyNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/RefreshCLicon.png"))); // NOI18N
        btnQuanLyNCC.setText("QUẢN LÝ NHÀ CUNG CẤP");
        btnQuanLyNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNCCActionPerformed(evt);
            }
        });

        btnQuanLyNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nv.png"))); // NOI18N
        btnQuanLyNV.setText("QUẢN LÝ NHÂN VIÊN");
        btnQuanLyNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuanLySP)
                .addGap(44, 44, 44)
                .addComponent(btnQuanLyLH)
                .addGap(37, 37, 37)
                .addComponent(btnQuanLyNCC)
                .addGap(38, 38, 38)
                .addComponent(btnQuanLyKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnQuanLyNV)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuanLySP)
                            .addComponent(btnQuanLyLH)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnQuanLyNV, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnQuanLyKH)
                                .addComponent(btnQuanLyNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel28.setText("Xin chào :");

        labelUser.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labelUser.setText("---------");

        panelSanPham.setBorder(new javax.swing.border.MatteBorder(null));
        panelSanPham.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tìm kiếm sản phẩm");

        btnTimSP.setText("Tìm Sản Phẩm");
        btnTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSPActionPerformed(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jLabel3.setText("Mã sản phẩm");

        jLabel4.setText("Tên sản phẩm");

        jLabel6.setText("Đơn giá");

        jLabel8.setText("Chiết khấu");

        jLabel9.setText("Nhà Cung Cấp");

        jLabel10.setText("Loại hàng");

        jLabel11.setText("Số lượng trong kho");

        txtMaSP.setText("0");
        txtMaSP.setEnabled(false);

        txtDonGia.setText("0");

        txtSoLuongTon.setEditable(false);
        txtSoLuongTon.setText("0");

        txtChietKhau.setText("0");

        btnThemSP.setText("Thêm Sản phẩm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa Sản phẩm");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnSuaSp.setText("Sửa Sản phẩm");
        btnSuaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSpActionPerformed(evt);
            }
        });

        cboMaLoaiHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMaNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboTimLH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setText("Tên Sản phẩm");

        jLabel30.setText("Loại hàng");

        cboTimNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel31.setText("Nhà cung cấp");

        btnHuyTimKiem.setText("Hủy tìm kiếm");
        btnHuyTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTimKiemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("NHẬP HÀNG");

        jLabel32.setText("Số lượng nhập thêm");

        txtSoLuongNhap.setText("0");

        btnNhapVaoKho.setText("Nhập Vào Kho");
        btnNhapVaoKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapVaoKhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSanPhamLayout = new javax.swing.GroupLayout(panelSanPham);
        panelSanPham.setLayout(panelSanPhamLayout);
        panelSanPhamLayout.setHorizontalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSanPhamLayout.createSequentialGroup()
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(31, 31, 31)
                                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))
                                        .addGap(54, 54, 54)
                                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtChietKhau)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(33, 33, 33)
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoLuongTon)
                                    .addComponent(cboMaLoaiHang, 0, 217, Short.MAX_VALUE)
                                    .addComponent(cboMaNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(119, 119, 119)
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSuaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemSP)
                                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(32, 32, 32))))
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel2)
                .addGap(116, 116, 116)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboTimNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboTimLH, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(30, 30, 30)
                        .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(151, 151, 151)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuyTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(136, 136, 136))
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(btnNhapVaoKho))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSanPhamLayout.setVerticalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimSP)
                            .addComponent(jLabel29)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTimLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(10, 10, 10)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTimNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnHuyTimKiem)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemSP))
                        .addGap(18, 18, 18)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSuaSp)
                            .addComponent(cboMaLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(btnXoaSP))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(22, 22, 22)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(cboMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapVaoKho))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelLoaiHang.setBorder(new javax.swing.border.MatteBorder(null));
        panelLoaiHang.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Tìm kiếm loại hàng theo tên");

        btnTimLH.setText("Tìm Loại Hàng");
        btnTimLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimLHActionPerformed(evt);
            }
        });

        tblLoaiHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLoaiHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiHang);

        jLabel12.setText("Mã Loại hàng");

        jLabel13.setText("Tên Loại Hàng");

        txtMaLH.setText("0");
        txtMaLH.setEnabled(false);

        btnThemLH.setText("Thêm Loại Hàng");
        btnThemLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLHActionPerformed(evt);
            }
        });

        btnXoaLH.setText("Xóa Loại Hàng");
        btnXoaLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLHActionPerformed(evt);
            }
        });

        btnSuaLH.setText("Sửa Loại Hàng");
        btnSuaLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoaiHangLayout = new javax.swing.GroupLayout(panelLoaiHang);
        panelLoaiHang.setLayout(panelLoaiHangLayout);
        panelLoaiHangLayout.setHorizontalGroup(
            panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoaiHangLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoaiHangLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelLoaiHangLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(46, 46, 46)
                                .addComponent(txtTenLH))
                            .addGroup(panelLoaiHangLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(52, 52, 52)
                                .addComponent(txtMaLH, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)
                        .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemLH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaLH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaLH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelLoaiHangLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(txtTimLH, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTimLH))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        panelLoaiHangLayout.setVerticalGroup(
            panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoaiHangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTimLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimLH))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoaiHangLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtMaLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panelLoaiHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTenLH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLoaiHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnThemLH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaLH)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaLH)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        panelNCC.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setText("Tìm kiếm NCC theo tên");

        btnTimNCC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTimNCC.setText("Tìm Loại Hàng");
        btnTimNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimNCCActionPerformed(evt);
            }
        });

        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNCCMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblNCC);

        jLabel18.setText("Mã nhà cung cấp");

        jLabel19.setText("Tên nhà cung cấp");

        txtMaNCC.setText("0");
        txtMaNCC.setEnabled(false);

        btnThemNCC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnThemNCC.setText("Thêm Nhà Cung Cấp");
        btnThemNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNCCActionPerformed(evt);
            }
        });

        btnXoaNCC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnXoaNCC.setText("Xóa Nhà Cung Cấp");
        btnXoaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNCCActionPerformed(evt);
            }
        });

        btnSuaNCC.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSuaNCC.setText("Sửa Nhà Cung Cấp");
        btnSuaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNCCActionPerformed(evt);
            }
        });

        jLabel20.setText("Đ/c nhà cung cấp");

        javax.swing.GroupLayout panelNCCLayout = new javax.swing.GroupLayout(panelNCC);
        panelNCC.setLayout(panelNCCLayout);
        panelNCCLayout.setHorizontalGroup(
            panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNCCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelNCCLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(50, 50, 50)
                        .addComponent(txtTimNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnTimNCC)
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(panelNCCLayout.createSequentialGroup()
                        .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelNCCLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(46, 46, 46)
                                .addComponent(txtTenNCC))
                            .addGroup(panelNCCLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(52, 52, 52)
                                .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelNCCLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(46, 46, 46)
                                .addComponent(txtDiachiNCC)))
                        .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNCCLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemNCC))
                            .addGroup(panelNCCLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSuaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        panelNCCLayout.setVerticalGroup(
            panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNCCLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTimNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimNCC))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNCC))
                .addGap(33, 33, 33)
                .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNCC))
                .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNCCLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panelNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtDiachiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNCCLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaNCC)
                        .addGap(29, 29, 29))))
        );

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("Tìm kiếm nhân viên theo tên");

        btnTimNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTimNV.setText("Tìm nhân viên");
        btnTimNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimNVActionPerformed(evt);
            }
        });

        jLabel23.setText("Mã nhân viên");

        txtMaNV.setEditable(false);
        txtMaNV.setText("0");

        jLabel24.setText("Tên nhân viên");

        jLabel25.setText("Địa chỉ");

        jLabel26.setText("SĐT");

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblNV);

        jLabel27.setText("Tài khoản");

        btnSuaNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSuaNV.setText("Sửa thông tin NV");
        btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNVActionPerformed(evt);
            }
        });

        btnXoaNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoaNV.setText("Xóa NV");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        btnThemNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThemNV.setText("Thêm NV");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNVLayout = new javax.swing.GroupLayout(panelNV);
        panelNV.setLayout(panelNVLayout);
        panelNVLayout.setHorizontalGroup(
            panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNVLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNVLayout.createSequentialGroup()
                        .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNVLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNVLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(75, 75, 75))
                            .addGroup(panelNVLayout.createSequentialGroup()
                                .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23))
                                .addGap(19, 19, 19)))
                        .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChiNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSdtNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelNVLayout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTaikhoanNV, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSuaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNVLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNVLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel15)
                .addGap(37, 37, 37)
                .addComponent(txtTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimNV)
                .addGap(23, 23, 23))
        );
        panelNVLayout.setVerticalGroup(
            panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNVLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtTaikhoanNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNV))
                .addGap(23, 23, 23)
                .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNV))
                .addGap(18, 18, 18)
                .addGroup(panelNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtSdtNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNV))
                .addGap(36, 36, 36))
        );

        panelKH.setEnabled(false);
        panelKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("Tìm kiếm theo tên");

        btnCapNhatKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCapNhatKH.setText(" Cập nhật thông tin Khách hàng");
        btnCapNhatKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatKHActionPerformed(evt);
            }
        });

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKH);

        jlabel15.setText("Mã khách hàng");

        txtMaKH.setEditable(false);
        txtMaKH.setText("0");

        jLabel16.setText("Tên khách hàng");

        jLabel21.setText("Số điện thoại");

        jLabel22.setText("Địa chỉ");

        btnThemKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThemKH.setText("Thêm Khách hàng");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnTimKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTimKH.setText("Tìm Khách hàng");
        btnTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKHLayout = new javax.swing.GroupLayout(panelKH);
        panelKH.setLayout(panelKHLayout);
        panelKHLayout.setHorizontalGroup(
            panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panelKHLayout.createSequentialGroup()
                        .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelKHLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addGroup(panelKHLayout.createSequentialGroup()
                                        .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16)
                                            .addComponent(jlabel15))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelKHLayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(56, 56, 56)
                                .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCapNhatKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelKHLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(27, 27, 27)
                                .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnTimKH)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelKHLayout.setVerticalGroup(
            panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKHLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKH))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKHLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(btnCapNhatKH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(29, 29, 29))
        );

        jLayeredPane1.setLayer(panelSanPham, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelLoaiHang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelNCC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelNV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelKH, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1107, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 14, Short.MAX_VALUE)
                    .addComponent(panelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(227, 227, 227)
                    .addComponent(panelNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(227, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(panelNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(207, 207, 207)
                    .addComponent(panelKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(208, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(panelNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(panelNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(panelKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(340, 340, 340)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel28)
                            .addComponent(labelUser)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDangXuat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDoiMatKhau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public SanPham getDetailSP() {
        SanPham sp = new SanPham();
        if (txtMaSP.getText().equals("") || txtDonGia.getText().equals("")
                || txtChietKhau.getText().equals("") || txtSoLuongTon.getText().equals("")
                || cboMaLoaiHang.getSelectedIndex() == -1 || cboMaNCC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Nhập chưa đủ thông tin sản phẩm");
            return null;

        } else {
            sp.setMasp(Integer.parseInt(txtMaSP.getText()));
            sp.setTensp(txtTenSP.getText().toString());
            sp.setDongia(Float.parseFloat(txtDonGia.getText()));
            sp.setChietkhau(Float.parseFloat(txtChietKhau.getText()));
            sp.setSoluongTon(Integer.parseInt(txtSoLuongTon.getText()));
            sp.setMaLoaiHang(listLoaiHang.get(cboMaLoaiHang.getSelectedIndex()).getMaLoaiHang());
            sp.setMaNCC(listNCCFoCombo.get(cboMaNCC.getSelectedIndex()).getMaNCC());
            return sp;
        }
    }

    public LoaiHang getDetailLH() {
        if (txtMaLH.getText().equals("") || txtTenLH.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đủ thông tin loại hàng!!!");
            return null;
        } else {
            LoaiHang lh = new LoaiHang();
            lh.setMaLoaiHang(Integer.parseInt(txtMaLH.getText()));
            lh.setTenLoaiHang(String.valueOf(txtTenLH.getText()));
            return lh;
        }
    }

    public NhaCungCap getDetailNCC() {
        if (txtMaNCC.getText().equals("") || txtTenNCC.getText().equals("") || txtDiachiNCC.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đủ thông tin nhà cung cấp!!!");
            return null;
        } else {
            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNCC(Integer.parseInt(txtMaNCC.getText()));
            ncc.setTenNCC(String.valueOf(txtTenNCC.getText()));
            ncc.setDiachi(String.valueOf(txtDiachiNCC.getText()));
            return ncc;
        }
    }

    public KhachHang getDetailKH() {
        if (txtTenKH.getText().equals("") || txtSdtKH.getText().equals("") || txtDiachiKH.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đủ thông tin khách hàng!!!");
            return null;
        } else {
            KhachHang kh = new KhachHang();
            kh.setMakh(Integer.parseInt(txtMaKH.getText()));
            kh.setTenkh(String.valueOf(txtTenKH.getText()));
            kh.setSdt(String.valueOf(txtSdtKH.getText()));
            kh.setDiachi(String.valueOf(txtDiachiKH.getText()));
            return kh;
        }
    }

    public NhanVien getDetailNV() {
        if (txtMaNV.getText().equals("") || txtTenNV.getText().equals("") || txtDiaChiNV.getText().equals("")
                || txtSdtNV.getText().equals("") || txtTaikhoanNV.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đủ các trường dữ liệu!!!");
            return null;
        } else {
            NhanVien nv = new NhanVien();
            nv.setManv(Integer.parseInt(txtMaNV.getText()));
            nv.setTennv(String.valueOf(txtTenNV.getText()));
            nv.setDiachi(String.valueOf(txtDiaChiNV.getText()));
            nv.setSdt(String.valueOf(txtSdtNV.getText()));
            nv.setTentk(String.valueOf(txtTaikhoanNV.getText().trim()));
            return nv;
        }
    }

    public void clearTextSP() {
        txtMaSP.setText("0");
        txtChietKhau.setText("0");
        txtDonGia.setText("0");
        txtSoLuongNhap.setText("0");
        txtSoLuongTon.setText("0");
        txtTenSP.setText("");
        cboMaLoaiHang.setSelectedIndex(-1);
        cboMaNCC.setSelectedIndex(-1);
    }

    public void clearTextLH() {
        txtMaLH.setText("0");
        txtTenLH.setText("");
    }

    public void clearTextNCC() {
        txtMaNCC.setText("0");
        txtTenNCC.setText("");
        txtDiachiNCC.setText("");
    }

    public void clearTextKH() {
        txtMaKH.setText("0");
        txtTenKH.setText("");
        txtSdtKH.setText("");
        txtDiachiKH.setText("");

    }

    public void clearTextNV() {
        txtMaNV.setText("0");
        txtTenNV.setText("");
        txtDiaChiNV.setText("");
        txtSdtNV.setText("");
        txtTaikhoanNV.setText("");
    }

    private void btnSuaLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLHActionPerformed
        // TODO add your handling code here:
        LoaiHang lh = getDetailLH();
        boolean kq = loaiHangDAO.updateLoaiHang(lh);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể cập nhật");
        }
        loadTableLoaiHang();
        clearTextLH();
    }//GEN-LAST:event_btnSuaLHActionPerformed

    private void btnXoaLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLHActionPerformed
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(null,
                "Xóa loại hàng sẽ xóa tất cả các thông tin liên quan về sản phẩm và các hóa đơn. Bạn có chắc chắn xóa???", "Xóa Loại hàng?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
            ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
            int malh = Integer.parseInt(txtMaLH.getText());
            ArrayList<SanPham> listDel = sanphamdao.findAllSPByMaLoaiHang(malh);
            for (SanPham sanPham : listDel) {
                chiTietHoaDonDAO.deleteChiTietHoaDonByMaSP(sanPham.getMasp());
            }
            sanphamdao.deleteSPByMaLoaiHang(malh);
            boolean kq = loaiHangDAO.deleteLoaiHang(malh);
            loadTableLoaiHang();
            clearTextLH();
            if (kq) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa");
            }
        }
    }//GEN-LAST:event_btnXoaLHActionPerformed

    private void btnThemLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLHActionPerformed
        // TODO add your handling code here:
        LoaiHang lh = getDetailLH();
        lh.setMaLoaiHang(1);
        boolean kq = loaiHangDAO.insertLoaiHang(lh);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể thêm");
        }
        loadTableLoaiHang();
        clearTextLH();
    }//GEN-LAST:event_btnThemLHActionPerformed

    private void tblLoaiHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiHangMouseClicked
        // TODO add your handling code here:
        int dong = tblLoaiHang.getSelectedRow();
        System.out.println("dong = " + dong);
        LoaiHang lh = listLoaiHang.get(dong);
        setLHDetail(lh);
    }//GEN-LAST:event_tblLoaiHangMouseClicked

    private void btnTimLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimLHActionPerformed
        // TODO add your handling code here:
        String key = txtTimLH.getText();
        ArrayList<LoaiHang> listFind = loaiHangDAO.findLoaiHang(key);
        tblLoaiHang.setModel(new LoaiHangTable(listFind));
    }//GEN-LAST:event_btnTimLHActionPerformed


    private void btnSuaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNCCActionPerformed
        // TODO add your handling code here:
        NhaCungCap ncc = getDetailNCC();

        boolean kq = nccdao.updateNCC(ncc);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể cập nhật");
        }
        loadTableNCC();
        clearTextNCC();
    }//GEN-LAST:event_btnSuaNCCActionPerformed

    private void btnXoaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNCCActionPerformed
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(null,
                "Xóa Nhà cung cấp sẽ xóa tất cả các thông tin liên quan về sản phẩm và các hóa đơn. Bạn có chắc chắn xóa???", "Xóa Nhà cung cấp?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
            int maNCC = Integer.parseInt(txtMaNCC.getText());
            ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
            ArrayList<SanPham> listDEL = sanphamdao.findAllSPByMaNCC(maNCC);
            for (SanPham sanPham : listDEL) {
                chiTietHoaDonDAO.deleteChiTietHoaDonByMaSP(sanPham.getMasp());
            }
            sanphamdao.deleteSPByMaNCC(maNCC);
            boolean kq = nccdao.deleteNCC(maNCC);
            loadTableNCC();
            clearTextNCC();
            if (kq) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa");
            }
        }
    }//GEN-LAST:event_btnXoaNCCActionPerformed

    private void btnThemNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNCCActionPerformed
        // TODO add your handling code here:
        NhaCungCap ncc = getDetailNCC();
        ncc.setMaNCC(1);
        boolean kq = nccdao.insertNCC(ncc);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể thêm");
        }
        loadTableNCC();
        clearTextNCC();
    }//GEN-LAST:event_btnThemNCCActionPerformed

    private void tblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNCCMouseClicked
        // TODO add your handling code here:
        int dong = tblNCC.getSelectedRow();
        System.out.println("dong = " + dong);
        NhaCungCap ncc = listNCC.get(dong);
        setNCCDetail(ncc);

    }//GEN-LAST:event_tblNCCMouseClicked

    private void btnTimNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimNCCActionPerformed
        // TODO add your handling code here:
        String key = txtTimNCC.getText();
        ArrayList<NhaCungCap> listFind = nccdao.findNCC(key);
        tblNCC.setModel(new NCCTable(listFind));
    }//GEN-LAST:event_btnTimNCCActionPerformed


    private void btnSuaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSpActionPerformed
        // TODO add your handling code here:
        SanPham sp = getDetailSP();
        boolean kq = sanphamdao.updateSP(sp);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể cập nhật");
        }
        loadTableSanPham();
        clearTextSP();
    }//GEN-LAST:event_btnSuaSpActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // TODO add your handling code here:
        int input = JOptionPane.showConfirmDialog(null,
                "Xóa sản phẩm sẽ xóa tất cả các thông tin liên quan về các hóa đơn. Bạn có chắc chắn xóa???", "XóaSản phẩm?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input == 0) {
            int masp = Integer.parseInt(txtMaSP.getText());
            ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
            chiTietHoaDonDAO.deleteChiTietHoaDonByMaSP(masp);
            boolean kq = sanphamdao.deleteSP(masp);
            loadTableSanPham();
            clearTextSP();
            if (kq) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không thể xóa");
            }
        }
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        // TODO add your handling code here:
        SanPham sp = getDetailSP();
        sp.setMasp(1);
        boolean kq = sanphamdao.insertSP(sp);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể thêm");
        }
        loadTableSanPham();
        clearTextSP();
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int dong = tblSanPham.getSelectedRow();
        System.out.println("dong = " + dong);
        SanPham sp = listSP.get(dong);
        setSPDetail(sp);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSPActionPerformed
        // TODO add your handling code here:
        String name = txtTimSP.getText();
        int maLH = -1;
        int maNCC = -1;
        if (-1 != cboTimLH.getSelectedIndex()) {
            maLH = listLoaiHang.get(cboTimLH.getSelectedIndex()).getMaLoaiHang();
        }
        if (-1 != cboTimNCC.getSelectedIndex()) {
            maNCC = listNCC.get(cboTimNCC.getSelectedIndex()).getMaNCC();
        }

        StringBuilder sql = new StringBuilder("select * from SanPham where tensp like'%" + name + "%' ");
        if (-1 != maLH) {
            sql.append("and maLoaiHang=" + maLH + " ");
        }
        if (-1 != maNCC) {
            sql.append("and maNCC=" + maNCC + " ");
        }

        ArrayList<SanPham> listFind = sanphamdao.findSanPham(sql.toString());
        tblSanPham.setModel(new SanPhamTable(listFind));
    }//GEN-LAST:event_btnTimSPActionPerformed

    private void btnQuanLyLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyLHActionPerformed
        // TODO add your handling code here:
        panelSanPham.setVisible(false);
        panelLoaiHang.setVisible(true);
        panelKH.setVisible(false);
        panelNCC.setVisible(false);
        panelNV.setVisible(false);
        loadTableLoaiHang();
    }//GEN-LAST:event_btnQuanLyLHActionPerformed
    private void btnQuanLySPActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        panelSanPham.setVisible(true);
        panelLoaiHang.setVisible(false);
        panelKH.setVisible(false);
        panelNCC.setVisible(false);
        loadTableSanPham();
    }
//GEN-FIRST:event_btnQuanLySPActionPerformed

//GEN-LAST:event_btnQuanLySPActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        KhachHang kh = getDetailKH();
        boolean check = khachHangDAO.findByPhone(txtSdtKH.getText());
        if (check) {
            JOptionPane.showMessageDialog(rootPane, "SĐT đã được đăng kí!!!");
        } else {
            if (null != kh) {
                kh.setMakh(1);
                boolean kq = khachHangDAO.insertKhachHang(kh);
                if (kq) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không thể thêm");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không thể thêm");
            }
        }

        loadTableKhachHang();
        clearTextKH();
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnCapNhatKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatKHActionPerformed
        // TODO add your handling code here:
        KhachHang kh = getDetailKH();
        boolean kq = khachHangDAO.updateKhachHang(kh);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể cập nhật");
        }
        loadTableKhachHang();
        clearTextKH();
    }//GEN-LAST:event_btnCapNhatKHActionPerformed

//    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
//        int makh = Integer.parseInt(txtMaKH.getText());
//        boolean kq = khachHangDAO.deleteKhachHang(makh);
//        loadTableKhachHang();
//        clearTextKH();
//        if (kq) {
//            JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Không thể xóa");
//        }
//    }

    private void btnQuanLyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyKHActionPerformed
        // TODO add your handling code here:
        panelSanPham.setVisible(false);
        panelLoaiHang.setVisible(false);
        panelKH.setVisible(true);
        panelNCC.setVisible(false);
        panelNV.setVisible(false);
        loadTableKhachHang();
    }//GEN-LAST:event_btnQuanLyKHActionPerformed

    private void btnQuanLyNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNCCActionPerformed
        panelSanPham.setVisible(false);
        panelLoaiHang.setVisible(false);
        panelKH.setVisible(false);
        panelNCC.setVisible(true);
        panelNV.setVisible(false);
        loadTableNCC();        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNCCActionPerformed

    private void btnTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHActionPerformed
        // TODO add your handling code here:
        String key = txtTimKH.getText();
        ArrayList<KhachHang> listFind = khachHangDAO.findKhachHang(key);
        tblKH.setModel(new KhachHangTable(listFind));
    }//GEN-LAST:event_btnTimKHActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
        // TODO add your handling code here:
        int dong = tblKH.getSelectedRow();
        KhachHang kh = listKH.get(dong);
        setKHDetail(kh);
    }//GEN-LAST:event_tblKHMouseClicked


    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        // TODO add your handling code here:
        NhanVien nv = getDetailNV();
        nv.setManv(1);
        //set mac dinh pass nhan vien == 1
        nv.setPass("1");
//        nv.setIsadmin(false);
        boolean kq = nhanVienDAO.insertNV(nv);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể thêm");
        }
        loadTableNhanVien();
        clearTextNV();
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNVActionPerformed
        // TODO add your handling code here:
        NhanVien nv = getDetailNV();
        //set mac dinh pass nhan vien == 1
//        nv.setPass("1");
//        nv.setIsadmin(false);
        boolean kq = nhanVienDAO.updateNV(nv);
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể cập nhật");
        }
        loadTableNhanVien();
        clearTextNV();
    }//GEN-LAST:event_btnSuaNVActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        // TODO add your handling code here:
        int manv = Integer.parseInt(txtMaNV.getText());
        boolean kq = nhanVienDAO.deleteNV(manv);
        loadTableNhanVien();
        clearTextNV();
        if (kq) {
            JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không thể xóa");
        }
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnTimNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimNVActionPerformed
        // TODO add your handling code here:
        String key = txtTimNV.getText().trim().toLowerCase();
        ArrayList<NhanVien> listFind = nhanVienDAO.findNVTable(key);
        tblNV.setModel(new NhanVienTable(listFind));
    }//GEN-LAST:event_btnTimNVActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        // TODO add your handling code here:
        int dong = tblNV.getSelectedRow();
        NhanVien nv = listNV.get(dong);
        setNVDetail(nv);
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnQuanLyNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNVActionPerformed
        // TODO add your handling code here:
        panelSanPham.setVisible(false);
        panelLoaiHang.setVisible(false);
        panelKH.setVisible(false);
        panelNCC.setVisible(false);
        panelNV.setVisible(true);
        loadTableNhanVien();
    }//GEN-LAST:event_btnQuanLyNVActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhapScreen dangNhapScreen = new DangNhapScreen();
        dangNhapScreen.setVisible(true);
        dangNhapScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnHuyTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTimKiemActionPerformed
        // TODO add your handling code here:
        txtTimSP.setText("");
        loadTableSanPham();
    }//GEN-LAST:event_btnHuyTimKiemActionPerformed

    private void btnNhapVaoKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapVaoKhoActionPerformed
        // TODO add your handling code here:
        try {
            int slton = 0, slThem = 0;

            int slUpdate = 0;
            if (txtSoLuongTon.getText() != "") {
                slton = Integer.parseInt(txtSoLuongTon.getText());
            }
            if (txtSoLuongNhap.getText() != "") {
                slThem = Integer.parseInt(txtSoLuongNhap.getText());
            }
            slUpdate = slton + slThem;
            SanPham sp = getDetailSP();
            sp.setSoluongTon(slUpdate);
            boolean kq = sanphamdao.updateSP(sp);
            if (kq) {
                JOptionPane.showMessageDialog(rootPane, "Nhập kho thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nhập kho thất bại");
            }
            loadTableSanPham();
            clearTextSP();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Nhập đúng định dạng dữ liệu");
        }
    }//GEN-LAST:event_btnNhapVaoKhoActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        DoiMatKhauScreen doiMatKhauScreen = new DoiMatKhauScreen();
        doiMatKhauScreen.setVisible(true);
        doiMatKhauScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        dispose();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

// end button head
//    END PANEL LOAIHANG
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
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatKH;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHuyTimKiem;
    private javax.swing.JButton btnNhapVaoKho;
    private javax.swing.JButton btnQuanLyKH;
    private javax.swing.JButton btnQuanLyLH;
    private javax.swing.JButton btnQuanLyNCC;
    private javax.swing.JButton btnQuanLyNV;
    private javax.swing.JButton btnQuanLySP;
    private javax.swing.JButton btnSuaLH;
    private javax.swing.JButton btnSuaNCC;
    private javax.swing.JButton btnSuaNV;
    private javax.swing.JButton btnSuaSp;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThemLH;
    private javax.swing.JButton btnThemNCC;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnTimKH;
    private javax.swing.JButton btnTimLH;
    private javax.swing.JButton btnTimNCC;
    private javax.swing.JButton btnTimNV;
    private javax.swing.JButton btnTimSP;
    private javax.swing.JButton btnXoaLH;
    private javax.swing.JButton btnXoaNCC;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> cboMaLoaiHang;
    private javax.swing.JComboBox<String> cboMaNCC;
    private javax.swing.JComboBox<String> cboTimLH;
    private javax.swing.JComboBox<String> cboTimNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlabel15;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPanel panelKH;
    private javax.swing.JPanel panelLoaiHang;
    private javax.swing.JPanel panelNCC;
    private javax.swing.JPanel panelNV;
    private javax.swing.JPanel panelSanPham;
    private javax.swing.JTable tblKH;
    private javax.swing.JTable tblLoaiHang;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTable tblNV;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtDiachiKH;
    private javax.swing.JTextField txtDiachiNCC;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaLH;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSdtKH;
    private javax.swing.JTextField txtSdtNV;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTaikhoanNV;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenLH;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKH;
    private javax.swing.JTextField txtTimLH;
    private javax.swing.JTextField txtTimNCC;
    private javax.swing.JTextField txtTimNV;
    private javax.swing.JTextField txtTimSP;
    // End of variables declaration//GEN-END:variables
}
