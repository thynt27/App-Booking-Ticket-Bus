package com.example.pro1121.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121.R;
import com.example.pro1121.news.TinTucActivity;
import com.example.pro1121.view.MainActivity;
import com.example.pro1121.view.TimChuyenActivity;

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

        

        return view;
    }
}
