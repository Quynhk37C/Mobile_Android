package com.hue.husc.it.nhuquynh.quanlynv;

import android.content.EntityIterator;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by Admin on 10/27/2016.
 */

public class ThietLapMatKhauActivity extends AppCompatActivity {
    EditText editTenDangNhap, editMatKhau, editMatKhauMoi,editNhapLaiMatKhau,editTenDangNhapMoi;
    ToggleButton toggleTrangThai;
    RelativeLayout layoutThayDoi;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thaydoimatkhau);

        layoutThayDoi = (RelativeLayout)findViewById(R.id.khungthaydoi);
        editTenDangNhap = (EditText)findViewById(R.id.edTenDangNhap);
        editMatKhau = (EditText)findViewById(R.id.edMatKhau);
        editMatKhauMoi = (EditText)findViewById(R.id.edNhapLai);
        editNhapLaiMatKhau = (EditText)findViewById(R.id.edNhapMatKhauMoi);
        editTenDangNhapMoi = (EditText)findViewById(R.id.edTenDNMoi);
        toggleTrangThai = (ToggleButton)findViewById(R.id.toggleButton);
        sharedPreferences = getSharedPreferences("config",0);
        toggleTrangThai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layoutThayDoi.setVisibility(RelativeLayout.VISIBLE);
                }else{
                    layoutThayDoi.setVisibility(RelativeLayout.GONE);
                }
            }
        });

        Button btnLuu = (Button)findViewById(R.id.btnTLLuu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thayDoiMatKhau();
            }
        });
    }

    public void thayDoiMatKhau(){
        String tenTaiKhoan = sharedPreferences.getString("TaiKhoan","");
        String matKhau = sharedPreferences.getString("MatKhau","");
        String tenTaiKhoanNhap = editTenDangNhap.getText().toString();
        String matKhauNhap = editMatKhau.getText().toString();

        if(tenTaiKhoan.equals(tenTaiKhoanNhap) || matKhau.equals(matKhauNhap)){
            String tenTaiKhoanMoi = editTenDangNhapMoi.getText().toString();
            String matKhauMoi = editMatKhauMoi.getText().toString();
            String nhapLaiMatKhauMoi = editNhapLaiMatKhau.getText().toString();
            if(matKhauMoi.equals(nhapLaiMatKhauMoi)){
                SharedPreferences.Editor  editor= sharedPreferences.edit();
                editor.putString("TaiKhoan",tenTaiKhoanMoi);
                editor.putString("MatKhau",matKhauMoi);
                Toast.makeText(getApplicationContext(),"Đã thay đổi thành công",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(getApplicationContext(),"Nhập lại mật khẩu không khớp",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Tài khoản và mật khẩu không hợp lệ",Toast.LENGTH_LONG).show();
        }
    }
}
