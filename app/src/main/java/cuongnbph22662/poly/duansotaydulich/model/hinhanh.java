package cuongnbph22662.poly.duansotaydulich.model;

public class hinhanh {
    private String tieude ;
    private byte[] hinh ;

    public hinhanh(String tieude, byte[] hinh) {
        this.tieude = tieude;
        this.hinh = hinh;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }
}
