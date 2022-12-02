package cuongnbph22662.poly.duansotaydulich.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class ThanhPhoAdapter extends RecyclerView.Adapter<ThanhPhoAdapter.ThanhPhoViewHolder>{
    private List<ThanhPho> mythanhPhoList ;

    public ThanhPhoAdapter(List<ThanhPho> mythanhPhoList) {
        this.mythanhPhoList = mythanhPhoList;
    }

    @NonNull
    @Override
    public ThanhPhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtopmenu,parent,false);

        return new ThanhPhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhPhoViewHolder holder, int position) {
      ThanhPho thanhPho = mythanhPhoList.get(position);
      if(thanhPho == null){
        return;
      }
      holder.TVthanhpho.setText(thanhPho.getTenTP());
    }

    @Override
    public int getItemCount() {
        if(mythanhPhoList != null ){
            return mythanhPhoList.size();
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
