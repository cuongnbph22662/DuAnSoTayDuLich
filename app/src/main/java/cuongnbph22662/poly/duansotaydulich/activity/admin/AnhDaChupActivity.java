package cuongnbph22662.poly.duansotaydulich.activity.admin;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.PhotoAdapter;
import cuongnbph22662.poly.duansotaydulich.database.img_SQlite;
import cuongnbph22662.poly.duansotaydulich.model.HinhAnh;

public class AnhDaChupActivity extends AppCompatActivity {
    private ListView lvphoto ;
    private ArrayList<HinhAnh> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachanhdachup);
        lvphoto = findViewById(R.id.lvphoto);

        //Database
        final img_SQlite db = new img_SQlite(getApplicationContext(),"thuvienanh.sqlite",null,1);
        Cursor cursor = db.GetData("SELECT * FROM photo");
        while (cursor.moveToNext()){
            list.add(new HinhAnh(cursor.getString(1),cursor.getBlob(2)));
        }

        PhotoAdapter adapter = new PhotoAdapter(getApplicationContext(), R.layout.activity_donganhactivity,list);
        lvphoto.setAdapter(adapter);

    }
}