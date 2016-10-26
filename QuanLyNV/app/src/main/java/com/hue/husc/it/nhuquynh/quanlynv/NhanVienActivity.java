package com.hue.husc.it.nhuquynh.quanlynv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by dell on 2016-10-25.
 */

public class NhanVienActivity extends Activity{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_nhanvien);
        LinearLayout layout_nhanvien= (LinearLayout) findViewById(R.id.layout_nhanvien);
        registerForContextMenu(layout_nhanvien);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_chucnang,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.menuThem){
            Intent iThemNhanVien=new Intent(NhanVienActivity.this,ThemNhanVienActivity.class);
            startActivity(iThemNhanVien);
        }
        return super.onContextItemSelected(item);
    }
}
