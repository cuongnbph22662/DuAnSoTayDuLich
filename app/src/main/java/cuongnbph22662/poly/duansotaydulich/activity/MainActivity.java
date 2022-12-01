package cuongnbph22662.poly.duansotaydulich.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import cuongnbph22662.poly.duansotaydulich.R;
import cuongnbph22662.poly.duansotaydulich.databinding.ActivityMainBinding;
import cuongnbph22662.poly.duansotaydulich.fragment.CaNhanFragment;
import cuongnbph22662.poly.duansotaydulich.fragment.HomeFragment;
import cuongnbph22662.poly.duansotaydulich.fragment.KhamPhaFragment;
import cuongnbph22662.poly.duansotaydulich.fragment.LichFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        replaceFrament(new HomeFragment());
        activityMainBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    replaceFrament(new HomeFragment());
                    break;
                case R.id.navigation_calendar:
                    replaceFrament(new LichFragment());
                    break;
                case R.id.navigation_search:
                    replaceFrament(new KhamPhaFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFrament(new CaNhanFragment());
                    break;
            }
            return true;
        });
    }
    private  void  replaceFrament(Fragment fragment){
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();

    }
}