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
import cuongnbph22662.poly.duansotaydulich.model.TheLoai;

public class TheLoaiDAO {
    private SQLiteDatabase db;
    public TheLoaiDAO(Context context){
        DB_Helper dbHelper = new DB_Helper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(TheLoai obj){
        ContentValues values = new ContentValues();
        values.put("tenTheLoai",obj.getTenTheLoai());
        return db.insert("TheLoai",null,values);
    }
    public int update (TheLoai obj){
        ContentValues values = new ContentValues();
        values.put("tenTheLoai",obj.getTenTheLoai());
        return db.update("TheLoai",values,"maTheLoai=?",new String[]{String.valueOf(obj.getTenTheLoai())});
    }
    public int delete(String id){
        return db.delete("TheLoai","maTheLoai=?", new String[]{id});
    }

    @SuppressLint("Range")
    public List<TheLoai> getData(String sql, String...selectionArgs){
        List<TheLoai> list = new ArrayList<TheLoai>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            TheLoai obj = new TheLoai();
            obj.setMaTheLoai(Integer.parseInt(c.getString(c.getColumnIndex("maTheLoai"))));
            obj.setTenTheLoai(c.getString(c.getColumnIndex("tenTheLoai")));
            Log.i("//=======", obj.toString());
            list.add(obj);
        }
        return list;
    }
    public List<TheLoai> getAll(){
        String sql = "SELECT * FROM TheLoai";
        return getData(sql);
    }
    public TheLoai getID(String id){
        String sql = "SELECT * FROM TheLoai WHERE maTheLoai=?";
        List<TheLoai> list = getData(sql,id);
        return list.get(0);
    }
}
