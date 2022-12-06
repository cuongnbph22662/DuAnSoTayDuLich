package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;
import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;

public class DoiThongTinActivity extends AppCompatActivity {
    ImageView troLai;
    EditText hoTen, namSinh, gioiTinh, diaChi, soDienThoai;
    Button btnXacNhan;
    NguoiDungDAO nguoiDungDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_thong_tin);
        anhXa();
        nguoiDungDAO = new NguoiDungDAO(getApplicationContext());
        String user = DataLocalManager.getUser();
        NguoiDung nguoiDung = nguoiDungDAO.getID(user);
        hoTen.setText(nguoiDung.getHoTen());
        namSinh.setText(nguoiDung.getNamSinh()+"");
        gioiTinh.setText(nguoiDung.getGioiTinh());
        diaChi.setText(nguoiDung.getDiaChi());
        soDienThoai.setText(nguoiDung.getSoDienThoai());
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kiemTraLoi()){
                    String gioitinh = gioiTinh.getText().toString();
                    if(!gioitinh.equalsIgnoreCase("Nam")){
                        dialog("Chỉ đc nhập Nam hoặc Nữ");
                    }else if (!gioitinh.equalsIgnoreCase("Nữ")){
                        dialog("Chỉ đc nhập Nam hoặc Nữ");
                    }else {}
                    nguoiDung.setHoTen(hoTen.getText().toString());
                    nguoiDung.setNamSinh(Integer.parseInt(namSinh.getText().toString()));
                    nguoiDung.setGioiTinh(gioitinh);
                    nguoiDung.setDiaChi(diaChi.getText().toString());
                    nguoiDung.setSoDienThoai(soDienThoai.getText().toString());
                    nguoiDungDAO.update(nguoiDung);
                    dialog("Đổi thông tin thành công thành công");
                }
                startActivity(new Intent(DoiThongTinActivity.this, TTCaNhanActivity.class));
            }
        });
    }

    public boolean kiemTraLoi(){
        if(hoTen.getText().toString().isEmpty()){
            dialog("Không đc để trống họ tên");
            return false;
        }
        if(namSinh.getText().toString().isEmpty()){
            dialog("Không đc để trống năm sinh");
            return false;
        }
        if(diaChi.getText().toString().isEmpty()){
            dialog("Không đc để trống địa chỉ");
            return false;
        }
        if(soDienThoai.getText().toString().isEmpty()){
            dialog("Không đc để trống số điện thoại");
            return false;
        }
        if(gioiTinh.getText().toString().isEmpty()){
            dialog("Không đc để trống giới tính");
            return false;
        }


        return true;
    }

    private void anhXa() {
        troLai = findViewById(R.id.img_trove_ttcn);
        hoTen = findViewById(R.id.edHoTenDTT);
        namSinh = findViewById(R.id.edNamSinhDTT);
        gioiTinh = findViewById(R.id.edGioiTinhDTT);
        diaChi = findViewById(R.id.edDiaChiDTT);
        soDienThoai = findViewById(R.id.edSoDienThoaiDTT);
        btnXacNhan = findViewById(R.id.btnDoiThongTin);
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