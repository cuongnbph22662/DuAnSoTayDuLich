package cuongnbph22662.poly.duansotaydulich.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.activity.danang;
import cuongnbph22662.poly.duansotaydulich.activity.hanam;
import cuongnbph22662.poly.duansotaydulich.activity.hanoi;
import cuongnbph22662.poly.duansotaydulich.activity.hochiminh;
import cuongnbph22662.poly.duansotaydulich.activity.hue;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class ThanhPhoAdapter extends RecyclerView.Adapter<ThanhPhoAdapter.ThanhPhoViewHolder>{
    private Context mContext;
    private List<ThanhPho> listTP = new ArrayList<>();

    public ThanhPhoAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListTP(ArrayList<ThanhPho> list){
        this.listTP = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ThanhPhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,parent,false);

        return new ThanhPhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhPhoViewHolder holder, int position) {
      ThanhPho obj = listTP.get(position);
      if(obj == null){
        return;
      }
        holder.TVthanhpho.setText(obj.getTenThanhPho());
        holder.TVthanhpho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.TVthanhpho.getText().toString().equalsIgnoreCase("Hà Nội")){
                    Intent intent = new Intent(mContext, hanoi.class);
                    mContext.startActivity(intent);
                }else if(holder.TVthanhpho.getText().toString().equalsIgnoreCase("Huế")){
                    Intent intent = new Intent(mContext, hue.class);
                    mContext.startActivity(intent);
                }else if(holder.TVthanhpho.getText().toString().equalsIgnoreCase("Hồ Chí Minh")){
                    Intent intent = new Intent(mContext, hochiminh.class);
                    mContext.startActivity(intent);
                }else if(holder.TVthanhpho.getText().toString().equalsIgnoreCase("Đà Nẵng")){
                    Intent intent = new Intent(mContext, danang.class);
                    mContext.startActivity(intent);
                }else if(holder.TVthanhpho.getText().toString().equalsIgnoreCase("Hà Nam")){
                    Intent intent = new Intent(mContext, hanam.class);
                    mContext.startActivity(intent);
                }

            }
        });
      holder.TVthanhpho.setText(obj.getTenThanhPho());
    }

    @Override
    public int getItemCount() {
        if(listTP != null ){
            return listTP.size();
        }
        return 0;
    }

    public class ThanhPhoViewHolder extends RecyclerView.ViewHolder{
        private TextView TVthanhpho ;
        public ThanhPhoViewHolder(@NonNull View itemView) {
            super(itemView);
            TVthanhpho = itemView.findViewById(R.id.tvThanhPho);
        }
    }
}
