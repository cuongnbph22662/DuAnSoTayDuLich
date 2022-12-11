package cuongnbph22662.poly.duansotaydulich.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.DiaDiemAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;

public class TimKiemFragment extends Fragment {
    RecyclerView recyTimKiem;
    Button btnTimKiem;
    EditText edTimKiem;
    DiaDiemDAO diaDiemDAO;
    ThanhPhoDAO thanhPhoDAO;
    ArrayList<DiaDiem> listDD = new ArrayList<>();
    DiaDiemAdapter diaDiemAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kham_pha, container, false);
        anhXa(view);
        // code
        listDD.clear();
        listDD = (ArrayList<DiaDiem>) diaDiemDAO.getAll();
        loadDataDiaDiem();
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diaDiem = edTimKiem.getText().toString().trim();
                if(diaDiem.isEmpty()){
                    dialog("Phải nhập từ khóa đã");
                }else {
                    try {
                        listDD.clear();
                        listDD = (ArrayList<DiaDiem>) diaDiemDAO.timTheoTen(diaDiem);
                        loadDataDiaDiem();
                    }catch (Exception e){
                        dialog("Địa điểm không tồn tại");
                    }
                }
            }
        });
        return view;
    }

    private void loadDataDiaDiem() {
        diaDiemAdapter = new DiaDiemAdapter(getActivity());
        diaDiemAdapter.setListDD(listDD);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
        recyTimKiem.setLayoutManager(LinLayoutManager);
        recyTimKiem.setAdapter(diaDiemAdapter);
    }

    private void anhXa(View view) {
        thanhPhoDAO = new ThanhPhoDAO(getActivity());
        diaDiemDAO = new DiaDiemDAO(getActivity());
        recyTimKiem = view.findViewById(R.id.id_recy_timkiem);
        btnTimKiem = view.findViewById(R.id.btn_TimKiem);
        edTimKiem = view.findViewById(R.id.ed_TimKiem);
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

}