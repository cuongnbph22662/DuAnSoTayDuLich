package cuongnbph22662.poly.duansotaydulich.activity.admin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.adapter_admin.TTDiaDiemAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;

public class ThongTinDiaDiemActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
   private FloatingActionButton floaBtn;
   private ArrayList<DiaDiem> listDD = new ArrayList<>();
   private TTDiaDiemAdapter adapter;
   static DiaDiemDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dia_diem);
        recyclerView = findViewById(R.id.id_RecyDiaDiem);
        floaBtn = findViewById(R.id.btn_ThemDiaDiem);
        listDD.clear();
        dao = new DiaDiemDAO(this);
        listDD = (ArrayList<DiaDiem>) dao.getAll();
        adapter = new TTDiaDiemAdapter(ThongTinDiaDiemActivity.this);
        adapter.setList(listDD);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}