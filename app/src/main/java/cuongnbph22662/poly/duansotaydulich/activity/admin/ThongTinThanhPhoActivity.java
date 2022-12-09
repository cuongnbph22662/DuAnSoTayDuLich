package cuongnbph22662.poly.duansotaydulich.activity.admin;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.admin.TTThanhPhoAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.loaddata.LoadDataTTThanhPho;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class ThongTinThanhPhoActivity extends AppCompatActivity implements LoadDataTTThanhPho {
    EditText tenTP;
    private Button btnThem;
    private RecyclerView itemThanhPho ;
    private ArrayList<ThanhPho> listTP = new ArrayList<>();
    private TTThanhPhoAdapter ttThanhPhoAdapter;
    private ThanhPhoDAO thanhPhoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_thanh_pho);
        anhXa();
        loadDataTP();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThanhPho tp = new ThanhPho();
                tp.setTenThanhPho(tenTP.getText().toString());
                if(tenTP.getText().toString().isEmpty()){
                    dialog("Không được để trống");
                }else {
                    thanhPhoDAO.insert(tp);
                    loadDataTP();
                    tenTP.setText("");
                    dialog("Thêm thành công");
                }
            }
        });
    }


    private void anhXa() {
        thanhPhoDAO = new ThanhPhoDAO(ThongTinThanhPhoActivity.this);
        itemThanhPho = findViewById(R.id.id_RecyThanhPho);
        btnThem = findViewById(R.id.btnThemThanhPho);
        tenTP = findViewById(R.id.ed_tenTP);
    }

    @Override
    public void loadDataTP() {
        listTP.clear();
        listTP = (ArrayList<ThanhPho>)  thanhPhoDAO.getAll();
        ttThanhPhoAdapter = new TTThanhPhoAdapter(ThongTinThanhPhoActivity.this, this);
        ttThanhPhoAdapter.setListTP(listTP);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(ThongTinThanhPhoActivity.this, RecyclerView.VERTICAL,false);
        itemThanhPho.setLayoutManager(LinLayoutManager);
        itemThanhPho.setAdapter(ttThanhPhoAdapter);
    }

    public void dialog(String thongbao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ThongTinThanhPhoActivity.this);
        View view = LayoutInflater.from(ThongTinThanhPhoActivity.this).inflate(R.layout.dialog_thongbao, null);
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