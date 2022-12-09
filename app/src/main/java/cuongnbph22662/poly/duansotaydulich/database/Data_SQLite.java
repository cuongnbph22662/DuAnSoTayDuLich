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
            "('Thanh hóa')," +
            "('Huế')," +
            "('Quảng ninh')," +
            "('Khánh hòa')," +
            "('Lâm đồng')," +
            "('Hồ Chí Minh')," +
            "('Tây Nguyên')," +
            "('Đà Nẵng')," +
            "('Hà Nam')";
    public static final String INSERT_DIA_DIEM ="INSERT INTO DiaDiem (maThanhPho,tenDiaDiem,giaThue,noiDung,viTri) VALUES " +
            "(1,'Nhà thờ lớn hà nội',5000,'Nhà thờ Lớn Hà Nội (tên chính thức: Nhà thờ chính tòa Thánh Giuse, cũng gọi là Nhà thờ chính tòa Hà Nội) là nhà thờ chính tòa của Tổng giáo phận Hà Nội, nơi có ngai tòa của tổng giám mục. Đây là một nhà thờ cổ kính tại thành phố này, thường xuyên diễn ra các sinh hoạt tín ngưỡng của các giáo dân Công giáo thuộc giáo xứ chính tòa cũng như của toàn tổng giáo phận.','2RHX+FHX, Hàng Trống, Hoàn Kiếm, Hà Nội')," +
            "(1,'Lăng Bác',30000,'Lăng Chủ tịch Hồ Chí Minh, còn gọi là Lăng Hồ Chủ tịch, Lăng Bác, là nơi gìn giữ di hài Chủ tịch Hồ Chí Minh. Lăng được chính thức khởi công ngày 2 tháng 9 năm 1973, tại vị trí của lễ đài cũ giữa Quảng trường Ba Đình, nơi Hồ Chí Minh từng chủ trì các cuộc gặp mặt quan trọng.','8 Hùng Vương, Điện Biên, Ba Đình, Hà Nội 100000')," +
            "(5,'Địa Tạng Phi Lai Tự',30000,'Về quy mô, chùa có Tam bảo, nhà thờ tổ, nơi thờ Đức Ông, đức Thánh hiền; nhà ở, giảng đường, nhà khách, nơi ở của phật tử. Cả quần thể ngôi chùa nhìn từ xa ẩn mình và được che chở giữa rừng thông. Ngôi chùa vừa có kiến trúc đẹp, vừa gợi lên cảm giác thanh tao, thoát tục mà bất kỳ ai có dịp đến đây cũng có thể cảm nhận.','tọa lạc ở thôn Ninh Trung, xã Liêm Sơn, huyện Thanh Liêm - Hà nam')," +
            "(1,'Ba Vì',30000,'Ba Vì là huyện thuộc vùng bán sơn địa, nằm về phía tây bắc thủ đô Hà Nội. Phía đông giáp thị xã Sơn Tây, phía nam giáp tỉnh Hòa Bình, phía tây giáp tỉnh Phú Thọ và phía Bắc giáp tỉnh Vĩnh Phúc. Ba Vì được thiên nhiên ưu đãi ban tặng sơn thuỷ hữu tình, với hệ sinh thái phong phú','Hoài Đức Hà Nội')," +
            "(3,'Kinh Thành Huế',4000,'Nằm bên bờ sông Hương thơ mộng, di tích Kinh thành Huế  hay còn được nhiều người gọi là Thuận Hóa Kinh Thành là một toà thành cổ, thuộc Quần thể di tích Cố đô Huế được UNESCO công nhận là Di sản Văn hoá Thế giới','Quần thể di tích Cố đô Huế')," +
            "(6,'Đà lạt',6000,'Nói về văn hoá của Đà Lạt thì như một thiên đường với đa dạng bản sắc văn hóa dân tộc của nhiều tộc người. Được thể hiện thông qua các chương trình thuật biểu diễn, những loại nhạc cụ độc đáo và cả những bộ trang phục đầy sắc màu.','Cao nguyên Lâm Viên thuộc Lâm Đồng')," +
            "(5,'Nha Trang',3000,'Nha Trang, thành phố biển nằm tại vị trí trung tâm tỉnh Khánh Hòa, từ lâu đã là một trong những điểm du lịch hút khách nhất Việt Nam. Được thiên nhiên ban tặng những bãi biển, vùng vịnh đẹp cùng nhiều đảo lớn nhỏ, thành phố còn sở hữu nhiều danh lam thắng cảnh, điểm tham quan, vui chơi và cơ sở nghỉ dưỡng.','Thành phố Nha Trang thuộc tỉnh Khánh Hòa')," +
            "(9,'Cầu vàng',4000,'Cầu Vàng Đà Nẵng là một trong những công trình đặc sắc thuộc quần thể du lịch Sun World Bà Nà Hills Đà Nẵng. Cây cầu có thiết kế vô cùng ấn tượng, mềm mại uốn cong như dải lụa vàng óng ả giữa núi rừng, được nâng niu bởi hai bàn tay khổng lồ loang lổ rêu phong, tựa như chính thiên nhiên Bà Nà đã sinh ra nó.','huộc làng An Sơn, xã Hòa Ninh, huyện Hòa Vàng, thành phố Đà Nẵng')," +
            "(4,'Cát bà',5000,'Cát Bà là điểm đến thu hút du khách. Nơi đây mang cảnh sắc đặc trưng của vùng vịnh Hạ Long với những dãy núi đá vôi và vùng biển lặng xanh ngắt.','thuộc phía nam vịnh Hạ Long, ngoài khơi thành phố Hải Phòng và tỉnh Quảng Ninh')," +
            "(2,'Sầm sơn',3000,'Khu du lịch Sầm Sơn Thanh Hoá nằm cách trung tâm thành phố 17km, là một trong những bãi biển đẹp nhất Bắc Trung Bộ và được mệnh danh là chốn nghỉ dưỡng lý tưởng nhất Đông Dương . Nơi đây có đường bờ biển chạy dài 6km từ chân núi Trường Lệ với độ dốc, độ mặn nước biển vừa phải, rất thích hợp cho các hoạt động vui chơi, tắm biển','nằm ở phía đông của tỉnh Thanh Hóa ,Thị xã Sầm Sơn, Thanh Hóa')," +
            "(4,'Vịnh hạ long',4000,'Vịnh Hạ Long được Unesco nhiều lần công nhận là Di sản thiên nhiên của Thế giới với hàng nghìn hòn đảo được làm nên bởi tạo hoá kỳ vĩ và sống động. Vịnh Hạ Long có phong cảnh tuyệt đẹp nên nơi đây là một điểm du lịch rất hấp dẫn với du khách trong nước và quốc tế.','Vịnh Hạ Long thuộc tỉnh Quảng Ninh, nằm ở phía Đông Bắc nước ta')," +
            "(1,'Phố hàng mã',4000,'Phố Hàng Mã là một con phố thuộc Hà Nội 36 phố phường, một con phố mang đậm nét văn hóa phương Đông. Cứ đến ngày lễ tết, nơi đây lại khoác lên cho mình một bộ trang phục mới toanh ngập tràn trong màu sắc, ánh đèn cũng như dòng người tấp nập đổ xô về vừa vãn cảnh','Hàng Mã, Hoàn Kiếm, Hà Nội')," +
            "(1,'Văn miếu quốc tử giám',4000,'Văn Miếu Quốc Tử Giám nằm ngay giữa trung tâm thành phố Hà Nội, là địa điểm du lịch bạn không nên bỏ qua khi ghé thăm thủ đô. Văn Miếu cổ kính nằm giữa lòng Hà Nội hàng năm thu hút hàng nghìn du khách trong và ngoài nước ghé qua tham quan, chụp ảnh, tìm hiểu giá trị lịch sử – văn hóa.','58 P. Quốc Tử Giám, Văn Miếu, Đống Đa, Hà Nộ')," +
            "(7,'Cầu ánh sao ',4000,'Đây không chỉ là nơi tản bộ, ngắm cảnh mà còn là chốn hẹn hò lãng mạn của các bạn trẻ. Cầu Ánh Sao được xây dựng năm 2009 với chiều dài 170m, rộng 8,3m với thiết kế ấn tượng. Khu Kênh Đào với quảng trường thiết kế mô phỏng hình mặt trăng, khu Hồ Bán Nguyệt mô phỏng hình mặt trời. Hai bên thành cầu được lắp đặt hệ thống đèn led bảy màu','Tọa lạc tại khu đô thị mới Phú Mỹ Hưng, Quận 7, Thành phố Hồ Chí Minh')," +
            "(5,'Thu lũng tình yêu',4000,'Đà Lạt là một nơi đáng sống, thu hút nhiều khách du lịch không chỉ những địa điểm tham quan nổi tiếng, không khí trong lành mà còn sự hiếu khách, dễ mến của người dân nơi đây. Nơi nào của xứ sở này cũng quyến rũ lòng người, trong đó phải kể đến Thung Lũng Tình Yêu','số 7, đường Mai Anh Đào, phường 8, Đà Lạt')," +
            "(10,'Tam Chúc',500000,'Quần thể du lịch chùa Tam Chúc Hà Nam là điểm du lịch tâm linh đang nhận được rất nhiều sự quan tâm từ các bạn trẻ và Phật tử trên cả nước. Tham khảo kinh nghiệm du lịch ở ngôi chùa lớn nhất thế giới được mệnh danh “Hạ Long trên cạn” trong bài viết.','Thuộc thị xã Ba Sao huyện Kim Bảng tỉnh Hà Nam')";
    public static final String INSERT_CHUYEN_DI ="INSERT INTO ChuyenDi(taiKhoan,maDiaDiem,tienThue,SoLuongNguoi,NgayDat) VALUES " +
            "('cuongnb',1,10000,2,'2022/11/09')," +
            "('cuongnb',2,30000,1,'2022/11/09')";
}
