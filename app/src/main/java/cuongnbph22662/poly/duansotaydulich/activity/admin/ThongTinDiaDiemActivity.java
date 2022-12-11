package cuongnbph22662.poly.duansotaydulich.activity.admin;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
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
    private ArrayList<ThanhPho> listTP = new ArrayList<>();
    private ThanhPhoDAO thanhPhoDAO;
    private DiaDiemDAO diaDiemDAO;
    private DiaDiemSPAdapter diaDiemSPAdapter;
    private int maThanhPho,position1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dia_diem);
        anhXa();
        loadDataDiaDiem();
        floaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void anhXa() {
        diaDiemDAO = new DiaDiemDAO(this);
        recyclerView = findViewById(R.id.id_RecyDiaDiem);
        floaBtn = findViewById(R.id.btn_ThemDiaDiem);
    }

    @Override
    public void loadDataDiaDiem() {
        listDD.clear();
        listDD = (ArrayList<DiaDiem>) diaDiemDAO.getAllAdmin();
        adapter = new TTDiaDiemAdapter(ThongTinDiaDiemActivity.this,this);
        adapter.setListTTDiaDiem(listDD);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    protected void openDialog(){
        Dialog dialog = new Dialog(ThongTinDiaDiemActivity.this);
        dialog.setContentView(R.layout.dialog_them_dia_diem);
        // ánh xạ
        EditText edTenDiaDiem = dialog.findViewById(R.id.ed_TenDiaDiem);
        EditText edVitri = dialog.findViewById(R.id.ed_ViTri);
        Spinner spMaThanhPho = dialog.findViewById(R.id.spMaThanhPho);
        EditText edNoiDung = dialog.findViewById(R.id.ed_NoiDung);
        EditText edGia = dialog.findViewById(R.id.ed_Gia);
        Button btnThem = dialog.findViewById(R.id.btnSaveDiaDiem);
        Button btnCancel = dialog.findViewById(R.id.btnCancelDiaDiem);
        // code
        thanhPhoDAO = new ThanhPhoDAO(this);
        listTP =(ArrayList<ThanhPho>)thanhPhoDAO.getAll();
        diaDiemSPAdapter = new DiaDiemSPAdapter(this,listTP);
        spMaThanhPho.setAdapter(diaDiemSPAdapter);
        spMaThanhPho.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maThanhPho = listTP.get(position).getMaThanhPho();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edTenDiaDiem.getText().toString().isEmpty() || edVitri.getText().toString().isEmpty() ||
                        edGia.getText().toString().isEmpty() || edNoiDung.getText().toString().isEmpty()){
                    dialog("Vui lòng nhập đủ thông tin");
                }
                else {
                    diaDiemDAO = new DiaDiemDAO(getApplicationContext());
                    DiaDiem item = new DiaDiem();
                    item.setMaThanhPho(maThanhPho);
                    item.setTenDiaDiem(edTenDiaDiem.getText().toString());
                    item.setViTri(edVitri.getText().toString());
                    item.setNoiDung(edNoiDung.getText().toString());
                    item.setGiaThue(Integer.parseInt(edGia.getText().toString()));
                    diaDiemDAO.insert(item);
                    loadDataDiaDiem();
                    dialog.dismiss();
                    dialog("Thêm địa điểm thành công");
                }
            }
        });
        dialog.show();
    }

    public void dialog(String thongbao) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(ThongTinDiaDiemActivity.this);
        View view = LayoutInflater.from(ThongTinDiaDiemActivity.this).inflate(R.layout.dialog_thongbao, null);
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