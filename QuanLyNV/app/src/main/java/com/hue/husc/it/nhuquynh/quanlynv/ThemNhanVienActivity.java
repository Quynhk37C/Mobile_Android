package com.hue.husc.it.nhuquynh.quanlynv;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dell on 2016-10-26.
 */
public class ThemNhanVienActivity extends AppCompatActivity {
    Spinner spinnerPhongBan;
    EditText txtTenNhanVien,txtDiaChi,txtSdt,txtLuong,txtNgaySinh,txtEmail;
    Button btnThem,btnThoat;
    List<PhongBanDTO> list;
    PhongBanDAO dbphongban;
    NhanVienDAO dbNhanVien;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themnhanvien);
        btnThem = (Button)findViewById(R.id.btnThem);
        btnThoat = (Button)findViewById(R.id.btnThoat);
        txtTenNhanVien = (EditText)findViewById(R.id.editTenNv);
        txtDiaChi = (EditText)findViewById(R.id.editDiaChi);
        txtEmail = (EditText)findViewById(R.id.editEmail);
        txtSdt = (EditText)findViewById(R.id.editSoDT);
        txtLuong = (EditText)findViewById(R.id.editLuong);
        txtNgaySinh = (EditText)findViewById(R.id.editNgaySinh);
        dbphongban=new PhongBanDAO(this);
        dbNhanVien = new NhanVienDAO(this);
        spinnerPhongBan= (Spinner) findViewById(R.id.spinnerPhongBan);
        list=new ArrayList<PhongBanDTO>();
        list=dbphongban.layAllPhongBan();
        Custom_Spinner_ThemNhanvien adapter= new Custom_Spinner_ThemNhanvien(this,R.layout.custom_layout_spinner,list);
        spinnerPhongBan.setAdapter(adapter);
        spinnerPhongBan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // Xứ lý sự kiện thêm nhân viên
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                RadioGroup rdGroup = (RadioGroup)findViewById(R.id.rdGioiTinh);
                int rdID = rdGroup.getCheckedRadioButtonId();
                RadioButton rdChecked = (RadioButton)findViewById(rdID);
                String gioiTinh = rdChecked.getText().toString();
                int maPB = Integer.parseInt(list.get(vitri).getMaPhongBan());
                try{
                    nhanVienDTO.setTennv(txtTenNhanVien.getText().toString());
                    nhanVienDTO.setDiachi(txtDiaChi.getText().toString());
                    nhanVienDTO.setEmail(txtEmail.getText().toString());
                    nhanVienDTO.setSdt(txtSdt.getText().toString());
                    nhanVienDTO.setGioitinh(gioiTinh);
                    nhanVienDTO.setLuong(Integer.parseInt(txtLuong.getText().toString()));
                    nhanVienDTO.setMapb(String.valueOf(maPB));
                    nhanVienDTO.setNgaysinh(txtNgaySinh.getText().toString());
                    dbNhanVien.themNhanVien(nhanVienDTO);
                    Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
                    finish();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
/*
package com.hue.husc.it.nhuquynh.quanlynv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
=======
import android.view.View;
import android.widget.AdapterView;
>>>>>>> 75512b734e462fde99fc71bea9a4d64f335ce630
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016-10-26.

<<<<<<< HEAD

=======
>>>>>>> 75512b734e462fde99fc71bea9a4d64f335ce630
public class ThemNhanVienActivity extends AppCompatActivity {
    Spinner spinnerPhongBan;
    EditText txtTenNhanVien,txtDiaChi,txtSdt,txtLuong,txtNgaySinh,txtEmail;
    Button btnThem,btnThoat;
    List<PhongBanDTO> list;
    PhongBanDAO dbphongban;
    NhanVienDAO dbNhanVien;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_themnhanvien);

        btnThem = (Button)findViewById(R.id.btnThem);
        btnThoat = (Button)findViewById(R.id.btnThoat);

        txtTenNhanVien = (EditText)findViewById(R.id.editTenNv);
        txtDiaChi = (EditText)findViewById(R.id.editDiaChi);
        txtEmail = (EditText)findViewById(R.id.editEmail);
        txtSdt = (EditText)findViewById(R.id.editSoDT);
        txtLuong = (EditText)findViewById(R.id.editLuong);
        txtNgaySinh = (EditText)findViewById(R.id.editNgaySinh);

        dbphongban=new PhongBanDAO(this);
        dbNhanVien = new NhanVienDAO(this);

        spinnerPhongBan= (Spinner) findViewById(R.id.spinnerPhongBan);
        list=new ArrayList<PhongBanDTO>();
        list=dbphongban.layAllPhongBan();
        Custom_Spinner_ThemNhanvien adapter= new Custom_Spinner_ThemNhanvien(this,R.layout.custom_layout_spinner,list);
        spinnerPhongBan.setAdapter(adapter);
        spinnerPhongBan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Xứ lý sự kiện thêm nhân viên
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                RadioGroup rdGroup = (RadioGroup)findViewById(R.id.rdGioiTinh);
                int rdID = rdGroup.getCheckedRadioButtonId();
                RadioButton rdChecked = (RadioButton)findViewById(rdID);
                String gioiTinh = rdChecked.getText().toString();
                int maPB = Integer.parseInt(list.get(vitri).getMaPhongBan());
                try{
                nhanVienDTO.setTennv(txtTenNhanVien.getText().toString());
                nhanVienDTO.setDiachi(txtDiaChi.getText().toString());
                nhanVienDTO.setEmail(txtEmail.getText().toString());
                nhanVienDTO.setSdt(txtSdt.getText().toString());
                nhanVienDTO.setGioitinh(gioiTinh);
                nhanVienDTO.setLuong(Integer.parseInt(txtLuong.getText().toString()));
                nhanVienDTO.setMapb(String.valueOf(maPB));

                dbNhanVien.themNhanVien(nhanVienDTO);
                Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
                    finish();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}*/
