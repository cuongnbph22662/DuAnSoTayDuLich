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
            "soDienThoai TEXT NOT NULL," +
            "namSinh INTEGER NOT NULL," +
            "diaChi TEXT NOT NULL)";
    static final String CREATE_TABLE_THANH_PHO = "CREATE TABLE ThanhPho (" +
            "maThanhPho INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tenThanhPho TEXT NOT NULL)";
    static final String CREATE_TABLE_DIA_DIEM = "CREATE TABLE DiaDiem(" +
            "maDiaDiem INTEGER PRIMARY KEY AUTOINCREMENT," +
            "maThanhPho INTEGER REFERENCES TheLoai(maThanhPho)," +
            "tenDiaDiem TEXT NOT NULL," +
            "giaThue INTEGER NOT NULL," +
            "noiDung TEXT NOT NULL," +
            "viTri TEXT NOT NULL)";
    static final String CREATE_TABLE_CHUYEN_DI = "CREATE TABLE ChuyenDi(" +
            "maChuyenDi INTEGER PRIMARY KEY AUTOINCREMENT," +
            "taiKhoan TEXT REFERENCES NguoiDung(taiKhoan)," +
            "maDiaDiem INTEGER REFERENCES PhieuDuLich(maDiaDiem)," +
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
        db.execSQL(CREATE_TABLE_THANH_PHO);
        db.execSQL(CREATE_TABLE_DIA_DIEM);
        db.execSQL(CREATE_TABLE_CHUYEN_DI);
        // insert dữ liệu vào database
        db.execSQL(Data_SQLite.INSERT_NGUOI_DUNG);
        db.execSQL(Data_SQLite.INSERT_THANH_PHO);
        db.execSQL(Data_SQLite.INSERT_DIA_DIEM);
        db.execSQL(Data_SQLite.INSERT_CHUYEN_DI);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DropTableNguoiDung = "DROP TABLE IF EXISTS NguoiDung";
        db.execSQL(DropTableNguoiDung);
        String DropTableThanhPho = "DROP TABLE IF EXISTS ThanhPho";
        db.execSQL(DropTableThanhPho);
        String DropTableDiaDiem = "DROP TABLE IF EXISTS DiaDiem";
        db.execSQL(DropTableDiaDiem);
        String DropTableChuyenDi = "DROP TABLE IF EXISTS ChuyenDi";
        db.execSQL(DropTableChuyenDi);

        onCreate(db);
    }

}
