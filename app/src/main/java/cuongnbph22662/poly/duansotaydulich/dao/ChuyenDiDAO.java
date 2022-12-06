package cuongnbph22662.poly.duansotaydulich.dao;

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
import cuongnbph22662.poly.duansotaydulich.model.ChuyenDi;

public class ChuyenDiDAO {

    private SQLiteDatabase db;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    public ChuyenDiDAO(Context context){
        DB_Helper dbHelper = new DB_Helper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(ChuyenDi obj){
        ContentValues values = new ContentValues();
        values.put("taiKhoan",obj.getTaiKhoan());
        values.put("maDiaDiem",obj.getMaDiaDiem());
        values.put("tienThue",obj.getTienThue());
        values.put("SoLuongNguoi",obj.getSoLuongNguoi());
        values.put("NgayDat",sdf.format(obj.getNgayDat()));
        return db.insert("ChuyenDi",null,values);
    }
    public int update (ChuyenDi obj){
        ContentValues values = new ContentValues();
        values.put("taiKhoan",obj.getTaiKhoan());
        values.put("maDiaDiem",obj.getMaDiaDiem());
        values.put("tienThue",obj.getTienThue());
        values.put("SoLuongNguoi",obj.getSoLuongNguoi());
        values.put("NgayDat",sdf.format(obj.getNgayDat()));
        return db.update("ChuyenDi",values,"maChuyenDi=?",new String[]{String.valueOf(obj.getMaChuyenDi())});
    }
    public int delete(String id){
        return db.delete("ChuyenDi","maChuyenDi=?", new String[]{id});
    }


    @SuppressLint("Range")
    public List<ChuyenDi> getData(String sql, String...selectionArgs){
        List<ChuyenDi> list = new ArrayList<ChuyenDi>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            ChuyenDi obj = new ChuyenDi();
            obj.setMaChuyenDi(Integer.parseInt(c.getString(c.getColumnIndex("maChuyenDi"))));
            obj.setTaiKhoan(c.getString(c.getColumnIndex("taiKhoan")));
            obj.setMaDiaDiem(Integer.parseInt(c.getString(c.getColumnIndex("maDiaDiem"))));
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
    public List<ChuyenDi> getAll(){
        String sql = "SELECT * FROM ChuyenDi";
        return getData(sql);
    }
    public ChuyenDi getID(String id){
        String sql = "SELECT * FROM ChuyenDi WHERE maChuyenDi=?";
        List<ChuyenDi> list = getData(sql,id);
        return list.get(0);
    }
}
