package com.hue.husc.it.nhuquynh.quanlynv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hue.husc.it.nhuquynh.quanlynv.Adapter.Custom_Listview_NhanVien;
import com.hue.husc.it.nhuquynh.quanlynv.Adapter.Custom_Spinner_ThemNhanvien;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.NhanVienDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;

import java.util.List;

/**
 * Created by Admin on 10/25/2016.
 */

public class NhanVienPhongBanActivity extends AppCompatActivity {
    ListView listViewNhanVienPhongBan ;
    NhanVienDAO dbNhanVien;
    List<NhanVienDTO> listNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nhanvien_phongban);

        listViewNhanVienPhongBan = (ListView)findViewById(R.id.listNhanVienPhongBan);
        dbNhanVien = new NhanVienDAO(this);

        Intent intent = getIntent();
        int mapb = Integer.parseInt(intent.getExtras().getString("maphongban"));
        listNhanVien = dbNhanVien.layNhanVienTheoPhong(mapb);
        Custom_Listview_NhanVien adapter = new Custom_Listview_NhanVien(this,R.layout.custom_layout_nhanvien,listNhanVien);
        listViewNhanVienPhongBan.setAdapter(adapter);

        listViewNhanVienPhongBan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent iChiTietNhanVien = new Intent(NhanVienPhongBanActivity.this,ChitietNhanVienActivity.class);
                iChiTietNhanVien.putExtra("manv",listNhanVien.get(position).getManv());
                startActivity(iChiTietNhanVien);
            }
        });
    }
}
