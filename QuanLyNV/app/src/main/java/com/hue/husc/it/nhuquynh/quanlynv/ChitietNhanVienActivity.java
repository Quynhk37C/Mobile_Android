package com.hue.husc.it.nhuquynh.quanlynv;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.hue.husc.it.nhuquynh.quanlynv.DAO.NhanVienDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;

/**
 * Created by dell on 2016-10-27.
 */

public class ChitietNhanVienActivity extends AppCompatActivity {
    TextView vTenNV,vGioitinh,vSoDienThoai,vDiaChi,vNgaysinh,vPhongBan,vEmail,vLuong;
    NhanVienDAO dbnhanvien;
    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_chitietnhanvien);

       vTenNV= (TextView) findViewById(R.id.vCTTenNhanVien);
        vGioitinh= (TextView) findViewById(R.id.vCTGioiTinh);
        vEmail= (TextView) findViewById(R.id.VHTEmail);
        vSoDienThoai= (TextView) findViewById(R.id.vCTSoDienThoai);
        vDiaChi = (TextView) findViewById(R.id.VHTDiachi);
        vPhongBan= (TextView) findViewById(R.id.VHTPhongBan);
        vLuong= (TextView) findViewById(R.id.VHTLuong);
      //  vNgaysinh= (TextView) findViewById(R.id.VHTNgaySinh);
        dbnhanvien =new NhanVienDAO(this);
        int id=getIntent().getExtras().getInt("manv");
        NhanVienDTO nhanvien=new NhanVienDTO();
        nhanvien=dbnhanvien.LayNhanVienTheoMa(id);

        vTenNV.setText(nhanvien.getTennv().toString());
        vGioitinh.setText(nhanvien.getGioitinh().toString());
        vEmail.setText(nhanvien.getEmail().toString());
        vSoDienThoai.setText(nhanvien.getSdt().toString());
        vDiaChi.setText(nhanvien.getDiachi().toString());
        vPhongBan.setText(nhanvien.getTenphongban().toString());
        vLuong.setText(String.valueOf(nhanvien.getLuong()));
      //  vNgaysinh.setText(nhanvien.getNgaysinh().toString()); cai nay them vao csdl
    }
}
