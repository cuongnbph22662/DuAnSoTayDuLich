package cuongnbph22662.poly.duansotaydulich.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Helper extends SQLiteOpenHelper {
    static final String DB_NAME = "sotaydulich.db";
    static final int DB_VERSION = 1;
    static final String CREATE_TABLE_NGUOI_DUNG = "CREATE TABLE NguoiDung (" +
            "taiKhoan TEXT PRIMARY KEY," +
            "hoTen TEXT NOT NULL," +
            "matKhau TEXT NOT NULL," +
            "soDienThoai TEXT NOT NULL)";
    static final String CREATE_TABLE_THELOAI = "CREATE TABLE TheLoai (" +
            "maTheLoai INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tenTheLoai TEXT NOT NULL)";
    static final String CREATE_TABLE_PHIEU_DU_LICH = "CREATE TABLE PhieuDuLich(" +
            "maPhieu INTEGER PRIMARY KEY AUTOINCREMENT," +
            "maTheLoai INTEGER REFERENCES TheLoai(maTheLoai)," +
            "giaThue INTEGER NOT NULL," +
            "noiDung TEXT NOT NULL," +
            "diaChi TEXT NOT NULL)";
    static final String CREATE_TABLE_PHIEU_CHI_TIET = "CREATE TABLE PhieuDLChiTiet(" +
            "maPhieuChiTiet INTEGER PRIMARY KEY AUTOINCREMENT," +
            "taiKhoan TEXT REFERENCES NguoiDung(taiKhoan)," +
            "maPhieu INTEGER REFERENCES PhieuDuLich(maPhieu)," +
            "tienThue INTEGER NOT NULL," +
            "SoLuongNguoi INTEGER NOT NULL," +
            "NgayDat DATE NOT NULL)";
    public DB_Helper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng
        db.execSQL(CREATE_TABLE_NGUOI_DUNG);
        db.execSQL(CREATE_TABLE_THELOAI);
        db.execSQL(CREATE_TABLE_PHIEU_DU_LICH);
        db.execSQL(CREATE_TABLE_PHIEU_CHI_TIET);
        // insert dữ liệu vào database
        db.execSQL(Data_SQLite.INSERT_NGUOI_DUNG);
        db.execSQL(Data_SQLite.INSERT_THE_LOAI);
        db.execSQL(Data_SQLite.INSERT_PHIEU_DU_LICH);
        db.execSQL(Data_SQLite.INSERT_PHIEU_DU_LICH_CHI_TIET);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DropTableNguoiDung = "DROP TABLE IF EXISTS NguoiDung";
        db.execSQL(DropTableNguoiDung);
        String DropTableTheLoai = "DROP TABLE IF EXISTS TheLoai";
        db.execSQL(DropTableTheLoai);
        String DropTablePhieuDuLich = "DROP TABLE IF EXISTS PhieuDuLich";
        db.execSQL(DropTablePhieuDuLich);
        String DropTablePhieuChiTiet = "DROP TABLE IF EXISTS PhieuDLChiTiet";
        db.execSQL(DropTablePhieuChiTiet);

        onCreate(db);
    }

}
