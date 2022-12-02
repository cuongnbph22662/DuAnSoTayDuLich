package cuongnbph22662.poly.duansotaydulich.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;
import cuongnbph22662.poly.duansotaydulich.model.itemdiadiem;

public class itemDiaDiemAdapter extends RecyclerView.Adapter<itemDiaDiemAdapter.itemDiaDiemViewHolder>{

    private List<itemdiadiem> mItemdiadiem ;

    public itemDiaDiemAdapter(List<itemdiadiem> mItemdiadiem) {
        this.mItemdiadiem = mItemdiadiem;
    }

    public void setData(List<itemdiadiem> list){
        this.mItemdiadiem = list ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public itemDiaDiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistitem1,parent,false);
        return new itemDiaDiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemDiaDiemViewHolder holder, int position) {
        itemdiadiem diadiem = mItemdiadiem.get(position);
        if(diadiem == null){
            return;
        }
        holder.imgItem.setImageResource(diadiem.getImg());
        holder.tvTittle.setText(diadiem.getTittle());
    }

    @Override
    public int getItemCount() {
        if(mItemdiadiem != null ){
            return mItemdiadiem.size();
        }
        return 0;
    }

    public class itemDiaDiemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem ;
        private TextView tvTittle ;


        public itemDiaDiemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgitem);
            tvTittle = itemView.findViewById(R.id.tvtendiadiem);
        }
    }

}
