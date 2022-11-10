package cuongnbph22662.poly.duansotaydulich.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.database.DB_Helper;
import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;
import cuongnbph22662.poly.duansotaydulich.model.PhieuDuLich;

public class PhieuDuLichDAO {
    private SQLiteDatabase db;
    public PhieuDuLichDAO(Context context){
        DB_Helper dbHelper = new DB_Helper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(PhieuDuLich obj){
        ContentValues values = new ContentValues();
        values.put("maTheLoai",obj.getMaTheLoai());
        values.put("giaThue",obj.getGiaThue());
        values.put("noiDung",obj.getNoiDung());
        values.put("diaChi",obj.getDiaChi());
        return db.insert("PhieuDuLich",null,values);
    }
    public int update (PhieuDuLich obj){
        ContentValues values = new ContentValues();
        values.put("maTheLoai",obj.getMaTheLoai());
        values.put("giaThue",obj.getGiaThue());
        values.put("noiDung",obj.getNoiDung());
        values.put("diaChi",obj.getDiaChi());
        return db.update("PhieuDuLich",values,"maPhieu=?",new String[]{String.valueOf(obj.getMaPhieu())});
    }
    public int delete(String id){
        return db.delete("PhieuDuLich","maPhieu=?", new String[]{id});
    }


    @SuppressLint("Range")
    public List<PhieuDuLich> getData(String sql, String...selectionArgs){
        List<PhieuDuLich> list = new ArrayList<PhieuDuLich>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            PhieuDuLich obj = new PhieuDuLich();
            obj.setMaPhieu(Integer.parseInt(c.getString(c.getColumnIndex("maPhieu"))));
            obj.setMaTheLoai(Integer.parseInt(c.getString(c.getColumnIndex("maTheLoai"))));
            obj.setGiaThue(Integer.parseInt(c.getString(c.getColumnIndex("giaThue"))));
            obj.setNoiDung(c.getString(c.getColumnIndex("noiDung")));
            obj.setDiaChi(c.getString(c.getColumnIndex("diaChi")));
            Log.i("//=======", obj.toString());
            list.add(obj);
        }
        return list;
    }
    public List<PhieuDuLich> getAll(){
        String sql = "SELECT * FROM PhieuDuLich";
        return getData(sql);
    }
    public PhieuDuLich getID(String id){
        String sql = "SELECT * FROM PhieuDuLich WHERE maPhieu=?";
        List<PhieuDuLich> list = getData(sql,id);
        return list.get(0);
    }
}
