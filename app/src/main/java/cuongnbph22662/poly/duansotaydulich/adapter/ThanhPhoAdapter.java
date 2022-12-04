package cuongnbph22662.poly.duansotaydulich.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.TheLoai;

public class ThanhPhoAdapter extends RecyclerView.Adapter<ThanhPhoAdapter.ThanhPhoViewHolder>{
    private Context mContext;
    private List<TheLoai> listTP = new ArrayList<>();

    public ThanhPhoAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListTP(ArrayList<TheLoai> list){
        this.listTP = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ThanhPhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtopmenu,parent,false);

        return new ThanhPhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhPhoViewHolder holder, int position) {
      TheLoai obj = listTP.get(position);
      if(obj == null){
        return;
      }
      holder.TVthanhpho.setText(obj.getTenTheLoai());
    }

    @Override
    public int getItemCount() {
        if(listTP != null ){
            return listTP.size();
        }
        return 0;
    }

    class ThanhPhoViewHolder extends RecyclerView.ViewHolder{
        private TextView TVthanhpho ;
        public ThanhPhoViewHolder(@NonNull View itemView) {
            super(itemView);
            TVthanhpho = itemView.findViewById(R.id.tvThanhPho);
        }
    }
}
