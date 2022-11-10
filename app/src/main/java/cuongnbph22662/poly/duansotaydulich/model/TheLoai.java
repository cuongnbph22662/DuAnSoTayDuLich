package cuongnbph22662.poly.duansotaydulich.model;

public class TheLoai {
    private int maTheLoai;
    private String tenTheLoai;

    public TheLoai(int maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoai() {
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
        return "TheLoai{" +
                "maTheLoai=" + maTheLoai +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                '}';
    }
}
