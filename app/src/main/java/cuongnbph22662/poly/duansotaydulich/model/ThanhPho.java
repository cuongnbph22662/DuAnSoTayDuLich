package cuongnbph22662.poly.duansotaydulich.model;

public class ThanhPho {
    private int maTheLoai;
    private String tenTheLoai;

    public ThanhPho(int maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public ThanhPho() {
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    @Override
    public String toString() {
        return "ThanhPho{" +
                "maTheLoai=" + maTheLoai +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                '}';
    }
}
