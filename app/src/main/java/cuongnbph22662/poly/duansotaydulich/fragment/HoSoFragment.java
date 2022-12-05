package cuongnbph22662.poly.duansotaydulich.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.activity.CongDongActivity;
import cuongnbph22662.poly.duansotaydulich.activity.DangNhapActivity;
import cuongnbph22662.poly.duansotaydulich.activity.DoiMatKhauActivity;
import cuongnbph22662.poly.duansotaydulich.activity.LichSuActivity;
import cuongnbph22662.poly.duansotaydulich.activity.LienHeActivity;
import cuongnbph22662.poly.duansotaydulich.activity.ManChaoActivity;
import cuongnbph22662.poly.duansotaydulich.activity.TTCaNhanActivity;
import cuongnbph22662.poly.duansotaydulich.activity.TaoTaiKhoanActivity;

public class HoSoFragment extends Fragment {
    Button btnDangNhap;
    TextView tvTaoTaiKhoan;
    LinearLayout hoSoCaNhan, hoSoCuaBan,
                ThongTinCaNhan,DoiMatKhau, DangXuat, CongDong, LichSuDi, HoTro,DieuKhoan, QuyenRiengTu,
            dieuKhoan, quyenRiengTu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ho_so, container, false);
        // anh xa
        anhXa(view);
        // trc khi đăng nhập
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DangNhapActivity.class);
                startActivity(intent);
            }
        });
        tvTaoTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TaoTaiKhoanActivity.class);
                startActivity(intent);
            }
        });
        // chưa làm
        dieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        quyenRiengTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // sau khi đăng nhập
        ThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TTCaNhanActivity.class));
            }
        });
        DoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DoiMatKhauActivity.class));
            }
        });
        LichSuDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LichSuActivity.class));
            }
        });
        HoTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LienHeActivity.class));
            }
        });
        DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ManChaoActivity.class));
                hoSoCaNhan.setVisibility(View.VISIBLE);
                hoSoCuaBan.setVisibility(View.GONE);
                clearLuuDangNhap();
            }
        });
        // chưa làm
        CongDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CongDongActivity.class));
            }
        });
        DieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        QuyenRiengTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        Intent intent = getActivity().getIntent();
        Log.i("//=======", intent+"");
        String trangthai = intent.getStringExtra("trangthai");
        String kt = "anhien";
        if (kt.equals(trangthai)){
            hoSoCaNhan.setVisibility(View.GONE);
            hoSoCuaBan.setVisibility(View.VISIBLE);
        }
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("MY_SF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences2.edit();
        editor.putBoolean("luuDangNhap", true);
        editor.commit();
        return view;
    }

    private void anhXa(View view) {
        btnDangNhap = view.findViewById(R.id.btnDangNhap);
        tvTaoTaiKhoan = view.findViewById(R.id.tvDangKi);
        dieuKhoan = view.findViewById(R.id.id_dieuKhoan);
        quyenRiengTu = view.findViewById(R.id.id_quyenRiengTu);

        hoSoCaNhan = view.findViewById(R.id.id_HoSoCaNhan);
        hoSoCuaBan = view.findViewById(R.id.id_HoSoCuaBan);

        ThongTinCaNhan = view.findViewById(R.id.id_ThongTinCaNhan);
        DangXuat = view.findViewById(R.id.id_DangXuat);
        DoiMatKhau = view.findViewById(R.id.id_DoiMatKhau);
        CongDong = view.findViewById(R.id.id_CongDong);
        LichSuDi = view.findViewById(R.id.id_LichSuChuyenDi);
        HoTro = view.findViewById(R.id.id_PhanHoi);
        DieuKhoan = view.findViewById(R.id.id_DieuKhoan);
        QuyenRiengTu = view.findViewById(R.id.id_QuyenRiengTu);
    }

    private void clearLuuDangNhap() {
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("MY_SF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences2.edit();
        editor.putBoolean("luuDangNhap", false);
        editor.apply();
        editor.commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}