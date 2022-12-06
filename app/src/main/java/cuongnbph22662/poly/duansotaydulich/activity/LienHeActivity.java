package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;

public class LienHeActivity extends AppCompatActivity {
    ImageView trove;
    Button nhantin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);
        anhXa();
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LienHeActivity.this, MainActivity.class));
            }
        });
        nhantin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LienHeActivity.this, NhanTinActivity.class));
            }
        });
    }

    private void anhXa() {
        trove = findViewById(R.id.img_trove_nhantin);
        nhantin = findViewById(R.id.btnSoanTinNhan);
    }
}