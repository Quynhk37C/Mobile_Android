package com.hue.husc.it.nhuquynh.quanlynv;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.hue.husc.it.nhuquynh.quanlynv.Adapter.Custom_Spinner_ThemNhanvien;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.NhanVienDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.PhongBanDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;

import java.util.List;

/**
 * Created by Admin on 10/27/2016.
 */

public class CapNhatNhanVienActivity extends AppCompatActivity {
    PhongBanDAO dbPhongBan;
    NhanVienDAO dbNhanVien;
    Spinner spinner;
    EditText txtTenNhanVien,txtDiaChi,txtSdt,txtLuong,txtNgaySinh,txtEmail;
    Button btnThem,btnThoat;
    RadioGroup gioiTinh;
    RadioButton rdNam,rdNu;
    List<PhongBanDTO> listPhongBan;
    int vitri;
    int iMaNV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_capnhatnhanvien);
        btnThem = (Button)findViewById(R.id.btnCapNhat);
        btnThoat = (Button)findViewById(R.id.btnCNThoat);

        txtTenNhanVien = (EditText)findViewById(R.id.editSuaTenNv);
        txtDiaChi = (EditText)findViewById(R.id.editSuaDiaChi);
        txtEmail = (EditText)findViewById(R.id.editSuaEmail);
        txtSdt = (EditText)findViewById(R.id.editSuaSoDT);
        txtLuong = (EditText)findViewById(R.id.editSuaLuong);
        txtNgaySinh = (EditText)findViewById(R.id.editSuaNgaySinh);
        gioiTinh = (RadioGroup) findViewById(R.id.rdSuaGioiTinh);
        spinner = (Spinner)findViewById(R.id.spinnerSuaPhongBan);
        rdNam = (RadioButton)findViewById(R.id.rdNam);
        rdNu = (RadioButton)findViewById(R.id.rdNu);
        Intent intent = getIntent();
        iMaNV = intent.getExtras().getInt("manv");
        this.setResult(RESULT_OK);
        dbPhongBan = new PhongBanDAO(this);
        dbNhanVien = new NhanVienDAO(this);
        listPhongBan = dbPhongBan.layAllPhongBan();
        Custom_Spinner_ThemNhanvien adapter = new Custom_Spinner_ThemNhanvien(this,R.layout.custom_layout_spinner,listPhongBan);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        NhanVienDTO tam = dbNhanVien.LayNhanVienTheoMa(iMaNV);
        txtTenNhanVien.setText(tam.getTennv());
        txtDiaChi.setText(tam.getDiachi());
        txtEmail.setText(tam.getEmail());
        txtLuong.setText(tam.getLuong()+"");
        txtNgaySinh.setText(tam.getNgaysinh());
        txtSdt.setText(tam.getSdt());
<<<<<<< HEAD
        spinner.setSelection(dbPhongBan.getPosition(tam.getTenphongban()));
=======
       if(tam.getGioitinh().equals("Nữ"))
            rdNu.setChecked(true);
        else
            rdNam.setChecked(true);
>>>>>>> 459d7cb44b1b1f76678dc4433320ba2233787aa3
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CapNhatNhanVien();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void CapNhatNhanVien(){
        NhanVienDTO nhanvien = new NhanVienDTO();
        dbNhanVien.CapNhatNhanVien(nhanvien);
        RadioGroup rdGroup = (RadioGroup)findViewById(R.id.rdSuaGioiTinh);
        int rdID = rdGroup.getCheckedRadioButtonId();
        RadioButton rdChecked = (RadioButton)findViewById(rdID);
        String gioiTinh = rdChecked.getText().toString();
        int maPB = Integer.parseInt(listPhongBan.get(vitri).getMaPhongBan());
        nhanvien.setManv(iMaNV);
        nhanvien.setTennv(txtTenNhanVien.getText().toString());
        nhanvien.setDiachi(txtDiaChi.getText().toString());
        nhanvien.setEmail(txtEmail.getText().toString());
        nhanvien.setSdt(txtSdt.getText().toString());
        nhanvien.setNgaysinh(txtNgaySinh.getText().toString());
        nhanvien.setGioitinh(gioiTinh);
        nhanvien.setLuong(Integer.parseInt(txtLuong.getText().toString()));
        nhanvien.setMapb(String.valueOf(maPB));

        if(dbNhanVien.CapNhatNhanVien(nhanvien) != -1){
            Toast.makeText(getApplicationContext(),"Sửa thành công",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Sửa thất bại",Toast.LENGTH_LONG).show();
        }

    }
}
