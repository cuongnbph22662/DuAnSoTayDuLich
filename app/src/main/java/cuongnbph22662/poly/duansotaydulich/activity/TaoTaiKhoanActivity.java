package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;

public class TaoTaiKhoanActivity extends AppCompatActivity {
    EditText edTenDangNhap, edHoTen, edMatKhau, edNamSinh, edDiaChi, edSDT;
    Button btnDangKi;
    TextView tvTroVeManDNhap;
    NguoiDungDAO dao;
    NguoiDung nguoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_tai_khoan);
        anhXa();
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TenDangNhap = edTenDangNhap.getText().toString();
                String HoTen = edHoTen.getText().toString();
                String MatKhau = edMatKhau.getText().toString();
                String SDT = edSDT.getText().toString();
                if (TenDangNhap.isEmpty()||HoTen.isEmpty()||MatKhau.isEmpty()||SDT.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Không được để trống ",Toast.LENGTH_SHORT).show();
                }
                else {
                    dao = new NguoiDungDAO(getApplicationContext());
                    nguoiDung = new NguoiDung();
                    nguoiDung.setTaiKhoan(TenDangNhap);
                    nguoiDung.setHoTen(HoTen);
                    nguoiDung.setMatKhau(MatKhau);
                    nguoiDung.setSoDienThoai(SDT);
                    dao.insert(nguoiDung);
                    Toast.makeText(TaoTaiKhoanActivity.this, "Đăng kí thành công !!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), DangNhapActivity.class));
                }

            }
        });
    }

    private void anhXa() {
        edTenDangNhap = findViewById(R.id.edTenDangNhap);
        edHoTen = findViewById(R.id.edHoTen);
        edMatKhau = findViewById(R.id.edMatKhau);
        edNamSinh = findViewById(R.id.edNamSinh);
        edDiaChi = findViewById(R.id.edDiaChi);
        edSDT = findViewById(R.id.edSoDienThoai);
        btnDangKi = findViewById(R.id.btnDangKi);


    }
}