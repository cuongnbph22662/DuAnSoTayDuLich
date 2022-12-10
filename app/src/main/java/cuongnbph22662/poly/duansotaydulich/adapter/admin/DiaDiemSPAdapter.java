package cuongnbph22662.poly.duansotaydulich.adapter.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;

public class DiaDiemSPAdapter extends ArrayAdapter<ThanhPho> {
    Context context;
    ArrayList<ThanhPho> list;
    TextView tvMaThanhPhoSp,tvTenThanhPho;

    public DiaDiemSPAdapter(@NonNull Context context, ArrayList<ThanhPho> list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_dia_diem_spiner,null);
        }
        final ThanhPho item = list.get(position);
        if (item != null){
            tvMaThanhPhoSp = view.findViewById(R.id.tvMaThanhPhoSP);
            tvTenThanhPho = view.findViewById(R.id.tvTenThanhPhoSP);
            tvMaThanhPhoSp.setText(item.getMaThanhPho()+".");
            tvTenThanhPho.setText(item.getTenThanhPho());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_dia_diem_spiner,null);
        }
        final ThanhPho item = list.get(position);
        if (item != null){
            tvMaThanhPhoSp = view.findViewById(R.id.tvMaThanhPhoSP);
            tvTenThanhPho = view.findViewById(R.id.tvTenThanhPhoSP);
            tvMaThanhPhoSp.setText(item.getMaThanhPho()+".");
            tvTenThanhPho.setText(item.getTenThanhPho());
        }
        return view;
    }
}
