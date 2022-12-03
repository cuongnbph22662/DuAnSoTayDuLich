package cuongnbph22662.poly.duansotaydulich.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cuongnbph22662.poly.duansotaydulich.R;

public class CongDongActivity extends AppCompatActivity {
    private Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_dongactivity);
        btn = findViewById(R.id.btnviewall);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CongDongActivity.this , TripPlanActivity.class);
                startActivity(intent);
            }
        });
    }
}