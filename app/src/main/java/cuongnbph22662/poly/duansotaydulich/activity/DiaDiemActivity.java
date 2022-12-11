package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.ChuyenDiDAO;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;
import cuongnbph22662.poly.duansotaydulich.model.ChuyenDi;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class DiaDiemActivity extends AppCompatActivity {
    ImageView troVe;
    TextView tenDiaDiem, giaThue, tongTienDi, tenThanhPho, viTri, thongTin, soLuongNguoi;
    Button btnDatTua, btnTangND, btnGiamND;
    DiaDiemDAO diaDiemDAO;
    ThanhPhoDAO thanhPhoDAO;
    ChuyenDiDAO chuyenDiDAO;
    int soNguoi, tongTien, tien;
    String maDD, tongTien2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_diem);
        anhXa();
        troVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DiaDiemActivity.this, MainActivity.class));
            }
        });
        Intent intent = getIntent();
        maDD = intent.getStringExtra("maDiaDiem");
        DiaDiem diaDiem = diaDiemDAO.getID(String.valueOf(maDD));
        ThanhPho thanhPho = thanhPhoDAO.getID(String.valueOf(diaDiem.getMaThanhPho()));
        tenDiaDiem.setText(diaDiem.getTenDiaDiem());
        giaThue.setText(""+diaDiem.getGiaThue()+" VNĐ");
        thongTin.setText("       "+diaDiem.getNoiDung());
        tenThanhPho.setText(thanhPho.getTenThanhPho());
        viTri.setText(diaDiem.getViTri());
        tongTienDi.setText(String.valueOf(diaDiem.getGiaThue()));
        soLuongNguoi.setText(String.valueOf(1));

        soNguoi = Integer.parseInt(soLuongNguoi.getText().toString());
        tien = diaDiem.getGiaThue();
        tongTien = 0;
        btnGiamND.setOnClickListener(view1 -> {
            if (Integer.parseInt(soLuongNguoi.getText().toString()) > 1) {
                soLuongNguoi.setText(String.valueOf(Integer.parseInt(soLuongNguoi.getText().toString()) - 1));
                soNguoi = Integer.parseInt(soLuongNguoi.getText().toString());
                btnGiamND.setEnabled(true);
            } else {
                btnGiamND.setEnabled(false);
            }
            tongTienDi.setText(String.valueOf(((soNguoi/tien)+tien*soNguoi)));
            tongTien2 = tongTienDi.getText().toString();
            btnTangND.setEnabled(true);
        });
        btnTangND.setOnClickListener(view1 -> {
            if (Integer.parseInt(soLuongNguoi.getText().toString()) < 100) {
                soLuongNguoi.setText(String.valueOf(Integer.parseInt(soLuongNguoi.getText().toString()) + 1));
                soNguoi = Integer.parseInt(soLuongNguoi.getText().toString());
                btnTangND.setEnabled(true);
            } else {
                btnTangND.setEnabled(false);
            }
            tongTienDi.setText(String.valueOf((soNguoi*tien)));
            tongTien2 = tongTienDi.getText().toString();
            btnGiamND.setEnabled(true);
        });
        btnDatTua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DataLocalManager.layTrangThaiDangNhap() == false){
                    dialog("Bạn phải đăng nhập mới sử dụng đc chứ năng này");
                }else {
                    lenLichChuyenDi(Integer.parseInt(tongTien2), soNguoi);
                    startActivity(new Intent(DiaDiemActivity.this, LichSuActivity.class));
                }
            }
        });
    }

    private void lenLichChuyenDi(int tongTienDi, int soluongnguoi) {
        String user = DataLocalManager.getUser();
        chuyenDiDAO = new ChuyenDiDAO(getApplicationContext());
        ChuyenDi obj = new ChuyenDi();
        obj.setMaDiaDiem(Integer.parseInt(maDD));
        obj.setNgayDat(new Date());
        obj.setSoLuongNguoi(soluongnguoi);
        obj.setTaiKhoan(user);
        obj.setTienThue(tongTienDi);
        chuyenDiDAO.insert(obj);
    }

    private void anhXa() {
        thanhPhoDAO = new ThanhPhoDAO(getApplicationContext());
        diaDiemDAO = new DiaDiemDAO(getApplicationContext());
        chuyenDiDAO = new ChuyenDiDAO(getApplicationContext());

        troVe = findViewById(R.id.img_trove_item);
        tenDiaDiem = findViewById(R.id.tv_TenDiaDiem);
        giaThue = findViewById(R.id.tv_GiaThue);
        tongTienDi = findViewById(R.id.tv_TienDi);
        tenThanhPho = findViewById(R.id.tv_TenThanhPho);
        viTri = findViewById(R.id.tv_ViTri);
        thongTin = findViewById(R.id.tv_ThongTin);
        soLuongNguoi = findViewById(R.id.tv_dialog_SoLuongMua);
        btnDatTua = findViewById(R.id.btnDatTua);
        btnTangND = findViewById(R.id.btn_dialog_Tang);
        btnGiamND = findViewById(R.id.btn_dialog_Giam);
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