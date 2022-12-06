package cuongnbph22662.poly.duansotaydulich.database;

public class Data_SQLite {
    public static final String INSERT_NGUOI_DUNG= "INSERT INTO NguoiDung(taiKhoan,hoTen,matKhau,soDienThoai,namSinh,diaChi,gioiTinh) VALUES " +
            "('cuongnb','Nguyễn Bá Cường','1','0339760892',2003,'Ha Noi','Nam')," +
            "('thuynt','Nguyễn Thanh Thúy','2','0339760893',2004,'Mi Dinh','Nữ')," +
            "('hoangttm','Tạ Trần Minh Hoàng','3','0339760894',2005,'Moc Chau','Nam')," +
            "('hungvh','Vũ Hải Hưng','4','0339760895',2006,'Ha Nam','Nam')," +
            "('thanhnh','Nguyễn Hiếu Thành','5','0339760896',2006,'Thai Nguyen','Nam')";
    public static final String INSERT_THANH_PHO = "INSERT INTO ThanhPho(tenThanhPho) VALUES " +
            "('Hà Nội')," +
            "('Hồ Chí Minh')," +
            "('Tây Nguyên')," +
            "('Đà Nẵng')," +
            "('Hà Nam')";
    public static final String INSERT_DIA_DIEM ="INSERT INTO DiaDiem (maThanhPho,tenDiaDiem,giaThue,noiDung,viTri) VALUES " +
            "(1,'Nhà thờ lớn hà nội',5000,'Nhà thờ Lớn Hà Nội (tên chính thức: Nhà thờ chính tòa Thánh Giuse, cũng gọi là Nhà thờ chính tòa Hà Nội) là nhà thờ chính tòa của Tổng giáo phận Hà Nội, nơi có ngai tòa của tổng giám mục. Đây là một nhà thờ cổ kính tại thành phố này, thường xuyên diễn ra các sinh hoạt tín ngưỡng của các giáo dân Công giáo thuộc giáo xứ chính tòa cũng như của toàn tổng giáo phận.','2RHX+FHX, Hàng Trống, Hoàn Kiếm, Hà Nội')," +
            "(1,'Lăng Bác',30000,'Lăng Chủ tịch Hồ Chí Minh, còn gọi là Lăng Hồ Chủ tịch, Lăng Bác, là nơi gìn giữ di hài Chủ tịch Hồ Chí Minh. Lăng được chính thức khởi công ngày 2 tháng 9 năm 1973, tại vị trí của lễ đài cũ giữa Quảng trường Ba Đình, nơi Hồ Chí Minh từng chủ trì các cuộc gặp mặt quan trọng.','8 Hùng Vương, Điện Biên, Ba Đình, Hà Nội 100000')," +
            "(5,'Địa Tạng Phi Lai Tự',30000,'Là Ngôi chùa','Hoài Đức Hà Nội')," +
            "(1,'Ba Vì',30000,'Hi hi','Hoài Đức Hà Nội')," +
            "(5,'Tam Chúc',500000,'Quần thể du lịch chùa Tam Chúc Hà Nam là điểm du lịch tâm linh đang nhận được rất nhiều sự quan tâm từ các bạn trẻ và Phật tử trên cả nước. Tham khảo kinh nghiệm du lịch ở ngôi chùa lớn nhất thế giới được mệnh danh “Hạ Long trên cạn” trong bài viết.','Từ thành phố Phủ Lý, theo đường quốc lộ 21 đi khoảng 12 km thì đến hồ Tam Chúc')";
    public static final String INSERT_CHUYEN_DI ="INSERT INTO ChuyenDi(taiKhoan,maDiaDiem,tienThue,SoLuongNguoi,NgayDat) VALUES " +
            "('cuongnb',1,10000,2,'2022/11/09')," +
            "('cuongnb',2,30000,1,'2022/11/09')";
}
