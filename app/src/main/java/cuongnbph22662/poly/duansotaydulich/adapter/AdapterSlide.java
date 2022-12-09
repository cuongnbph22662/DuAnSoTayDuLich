package cuongnbph22662.poly.duansotaydulich.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.model.AnhSilde;

public class AdapterSlide extends RecyclerView.Adapter<AdapterSlide.PhotoViewHolder> {
    private final ArrayList<AnhSilde> list;

    public AdapterSlide(ArrayList<AnhSilde> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slide, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        AnhSilde photo = list.get(position);
        if (photo == null) {
            return;
        }
        holder.imageView.setBackgroundResource(photo.getAnh());

    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgPhoto);
        }
    }
}
