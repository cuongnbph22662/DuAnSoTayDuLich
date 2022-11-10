package cuongnbph22662.poly.duansotaydulich.model;

public class PhieuDuLich {
    private int maPhieu;
    private int maTheLoai;
    private int giaThue;
    private String noiDung;
    private String diaChi;

    public PhieuDuLich(int maPhieu, int maTheLoai, int giaThue, String noiDung, String diaChi) {
        this.maPhieu = maPhieu;
        this.maTheLoai = maTheLoai;
        this.giaThue = giaThue;
        this.noiDung = noiDung;
        this.diaChi = diaChi;
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
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "PhieuDuLich{" +
                "maPhieu=" + maPhieu +
                ", maTheLoai=" + maTheLoai +
                ", giaThue=" + giaThue +
                ", noiDung='" + noiDung + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
