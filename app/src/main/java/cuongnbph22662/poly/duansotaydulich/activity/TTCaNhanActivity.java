package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;
import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;

public class TTCaNhanActivity extends AppCompatActivity {
    TextView namSinh, hoTen, diaChi, soDienThoai, gioiTinh, cmt;
    Button btnSuaThongTin;
    ImageView trolai, avataNguoiDung;
    NguoiDungDAO nguoiDungDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttca_nhan);
        anhXa();
        trolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TTCaNhanActivity.this, MainActivity.class));
            }
        });
        btnSuaThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TTCaNhanActivity.this, DoiThongTinActivity.class));
            }
        });

        nguoiDungDAO = new NguoiDungDAO(getApplicationContext());
        String hoso = DataLocalManager.getUser();
        NguoiDung nguoiDung = nguoiDungDAO.getID(hoso);
        namSinh.setText(String.valueOf(nguoiDung.getNamSinh()));
        hoTen.setText(nguoiDung.getHoTen());
        diaChi.setText(nguoiDung.getDiaChi());
        soDienThoai.setText(nguoiDung.getSoDienThoai());
        gioiTinh.setText(nguoiDung.getGioiTinh());
        cmt.setText(nguoiDung.getMatKhau());
        if(nguoiDung.getGioiTinh().equals("Nữ")){
            avataNguoiDung.setImageResource(R.drawable.img_avt_nu);
        }else if (nguoiDung.getGioiTinh().equals("Nam")){
            avataNguoiDung.setImageResource(R.drawable.img_avt_nam);
        }else {
            avataNguoiDung.setImageResource(R.drawable.img_avt);
        }



    }

    private void anhXa() {
        avataNguoiDung = findViewById(R.id.img_avt);
        namSinh = findViewById(R.id.tv_ttcn_namsinh);
        hoTen = findViewById(R.id.tv_ttcn_hoten);
        diaChi = findViewById(R.id.tv_ttcn_diachi);
        soDienThoai = findViewById(R.id.tv_ttcn_sdt);
        gioiTinh = findViewById(R.id.tv_ttcn_gioitinh);
        cmt = findViewById(R.id.tv_ttcn_cmt);
        btnSuaThongTin = findViewById(R.id.btnThayDoiThongTin);
        trolai = findViewById(R.id.img_trove_hoso);
    }
}