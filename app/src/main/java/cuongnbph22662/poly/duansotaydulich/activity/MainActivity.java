package cuongnbph22662.poly.duansotaydulich.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.fragment.HoSoFragment;
import cuongnbph22662.poly.duansotaydulich.fragment.HomeFragment;
import cuongnbph22662.poly.duansotaydulich.fragment.TimKiemFragment;
import cuongnbph22662.poly.duansotaydulich.fragment.LichFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        khoiDongManChao();
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        replaceFrament(new HomeFragment());
        activityMainBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFrament(new HomeFragment());
                    break;
                case R.id.navigation_calendar:
                    replaceFrament(new LichFragment());
                    break;
                case R.id.navigation_search:
                    replaceFrament(new TimKiemFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFrament(new HoSoFragment());
                    break;
            }
            return true;
        });

    }

    private void khoiDongManChao() {

    }


    private  void  replaceFrament(Fragment fragment){
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();

    }

    public void Exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_thoat, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();

        Button btnHuy = view.findViewById(R.id.btn_dialog_Huy);
        Button btnOut = view.findViewById(R.id.btn_dialog_Thoat);

        btnOut.setOnClickListener(v -> {
            alertDialog.dismiss();
            System.exit(0);

        });

        btnHuy.setOnClickListener(v -> alertDialog.dismiss());
    }

    @Override
    public void onBackPressed() {
        Exit();
    }
}