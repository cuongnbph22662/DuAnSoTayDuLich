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

public class DiaDiemAdapter extends RecyclerView.Adapter<DiaDiemAdapter.DiaDiemViewHolder>{
    private Context mContext;
    private List<DiaDiem> listDD = new ArrayList<>();

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

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DiaDiemViewHolder extends RecyclerView.ViewHolder{
        private TextView TVthanhpho ;
        public DiaDiemViewHolder(@NonNull View itemView) {
            super(itemView);
            TVthanhpho = itemView.findViewById(R.id.tvThanhPho);
        }
    }
}
