package cuongnbph22662.poly.duansotaydulich.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;

public class DangNhapActivity extends AppCompatActivity {
    EditText edUsername,edPassword;
    NguoiDungDAO nguoiDungDAO;
    Button btnLogin;
    String strUser,strPass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        anhXa();
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
    }

    private void anhXa() {
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
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
                luuTaiKhoan(strUser);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user", strUser);
                intent.putExtra("trangthai", "anhien");
                startActivity(intent);
                finish();

            }
            else {
                Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không đúng",Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void luuTaiKhoan(String username){
        SharedPreferences sharedPreferences2 = DangNhapActivity.this.getSharedPreferences("Luu_dangNhap", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences2.edit();
        editor.putBoolean("luuDangNhap", true);
        editor.putString("tenDangNhap", username);
        editor.apply();
    }


}