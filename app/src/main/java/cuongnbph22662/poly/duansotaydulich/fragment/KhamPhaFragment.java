package cuongnbph22662.poly.duansotaydulich.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import cuongnbph22662.poly.duansotaydulich.R;

public class KhamPhaFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

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
        tabLayout=view.findViewById(R.id.tab_layout);
        viewPager=view.findViewById(R.id.view_pager);

        // Initialize array list
        ArrayList<String> arrayList=new ArrayList<>(0);

        // Add title in array list
        arrayList.add("Searches");
        arrayList.add("Favourite");
        arrayList.add("Single/Cuple");

        // Setup tab layout
        tabLayout.setupWithViewPager(viewPager);

        // Prepare view pager
        prepareViewPager(viewPager,arrayList);
        Toast.makeText(getActivity(),"update",Toast.LENGTH_LONG).show();

    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        // Initialize main adapter
        MainAdapter adapter=new MainAdapter(getActivity().getSupportFragmentManager());

        // Initialize main fragment
        MainFragment mainFragment=new MainFragment();

        // Use for loop
        for(int i=0;i<arrayList.size();i++)
        {
            // Initialize bundle
            Bundle bundle=new Bundle();

            // Put title
            bundle.putString("title",arrayList.get(i));

            // set argument
            mainFragment.setArguments(bundle);

            // Add fragment
            adapter.addFragment(mainFragment,arrayList.get(i));
            mainFragment=new MainFragment();
        }
        // set adapter
        viewPager.setAdapter(adapter);
    }

    private class MainAdapter extends FragmentPagerAdapter {
        // Initialize arrayList
        ArrayList<Fragment> fragmentArrayList= new ArrayList<>();
        ArrayList<String> stringArrayList=new ArrayList<>();

        int[] imageList={R.drawable.ic_baseline_person_search_24,R.drawable.ic_baseline_favorite_border_24,R.drawable.ic_baseline_people_24};

        // Create constructor
        public void addFragment(Fragment fragment,String s)
        {
            // Add fragment
            fragmentArrayList.add(fragment);
            // Add title
            stringArrayList.add(s);
        }

        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            // return fragment position
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            // Return fragment array list size
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            // Initialize drawable
            Drawable drawable= ContextCompat.getDrawable(getActivity().getApplicationContext()
                    ,imageList[position]);

            // set bound
            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());

            // Initialize spannable image
            SpannableString spannableString=new SpannableString("  "+stringArrayList.get(position));

            // Initialize image span
            ImageSpan imageSpan=new ImageSpan(drawable,ImageSpan.ALIGN_BOTTOM);

            // Set span
            spannableString.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            // return spannable string
            return spannableString;
        }
    }
}