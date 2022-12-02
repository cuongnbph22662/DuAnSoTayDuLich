package cuongnbph22662.poly.duansotaydulich;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cuongnbph22662.poly.duansotaydulich.Adapter.ThanhPhoAdapter;
import cuongnbph22662.poly.duansotaydulich.Adapter.itemDiaDiemAdapter;
import cuongnbph22662.poly.duansotaydulich.model.ThanhPho;
import cuongnbph22662.poly.duansotaydulich.model.itemdiadiem;




public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewThanhPho ;
    private List<ThanhPho> thanhPhoList = new ArrayList<>() ;
    private ThanhPhoAdapter thanhPhoAdapter ;

    private RecyclerView recyclerViewitem ;
    private List<itemdiadiem> itemList = new ArrayList<>();
    private itemDiaDiemAdapter mitemDiaDiemAdapter ;

    private RecyclerView recyclerViewitem1 ;
    private RecyclerView recyclerViewitem2 ;


   // ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewThanhPho = findViewById(R.id.recycleviewTopmenu);
        recyclerViewitem = findViewById(R.id.recycleviewItem1);
        recyclerViewitem1 = findViewById(R.id.recycleviewItem2);
        recyclerViewitem2 = findViewById(R.id.recycleviewItem3);

        //Dữ liệu thêm vào
        ThanhPho thanhPho = new ThanhPho(1,"Hà Nội");
        ThanhPho thanhPho1 = new ThanhPho(2,"Huế");
        ThanhPho thanhPho2 = new ThanhPho(3,"Đà Nẵng");
        ThanhPho thanhPho3 = new ThanhPho(4,"Sài Gòn");
        ThanhPho thanhPho4 = new ThanhPho(5,"Vũng Tàu");
        ThanhPho thanhPho5 = new ThanhPho(6,"Hà Nội");
        ThanhPho thanhPho6 = new ThanhPho(7,"Huế");
        ThanhPho thanhPho7 = new ThanhPho(8,"Đà Nẵng");
        ThanhPho thanhPho8 = new ThanhPho(9,"Sài Gòn");
        ThanhPho thanhPho9 = new ThanhPho(10,"Vũng Tàu");
        thanhPhoList.add(thanhPho);
        thanhPhoList.add(thanhPho1);
        thanhPhoList.add(thanhPho2);
        thanhPhoList.add(thanhPho3);
        thanhPhoList.add(thanhPho4);
        thanhPhoList.add(thanhPho5);
        thanhPhoList.add(thanhPho6);
        thanhPhoList.add(thanhPho7);
        thanhPhoList.add(thanhPho8);
        thanhPhoList.add(thanhPho9);

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




        //code
        thanhPhoAdapter = new ThanhPhoAdapter(thanhPhoList);
        LinearLayoutManager LinLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewThanhPho.setLayoutManager(LinLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        recyclerViewThanhPho.addItemDecoration(itemDecoration);
        recyclerViewThanhPho.setAdapter(thanhPhoAdapter);


        mitemDiaDiemAdapter = new itemDiaDiemAdapter(itemList);
        LinearLayoutManager LinLayoutManager1 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewitem.setLayoutManager(LinLayoutManager1);
        RecyclerView.ItemDecoration itemDecoration1 = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        recyclerViewitem.addItemDecoration(itemDecoration1);
        recyclerViewitem.setAdapter(mitemDiaDiemAdapter);



        mitemDiaDiemAdapter = new itemDiaDiemAdapter(itemList);
        LinearLayoutManager LinLayoutManager2 = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerViewitem1.setLayoutManager(LinLayoutManager2);
        RecyclerView.ItemDecoration itemDecoration2 = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerViewitem1.addItemDecoration(itemDecoration2);
        recyclerViewitem1.setAdapter(mitemDiaDiemAdapter);

        mitemDiaDiemAdapter = new itemDiaDiemAdapter(itemList);
        LinearLayoutManager LinLayoutManager3 = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerViewitem2.setLayoutManager(LinLayoutManager3);
        RecyclerView.ItemDecoration itemDecoration3 = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerViewitem2.addItemDecoration(itemDecoration3);
        recyclerViewitem2.setAdapter(mitemDiaDiemAdapter);
    }

    private  void  replaceFrament(Fragment fragment){
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();

    }
}