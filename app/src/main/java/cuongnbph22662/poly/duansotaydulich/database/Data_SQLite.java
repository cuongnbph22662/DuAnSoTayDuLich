package cuongnbph22662.poly.duansotaydulich.database;

public class Data_SQLite {
    public static final String INSERT_NGUOI_DUNG= "INSERT INTO NguoiDung(taiKhoan,hoTen,matKhau,soDienThoai,namSinh,diaChi) VALUES " +
            "('cuongnb1','Nguyễn Bá Cường','1','0339760892',2003,'Ha Noi')," +
            "('thuynt2','Nguyễn Thanh Thúy','2','0339760893',2004,'Mi Dinh')," +
            "('hoangttm3','Tạ Trần Minh Hoàng','3','0339760894',2005,'Moc Chau')," +
            "('hungvh4','Vũ Hải Hưng','4','0339760895',2006,'Ha Nam')," +
            "('thanhnh5','Nguyễn Hiếu Thành','5','0339760896',2006,'Thai Nguyen')";
    public static final String INSERT_THE_LOAI = "INSERT INTO TheLoai(tenTheLoai) VALUES " +
            "('Hà Nội')," +
            "('Hồ Chí Minh')," +
            "('Tây Nguyên')," +
            "('Đà Nẵng')," +
            "('Hà Nam')";
    public static final String INSERT_PHIEU_DU_LICH ="INSERT INTO PhieuDuLich (maTheLoai,tenDiaDiem,giaThue,noiDung,viTri) VALUES " +
            "(1,'Bar Hà Nội',30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(2,'Lăng Bác',30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(3,'Tam Chúc',30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(4,'Ba Vì',30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(5,'Vịnh Hạ Long',30000,'Hi hi','Hoài Đức Hà Nội')";
    public static final String INSERT_PHIEU_DU_LICH_CHI_TIET ="INSERT INTO PhieuDLChiTiet(taiKhoan,maPhieu,tienThue,SoLuongNguoi,NgayDat) VALUES " +
            "('cuongnb',1,30000,5,'2022/11/09')," +
            "('cuongnb',1,30000,5,'2022/11/09')";
}
