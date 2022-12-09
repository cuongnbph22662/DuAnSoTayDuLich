package cuongnbph22662.poly.duansotaydulich.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.adapter.ThanhPhoAdapter;
import cuongnbph22662.poly.duansotaydulich.adapter.SlideShowAdapter;
import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.dao.PhieuDuLichDAO;
import cuongnbph22662.poly.duansotaydulich.dao.TheLoaiDAO;
import cuongnbph22662.poly.duansotaydulich.model.PhieuDuLich;
import cuongnbph22662.poly.duansotaydulich.model.TheLoai;
import cuongnbph22662.poly.duansotaydulich.model.itemdiadiem;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerViewThanhPho ;
    private ArrayList<TheLoai> listTP = new ArrayList<>() ;
    private ThanhPhoAdapter thanhPhoAdapter ;
    static TheLoaiDAO theLoaiDAO;

    private List<itemdiadiem> itemList = new ArrayList<>();
    private SlideShowAdapter mitemDiaDiemAdapter ;

    private RecyclerView recyclerViewitem ;
    private RecyclerView recyclerViewitem1 ;
    private RecyclerView recyclerViewitem2 ;
    private ArrayList<PhieuDuLich> listPhieuDL = new ArrayList<>();
    static PhieuDuLichDAO phieuDuLichDAO;
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
        theLoaiDAO = new TheLoaiDAO(getActivity());
        phieuDuLichDAO = new PhieuDuLichDAO(getActivity());
        //Dữ liệu thêm vào
        createDuLieu();
        //code
//        loadDataThanhPho();


        mitemDiaDiemAdapter = new SlideShowAdapter(itemList, getContext());
        LinearLayoutManager LinLayoutManager1 = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerViewitem.setLayoutManager(LinLayoutManager1);
        RecyclerView.ItemDecoration itemDecoration1 = new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL);
        recyclerViewitem.addItemDecoration(itemDecoration1);
        recyclerViewitem.setAdapter(mitemDiaDiemAdapter);


        mitemDiaDiemAdapter = new SlideShowAdapter(itemList, getContext());
        LinearLayoutManager LinLayoutManager2 = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerViewitem1.setLayoutManager(LinLayoutManager2);
        RecyclerView.ItemDecoration itemDecoration2 = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        recyclerViewitem1.addItemDecoration(itemDecoration2);
        recyclerViewitem1.setAdapter(mitemDiaDiemAdapter);

        mitemDiaDiemAdapter = new SlideShowAdapter(itemList, getContext());
        LinearLayoutManager LinLayoutManager3 = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerViewitem2.setLayoutManager(LinLayoutManager3);
        RecyclerView.ItemDecoration itemDecoration3 = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        recyclerViewitem2.addItemDecoration(itemDecoration3);
        recyclerViewitem2.setAdapter(mitemDiaDiemAdapter);


        return view;
    }

    private void anhXa(View view) {
        recyclerViewThanhPho = view.findViewById(R.id.recycleviewTopmenu);
        recyclerViewitem = view.findViewById(R.id.recycleviewItem1);
        recyclerViewitem1 = view.findViewById(R.id.recycleviewItem2);
        recyclerViewitem2 = view.findViewById(R.id.recycleviewItem3);
    }

    private void loadDataThanhPho() {
        listTP.clear();
        listTP = (ArrayList<TheLoai>) theLoaiDAO.getAll();
        thanhPhoAdapter = new ThanhPhoAdapter(getActivity());
        thanhPhoAdapter.setListTP(listTP);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false);
        recyclerViewThanhPho.setLayoutManager(LinLayoutManager);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL);
//        recyclerViewThanhPho.addItemDecoration(itemDecoration);
        recyclerViewThanhPho.setAdapter(thanhPhoAdapter);
    }

    private void createDuLieu() {

        itemdiadiem itemdiadiem = new itemdiadiem(R.drawable.img1,"Nhứ đb");
        itemdiadiem itemdiadiem1 = new itemdiadiem(R.drawable.img2,"Nhứ đb");
        itemdiadiem itemdiadiem2 = new itemdiadiem(R.drawable.img3,"Nhứ đb");
        itemdiadiem itemdiadiem3 = new itemdiadiem(R.drawable.img2,"Nhứ đb");
        itemdiadiem itemdiadiem4 = new itemdiadiem(R.drawable.img1,"Nhứ đb");
        itemList.add(itemdiadiem);
        itemList.add(itemdiadiem1);
        itemList.add(itemdiadiem2);
        itemList.add(itemdiadiem3);
        itemList.add(itemdiadiem4);
    }

}