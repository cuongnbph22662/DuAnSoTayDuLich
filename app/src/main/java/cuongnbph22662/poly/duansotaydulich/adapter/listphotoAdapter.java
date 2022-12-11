package cuongnbph22662.poly.duansotaydulich.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.hinhanh;

public class listphotoAdapter extends ArrayAdapter<hinhanh> {
    public listphotoAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public listphotoAdapter(@NonNull Context context, int resource , List<hinhanh> items) {
        super(context, resource , items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater ;
            inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_donganhactivity,null);
        }

        hinhanh ha = getItem(position);

        if(ha != null){
            //Anh xa
            TextView tvtieude = convertView.findViewById(R.id.tvTieudedong);
            tvtieude.setText(ha.getTieude());

            ImageView imgphoto = convertView.findViewById(R.id.imgdong);
            Bitmap bitmap = BitmapFactory.decodeByteArray(ha.getHinh(), 0 ,ha.getHinh().length);
            imgphoto.setImageBitmap(bitmap);
        }

        return convertView;
    }
}