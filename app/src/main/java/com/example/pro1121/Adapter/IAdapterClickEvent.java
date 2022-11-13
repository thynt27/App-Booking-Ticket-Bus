package com.example.pro1121.Adapter;

import android.content.Context;

import com.example.pro1121.mode.ChuyenXE;

public interface IAdapterClickEvent {
    public void onEditChuyenXeClick(ChuyenXE chuyenxe);
    public  void onDeleteChuyenXeClick(ChuyenXE chuyenXE);
    public void onDatXeClick();
}
