package cuongnbph22662.poly.duansotaydulich.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.database.DB_Helper;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;

public class DiaDiemDAO {
    private SQLiteDatabase db;
    public DiaDiemDAO(Context context){
        DB_Helper dbHelper = new DB_Helper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(DiaDiem obj){
        ContentValues values = new ContentValues();
        values.put("maThanhPho",obj.getMaThanhPho());
        values.put("tenDiaDiem", obj.getTenDiaDiem());
        values.put("giaThue",obj.getGiaThue());
        values.put("noiDung",obj.getNoiDung());
        values.put("viTri",obj.getViTri());
        return db.insert("DiaDiem",null,values);
    }
    public int update (DiaDiem obj){
        ContentValues values = new ContentValues();
        values.put("maThanhPho",obj.getMaThanhPho());
        values.put("tenDiaDiem", obj.getTenDiaDiem());
        values.put("giaThue",obj.getGiaThue());
        values.put("noiDung",obj.getNoiDung());
        values.put("viTri",obj.getViTri());
        return db.update("DiaDiem",values,"maDiaDiem=?",new String[]{String.valueOf(obj.getMaDiaDiem())});
    }
    public int delete(String id){
        return db.delete("DiaDiem","maDiaDiem=?", new String[]{id});
    }


    @SuppressLint("Range")
    public List<DiaDiem> getData(String sql, String...selectionArgs){
        List<DiaDiem> list = new ArrayList<DiaDiem>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            DiaDiem obj = new DiaDiem();
            obj.setMaDiaDiem(Integer.parseInt(c.getString(c.getColumnIndex("maDiaDiem"))));
            obj.setMaThanhPho(Integer.parseInt(c.getString(c.getColumnIndex("maThanhPho"))));
            obj.setTenDiaDiem(c.getString(c.getColumnIndex("tenDiaDiem")));
            obj.setGiaThue(Integer.parseInt(c.getString(c.getColumnIndex("giaThue"))));
            obj.setNoiDung(c.getString(c.getColumnIndex("noiDung")));
            obj.setViTri(c.getString(c.getColumnIndex("viTri")));
            Log.i("//=======", obj.toString());
            list.add(obj);
        }
        return list;
    }
    public List<DiaDiem> getAll(){
        String sql = "SELECT * FROM DiaDiem";
        return getData(sql);
    }

    public List<DiaDiem> getAllAdmin(){
        String sql = "SELECT * FROM DiaDiem Order by maDiaDiem Desc";
        return getData(sql);
    }

    public DiaDiem getID(String id){
        String sql = "SELECT * FROM DiaDiem WHERE maDiaDiem=?";
        List<DiaDiem> list = getData(sql,id);
        return list.get(0);
    }

    public List<DiaDiem> timTheoTen(String diachi){
        String sql = "SELECT * FROM DiaDiem WHERE tenDiaDiem=?";
        return getData(sql, diachi);
    }

    public List<DiaDiem> timTheoThanhPho(String diachi){
        String sql = "SELECT * FROM DiaDiem WHERE maThanhPho=?";
        return getData(sql, diachi);
    }
}
