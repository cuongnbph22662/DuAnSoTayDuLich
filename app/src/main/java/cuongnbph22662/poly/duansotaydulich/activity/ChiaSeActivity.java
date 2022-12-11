package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.activity.admin.AnhDaChupActivity;
import cuongnbph22662.poly.duansotaydulich.database.img_SQlite;

public class ChiaSeActivity extends AppCompatActivity {
    ImageView trove;
    private ImageView imgPhoto;
    private EditText edttieude ;
    private ImageButton imbcamera , imbupload ;
    private Button btndang , btnbangtin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chia_se);

        anhxa();


        //Database
        img_SQlite db = new img_SQlite(getApplicationContext(), "thuvienanh.sqlite", null, 1);
        db.QueryData("CREATE TABLE IF NOT EXISTS photo(id INTEGER PRIMARY KEY AUTOINCREMENT,tieude VARCHAR , hinh BLOB)");

        //Đăng
        btndang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.INSERT_photo(edttieude.getText().toString(), ImageView_To_Byte(imgPhoto));
                    Toast.makeText(ChiaSeActivity.this, "Đăng thành công !!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(ChiaSeActivity.this, "ko thành công !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //chuyển attvv
        btnbangtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiaSeActivity.this, AnhDaChupActivity.class);
                startActivity(intent);
            }
        });

        trove = findViewById(R.id.img_trove_chiase);
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChiaSeActivity.this, CongDongActivity.class));
            }
        });


        //Chụp hình
        imbcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maychuphinh = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(maychuphinh, 88);
            }
        });
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 88 && requestCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(photo);
        } else {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(photo);
        }
    }

    public byte[] ImageView_To_Byte(ImageView h){
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hue);
        BitmapDrawable drawable  = (BitmapDrawable) h.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public void anhxa(){
        imgPhoto = findViewById(R.id.imgchiase);
        edttieude = findViewById(R.id.edttieude);
        imbupload = findViewById(R.id.uploadimg);
        imbcamera = findViewById(R.id.cameraimg);
        btndang = findViewById(R.id.btndang);
        btnbangtin = findViewById(R.id.btnluutru);
    }
}