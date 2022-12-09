package cuongnbph22662.poly.duansotaydulich.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.adapter.AdapterSlide;
import cuongnbph22662.poly.duansotaydulich.adapter.DiaDiemAdapter;
import cuongnbph22662.poly.duansotaydulich.adapter.ThanhPhoAdapter;
import cuongnbph22662.poly.duansotaydulich.dao.DiaDiemDAO;
import cuongnbph22662.poly.duansotaydulich.dao.ThanhPhoDAO;
import cuongnbph22662.poly.duansotaydulich.model.AnhSilde;
import cuongnbph22662.poly.duansotaydulich.model.DepthPageTransformer;
import cuongnbph22662.poly.duansotaydulich.model.DiaDiem;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;
import me.relex.circleindicator.CircleIndicator3;

public class HomeFragment extends Fragment {
    private ViewPager2 slideShow;
    private CircleIndicator3 chuyenSlide;
    private RecyclerView itemDiaDiem, itemThanhPho ;
    private ArrayList<ThanhPho> listTP = new ArrayList<>();
    private ArrayList<DiaDiem> listDD = new ArrayList<>();
    private ArrayList<AnhSilde> listSlide = new ArrayList<>();
    private ThanhPhoAdapter thanhPhoAdapter ;
    private DiaDiemAdapter diaDiemAdapter;
    static ThanhPhoDAO theLoaiDAO;
    static DiaDiemDAO diaDiemDAO;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (slideShow.getCurrentItem() == listSlide.size() - 1) {
                slideShow.setCurrentItem(0);
            } else {
                slideShow.setCurrentItem(slideShow.getCurrentItem() + 1);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //anhXa
        anhXa(view);
        // khởi chạy database
        theLoaiDAO = new ThanhPhoDAO(getActivity());
        diaDiemDAO = new DiaDiemDAO(getActivity());
        //code
        Slide();
        loadDataThanhPho();
        loadDataDiaDiem();

        return view;
    }

    private void loadDataDiaDiem() {
        listDD.clear();
        listDD = (ArrayList<DiaDiem>) diaDiemDAO.getAll();
        diaDiemAdapter = new DiaDiemAdapter(getActivity());
        diaDiemAdapter.setListDD(listDD);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
        itemDiaDiem.setLayoutManager(LinLayoutManager);
        itemDiaDiem.setAdapter(diaDiemAdapter);
    }

    private void Slide() {
        listSlide = getListAnh();
        AdapterSlide adapterSlide = new AdapterSlide(listSlide);
        slideShow.setAdapter(adapterSlide);

        chuyenSlide.setViewPager(slideShow);

        slideShow.setPageTransformer(new DepthPageTransformer());
        // auto chạy sau 5s
        slideShow.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 5000);
            }
        });
    }

    private void loadDataThanhPho() {
        listTP.clear();
        listTP = (ArrayList<ThanhPho>) theLoaiDAO.getAll();
        thanhPhoAdapter = new ThanhPhoAdapter(getActivity());
        thanhPhoAdapter.setListTP(listTP);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false);
        itemThanhPho.setLayoutManager(LinLayoutManager);
        itemThanhPho.setAdapter(thanhPhoAdapter);
    }

    private ArrayList<AnhSilde> getListAnh(){
        ArrayList<AnhSilde>list = new ArrayList<>();
        list.add(new AnhSilde(R.drawable.anh_bo_song_han));
        list.add(new AnhSilde(R.drawable.anh_cau_anh_sao));
        list.add(new AnhSilde(R.drawable.anh_cau_vang_da_nang));
        list.add(new AnhSilde(R.drawable.anh_den_hung));
        list.add(new AnhSilde(R.drawable.anh_dao_phu_quoc));
        list.add(new AnhSilde(R.drawable.anh_ho_hoan_kiem));
        list.add(new AnhSilde(R.drawable.anh_lang_bac));
        list.add(new AnhSilde(R.drawable.anh_lich_dao_co_to));
        list.add(new AnhSilde(R.drawable.anh_moc_chau));
        list.add(new AnhSilde(R.drawable.anh_vuon_quoc_gia_ba_vi));
        return list;
    }

    private void anhXa(View view) {
        slideShow = view.findViewById(R.id.id_SlideShow);
        chuyenSlide = view.findViewById(R.id.id_chuyenSlide);
        itemThanhPho = view.findViewById(R.id.recycleviewTopmenu);
        itemDiaDiem = view.findViewById(R.id.id_ItemDiaDiem);
    }

}