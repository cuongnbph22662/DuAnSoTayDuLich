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
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.TimKiemViewHolder>{
    private Context mContext;
    private List<DiaDiem> listDD = new ArrayList<>();

    public TimKiemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListTK(ArrayList<DiaDiem> list){
        this.listDD = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TimKiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dia_diem_item, parent, false);

        return new TimKiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimKiemViewHolder holder, int position) {
        DiaDiem obj = listDD.get(position);
        if(obj == null){
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class TimKiemViewHolder extends RecyclerView.ViewHolder{
        private TextView TVthanhpho ;
        public TimKiemViewHolder(@NonNull View itemView) {
            super(itemView);
            TVthanhpho = itemView.findViewById(R.id.tvThanhPho);
        }
    }
}
