package cuongnbph22662.poly.duansotaydulich.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.PhieuDuLich;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.ViewHodel> {
    Context context;
    ArrayList<PhieuDuLich> list;

    public TimKiemAdapter(Context context, ArrayList<PhieuDuLich> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TimKiemAdapter.ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.kham_pha_item,parent,false);
        return new ViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimKiemAdapter.ViewHodel holder, int position) {
        PhieuDuLich model = list.get(position);
        holder.KhamPha.setImageResource(R.drawable.dalat);
        holder.tenDiaDiem.setText(model.getTenDiaDiem());
        holder.diaDiem.setText(model.getDiaChi());
        holder.gia.setText(model.getGiaThue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {
        ImageView KhamPha;
        TextView tenDiaDiem,gia,diaDiem;


        public ViewHodel(@NonNull View itemView) {
            super(itemView);
            gia = itemView.findViewById(R.id.tvGia);
            diaDiem = itemView.findViewById(R.id.tv_DiaDiem);
            KhamPha = itemView.findViewById(R.id.imgkhampha);
            tenDiaDiem = itemView.findViewById(R.id.tvNameDiaDiem);

        }
    }
}
