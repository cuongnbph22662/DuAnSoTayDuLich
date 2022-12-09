package cuongnbph22662.poly.duansotaydulich.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.activity.DiaDiemActivity;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class DiaDiemAdapter extends RecyclerView.Adapter<DiaDiemAdapter.DiaDiemViewHolder>{
    private Context mContext;
    private List<DiaDiem> listDD = new ArrayList<>();

    private ThanhPhoDAO thanhPhoDAO;

    public DiaDiemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListDD(ArrayList<DiaDiem> list){
        this.listDD = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DiaDiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dia_diem_item, parent, false);
        return new DiaDiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaDiemViewHolder holder, int position) {
        DiaDiem obj = listDD.get(position);
        if(listDD == null)
            return;
        thanhPhoDAO = new ThanhPhoDAO(mContext);
        ThanhPho thanhPho = thanhPhoDAO.getID(String.valueOf(obj.getMaThanhPho()));
        holder.tenThanhPho.setText(thanhPho.getTenThanhPho());
        holder.tenDiaDiem.setText(obj.getTenDiaDiem());
        holder.gia.setText(String.valueOf(obj.getGiaThue()));
        holder.viTri.setText(obj.getViTri());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DiaDiemActivity.class);
                intent.putExtra("maDiaDiem", String.valueOf(obj.getMaDiaDiem()));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(listDD != null)
            return listDD.size();
        return 0;
    }

    public class DiaDiemViewHolder extends RecyclerView.ViewHolder{
        private TextView tenThanhPho, tenDiaDiem, gia, viTri;
        private ImageView imgAnh;
        public DiaDiemViewHolder(@NonNull View itemView) {
            super(itemView);
            tenThanhPho = itemView.findViewById(R.id.tv_tenThanhPho);
            tenDiaDiem = itemView.findViewById(R.id.tv_tenDiaDiem);
            gia = itemView.findViewById(R.id.tv_Gia);
            viTri = itemView.findViewById(R.id.tv_viTri);
            imgAnh = itemView.findViewById(R.id.img_ItemAnh);
        }
    }
}
