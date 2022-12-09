package cuongnbph22662.poly.duansotaydulich.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import cuongnbph22662.poly.duansotaydulich.activity.admin.ThongKeDoanhThuActivity;
import cuongnbph22662.poly.duansotaydulich.activity.admin.ThongTinDiaDiemActivity;
import cuongnbph22662.poly.duansotaydulich.activity.admin.ThongTinThanhPhoActivity;
import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;

public class HoSoFragment extends Fragment {
    Button btnDangNhap;
    TextView tvTaoTaiKhoan;
    LinearLayout hoSoCaNhan, hoSoCuaBan, hoSoAdmin,
                ThongTinCaNhan,DoiMatKhau, DangXuat, CongDong, LichSuDi, HoTro,DieuKhoan, QuyenRiengTu,
                dieuKhoan, quyenRiengTu,
                thongTinAdmin, doiMatKhauAdmin, dangXuatAdmin, thongKe, thongTinThanhPho, thongTinDiaDiem, traLoiTinNhan;

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
        dieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Chức năng đang được phát triên, Bạn hãy quay lại sau nhé");
            }
        });
        quyenRiengTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Chức năng đang được phát triên, Bạn hãy quay lại sau nhé");
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
                dialogDangXuat();
            }
        });
        CongDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CongDongActivity.class));
            }
        });
        DieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Chức năng đang được phát triên, Bạn hãy quay lại sau nhé");
            }
        });
        QuyenRiengTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Chức năng đang được phát triên, Bạn hãy quay lại sau nhé");
            }
        });
        // chức năng của admin
        thongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ThongKeDoanhThuActivity.class));
            }
        });
        thongTinThanhPho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ThongTinThanhPhoActivity.class));
            }
        });
        thongTinDiaDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ThongTinDiaDiemActivity.class));
            }
        });
        traLoiTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Chức năng đang được phát triên, Bạn hãy quay lại sau nhé");
            }
        });
        thongTinAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TTCaNhanActivity.class));
            }
        });
        doiMatKhauAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DoiMatKhauActivity.class));
            }
        });
        dangXuatAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDangXuat();
            }
        });
        // lưu đăng nhập
        String admin = DataLocalManager.getUser();
        if(DataLocalManager.layTrangThaiDangNhap() == true){
            if(admin.equalsIgnoreCase("admin")){
                hoSoAdmin.setVisibility(View.VISIBLE);
                hoSoCaNhan.setVisibility(View.GONE);
            }else {
                hoSoCaNhan.setVisibility(View.GONE);
                hoSoCuaBan.setVisibility(View.VISIBLE);
            }
        }
        return view;
    }

    private void dialogDangXuat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_dangxuat, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();
        // dialog
        Button btnHuy = view.findViewById(R.id.btnHuyDX);
        Button btnOK = view.findViewById(R.id.btnDangXuat);

        btnHuy.setOnClickListener(view1 -> {
            alertDialog.dismiss();
        });

        btnOK.setOnClickListener(view1 -> {
            startActivity(new Intent(getActivity(), ManChaoActivity.class));
            hoSoCaNhan.setVisibility(View.VISIBLE);
            hoSoCuaBan.setVisibility(View.GONE);
            DataLocalManager.setTrangThaiDangNhap(false);
            alertDialog.dismiss();
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void dialog(String thongbao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_thongbao, null);
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

    private void anhXa(View view) {
        hoSoCaNhan = view.findViewById(R.id.id_HoSoCaNhan);
        hoSoCuaBan = view.findViewById(R.id.id_HoSoCuaBan);
        hoSoAdmin = view.findViewById(R.id.id_ChucNangAdmin);
        //hồ sơ cá nhân
        btnDangNhap = view.findViewById(R.id.btnDangNhap);
        tvTaoTaiKhoan = view.findViewById(R.id.tvDangKi);
        dieuKhoan = view.findViewById(R.id.id_dieuKhoan);
        quyenRiengTu = view.findViewById(R.id.id_quyenRiengTu);
        //người dùng
        ThongTinCaNhan = view.findViewById(R.id.id_ThongTinCaNhan);
        DangXuat = view.findViewById(R.id.id_DangXuat);
        DoiMatKhau = view.findViewById(R.id.id_DoiMatKhau);
        CongDong = view.findViewById(R.id.id_CongDong);
        LichSuDi = view.findViewById(R.id.id_LichSuChuyenDi);
        HoTro = view.findViewById(R.id.id_PhanHoi);
        DieuKhoan = view.findViewById(R.id.id_DieuKhoan);
        QuyenRiengTu = view.findViewById(R.id.id_QuyenRiengTu);
        //admin
        thongTinAdmin = view.findViewById(R.id.id_ThongTinCaNhanAdmin);
        doiMatKhauAdmin = view.findViewById(R.id.id_DoiMatKhauAdmin);
        dangXuatAdmin = view.findViewById(R.id.id_DangXuatAdmin);
        thongKe = view.findViewById(R.id.id_ThongKe);
        thongTinThanhPho = view.findViewById(R.id.id_ThemThanhPho);
        thongTinDiaDiem = view.findViewById(R.id.id_ThemDiaDiem);
        traLoiTinNhan = view.findViewById(R.id.id_TraLoiTinNhan);
    }


}