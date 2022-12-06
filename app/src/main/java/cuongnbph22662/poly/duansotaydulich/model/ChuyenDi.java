package cuongnbph22662.poly.duansotaydulich.model;

import java.util.Date;

public class ChuyenDi {
    private int maChuyenDi;
    private String taiKhoan;
    private int maDiaDiem;
    private int tienThue;
    private int soLuongNguoi;
    private Date ngayDat;

    public ChuyenDi() {
    }

    public ChuyenDi(int maChuyenDi, String taiKhoan, int maDiaDiem, int tienThue, int soLuongNguoi, Date ngayDat) {
        this.maChuyenDi = maChuyenDi;
        this.taiKhoan = taiKhoan;
        this.maDiaDiem = maDiaDiem;
        this.tienThue = tienThue;
        this.soLuongNguoi = soLuongNguoi;
        this.ngayDat = ngayDat;
    }

    public int getMaChuyenDi() {
        return maChuyenDi;
    }

    public void setMaChuyenDi(int maChuyenDi) {
        this.maChuyenDi = maChuyenDi;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public int getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
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
        return "ChuyenDi{" +
                "maChuyenDi=" + maChuyenDi +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", maDiaDiem=" + maDiaDiem +
                ", tienThue=" + tienThue +
                ", soLuongNguoi=" + soLuongNguoi +
                ", ngayDat=" + ngayDat +
                '}';
    }
}
