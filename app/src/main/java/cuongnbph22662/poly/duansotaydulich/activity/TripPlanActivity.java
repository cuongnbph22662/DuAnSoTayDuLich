package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.activity.congdong.DaNangActivity;
import cuongnbph22662.poly.duansotaydulich.activity.congdong.HaNamActivity;
import cuongnbph22662.poly.duansotaydulich.activity.congdong.HaNoiActivity;
import cuongnbph22662.poly.duansotaydulich.activity.congdong.HoChiMinhActivity;
import cuongnbph22662.poly.duansotaydulich.activity.congdong.HueActivity;

public class TripPlanActivity extends AppCompatActivity {
    ImageView trove;
    LinearLayout haNoi, hue, daNang, ninhBinh, hoiAn, phuQuoc, nhaTrang, daLac, tamDao, sapa, mocChau, haNam, haGiang, hoChiMinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_plan);
        anhXa();
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TripPlanActivity.this, CongDongActivity.class));
            }
        });
        //
        haNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TripPlanActivity.this, HaNoiActivity.class));
            }
        });
        hoChiMinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TripPlanActivity.this, HoChiMinhActivity.class));
            }
        });
        hue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TripPlanActivity.this, HueActivity.class));
            }
        });
        daNang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TripPlanActivity.this, DaNangActivity.class));
            }
        });
        ninhBinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        hoiAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        phuQuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        nhaTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        daLac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        tamDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        sapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        mocChau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
        haNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TripPlanActivity.this, HaNamActivity.class));
            }
        });
        haGiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Địa điểm này đang được cập nhật");
            }
        });
    }

    public void dialog(String thongbao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TripPlanActivity.this);
        View view = LayoutInflater.from(TripPlanActivity.this).inflate(R.layout.dialog_thongbao, null);
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

    private void anhXa() {
        trove = findViewById(R.id.img_trove_cd);
        haNoi = findViewById(R.id.id_HaNoi);
        hue = findViewById(R.id.id_Hue);
        daNang = findViewById(R.id.id_DaNang);
        ninhBinh = findViewById(R.id.id_NinhBinh);
        hoiAn = findViewById(R.id.id_HoiAn);
        phuQuoc = findViewById(R.id.id_PhuQuoc);
        nhaTrang = findViewById(R.id.id_NhaTrang);
        daLac = findViewById(R.id.id_DaLac);
        tamDao = findViewById(R.id.id_TamDao);
        sapa = findViewById(R.id.id_Spa);
        mocChau = findViewById(R.id.id_MocChau);
        haNam = findViewById(R.id.id_TamChuc);
        haGiang = findViewById(R.id.id_HaGiang);
        hoChiMinh = findViewById(R.id.id_HoChiMinh);
    }
}