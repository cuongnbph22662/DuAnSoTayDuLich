package cuongnbph22662.poly.duansotaydulich.fragment;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.TimKiemAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.PhieuDuLichDAO;
import cuongnbph22662.poly.duansotaydulich.model.PhieuDuLich;

public class TimKiemFragment extends Fragment {
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private PhieuDuLichDAO phieuDuLichDAO;
    private SearchView searchView;
    private TimKiemAdapter timKiemAdapter;
    private ArrayList<PhieuDuLich> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kham_pha, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            recyclerView = view.findViewById(R.id.recyclerView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            searchView = new SearchView(getContext());
            timKiemAdapter = new TimKiemAdapter(getListUser());
            recyclerView.setAdapter(timKiemAdapter);
            RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(itemDecoration);

            searchView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

    }

    private List<PhieuDuLich> getListUser() {
        List<PhieuDuLich> list = new ArrayList<>();
            
           searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                timKiemAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                timKiemAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return list;
    }

}