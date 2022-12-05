package com.example.pro1121.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pro1121.R;
import com.example.pro1121.model.LichSuVeXe;
import com.example.pro1121.model.TramXe;
import com.example.pro1121.model.VeXE;


import java.util.ArrayList;

public class VeXeAdapter extends BaseAdapter {
    private ArrayList<LichSuVeXe> list;
    private Context context;

    public VeXeAdapter(ArrayList<LichSuVeXe> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view = _view;
        if (view == null) {
            view = View.inflate(_viewGroup.getContext(), R.layout.item_recycler_vexe, null);
            TextView diemDi = view.findViewById(R.id.txtDiemDi);
            TextView diemDen = view.findViewById(R.id.txtDiemDen);
            TextView gia = view.findViewById(R.id.txtGiaVe);
            TextView gioChuyenDi = view.findViewById(R.id.txtGioChuyenDi);
            TextView gioDat = view.findViewById(R.id.txtGioDat);
            TextView soLuongDat = view.findViewById(R.id.txtSoLuongCho);
            TextView soXE = view.findViewById(R.id.txtSoXe);
            TextView viTriGhe = view.findViewById(R.id.txtViTriGhe);
            Button btnHuyVe = view.findViewById(R.id.btnHuyVe);

            ViewHolder holder = new ViewHolder(diemDi,diemDen,gia,gioChuyenDi,gioDat,soLuongDat,soXE,viTriGhe,btnHuyVe);
            view.setTag(holder);



        }
        LichSuVeXe veXe = (LichSuVeXe) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.diemDen.setText("Điểm đến: "+veXe.getDiemDen());
        holder.diemDi.setText("Điểm đi: "+veXe.getDiemDi());
        holder.gia.setText(veXe.getGia());
        holder.gioChuyenDi.setText(veXe.getGioChuyenDi());
        holder.gioDat.setText(veXe.getGioDatVe());
        holder.soLuongDat.setText("Số chỗ: "+veXe.getSoLuongChoDat());
        holder.soXe.setText("Biển số xe: "+veXe.getSoXe());
        holder.viTriGhe.setText("Vị trí: "+veXe.getViTriGhe());


        holder.huyVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IAdapterClickEvent2 iAdapterClickEvent = (IAdapterClickEvent2) _viewGroup.getContext();
                iAdapterClickEvent.onDeleteVeXeClick(veXe);
            }
        });



        return view;
    }
    private static class ViewHolder{

        final TextView diemDi,diemDen,gia,gioChuyenDi,gioDat,soLuongDat,soXe,viTriGhe;
        final Button huyVe;

        public ViewHolder(TextView diemDi, TextView diemDen, TextView gia, TextView gioChuyenDi, TextView gioDat, TextView soLuongDat, TextView soXe, TextView viTriGhe,Button huyVe) {
            this.diemDi = diemDi;
            this.diemDen = diemDen;
            this.gia = gia;
            this.gioChuyenDi = gioChuyenDi;
            this.gioDat = gioDat;
            this.soLuongDat = soLuongDat;
            this.soXe = soXe;
            this.viTriGhe = viTriGhe;
            this.huyVe=huyVe;
        }
    }

}
