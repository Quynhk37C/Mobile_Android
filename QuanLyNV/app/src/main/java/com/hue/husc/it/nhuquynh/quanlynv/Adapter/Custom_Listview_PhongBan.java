package com.hue.husc.it.nhuquynh.quanlynv.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;
import com.hue.husc.it.nhuquynh.quanlynv.R;

import java.util.List;

/**
 * Created by dell on 2016-10-25.
 */

public class Custom_Listview_PhongBan extends ArrayAdapter<PhongBanDTO> {
    Context context;
    int resource;
    List<PhongBanDTO> objects;
    public Custom_Listview_PhongBan(Context context, int resource, List<PhongBanDTO> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewrow =inflater.inflate(R.layout.custom_listview_phongban,parent,false);


        TextView vTenPhongBan= (TextView) viewrow.findViewById(R.id.ViewListPhongBan);
        TextView vMAPhongBan= (TextView) viewrow.findViewById(R.id.viewlistMaPhongBan);
        TextView vSoNhanVien= (TextView) viewrow.findViewById(R.id.viewlistSoNhanVien);

        PhongBanDTO phongban=objects.get(position);
        vTenPhongBan.setText(phongban.getTenPhongBan());
        vMAPhongBan.setText(phongban.getMaPhongBan());
        vSoNhanVien.setText(String.valueOf(phongban.getSoNhanVien()));
        return viewrow;
    }
}
