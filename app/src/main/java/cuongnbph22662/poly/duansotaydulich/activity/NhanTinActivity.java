package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;

public class NhanTinActivity extends AppCompatActivity {
    ImageView trove;
    Button guitinnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_tin);
        anhXa();
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NhanTinActivity.this, LienHeActivity.class));
            }
        });
        guitinnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NhanTinActivity.this, MainActivity.class));
            }
        });
    }

    private void anhXa() {
        trove = findViewById(R.id.img_trove_lienHe);
        guitinnhan = findViewById(R.id.btnGuiTinNhan);
    }
}