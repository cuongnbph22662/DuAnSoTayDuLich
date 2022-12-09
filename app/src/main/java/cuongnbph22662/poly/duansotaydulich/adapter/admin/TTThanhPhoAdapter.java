package cuongnbph22662.poly.duansotaydulich.adapter.admin;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.loaddata.LoadDataTTThanhPho;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class TTThanhPhoAdapter extends RecyclerView.Adapter<TTThanhPhoAdapter.ThanhPhoViewHoler> {
    Context mContext;
    LoadDataTTThanhPho loadDataTTThanhPho;
    ArrayList<ThanhPho> listTP = new ArrayList<>();
    ThanhPhoDAO dao;

    public TTThanhPhoAdapter(Context mContext, LoadDataTTThanhPho loadDataTTThanhPho) {
        this.mContext = mContext;
        this.loadDataTTThanhPho = loadDataTTThanhPho;
    }

    public void setListTP(ArrayList<ThanhPho> list){
        this.listTP = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ThanhPhoViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thong_tin_thanh_pho,parent,false);
        return new ThanhPhoViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhPhoViewHoler holder, int position) {
        ThanhPho obj = listTP.get(position);
        if(obj == null){
            return;
        }
        holder.maTP.setText("Mã thành phố: "+obj.getMaThanhPho());
        holder.tenTP.setText("Tên thành phố: "+obj.getTenThanhPho());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.dialog_sua_xoa_thanh_pho);

                EditText tenTP = dialog.findViewById(R.id.ed_TenTP);
                TextView maTP = dialog.findViewById(R.id.tv_MaTP);
                Button btnSua = dialog.findViewById(R.id.btn_Sua_TP);
                Button btnXoa = dialog.findViewById(R.id.btn_Xoa_TP);

                tenTP.setText(obj.getTenThanhPho());
                maTP.setText(String.valueOf(obj.getMaThanhPho()));
                btnSua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dao = new ThanhPhoDAO(mContext);
                        obj.setTenThanhPho(tenTP.getText().toString());
                        dao.update(obj);
                        loadDataTTThanhPho.loadDataTP();
                        dialog("Sửa thành công");
                        dialog.dismiss();
                    }
                });
                btnXoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dao = new ThanhPhoDAO(mContext);
                        dao.delete(String.valueOf(obj.getMaThanhPho()));
                        loadDataTTThanhPho.loadDataTP();
                        dialog("Xóa thành công");
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listTP != null)
            return listTP.size();
        return 0;
    }

    public class ThanhPhoViewHoler extends RecyclerView.ViewHolder{
        TextView maTP, tenTP;
        public ThanhPhoViewHoler(@NonNull View itemView) {
            super(itemView);
            maTP = itemView.findViewById(R.id.tv_item_maTP);
            tenTP = itemView.findViewById(R.id.tv_item_tenTP);
        }
    }

    public void dialog(String thongbao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
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
