package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;

public class ManChaoActivity extends AppCompatActivity {
    Button btngetstart ;
    ImageView imgView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        btngetstart = findViewById(R.id.btngetstart);

//        Animation animation4 = AnimationUtils.loadAnimation(helloActivity.this,R.anim.fade);
//        imgView.startAnimation(animation4);

        Animation animation = AnimationUtils.loadAnimation(ManChaoActivity.this,R.anim.fade);
        btngetstart.startAnimation(animation);

        btngetstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManChaoActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }
}