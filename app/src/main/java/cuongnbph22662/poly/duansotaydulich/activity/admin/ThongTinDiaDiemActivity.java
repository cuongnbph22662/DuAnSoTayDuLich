package cuongnbph22662.poly.duansotaydulich.activity.admin;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.admin.DiaDiemSPAdapter;
import cuongnbph22662.poly.duansotaydulich.adapter.admin.TTDiaDiemAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.loaddata.LoadDiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class ThongTinDiaDiemActivity extends AppCompatActivity implements LoadDiaDiem {
   private RecyclerView recyclerView;
   private FloatingActionButton floaBtn;
   private ArrayList<DiaDiem> listDD = new ArrayList<>();
   private TTDiaDiemAdapter adapter;
   DiaDiemDAO dao;
   DiaDiem item;
   ArrayList<ThanhPho> listThanhPho;
   ThanhPhoDAO thanhPhoDAO;
   DiaDiemSPAdapter diaDiemSPAdapter;
   int maThanhPho,position1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dia_diem);
        recyclerView = findViewById(R.id.id_RecyDiaDiem);
        floaBtn = findViewById(R.id.btn_ThemDiaDiem);
        dao = new DiaDiemDAO(this);
        loadDataDiaDiem();
        floaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

            }
        });
    }

    @Override
    public void loadDataDiaDiem() {
        listDD.clear();
        listDD = (ArrayList<DiaDiem>) dao.getAll();
        adapter = new TTDiaDiemAdapter(ThongTinDiaDiemActivity.this,this);
        adapter.setList(listDD);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
    protected void openDialog(){
        Dialog dialog = new Dialog(ThongTinDiaDiemActivity.this);
        dialog.setContentView(R.layout.item_them_dia_diem);
        EditText edMaDiaDiem,edTenDiaDiem,edVitri,edNoiDung,edGia;
        Spinner spMaThanhPho;
        edMaDiaDiem = dialog.findViewById(R.id.ed_MaDiaDiem);
        edTenDiaDiem = dialog.findViewById(R.id.ed_TenDiaDiem);
        edVitri = dialog.findViewById(R.id.ed_ViTri);
        spMaThanhPho = dialog.findViewById(R.id.spMaThanhPho);
        edNoiDung = dialog.findViewById(R.id.ed_NoiDung);
        edGia = dialog.findViewById(R.id.ed_Gia);
        Button btnThem = dialog.findViewById(R.id.btnSaveDiaDiem);
        Button btnCancel = dialog.findViewById(R.id.btnCancelDiaDiem);
        listThanhPho = new ArrayList<ThanhPho>();
        thanhPhoDAO = new ThanhPhoDAO(this);
        listThanhPho =(ArrayList<ThanhPho>)thanhPhoDAO.getAll();
        item = new DiaDiem();
        diaDiemSPAdapter = new DiaDiemSPAdapter(this,listThanhPho);
        spMaThanhPho.setAdapter(diaDiemSPAdapter);
        spMaThanhPho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maThanhPho = listThanhPho.get(position).getMaThanhPho();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        edMaDiaDiem.setText(String.valueOf(item.getMaDiaDiem()));
        edTenDiaDiem.setText(item.getTenDiaDiem());
        edVitri.setText(item.getViTri());
        edNoiDung.setText(item.getNoiDung());
        edGia.setText(String.valueOf(item.getGiaThue()));
        for (int i = 0 ; i<listThanhPho.size();i++)
            if (item.getMaThanhPho()==(listThanhPho.get(i)).getMaThanhPho()){
                position1 = i;
            }
            spMaThanhPho.setSelection(position1);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edTenDiaDiem.getText().toString().isEmpty()||edMaDiaDiem.getText().toString().isEmpty()||edVitri.getText().toString().isEmpty()||edGia.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else {
                    item.setMaThanhPho(maThanhPho);
                    item.setMaDiaDiem(Integer.parseInt(edMaDiaDiem.getText().toString()));
                    item.setTenDiaDiem(edTenDiaDiem.getText().toString());
                    item.setViTri(edVitri.getText().toString());
                    item.setNoiDung(edNoiDung.getText().toString());
                    item.setGiaThue(Integer.parseInt(edGia.getText().toString()));
                    dao.insert(item);
                    loadDataDiaDiem();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}