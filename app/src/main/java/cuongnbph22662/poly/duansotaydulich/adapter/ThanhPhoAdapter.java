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
import cuongnbph22662.poly.duansotaydulich.activity.ThanhPhoActivity;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ThanhPhoActivity.class);
                intent.putExtra("mathanhpho", String.valueOf(obj.getMaThanhPho()));
                mContext.startActivity(intent);
            }
        });
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
