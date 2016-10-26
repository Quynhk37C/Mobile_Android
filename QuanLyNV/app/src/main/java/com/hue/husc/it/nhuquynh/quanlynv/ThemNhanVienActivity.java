package com.hue.husc.it.nhuquynh.quanlynv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.hue.husc.it.nhuquynh.quanlynv.Adapter.Custom_Spinner_ThemNhanvien;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.PhongBanDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016-10-26.
 */

public class ThemNhanVienActivity extends Activity {
    Spinner spinnerPhongBan;
    EditText txtTenNhanVien,txtDiaChi,txtSdt,txtLuong,txtNgaySinh,txtEmail;
    Button btnThem,btnThoat;
    List<PhongBanDTO> list;
    PhongBanDAO dbphongban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themnhanvien);
        dbphongban=new PhongBanDAO(this);
        spinnerPhongBan= (Spinner) findViewById(R.id.spinnerPhongBan);
        list=new ArrayList<PhongBanDTO>();
        list=dbphongban.layAllPhongBan();
        Custom_Spinner_ThemNhanvien adapter= new Custom_Spinner_ThemNhanvien(this,R.layout.custom_layout_spinner,list);
        spinnerPhongBan.setAdapter(adapter);

    }
}
