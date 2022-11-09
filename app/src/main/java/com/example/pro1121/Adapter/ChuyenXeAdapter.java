package com.example.pro1121.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pro1121.R;
import com.example.pro1121.mode.ChuyenXE;

import java.util.ArrayList;

public class ChuyenXeAdapter extends BaseAdapter {
    private ArrayList<ChuyenXE> list;

    public ChuyenXeAdapter(ArrayList<ChuyenXE> list) {
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
            view = View.inflate(_viewGroup.getContext(), R.layout.one_item_chuyenxe, null);
            TextView chuyenxeDiemdi = view.findViewById(R.id.chuyenxeDiemdi);
            TextView chuyenxeDiemden = view.findViewById(R.id.chuyenxeDiemden);
            TextView chuyenxeGio = view.findViewById(R.id.chuyenxeGio);
            TextView chuyenxeSoxe = view.findViewById(R.id.chuyenxeSoxe);
            ImageButton btnedit = view.findViewById(R.id.btnedit);
            ImageButton btndelete = view.findViewById(R.id.btndelete);
            ViewHolder holder = new ViewHolder(chuyenxeDiemdi, chuyenxeDiemden, chuyenxeGio, chuyenxeSoxe, btnedit, btndelete);
            view.setTag(holder);
        }
        ChuyenXE chuyenXE = (ChuyenXE) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.chuyenxeDiemdi.setText((chuyenXE.getDiemdi()));
        holder.chuyenxeDiemden.setText((chuyenXE.getDiemden()));
        holder.chuyenxeGio.setText((chuyenXE.getGio()));
        holder.chuyenxeSoxe.setText((chuyenXE.getSoxe()));
        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IAdapterClickEvent iAdapterClickEvent = (IAdapterClickEvent) _viewGroup.getContext();
                iAdapterClickEvent.onEditChuyenXeClick(chuyenXE);

            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IAdapterClickEvent iAdapterClickEvent = (IAdapterClickEvent) _viewGroup.getContext();
                iAdapterClickEvent.onDeleteChuyenXeClick(chuyenXE);
            }
        });
        return view;
    }
    private static class ViewHolder{
        final TextView chuyenxeDiemdi,chuyenxeDiemden,chuyenxeGio,chuyenxeSoxe;
        final ImageButton btnedit,btndelete;

        public ViewHolder(TextView chuyenxeDiemdi, TextView chuyenxeDiemden, TextView chuyenxeGio, TextView chuyenxeSoxe,ImageButton btnedit,ImageButton btndelete) {
            this.chuyenxeDiemdi = chuyenxeDiemdi;
            this.chuyenxeDiemden = chuyenxeDiemden;
            this.chuyenxeGio = chuyenxeGio;
            this.chuyenxeSoxe = chuyenxeSoxe;
            this.btnedit = btnedit;
            this.btndelete = btndelete;
        }
    }

}
