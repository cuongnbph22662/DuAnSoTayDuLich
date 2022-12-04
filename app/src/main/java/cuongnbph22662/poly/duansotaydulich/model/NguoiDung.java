package cuongnbph22662.poly.duansotaydulich.model;

public class NguoiDung {
    private String taiKhoan;
    private String hoTen;
    private String matKhau;
    private String soDienThoai;
    private int namSinh;
    private String diaChi;

    public NguoiDung() {
    }

    public NguoiDung(String taiKhoan, String hoTen, String matKhau, String soDienThoai, int namSinh, String diaChi) {
        this.taiKhoan = taiKhoan;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "taiKhoan='" + taiKhoan + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
