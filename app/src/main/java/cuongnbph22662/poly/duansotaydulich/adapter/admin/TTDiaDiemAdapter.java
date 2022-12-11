package cuongnbph22662.poly.duansotaydulich.adapter.admin;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.loaddata.LoadDiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class TTDiaDiemAdapter extends RecyclerView.Adapter<TTDiaDiemAdapter.DiaiemViewHolder>{
    private Context mContext;
    private ArrayList<DiaDiem> listDD = new ArrayList<>();
    private ArrayList<ThanhPho> listTP = new ArrayList<>();
    private DiaDiemDAO diaDiemDao;
    private ThanhPhoDAO thanhPhoDAO;
    private LoadDiaDiem loadDiaDiem;
    private DiaDiemSPAdapter diaDiemSPAdapter;
    private int maThanhPho,position1;

    public TTDiaDiemAdapter(Context mContext, LoadDiaDiem loadDiaDiem) {
        this.mContext = mContext;
        this.loadDiaDiem = loadDiaDiem;
    }

    public void setListTTDiaDiem(ArrayList<DiaDiem> list){
        this.listDD = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DiaiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thong_tin_dia_diem, parent, false);
        return new DiaiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaiemViewHolder holder, int position) {
        DiaDiem obj = listDD.get(position);
        if (listDD == null){
            return;
        }
        thanhPhoDAO = new ThanhPhoDAO(mContext);
        ThanhPho tp = thanhPhoDAO.getID(String.valueOf(obj.getMaThanhPho()));
        holder.TTMaDiaDiem.setText("Mã địa điểm: "+obj.getMaDiaDiem());
        holder.TTMaThanhPho.setText("Tên thành phố: "+tp.getTenThanhPho());
        holder.TTTenDiaDiem.setText("Tên địa điểm: "+obj.getTenDiaDiem());
        holder.TTGia.setText("Giá : "+obj.getGiaThue());
        holder.TTViTri.setText("Vị trí: "+obj.getViTri());
        // chức năng xóa
        holder.btnXoaDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaDiemDao = new DiaDiemDAO(mContext);
                diaDiemDao.delete(String.valueOf(obj.getMaDiaDiem()));
                loadDiaDiem.loadDataDiaDiem();
                dialog("Xóa thành công ");
            }
        });
        // chức năng sửa
        holder.btnSuaDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.dialog_sua_dia_diem);

                EditText edMaDiaDiem = dialog.findViewById(R.id.ed_MaDiaDiemSua);
                EditText edTenDiaDiem = dialog.findViewById(R.id.ed_TenDiaDiemSua);
                EditText edVitri = dialog.findViewById(R.id.ed_ViTriSua);
                Spinner spMaThanhPho = dialog.findViewById(R.id.spMaThanhPhoSua);
                EditText edNoiDung = dialog.findViewById(R.id.ed_NoiDungSua);
                EditText edGia = dialog.findViewById(R.id.ed_GiaSua);
                Button btnSua = dialog.findViewById(R.id.btnSuaDiaDiem);
                Button btnHuy = dialog.findViewById(R.id.btnHuySuaDiaDiem);

                thanhPhoDAO = new ThanhPhoDAO(mContext);
                listTP =(ArrayList<ThanhPho>)thanhPhoDAO.getAll();
                diaDiemSPAdapter = new DiaDiemSPAdapter(mContext,listTP);
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
                edMaDiaDiem.setText(String.valueOf(obj.getMaDiaDiem()));
                edTenDiaDiem.setText(obj.getTenDiaDiem());
                edVitri.setText(obj.getViTri());
                edNoiDung.setText(obj.getNoiDung());
                edGia.setText(String.valueOf(obj.getGiaThue()));

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (edTenDiaDiem.getText().toString().isEmpty()||edMaDiaDiem.getText().toString().isEmpty()||edVitri.getText().toString().isEmpty()||edGia.getText().toString().isEmpty()){
                            dialog("Vui lòng nhập đủ thông tin");
                        }
                        else {
                            diaDiemDao = new DiaDiemDAO(mContext);
                            obj.setMaThanhPho(maThanhPho);
                            obj.setTenDiaDiem(edTenDiaDiem.getText().toString());
                            obj.setViTri(edVitri.getText().toString());
                            obj.setNoiDung(edNoiDung.getText().toString());
                            obj.setGiaThue(Integer.parseInt(edGia.getText().toString()));
                            diaDiemDao.update(obj);
                            loadDiaDiem.loadDataDiaDiem();
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listDD != null){
            return listDD.size();
        }
        return 0;
    }

    public class DiaiemViewHolder extends RecyclerView.ViewHolder {
        private TextView TTTenDiaDiem,TTMaDiaDiem,TTMaThanhPho,TTViTri,TTNoiDung,TTGia;
        private Button btnXoaDD, btnSuaDD;
        public DiaiemViewHolder(@NonNull View itemView) {
            super(itemView);
            TTTenDiaDiem = itemView.findViewById(R.id.tv_TTTenDiaDiem);
            TTMaDiaDiem = itemView.findViewById(R.id.tv_TTmaDiaDiem);
            TTMaThanhPho = itemView.findViewById(R.id.tv_TTmaThanhPho);
            TTViTri = itemView.findViewById(R.id.tv_TTViTri);
            TTNoiDung = itemView.findViewById(R.id.tv_TTNoiDung);
            TTGia = itemView.findViewById(R.id.tv_TTGia);
            btnXoaDD = itemView.findViewById(R.id.btn_Xoa_DD);
            btnSuaDD = itemView.findViewById(R.id.btn_Sua_DD);
        }
    }

    public void dialog(String thongbao) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_thongbao, null);
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
