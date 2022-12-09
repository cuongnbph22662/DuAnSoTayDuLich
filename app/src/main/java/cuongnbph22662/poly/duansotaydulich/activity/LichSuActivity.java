package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.ChuyenDiAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.ChuyenDiDAO;
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
        loadDataChuyenDi();
    }

    private void loadDataChuyenDi() {
        listCD.clear();
        listCD = (ArrayList<ChuyenDi>) chuyenDiDAO.getAll();
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
}