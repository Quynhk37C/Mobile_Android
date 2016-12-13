package com.hue.husc.it.nhuquynh.quanlynv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_chucnang extends AppCompatActivity {
    Button nhanvien,phongban,hethong,lienhe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chucnang);

        nhanvien = (Button)findViewById(R.id.btnnhanvien);
        nhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNhanVien = new Intent(Activity_chucnang.this,NhanVienActivity.class);
                startActivity(iNhanVien);
            }
        });
        phongban = (Button)findViewById(R.id.btnphongban);
        phongban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPhongBan = new Intent(Activity_chucnang.this,PhongBanActivity.class);
                startActivity(iPhongBan);
            }
        });
        hethong = (Button)findViewById(R.id.btnhethong);
        hethong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iHeThong = new Intent(Activity_chucnang.this,ThietLapMatKhauActivity.class);
                startActivity(iHeThong);
            }
        });
        lienhe = (Button)findViewById(R.id.btnlienhe);
        lienhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iLienHe = new Intent(Activity_chucnang.this,LienHeActivity.class);
                startActivity(iLienHe);
            }
        });
    }
}
