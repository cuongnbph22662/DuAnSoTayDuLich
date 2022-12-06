package cuongnbph22662.poly.duansotaydulich.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.PhieuDuLich;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.UserViewHolder> implements Filterable {
    private List<PhieuDuLich> mPhieuDuLichList;
    private List<PhieuDuLich> mPhieuDuLichListOld;

    public TimKiemAdapter(List<PhieuDuLich> mPhieuDuLichList) {
        this.mPhieuDuLichList = mPhieuDuLichList;
        this.mPhieuDuLichListOld = mPhieuDuLichList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kham_pha_item,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        PhieuDuLich phieuDuLich = mPhieuDuLichList.get(position);
        if (phieuDuLich == null){
            return;
        }
        holder.imageView.setImageResource(R.drawable.dalat);
        holder.DiaDiem.setText(phieuDuLich.getDiaChi());
        holder.Gia.setText(phieuDuLich.getGiaThue());
        holder.TenDiaDiem.setText(phieuDuLich.getTenDiaDiem());
    }

    @Override
    public int getItemCount() {
        if (mPhieuDuLichList != null){
            return mPhieuDuLichList.size();
        }
        return 0;
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView DiaDiem,Gia,TenDiaDiem;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgkhampha);
            DiaDiem = itemView.findViewById(R.id.tv_DiaDiem);
            Gia = itemView.findViewById(R.id.tvGia);
            TenDiaDiem = itemView.findViewById(R.id.tvNameDiaDiem);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if(strSearch.isEmpty()){
                    mPhieuDuLichList = mPhieuDuLichListOld;
                }else {
                    List<PhieuDuLich> list = new ArrayList<>();
                    for (PhieuDuLich phieuDuLich : mPhieuDuLichListOld){
                        if (phieuDuLich.getTenDiaDiem().toLowerCase(Locale.ROOT).contains(strSearch.toLowerCase(Locale.ROOT))){
                            list.add(phieuDuLich);
                        }
                    }
                    mPhieuDuLichList = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mPhieuDuLichList;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mPhieuDuLichList = (List<PhieuDuLich>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
