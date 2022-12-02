package cuongnbph22662.poly.duansotaydulich;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CongDongactivity extends AppCompatActivity {
    private Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_dongactivity);
        btn = findViewById(R.id.btnviewall);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CongDongactivity.this , TripPlanActivity.class);
                startActivity(intent);
            }
        });
    }
}