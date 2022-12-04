package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121.Adapter.TramXeAdapter;
import com.example.pro1121.Adapter.VeXeAdapter;
import com.example.pro1121.R;
import com.example.pro1121.model.TramXe;
import com.example.pro1121.model.VeXe;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VeXeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VeXeFragment extends Fragment  {


    private ArrayList<VeXe> veXes;
    private ListView lvFrgVeXe;

    public VeXeFragment() {
        // Required empty public constructor
    }



    public static VeXeFragment newInstance(ArrayList<VeXe> veXes) {


        VeXeFragment fragment = new VeXeFragment();
        Bundle args = new Bundle();
        args.putSerializable("vexe", veXes);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            veXes = (ArrayList<VeXe>) getArguments().getSerializable("vexe");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chuyen_xe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvFrgVeXe=view.findViewById(R.id.lvFrgChuyenXe);

        VeXeAdapter adapter = new VeXeAdapter(veXes,getContext());
        lvFrgVeXe.setAdapter(adapter);
        lvFrgVeXe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                VeXe tramXe=(VeXe) parent.getItemAtPosition(position);
                // truyen ra activyti
//                ChuyenXeActivity activity= (ChuyenXeActivity) view.getContext();
//                activity.onCoursesItemClick(course);
                return true;
            }
        });
    }
}