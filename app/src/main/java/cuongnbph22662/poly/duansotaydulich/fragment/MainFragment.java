package cuongnbph22662.poly.duansotaydulich.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cuongnbph22662.poly.duansotaydulich.R;



public class MainFragment extends Fragment {
    TextView textView;



    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_main, container, false);

        // Assign variable
        textView=view.findViewById(R.id.text_view);

        // Get Title
        String sTitle=getArguments().getString("title");

        // Set title on text view
        textView.setText(sTitle);

        // return view
        return view;
    }
}