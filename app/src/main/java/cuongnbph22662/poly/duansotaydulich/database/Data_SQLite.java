package cuongnbph22662.poly.duansotaydulich.database;

public class Data_SQLite {
    public static final String INSERT_NGUOI_DUNG= "INSERT INTO NguoiDung(taiKhoan,hoTen,matKhau,soDienThoai) VALUES " +
            "('cuongnb','Nguyễn Bá Cường','1','0339760892')," +
            "('thuynt','Nguyễn Thanh Thúy','1','0339760892')," +
            "('hoangttm','Tạ Trần Minh Hoàng','1','0339760892')," +
            "('hungvh','Vũ Hải Hưng','1','0339760892')," +
            "('thanhnh','Nguyễn Hiếu Thành','1','0339760892')";
    public static final String INSERT_THE_LOAI = "INSERT INTO TheLoai(tenTheLoai) VALUES " +
            "('Hà Nội')," +
            "('Hồ Chí Minh')," +
            "('Tây Nguyên')," +
            "('Đà Nẵng')," +
            "('Hà Nam')";
    public static final String INSERT_PHIEU_DU_LICH ="INSERT INTO PhieuDuLich (maTheLoai,giaThue,noiDung,diaChi) VALUES " +
            "(1,30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(2,30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(3,30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(4,30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(5,30000,'Hi hi','Hoài Đức Hà Nội')";
    public static final String INSERT_PHIEU_DU_LICH_CHI_TIET ="INSERT INTO PhieuDLChiTiet(taiKhoan,maPhieu,tienThue,SoLuongNguoi,NgayDat) VALUES " +
            "('cuongnb',1,30000,5,'2022/11/09')," +
            "('cuongnb',1,30000,5,'2022/11/09')";
}
