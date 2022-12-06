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
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class ThanhPhoDAO {
    private SQLiteDatabase db;
    public ThanhPhoDAO(Context context){
        DB_Helper dbHelper = new DB_Helper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(ThanhPho obj){
        ContentValues values = new ContentValues();
        values.put("tenThanhPho",obj.getTenThanhPho());
        return db.insert("ThanhPho",null,values);
    }
    public int update (ThanhPho obj){
        ContentValues values = new ContentValues();
        values.put("tenThanhPho",obj.getTenThanhPho());
        return db.update("ThanhPho",values,"maThanhPho=?",new String[]{String.valueOf(obj.getMaThanhPho())});
    }
    public int delete(String id){
        return db.delete("ThanhPho","maThanhPho=?", new String[]{id});
    }

    @SuppressLint("Range")
    public List<ThanhPho> getData(String sql, String...selectionArgs){
        List<ThanhPho> list = new ArrayList<ThanhPho>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            ThanhPho obj = new ThanhPho();
            obj.setMaThanhPho(Integer.parseInt(c.getString(c.getColumnIndex("maThanhPho"))));
            obj.setTenThanhPho(c.getString(c.getColumnIndex("tenThanhPho")));
            Log.i("//=======", obj.toString());
            list.add(obj);
        }
        return list;
    }
    public List<ThanhPho> getAll(){
        String sql = "SELECT * FROM ThanhPho";
        return getData(sql);
    }
    public ThanhPho getID(String id){
        String sql = "SELECT * FROM ThanhPho WHERE maThanhPho=?";
        List<ThanhPho> list = getData(sql,id);
        return list.get(0);
    }
}
