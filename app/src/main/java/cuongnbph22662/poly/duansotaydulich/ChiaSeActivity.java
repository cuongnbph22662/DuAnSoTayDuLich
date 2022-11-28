package cuongnbph22662.poly.duansotaydulich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChiaSeActivity extends AppCompatActivity {
    private ImageView img_anhchise;
    private ImageButton btn_img;
    private EditText edt_tieude;
    private Button btn_dangtin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chia_se);
        img_anhchise = findViewById(R.id.img_anhchiase);
        btn_img = findViewById(R.id.btn_img);
        edt_tieude = findViewById(R.id.edt_tieude);
        btn_dangtin = findViewById(R.id.btn_dangtin);
    }
}