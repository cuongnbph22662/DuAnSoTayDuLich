package cuongnbph22662.poly.duansotaydulich;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class helloActivity extends AppCompatActivity {
    Button btngetstart ;
    ImageView imgView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        btngetstart = findViewById(R.id.btngetstart);

//        Animation animation4 = AnimationUtils.loadAnimation(helloActivity.this,R.anim.fade);
//        imgView.startAnimation(animation4);

        Animation animation = AnimationUtils.loadAnimation(helloActivity.this,R.anim.fade);
        btngetstart.startAnimation(animation);

        btngetstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(helloActivity.this ,Login.class);
                startActivity(intent);
            }
        });
    }
}