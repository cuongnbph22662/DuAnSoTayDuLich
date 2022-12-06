package cuongnbph22662.poly.duansotaydulich.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;

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
        SharedPreferences pref = getSharedPreferences("DATA_LOCAL",MODE_PRIVATE);
        String user = pref.getString("tenDangNhap","");
        String pass = pref.getString("matKhau","");
        pref.getBoolean("trangThai",false);
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
            dialog("Tài khoản hoặc mật khẩu không được để trống");
        }
        else {
            if(nguoiDungDAO.checkLogin(strUser,strPass)>0){
                dialog("Đăng nhập thành công");
                DataLocalManager.setTrangThaiDangNhap(true);
                DataLocalManager.setUser(strUser);
                DataLocalManager.setMatKhau(strPass);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("trangthai", "anhien");
                startActivity(intent);
                finish();

            }
            else {
                dialog("Tên đăng nhập và mật khẩu không đúng");
            }
        }

    }

    public void luuTaiKhoan(String username, String pass){
        SharedPreferences pref = getSharedPreferences("DATA_LOCAL", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
            edit.putString("tenDangNhap", username);
            edit.putString("matKhau", pass);
            edit.putBoolean("trangThai", true);
        edit.commit();
    }

    public void dialog(String thongbao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_thongbao, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();
        TextView tvThongbao = view.findViewById(R.id.tvMess);
        // dialog
        Button btnThongBao = view.findViewById(R.id.btnThongBao);
        tvThongbao.setText(thongbao);

        btnThongBao.setOnClickListener(view1 -> {
            alertDialog.dismiss();
        });
    }

}