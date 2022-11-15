package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121.R;

public class TrangChuFragment extends Fragment {
    ImageView imgSearchBusinMain,imgMapBusinMain,imgHistoryBusinMain,imgProfileinMain,imgNewsinMain,imgExitinMain;
    Fragment fragment = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragmnet_trangchu, container, false);

        imgSearchBusinMain = view.findViewById(R.id.imgSearchBusinMain);
        imgMapBusinMain = view.findViewById(R.id.imgMapBusinMain);
        imgHistoryBusinMain = view.findViewById(R.id.imgHistoryBusinMain);
        imgProfileinMain = view.findViewById(R.id.imgProfileinMain);
        imgNewsinMain = view.findViewById(R.id.imgNewsinMain);
        imgExitinMain = view.findViewById(R.id.imgExitinMain);


        imgSearchBusinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new DatVeFragment();
            }
        });

        imgMapBusinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new TramXeFragment();
            }
        });

        imgHistoryBusinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragment = new HistoryFragment();
            }
        });

        imgProfileinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragment = new FragmentProfile();
            }
        });

        imgNewsinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragment = new FragmentNews();
            }
        });

        imgExitinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return view;
    }
}
