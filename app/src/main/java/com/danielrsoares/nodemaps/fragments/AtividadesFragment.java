package com.danielrsoares.nodemaps.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielrsoares.nodemaps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AtividadesFragment extends Fragment {


    public AtividadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atividades, container, false);
    }

}
