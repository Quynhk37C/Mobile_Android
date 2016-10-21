package com.hue.husc.it.nhuquynh.quanlynv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Admin on 10/20/2016.
 */
public class PhongBanActivity extends AppCompatActivity {
    ListView listviewPhongBan;
    LinearLayout layout_phongban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_phongban);
        listviewPhongBan = (ListView)findViewById(R.id.listPhongBan);
        layout_phongban = (LinearLayout)findViewById(R.id.layout_phongban);
        registerForContextMenu(listviewPhongBan);
        registerForContextMenu(layout_phongban);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_chucnang,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuThem){
            Toast.makeText(getApplication(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        if(id == R.id.menuXoa){
            Toast.makeText(getApplication(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        if(id == R.id.menuSua){
            Toast.makeText(getApplication(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_phongban,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuPhongBan){
            Toast.makeText(getApplication(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        if(id == R.id.menuNhanVien){
            Toast.makeText(getApplication(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        if(id == R.id.menuLienHe){
            Toast.makeText(getApplication(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        if(id == R.id.menuHeThong){
            Toast.makeText(getApplication(),item.getTitle(),Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
