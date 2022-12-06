package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;

public class ManChaoActivity extends AppCompatActivity {
    Button btngetstart ;
    ImageView imgView ;
    LinearLayout manChao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        btngetstart = findViewById(R.id.btnBatDau);
        manChao = findViewById(R.id.id_manChao);
        // set lần đầu vào app
        if(!DataLocalManager.getLanDauVaoApp()){
            Animation animation = AnimationUtils.loadAnimation(ManChaoActivity.this,R.anim.fade);
            btngetstart.startAnimation(animation);
            btngetstart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ManChaoActivity.this , MainActivity.class);
                    startActivity(intent);
                }
            });
            DataLocalManager.setLanDauVaoApp(true);
        }else{
            manChao.setVisibility(View.INVISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(ManChaoActivity.this, MainActivity.class));
                    finish();
                }
            }, 2000);
        }

//        manChao.setVisibility(View.INVISIBLE);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(ManChaoActivity.this, MainActivity.class));
//                finish();
//            }
//        }, 2000);

    }
}