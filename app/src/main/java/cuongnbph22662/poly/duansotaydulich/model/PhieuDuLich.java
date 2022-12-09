package cuongnbph22662.poly.duansotaydulich.model;

public class PhieuDuLich {
    private int img;
    private int maPhieu;
    private int maTheLoai;
    private String tenDiaDiem;
    private String giaThue;
    private String noiDung;
    private String viTri;


    public PhieuDuLich(int img, String tenDiaDiem, String giaThue, String noiDung) {
        this.img = img;
        this.maPhieu = maPhieu;
        this.maTheLoai = maTheLoai;
        this.tenDiaDiem = tenDiaDiem;
        this.giaThue = giaThue;
        this.noiDung = noiDung;
        this.viTri = viTri;
    }

    public PhieuDuLich() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(String giaThue) {
        this.giaThue = giaThue;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}
