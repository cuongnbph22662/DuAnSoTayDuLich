package cuongnbph22662.poly.duansotaydulich.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;
import cuongnbph22662.poly.duansotaydulich.fragment.HoSoFragment;

public class DangNhapActivity extends AppCompatActivity {
    EditText edUsername,edPassword;
    NguoiDungDAO nguoiDungDAO;
    Button btnLogin, btnBatDau;
    LinearLayout manChao;
    String strUser,strPass;
    TextView tvDangKi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        anhXa();
        if(!DataLocalManager.getFirstInstalled()){
            btnBatDau.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    manChao.setVisibility(View.INVISIBLE);
                }
            });
            DataLocalManager.setFirstInstalled(true);
        }else {
            startActivity(new Intent(DangNhapActivity.this, MainActivity.class));
            manChao.setVisibility(View.INVISIBLE);
        }
        nguoiDungDAO = new NguoiDungDAO(getApplicationContext());
        SharedPreferences pref = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        String user = pref.getString("taiKhoan","");
        String pass = pref.getString("matKhau","");
        edUsername.setText(user);
        edPassword.setText(pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });
        tvDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DangNhapActivity.this, TaoTaiKhoanActivity.class));
            }
        });
    }

    private void anhXa() {
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        manChao = findViewById(R.id.id_manChao);
        btnBatDau = findViewById(R.id.btnBatDau);
        tvDangKi = findViewById(R.id.tvDangKi);
    }

    public void checkLogin(){
        strUser = edUsername.getText().toString();
        strPass = edPassword.getText().toString();
        if(strUser.isEmpty()||strPass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không được bỏ trống", Toast.LENGTH_SHORT).show();
        }
        else {
            if(nguoiDungDAO.checkLogin(strUser,strPass)>0){
                Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user", strUser);
                startActivity(intent);
                finish();

            }
            else {
                Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không đúng",Toast.LENGTH_SHORT).show();
            }
        }

    }


}