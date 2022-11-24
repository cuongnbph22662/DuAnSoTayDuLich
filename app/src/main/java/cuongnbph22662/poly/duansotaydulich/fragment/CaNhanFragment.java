package cuongnbph22662.poly.duansotaydulich.fragment;

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

import cuongnbph22662.poly.duansotaydulich.Canhan.CreateAccount;
import cuongnbph22662.poly.duansotaydulich.Canhan.DangNhap;
import cuongnbph22662.poly.duansotaydulich.Canhan.TTCaNhan;
import cuongnbph22662.poly.duansotaydulich.R;

public class CaNhanFragment extends Fragment {
    TextView btnDangNhap,btnTaoTaiKhoan,btnTTTaiKhoan;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ca_nhan, container, false);
        btnDangNhap = view.findViewById(R.id.btnDangNhap);
        btnTaoTaiKhoan = view.findViewById(R.id.btnTaoTaiKhoan);
        btnTTTaiKhoan = view.findViewById(R.id.btnTTTaiKhoan);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DangNhap.class);
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