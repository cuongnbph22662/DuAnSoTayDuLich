package cuongnbph22662.poly.duansotaydulich.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
import cuongnbph22662.poly.duansotaydulich.loaddata.DiaLogThongBao;
import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;

public class DangNhapActivity extends AppCompatActivity {
    EditText edUsername,edPassword;
    NguoiDungDAO nguoiDungDAO;
    Button btnLogin;
    String strUser,strPass;
    DiaLogThongBao diaLogThongBao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        anhXa();
        nguoiDungDAO = new NguoiDungDAO(getApplicationContext());
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MY_SF",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String user = pref.getString("tenDangNhap","");
        String pass = pref.getString("matKhau","");
        ArrayList<NguoiDung> list = (ArrayList<NguoiDung>) nguoiDungDAO.getAll();
        Log.i("//++++++", list+"");
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
            diaLogThongBao.dialog("Tài khoản hoặc mật khẩu không được để trống");

        }
        else {
            if(nguoiDungDAO.checkLogin(strUser,strPass)>0){
                diaLogThongBao.dialog("Đăng nhập thành công");
                luuTaiKhoan(strUser, strPass);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("tenDangNhap", strUser);
                intent.putExtra("trangthai", "anhien");
                startActivity(intent);
                finish();

            }
            else {
                diaLogThongBao.dialog("Tên đăng nhập và mật khẩu không đúng");
            }
        }

    }

    public void luuTaiKhoan(String username, String pass){

    }

}