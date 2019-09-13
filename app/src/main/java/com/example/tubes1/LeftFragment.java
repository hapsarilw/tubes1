package com.example.tubes1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.tubes1.R.layout.list_nav_drawer;


public class LeftFragment extends Fragment {
    ListView lst_nav;
    FragmentManager fragmentManager;
    Adapter adapter;


    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        this.lst_nav = view.findViewById(R.id.lst_menu);

        String[] navigation = {"HOME", "ADD OPERATION", "HISTORY"};
        this.lst_nav.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, navigation));
        this.fragmentManager = getFragmentManager();
        lst_nav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id3) {
                final String scale = adapter.getItem(position).toString();
                // scale is gonna be "Centimeters" or "Meters", etc...
                if (scale.equals("HOME")) {

                } else if (scale.equals("Meters")) {
                    // do something else
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });




        return view;
    }



}
