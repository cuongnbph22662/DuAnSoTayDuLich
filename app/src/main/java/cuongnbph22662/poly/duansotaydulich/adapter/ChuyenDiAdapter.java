package cuongnbph22662.poly.duansotaydulich.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.model.ChuyenDi;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;

public class ChuyenDiAdapter extends RecyclerView.Adapter<ChuyenDiAdapter.ChuyenDiViewHolder>{
    private Context mContext;
    private List<ChuyenDi> listCD = new ArrayList<>();
    DiaDiemDAO diaDiemDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ChuyenDiAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setListCD(ArrayList<ChuyenDi> list){
        this.listCD = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChuyenDiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chuyen_di_item, parent, false);
        return new ChuyenDiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuyenDiViewHolder holder, int position) {
        ChuyenDi obj = listCD.get(position);
        if(obj == null){
            return;
        }
        diaDiemDAO = new DiaDiemDAO(mContext);
        DiaDiem diaDiem = diaDiemDAO.getID(String.valueOf(obj.getMaDiaDiem()));
        holder.soNguoi.setText("Số người: "+obj.getSoLuongNguoi());
        holder.ngayDi.setText("Ngày đi: "+sdf.format(obj.getNgayDat()));
        holder.tongTien.setText("Tổng tiên: "+obj.getTienThue());
        holder.tenChuyenDi.setText("Tên địa điểm: "+diaDiem.getTenDiaDiem());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if(listCD != null)
            return listCD.size();
        return 0;
    }

    public class ChuyenDiViewHolder extends RecyclerView.ViewHolder{
        private TextView tenChuyenDi, tongTien, ngayDi, soNguoi ;
        public ChuyenDiViewHolder(@NonNull View itemView) {
            super(itemView);
            tenChuyenDi = itemView.findViewById(R.id.tv_cdTenDiaDiem);
            tongTien = itemView.findViewById(R.id.tv_cdTongTien);
            ngayDi = itemView.findViewById(R.id.tv_cdNgayDi);
            soNguoi = itemView.findViewById(R.id.tv_cdSoNguoiDi);
        }
    }
}
