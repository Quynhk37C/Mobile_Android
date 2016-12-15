package com.hue.husc.it.nhuquynh.quanlynv;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button btnDangKy,btnThoatDK,btnDangNhap,btnThoatDN;
    EditText editTaiKhoanDK,editMatKhauDK,editNhapLaiMk,editMatKhauDN,editTaiKhoanDN;
    CheckBox saveLoginCheckBox;
    private Boolean saveLogin;
    String taikhoandn,matkhaudn;
    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        editTaiKhoanDN = (EditText)findViewById(R.id.editTenDangNhap);
        editMatKhauDN = (EditText)findViewById(R.id.editMatKhau);
        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        share = getSharedPreferences("auth", 0);
        if(share.getBoolean("auth_status", false)){  // the false stands for default value
            editTaiKhoanDN.setText(share.getString("auth_name", "elltz")); //default vaule is elltz
            editMatKhauDN.setText(share.getString("auth_pass", "elltz")); //default vaule is elltz
        }


    }
    public void exitAction(View v){
        finish();
    }

    public void DangNhap(View v){
        String matkhauconfig, taikhoanconfig, taikhoandn, matkhaudn;
        taikhoanconfig = sharedPreferences.getString("TaiKhoan","");
        matkhauconfig = sharedPreferences.getString("MatKhau","");
        taikhoandn = editTaiKhoanDN.getText().toString();
        matkhaudn = editMatKhauDN.getText().toString();
        SharedPreferences.Editor e = share.edit();
        e.putString("auth_name", editTaiKhoanDN.getText().toString());
        e.putString("auth_pass", editMatKhauDN .getText().toString());
        e.putBoolean("auth_status", saveLoginCheckBox.isChecked());
        e.commit();

        if(taikhoandn.equals(taikhoanconfig) && matkhaudn.equals(matkhauconfig)){
            Toast.makeText(getApplication(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
            Intent imain = new Intent(MainActivity.this,Activity_chucnang.class);
            startActivity(imain);

        }else{
            Toast.makeText(getApplication(),"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuDangKy){

            final String taikhoan, matkhau;
            taikhoan = sharedPreferences.getString("TaiKhoan","");
            matkhau = sharedPreferences.getString("MatKhau","");

            if(taikhoan.trim().length() == 0 || matkhau.trim().length() == 0){
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.activity_dangky);
                dialog.setTitle(R.string.titleDangKy);

                btnDangKy = (Button)dialog.findViewById(R.id.btnDangKy);
                editMatKhauDK = (EditText)dialog.findViewById(R.id.editMatKhau);
                editNhapLaiMk = (EditText)dialog.findViewById(R.id.editNhapLaiMK);
                editTaiKhoanDK = (EditText)dialog.findViewById(R.id.editTaiKhoanDK);

                btnDangKy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String matkhaudk, nhaplaimatkhaudk;

                        matkhaudk = editMatKhauDK.getText().toString();
                        nhaplaimatkhaudk = editNhapLaiMk.getText().toString();


                        if(!matkhaudk.equals(nhaplaimatkhaudk)){
                            Toast.makeText(getApplication(),"Mật khẩu nhập lại không đúng",Toast.LENGTH_LONG).show();
                        }else{
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("TaiKhoan",editTaiKhoanDK.getText().toString());
                            editor.putString("MatKhau",editMatKhauDK.getText().toString());
                            editor.commit();
                            Toast.makeText(getApplication(),"Đăng ký thành công",Toast.LENGTH_LONG).show();
                            dialog.dismiss();

                        }
                    }
                });
                btnThoatDK = (Button)dialog.findViewById(R.id.btnThoat);
                btnThoatDK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }else{

                Toast.makeText(getApplication(),"Bạn không thể đăng ký vì  đã có tài khoản",Toast.LENGTH_LONG).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
