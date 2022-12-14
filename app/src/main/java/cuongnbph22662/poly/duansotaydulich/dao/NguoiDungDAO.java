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
import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;

public class NguoiDungDAO {
    private SQLiteDatabase db;
    public NguoiDungDAO(Context context){
        DB_Helper dbHelper = new DB_Helper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(NguoiDung obj){
        ContentValues values = new ContentValues();
        values.put("taiKhoan",obj.getTaiKhoan());
        values.put("hoTen",obj.getHoTen());
        values.put("matKhau",obj.getMatKhau());
        values.put("soDienThoai",obj.getSoDienThoai());
        values.put("namSinh", obj.getNamSinh());
        values.put("diaChi", obj.getDiaChi());
        values.put("gioiTinh", obj.getGioiTinh());
        return db.insert("NguoiDung",null,values);
    }
    public int update (NguoiDung obj){
        ContentValues values = new ContentValues();
        values.put("taiKhoan",obj.getTaiKhoan());
        values.put("hoTen",obj.getHoTen());
        values.put("matKhau",obj.getMatKhau());
        values.put("soDienThoai",obj.getSoDienThoai());
        values.put("namSinh", obj.getNamSinh());
        values.put("diaChi", obj.getDiaChi());
        values.put("gioiTinh", obj.getGioiTinh());
        return db.update("NguoiDung",values,"taiKhoan=?",new String[]{obj.getTaiKhoan()});
    }

    public int delete(String id){
        return db.delete("NguoiDung","taiKhoan=?", new String[]{id});
    }

    @SuppressLint("Range")
    public List<NguoiDung> getData(String sql, String...selectionArgs){
        List<NguoiDung> list = new ArrayList<NguoiDung>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            NguoiDung obj = new NguoiDung();
            obj.setTaiKhoan(c.getString(c.getColumnIndex("taiKhoan")));
            obj.setHoTen(c.getString(c.getColumnIndex("hoTen")));
            obj.setMatKhau(c.getString(c.getColumnIndex("matKhau")));
            obj.setSoDienThoai(c.getString(c.getColumnIndex("soDienThoai")));
            obj.setNamSinh(Integer.parseInt(c.getString(c.getColumnIndex("namSinh"))));
            obj.setDiaChi(c.getString(c.getColumnIndex("diaChi")));
            obj.setGioiTinh(c.getString(c.getColumnIndex("gioiTinh")));
            Log.i("//=======", obj.toString());
            list.add(obj);
        }
        return list;
    }

    public List<NguoiDung> getAll(){
        String sql = "SELECT * FROM NguoiDung";
        return getData(sql);
    }

    public NguoiDung getID(String id){
        String sql = "SELECT * FROM NguoiDung WHERE taiKhoan=?";
        List<NguoiDung> list = getData(sql,id);
        return list.get(0);
    }

    public int checkLogin(String id,String password){
        String sql = " SELECT * FROM NguoiDung WHERE taiKhoan=? AND matKhau=?" ;
        List <NguoiDung> list = getData(sql,id,password) ;
        if (list.size()==0)
            return -1 ;
        return 1 ;
    }
}
