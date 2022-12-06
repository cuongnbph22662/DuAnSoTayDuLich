package cuongnbph22662.poly.duansotaydulich.model;

import android.widget.ImageView;

public class PhieuDuLich {
    private int maPhieu;
    private int maTheLoai;
    private String tenDiaDiem;
    private int giaThue;
    private String noiDung;
    private String viTri;


    @Override
    public String toString() {
        return "PhieuDuLich{" +
                "maPhieu=" + maPhieu +
                ", maTheLoai=" + maTheLoai +
                ", tenDiaDiem='" + tenDiaDiem + '\'' +
                ", giaThue=" + giaThue +
                ", noiDung='" + noiDung + '\'' +
                ", viTri='" + viTri + '\'' +
                '}';
    }

    public PhieuDuLich(int maPhieu, int maTheLoai, String tenDiaDiem, int giaThue, String noiDung, String viTri) {
        this.maPhieu = maPhieu;
        this.maTheLoai = maTheLoai;
        this.tenDiaDiem = tenDiaDiem;
        this.giaThue = giaThue;
        this.noiDung = noiDung;
        this.viTri = viTri;

    }

    public PhieuDuLich() {
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

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDiaChi() {
        return viTri;
    }

    public void setDiaChi(String diaChi) {
        this.viTri = diaChi;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

}
