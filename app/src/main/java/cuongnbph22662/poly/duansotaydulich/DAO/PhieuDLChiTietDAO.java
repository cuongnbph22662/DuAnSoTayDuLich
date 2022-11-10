package cuongnbph22662.poly.duansotaydulich.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.database.DB_Helper;
import cuongnbph22662.poly.duansotaydulich.model.PhieuDLChiTiet;
import cuongnbph22662.poly.duansotaydulich.model.PhieuDuLich;

public class PhieuDLChiTietDAO {

    private SQLiteDatabase db;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    public PhieuDLChiTietDAO(Context context){
        DB_Helper dbHelper = new DB_Helper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(PhieuDLChiTiet obj){
        ContentValues values = new ContentValues();
        values.put("taiKhoan",obj.getTaiKhoan());
        values.put("maPhieu",obj.getMaPhieu());
        values.put("tienThue",obj.getTienThue());
        values.put("SoLuongNguoi",obj.getSoLuongNguoi());
        values.put("NgayDat",sdf.format(obj.getNgayDat()));
        return db.insert("PhieuDLChiTiet",null,values);
    }
    public int update (PhieuDLChiTiet obj){
        ContentValues values = new ContentValues();
        return db.update("PhieuDLChiTiet",values,"maPhieuChiTiet=?",new String[]{String.valueOf(obj.getMaPhieuCT())});
    }
    public int delete(String id){
        return db.delete("PhieuDLChiTiet","maPhieuChiTiet=?", new String[]{id});
    }


    @SuppressLint("Range")
    public List<PhieuDLChiTiet> getData(String sql, String...selectionArgs){
        List<PhieuDLChiTiet> list = new ArrayList<PhieuDLChiTiet>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            PhieuDLChiTiet obj = new PhieuDLChiTiet();
            obj.setMaPhieu(Integer.parseInt(c.getString(c.getColumnIndex("maPhieuChiTiet"))));
            obj.setTaiKhoan(c.getString(c.getColumnIndex("taiKhoan")));
            obj.setMaPhieu(Integer.parseInt(c.getString(c.getColumnIndex("maPhieu"))));
            obj.setTienThue(Integer.parseInt(c.getString(c.getColumnIndex("tienThue"))));
            obj.setSoLuongNguoi(Integer.parseInt(c.getString(c.getColumnIndex("SoLuongNguoi"))));
            try {
                obj.setNgayDat(sdf.parse(c.getString(c.getColumnIndex("NgayDat"))));
            }catch (ParseException e){
                e.printStackTrace();
            }
            Log.i("//=======", obj.toString());
            list.add(obj);
        }
        return list;
    }
    public List<PhieuDLChiTiet> getAll(){
        String sql = "SELECT * FROM PhieuDLChiTiet";
        return getData(sql);
    }
    public PhieuDLChiTiet getID(String id){
        String sql = "SELECT * FROM PhieuDLChiTiet WHERE maPhieuChiTiet=?";
        List<PhieuDLChiTiet> list = getData(sql,id);
        return list.get(0);
    }
}
