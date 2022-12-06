package cuongnbph22662.poly.duansotaydulich.model;

public class DiaDiem {
    private int maDiaDiem;
    private int maThanhPho;
    private String tenDiaDiem;
    private int giaThue;
    private String noiDung;
    private String viTri;

    public DiaDiem(int maDiaDiem, int maThanhPho, String tenDiaDiem, int giaThue, String noiDung, String viTri) {
        this.maDiaDiem = maDiaDiem;
        this.maThanhPho = maThanhPho;
        this.tenDiaDiem = tenDiaDiem;
        this.giaThue = giaThue;
        this.noiDung = noiDung;
        this.viTri = viTri;
    }

    public DiaDiem() {
    }

    public int getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }

    public int getMaThanhPho() {
        return maThanhPho;
    }

    public void setMaThanhPho(int maThanhPho) {
        this.maThanhPho = maThanhPho;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
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

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }


    @Override
    public String toString() {
        return "DiaDiem{" +
                "maDiaDiem=" + maDiaDiem +
                ", maThanhPho=" + maThanhPho +
                ", tenDiaDiem='" + tenDiaDiem + '\'' +
                ", giaThue=" + giaThue +
                ", noiDung='" + noiDung + '\'' +
                ", viTri='" + viTri + '\'' +
                '}';
    }
}
