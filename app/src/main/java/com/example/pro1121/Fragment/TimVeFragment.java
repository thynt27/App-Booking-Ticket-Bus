package com.example.pro1121.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pro1121.Adapter.IAdapterClickEvent2;
import com.example.pro1121.R;
import com.example.pro1121.model.ChuyenXE;
import com.example.pro1121.model.TramXe;
import com.example.pro1121.model.VeXe;
import com.example.pro1121.view.ChuyenXeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimVeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimVeFragment extends Fragment implements IAdapterClickEvent2 {
    private ArrayList<VeXe> veXes;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private VeXe veXe=null;

    public TimVeFragment() {
        // Required empty public constructor
    }


    public static TimVeFragment newInstance(ArrayList<VeXe> veXes) {
        TimVeFragment fragment = new TimVeFragment();
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
        getData();
        return inflater.inflate(R.layout.fragment_tim_ve, container, false);

    }
    @Override
    public void onResume() {
        super.onResume();
        getData();
    }
    private void getData()
    {
        db.collection("vexelichsu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<VeXe> list= new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> map = document.getData();
                                String diemDen = map.get("diemden").toString();
                                String diemDi = map.get("diemdi").toString();
                                String gia = map.get("gia").toString();
                                String gioChuyenDi = map.get("giochuyendi").toString();
                                String giodat = map.get("giodat").toString();
                                String soluongcho = map.get("soluongdat").toString();
                                String soxe = map.get("soxe").toString();
                                String viTriGhe = map.get("vitrive").toString();

                                VeXe veXe = new VeXe(document.getId(),diemDen,diemDi,gia,gioChuyenDi,giodat,soluongcho,soxe,viTriGhe);
                                veXe.setIdVeXe(document.getId());
                                list.add(veXe);

                            }
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.frltimve, VeXeFragment.newInstance(list)).commit();
                        }
                    }

                });
    }
    @Override
    public void onDeleteVeXeClick(VeXe veXe) {
        new AlertDialog.Builder(getContext())
                .setTitle("Xóa")
                .setMessage("Xóa sẽ không phục hồi đc")
                .setNegativeButton("Hủy",null)
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.collection("vexelichsu").document(veXe.getIdVeXe())
                                .delete()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                                        getData();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getContext(), "Xóa không thành công", Toast.LENGTH_SHORT).show();

                                    }
                                });

                    }
                })
                .show();

    }
}