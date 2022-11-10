package cuongnbph22662.poly.duansotaydulich.model;

import java.util.Date;

public class PhieuDLChiTiet {
    private int maPhieuCT;
    private String taiKhoan;
    private int maPhieu;
    private int tienThue;
    private int soLuongNguoi;
    private Date ngayDat;

    public PhieuDLChiTiet() {
    }

    public PhieuDLChiTiet(int maPhieuCT, String taiKhoan, int maPhieu, int tienThue, int soLuongNguoi, Date ngayDat) {
        this.maPhieuCT = maPhieuCT;
        this.taiKhoan = taiKhoan;
        this.maPhieu = maPhieu;
        this.tienThue = tienThue;
        this.soLuongNguoi = soLuongNguoi;
        this.ngayDat = ngayDat;
    }

    public int getMaPhieuCT() {
        return maPhieuCT;
    }

    public void setMaPhieuCT(int maPhieuCT) {
        this.maPhieuCT = maPhieuCT;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getTienThue() {
        return tienThue;
    }

    public void setTienThue(int tienThue) {
        this.tienThue = tienThue;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    @Override
    public String toString() {
        return "PhieuChiTiet{" +
                "maPhieuCT=" + maPhieuCT +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", maPhieu=" + maPhieu +
                ", tienThue=" + tienThue +
                ", soLuongNguoi=" + soLuongNguoi +
                ", ngayDat=" + ngayDat +
                '}';
    }
}
