package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;

public class CongDongActivity extends AppCompatActivity {
    private Button btn ;
    private TextView chiase;
    private ImageView trove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_dong_activity);
        anhXa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CongDongActivity.this , TripPlanActivity.class);
                startActivity(intent);
            }
        });
        chiase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CongDongActivity.this , ChiaSeActivity.class);
                startActivity(intent);
            }
        });
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CongDongActivity.this, MainActivity.class));
            }
        });
    }

    private void anhXa() {
        btn = findViewById(R.id.btnviewall);
        chiase = findViewById(R.id.tv_chiaSe);
        trove = findViewById(R.id.img_trove_congdong);
    }
}