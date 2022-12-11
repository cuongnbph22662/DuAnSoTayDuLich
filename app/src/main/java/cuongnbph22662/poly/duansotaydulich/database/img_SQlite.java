package cuongnbph22662.poly.duansotaydulich.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class img_SQlite extends SQLiteOpenHelper {
    public img_SQlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //insert , update , delete + create
    public void QueryData(String sql){
      SQLiteDatabase db = getWritableDatabase();
      db.execSQL(sql);
    }

    //insert , update , delete + create
    public void INSERT_photo(String tieude, byte[] hinh){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO photo VALUES(null,?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,tieude);
        statement.bindBlob(2,hinh);

        statement.executeInsert();
    }

    //select
    public Cursor GetData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(sql,null);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
