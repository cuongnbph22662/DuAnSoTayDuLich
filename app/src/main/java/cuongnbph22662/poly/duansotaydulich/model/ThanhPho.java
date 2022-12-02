package cuongnbph22662.poly.duansotaydulich.model;

public class ThanhPho {
    private int MaTP ;
    private String tenTP ;

    public ThanhPho(int maTP, String tenTP) {
        MaTP = maTP;
        this.tenTP = tenTP;
    }

    public int getMaTP() {
        return MaTP;
    }

    public void setMaTP(int maTP) {
        MaTP = maTP;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }
}
