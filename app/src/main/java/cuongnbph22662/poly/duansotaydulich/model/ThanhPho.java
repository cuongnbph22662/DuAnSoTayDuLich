package cuongnbph22662.poly.duansotaydulich.model;

public class ThanhPho {
    private int maThanhPho;
    private String tenThanhPho;

    public ThanhPho(int maThanhPho, String tenThanhPho) {
        this.maThanhPho = maThanhPho;
        this.tenThanhPho = tenThanhPho;
    }

    public ThanhPho() {
    }

    public int getMaThanhPho() {
        return maThanhPho;
    }

    public void setMaThanhPho(int maThanhPho) {
        this.maThanhPho = maThanhPho;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    @Override
    public String toString() {
        return "ThanhPho{" +
                "maThanhPho=" + maThanhPho +
                ", tenThanhPho='" + tenThanhPho + '\'' +
                '}';
    }
}
