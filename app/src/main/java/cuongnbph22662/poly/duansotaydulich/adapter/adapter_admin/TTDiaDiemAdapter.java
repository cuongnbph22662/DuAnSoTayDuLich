package cuongnbph22662.poly.duansotaydulich.adapter.adapter_admin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.DiaDiemAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;

public class TTDiaDiemAdapter extends RecyclerView.Adapter<TTDiaDiemAdapter.DiaiemViewHolder>{
    private Context mContext;
    private List<DiaDiem> listTT = new ArrayList<>();
    private DiaDiemDAO diaDiemDao;

    public TTDiaDiemAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setList(ArrayList<DiaDiem> list){
        this.listTT = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DiaiemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thong_tin_dia_diem, parent, false);
        return new DiaiemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaiemViewHolder holder, int position) {
        DiaDiem obj = listTT.get(position);
        if (listTT == null){
            return;
        }
        diaDiemDao = new DiaDiemDAO(mContext);
        DiaDiem diaDiem = diaDiemDao.getID(String.valueOf(obj.getMaDiaDiem()));
        holder.TTMaDiaDiem.setText(String.valueOf(obj.getMaDiaDiem()));
        holder.TTMaThanhPho.setText(String.valueOf(diaDiem.getMaThanhPho()));
        holder.TTTenDiaDiem.setText(diaDiem.getTenDiaDiem());
        holder.TTGia.setText(String.valueOf(diaDiem.getGiaThue()));
//        holder.TTNoiDung.setText(diaDiem.getNoiDung());
        holder.TTViTri.setText(diaDiem.getViTri());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext.getApplicationContext());
                builder.setTitle("Delete");
                builder.setMessage("Bạn có muốn xóa không?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                       diaDiemDao.delete(String.valueOf(position));
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listTT != null){
            return listTT.size();
        }
        return 0;
    }

    public class DiaiemViewHolder extends RecyclerView.ViewHolder {
        private TextView TTTenDiaDiem,TTMaDiaDiem,TTMaThanhPho,TTViTri,TTNoiDung,TTGia;
        public DiaiemViewHolder(@NonNull View itemView) {
            super(itemView);
            TTTenDiaDiem = itemView.findViewById(R.id.tv_TTTenDiaDiem);
            TTMaDiaDiem = itemView.findViewById(R.id.tv_TTmaDiaDiem);
            TTMaThanhPho = itemView.findViewById(R.id.tv_TTmaThanhPho);
            TTViTri = itemView.findViewById(R.id.tv_TTViTri);
            TTNoiDung = itemView.findViewById(R.id.tv_TTNoiDung);
            TTGia = itemView.findViewById(R.id.tv_TTGia);
        }
    }
}
