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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.ChuyenDiAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.ChuyenDiDAO;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;
import cuongnbph22662.poly.duansotaydulich.model.ChuyenDi;

public class LichSuActivity extends AppCompatActivity {
    ImageView troVe;
    RecyclerView chuyenDiRecy;
    ChuyenDiDAO chuyenDiDAO ;
    ArrayList<ChuyenDi> listCD;
    ChuyenDiAdapter chuyenDiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su);
        anhXa();
        troVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LichSuActivity.this, MainActivity.class));
            }
        });
        listCD.clear();
        String user = DataLocalManager.getUser();
        try {
            listCD = (ArrayList<ChuyenDi>) chuyenDiDAO.getChuyenDiTheoUser(user);
        }catch (Exception e){
            dialog("Bạn chưa có chuyến đi nào cả");
        }
        loadDataChuyenDi();
    }

    private void loadDataChuyenDi() {
        chuyenDiAdapter = new ChuyenDiAdapter(this);
        chuyenDiAdapter.setListCD(listCD);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        chuyenDiRecy.setLayoutManager(LinLayoutManager);
        chuyenDiRecy.setAdapter(chuyenDiAdapter);
    }

    private void anhXa() {
        chuyenDiDAO = new ChuyenDiDAO(this);
        listCD = new ArrayList<>();
        troVe = findViewById(R.id.img_trove_chuyendi);
        chuyenDiRecy = findViewById(R.id.id_recyChuyenDi);
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