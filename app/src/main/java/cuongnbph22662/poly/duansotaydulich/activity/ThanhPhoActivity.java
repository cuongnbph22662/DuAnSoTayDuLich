package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.DiaDiemAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class ThanhPhoActivity extends AppCompatActivity {
    ImageView troVe;
    RecyclerView RecyActivity;
    TextView tvActivity;
    ThanhPhoDAO thanhPhoDAO;
    DiaDiemDAO diaDiemDAO;
    private ArrayList<DiaDiem> listDD = new ArrayList<>();
    private DiaDiemAdapter diaDiemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_pho);
        anhXa();
        troVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThanhPhoActivity.this, MainActivity.class));
            }
        });
        Intent intent = getIntent();
        String maTP = intent.getStringExtra("mathanhpho");
        ThanhPho thanhPho = thanhPhoDAO.getID(maTP);
        tvActivity.setText("Tên thành phố: "+thanhPho.getTenThanhPho());
        listDD.clear();
        listDD = (ArrayList<DiaDiem>) diaDiemDAO.timTheoThanhPho(maTP);
        diaDiemAdapter = new DiaDiemAdapter(ThanhPhoActivity.this);
        diaDiemAdapter.setListDD(listDD);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(ThanhPhoActivity.this, RecyclerView.VERTICAL,false);
        RecyActivity.setLayoutManager(LinLayoutManager);
        RecyActivity.setAdapter(diaDiemAdapter);
    }


    private void anhXa() {
        thanhPhoDAO = new ThanhPhoDAO(ThanhPhoActivity.this);
        diaDiemDAO = new DiaDiemDAO(ThanhPhoActivity.this);
        troVe = findViewById(R.id.img_troveActivity);
        RecyActivity = findViewById(R.id.id_RecyThanhPhoActivity);
        tvActivity = findViewById(R.id.tvTenThanhPhoActivity);
    }
}