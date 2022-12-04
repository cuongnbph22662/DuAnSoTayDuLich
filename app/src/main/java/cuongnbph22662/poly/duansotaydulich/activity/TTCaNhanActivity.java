package cuongnbph22662.poly.duansotaydulich.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.NguoiDungDAO;
import cuongnbph22662.poly.duansotaydulich.model.NguoiDung;

public class TTCaNhanActivity extends AppCompatActivity {
    TextView tvTen,tvSDT;
    NguoiDungDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttca_nhan);
        tvTen = findViewById(R.id.tvTen);
        tvSDT = findViewById(R.id.tvSDT);
        Intent intent = getIntent();
        String user  = intent.getStringExtra("ten");
        Toast.makeText(getApplicationContext(),user,Toast.LENGTH_SHORT).show();
//        dao = new NguoiDungDAO(this);
//        NguoiDung nguoiDung = dao.getID(user);
//        String userName = nguoiDung.getHoTen();
//        tvTen.setText(userName);

    }
}