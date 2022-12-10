package cuongnbph22662.poly.duansotaydulich.adapter.admin;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.loaddata.LoadDiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;

public class TTDiaDiemAdapter extends RecyclerView.Adapter<TTDiaDiemAdapter.DiaiemViewHolder>{
    private Context mContext;
    private List<DiaDiem> listTT = new ArrayList<>();
    private DiaDiemDAO diaDiemDao;
    LoadDiaDiem loadDiaDiem;

    public TTDiaDiemAdapter(Context mContext, LoadDiaDiem loadDiaDiem) {
        this.mContext = mContext;
        this.loadDiaDiem = loadDiaDiem;
    }

    public void setList(ArrayList<DiaDiem> list){
        this.listTT = list;
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
        DiaDiem obj = listTT.get(position);
        if (listTT == null){
            return;
        }
        diaDiemDao = new DiaDiemDAO(mContext);
        DiaDiem diaDiem = diaDiemDao.getID(String.valueOf(obj.getMaDiaDiem()));
        holder.TTMaDiaDiem.setText("Mã địa điểm: "+String.valueOf(obj.getMaDiaDiem()));
        holder.TTMaThanhPho.setText("Mã thành phố: "+String.valueOf(diaDiem.getMaThanhPho()));
        holder.TTTenDiaDiem.setText("Tên địa điểm: "+diaDiem.getTenDiaDiem());
        holder.TTGia.setText("Giá : "+String.valueOf(diaDiem.getGiaThue()));
//        holder.TTNoiDung.setText("Nội dung: "+diaDiem.getNoiDung());
        holder.TTViTri.setText("Địa điểm chi tiết: "+diaDiem.getViTri());
        holder.btnXoaDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaDiemDao = new DiaDiemDAO(mContext);
                diaDiemDao.delete(String.valueOf(obj.getMaDiaDiem()));
                loadDiaDiem.loadDataDiaDiem();
                dialog("Xóa thành công ");
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listTT != null){
            return listTT.size();
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
