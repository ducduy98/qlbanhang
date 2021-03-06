USE [QLCuaHang]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 18/06/2020 22:01:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[mahd] [int] NOT NULL,
	[masp] [int] NOT NULL,
	[soluongban] [int] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[mahd] ASC,
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 18/06/2020 22:01:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[mahd] [int] IDENTITY(1,1) NOT NULL,
	[makh] [int] NOT NULL,
	[ngayBan] [datetime] NULL,
	[manv] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mahd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 18/06/2020 22:01:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[makh] [int] IDENTITY(1,1) NOT NULL,
	[tenkh] [nvarchar](30) NULL,
	[sdt] [nchar](11) NULL,
	[diachi] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[makh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiHang]    Script Date: 18/06/2020 22:01:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiHang](
	[maLoaiHang] [int] IDENTITY(1,1) NOT NULL,
	[tenLoaiHang] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 18/06/2020 22:01:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [int] IDENTITY(1,1) NOT NULL,
	[tenNCC] [nvarchar](30) NULL,
	[diachi] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 18/06/2020 22:01:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[manv] [int] IDENTITY(1,1) NOT NULL,
	[tennv] [nvarchar](30) NOT NULL,
	[diachi] [nvarchar](40) NOT NULL,
	[sdt] [nchar](11) NOT NULL,
	[tentk] [nvarchar](30) NOT NULL,
	[pass] [nvarchar](30) NOT NULL,
	[isadmin] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 18/06/2020 22:01:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[masp] [int] IDENTITY(1,1) NOT NULL,
	[tensp] [nvarchar](30) NULL,
	[soluong] [int] NULL,
	[dongia] [float] NULL,
	[soluongTon] [int] NULL,
	[chietkhau] [float] NULL,
	[maLoaiHang] [int] NOT NULL,
	[maNCC] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (1, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (2, 1004, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (3, 1003, 1)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (4, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (5, 1004, 5)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (6, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (7, 1005, 1)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (12, 1003, 6)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (13, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (14, 1003, 1)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (15, 1006, 1)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (16, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (17, 1003, 23)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (18, 1006, 1)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (19, 1003, 5)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (20, 1003, 3)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (22, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (23, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (25, 1003, 111)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (26, 1004, 3)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (27, 1003, 2)
INSERT [dbo].[ChiTietHoaDon] ([mahd], [masp], [soluongban]) VALUES (28, 1003, 2)
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (1, 2, CAST(0x0000ABD800000000 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (2, 2, CAST(0x0000ABD800000000 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (3, 2, CAST(0x0000ABD800000000 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (4, 1, CAST(0x0000ABD800000000 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (5, 1, CAST(0x0000ABD800000000 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (6, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (7, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (8, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (9, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (10, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (11, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (12, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (13, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (14, 3, CAST(0x0000ABD800000000 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (15, 3, CAST(0x0000ABD800000000 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (16, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (17, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (18, 1, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (19, 3, CAST(0x0000ABD800000000 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (20, 3, CAST(0x0000AC8900F1FCD4 AS DateTime), 7)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (21, 3, CAST(0x0000ABD800F942F0 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (22, 3, CAST(0x0000ABD800F9AEC0 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (23, 3, CAST(0x0000ABD8010BDC44 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (24, 3, CAST(0x0000ABD8010BDC44 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (25, 3, CAST(0x0000ABD8010BDC44 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (26, 3, CAST(0x0000ABD8010D0268 AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (27, 3, CAST(0x0000ABD90098466C AS DateTime), 8)
INSERT [dbo].[HoaDon] ([mahd], [makh], [ngayBan], [manv]) VALUES (28, 3, CAST(0x0000ABDB00B5F02C AS DateTime), 8)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([makh], [tenkh], [sdt], [diachi]) VALUES (1, N'Lê Thanh Vân', N'0374813700 ', N'Thanh Hà-Hải Dương')
INSERT [dbo].[KhachHang] ([makh], [tenkh], [sdt], [diachi]) VALUES (2, N'Lê Văn Khánh', N'0374813720 ', N'Thanh Hà-Hải Dương')
INSERT [dbo].[KhachHang] ([makh], [tenkh], [sdt], [diachi]) VALUES (3, N'GUEST', N'0          ', N'Không rõ')
INSERT [dbo].[KhachHang] ([makh], [tenkh], [sdt], [diachi]) VALUES (4, N'Mạc Văn Khoa', N'0374813765 ', N'Thanh Miện-Hải Dương')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiHang] ON 

INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang]) VALUES (1, N'Quần Jean')
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang]) VALUES (2, N'Áo thun')
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang]) VALUES (3, N'Váy')
INSERT [dbo].[LoaiHang] ([maLoaiHang], [tenLoaiHang]) VALUES (4, N'Áo dài tay')
SET IDENTITY_INSERT [dbo].[LoaiHang] OFF
SET IDENTITY_INSERT [dbo].[NhaCungCap] ON 

INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachi]) VALUES (1, N'Adidas', N'132 Cầu Diễn')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachi]) VALUES (2, N'Uniqlo', N'156 Cầu Giấy')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachi]) VALUES (3, N'YODY', N'Hà Nam')
SET IDENTITY_INSERT [dbo].[NhaCungCap] OFF
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([manv], [tennv], [diachi], [sdt], [tentk], [pass], [isadmin]) VALUES (6, N'Nguyễn Đức Duy', N'Hải Dương', N'0355636650 ', N'admin', N'12345', 1)
INSERT [dbo].[NhanVien] ([manv], [tennv], [diachi], [sdt], [tentk], [pass], [isadmin]) VALUES (7, N'Nguyễn Văn Huy', N'Bắc Giang', N'0338548583 ', N'huy', N'12345', 0)
INSERT [dbo].[NhanVien] ([manv], [tennv], [diachi], [sdt], [tentk], [pass], [isadmin]) VALUES (8, N'Hoàng Văn Nam', N'Hải Phòng', N'0325636643 ', N'nam', N'12345', 0)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([masp], [tensp], [soluong], [dongia], [soluongTon], [chietkhau], [maLoaiHang], [maNCC]) VALUES (2, N'Quần Jean Bó Ống', 100, 3204, 100, 0, 1, 3)
INSERT [dbo].[SanPham] ([masp], [tensp], [soluong], [dongia], [soluongTon], [chietkhau], [maLoaiHang], [maNCC]) VALUES (3, N'Áo thun Nam', 100, 1000, 100, 0, 2, 2)
INSERT [dbo].[SanPham] ([masp], [tensp], [soluong], [dongia], [soluongTon], [chietkhau], [maLoaiHang], [maNCC]) VALUES (1003, N'Hoodie', 40, 500, 96, 0, 1, 1)
INSERT [dbo].[SanPham] ([masp], [tensp], [soluong], [dongia], [soluongTon], [chietkhau], [maLoaiHang], [maNCC]) VALUES (1004, N'Áo thun tay ngắn', 1000, 50000, 97, 0, 2, 3)
INSERT [dbo].[SanPham] ([masp], [tensp], [soluong], [dongia], [soluongTon], [chietkhau], [maLoaiHang], [maNCC]) VALUES (1005, N'Quần bò jean', 100, 100000, 100, 0, 1, 2)
INSERT [dbo].[SanPham] ([masp], [tensp], [soluong], [dongia], [soluongTon], [chietkhau], [maLoaiHang], [maNCC]) VALUES (1006, N'Váy hoa xòe', 50, 150000, 100, 0, 3, 1)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon] FOREIGN KEY([mahd])
REFERENCES [dbo].[HoaDon] ([mahd])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_SanPham] FOREIGN KEY([masp])
REFERENCES [dbo].[SanPham] ([masp])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang] FOREIGN KEY([makh])
REFERENCES [dbo].[KhachHang] ([makh])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien] FOREIGN KEY([manv])
REFERENCES [dbo].[NhanVien] ([manv])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_LoaiHang] FOREIGN KEY([maLoaiHang])
REFERENCES [dbo].[LoaiHang] ([maLoaiHang])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_LoaiHang]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_NhaCungCap] FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_NhaCungCap]
GO
