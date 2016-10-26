package com.hue.husc.it.nhuquynh.quanlynv.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;
import com.hue.husc.it.nhuquynh.quanlynv.R;

import java.util.List;

/**
 * Created by dell on 2016-10-26.
 */

public class Custom_Spinner_ThemNhanvien extends ArrayAdapter<PhongBanDTO>{
    Context context;
    int resource;
    List<PhongBanDTO> objects;

    public Custom_Spinner_ThemNhanvien(Context context, int resource, List<PhongBanDTO> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewrow =inflater.inflate(R.layout.custom_layout_spinner,parent,false);
        TextView vTenPhongBan= (TextView) viewrow.findViewById(R.id.vSpinnerPhongBan);

        PhongBanDTO phongban=objects.get(position);
        vTenPhongBan.setText(phongban.getTenPhongBan());
        return viewrow;
    }
}
