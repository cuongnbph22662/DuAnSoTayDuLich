package cuongnbph22662.poly.duansotaydulich.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import cuongnbph22662.poly.duansotaydulich.CreateAccountActivity;
import cuongnbph22662.poly.duansotaydulich.DangNhapActivity;
import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.TTCaNhanActivity;
import cuongnbph22662.poly.duansotaydulich.ThemEmailActivity;
import cuongnbph22662.poly.duansotaydulich.ThemSDTActivity;

public class CaNhanFragment extends Fragment {
    TextView btnDangNhap,btnTaoTaiKhoan,btnTTTaiKhoan,btnEmail,btnSoDienThoai;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ca_nhan, container, false);
        btnDangNhap = view.findViewById(R.id.btnDangNhap);
        btnTaoTaiKhoan = view.findViewById(R.id.btnTaoTaiKhoan);
        btnTTTaiKhoan = view.findViewById(R.id.btnTTTaiKhoan);
        btnEmail = view.findViewById(R.id.btnEmail);
        btnSoDienThoai = view.findViewById(R.id.btnSoDienThoai);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DangNhapActivity.class);
                startActivity(intent);
            }
        });
        btnTaoTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });
        btnTTTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TTCaNhanActivity.class);
                startActivity(intent);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemEmailActivity.class);
                startActivity(intent);
            }
        });
        btnSoDienThoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemSDTActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}