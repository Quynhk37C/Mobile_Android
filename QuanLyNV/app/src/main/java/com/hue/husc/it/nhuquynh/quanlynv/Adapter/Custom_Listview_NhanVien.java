package com.hue.husc.it.nhuquynh.quanlynv.Adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;
import com.hue.husc.it.nhuquynh.quanlynv.R;
import java.util.List;
/**
 * Created by dell on 2016-10-25.
 */
public class Custom_Listview_NhanVien  extends ArrayAdapter<NhanVienDTO>{
    Context context;
    int resource;
    List<NhanVienDTO> objects;
    public Custom_Listview_NhanVien(Context context, int resource,List<NhanVienDTO> objects) {
        super(context, resource,objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_layout_nhanvien,parent,false);
        TextView vTenNhanVien = (TextView)view.findViewById(R.id.vTenNhanVien);
        TextView vSoDT = (TextView)view.findViewById(R.id.vSodienThoai);
        TextView vGioiTinh = (TextView)view.findViewById(R.id.vGioiTinh);
        NhanVienDTO nhanVienDTO = objects.get(position);
        vTenNhanVien.setText(nhanVienDTO.getTennv());
        vSoDT.setText(nhanVienDTO.getSdt());
        vGioiTinh.setText(nhanVienDTO.getGioitinh());
        return view;
    }
}
