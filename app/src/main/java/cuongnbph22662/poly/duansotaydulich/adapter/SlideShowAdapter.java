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

import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.activity.DiaDiemActivity;
import cuongnbph22662.poly.duansotaydulich.model.itemdiadiem;

public class SlideShowAdapter extends RecyclerView.Adapter<SlideShowAdapter.itemDiaDiemViewHolder>{

    private List<itemdiadiem> mItemdiadiem ;
    private Context context;

    public SlideShowAdapter(List<itemdiadiem> mItemdiadiem, Context context) {
        this.mItemdiadiem = mItemdiadiem;
        this.context = context;
    }

    public void setData(List<itemdiadiem> list){
        this.mItemdiadiem = list ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public itemDiaDiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_show_item,parent,false);
        return new itemDiaDiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemDiaDiemViewHolder holder, int position) {
        itemdiadiem diadiem = mItemdiadiem.get(position);
        if(diadiem == null){
            return;
        }
        holder.imgItem.setBackgroundResource(diadiem.getImg());
        holder.tvTittle.setText(diadiem.getTittle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DiaDiemActivity.class);
                context.startActivity(intent);
            }
        });
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
