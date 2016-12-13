package com.hue.husc.it.nhuquynh.quanlynv.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hue.husc.it.nhuquynh.quanlynv.DAO.NhanVienDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.PhongBanDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;
import com.hue.husc.it.nhuquynh.quanlynv.PhongBanActivity;
import com.hue.husc.it.nhuquynh.quanlynv.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016-10-25.
 */

public class Custom_Listview_PhongBan extends ArrayAdapter<PhongBanDTO> {
    Context context;
    int resource;
    NhanVienDAO nv;
    PhongBanDAO pb;
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
        List<NhanVienDTO> ds = new ArrayList<NhanVienDTO>();
        int d = ds.size();
        PhongBanDTO phongban=objects.get(position);
        pb= new PhongBanDAO(context);
        vTenPhongBan.setText(phongban.getTenPhongBan());
<<<<<<< HEAD
        vMAPhongBan.setText(phongban.getMaPhongBan());
=======
        vMAPhongBan.setText("Mã phòng ban :"+phongban.getMaPhongBan());
        vSoNhanVien.setText("Số nhân viên :"+String.valueOf(pb.demSoNV(Integer.parseInt(phongban.getMaPhongBan()))));

>>>>>>> 37d724f6040efbb1d8d1ba7195a8206fe6580879
        return viewrow;
    }
}
