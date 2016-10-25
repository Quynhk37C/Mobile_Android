package com.hue.husc.it.nhuquynh.quanlynv;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.hue.husc.it.nhuquynh.quanlynv.Adapter.Custom_Listview_PhongBan;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.PhongBanDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/20/2016.
 */
public class PhongBanActivity extends AppCompatActivity {
    ListView listviewPhongBan;
    LinearLayout layout_phongban;
    EditText editTenPhongBan;
    Button btnThem;
    PhongBanDAO dbPhongBan;
    Custom_Listview_PhongBan adapter;
    List<PhongBanDTO> listPhongBan;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_phongban);
        listviewPhongBan = (ListView)findViewById(R.id.listPhongBan);
        layout_phongban = (LinearLayout)findViewById(R.id.layout_phongban);
        registerForContextMenu(listviewPhongBan);
        registerForContextMenu(layout_phongban);
        dbPhongBan=new PhongBanDAO(this);
        LoadListViewPhongBan();

        listviewPhongBan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                position=i;
                return  false;
            }
        });
    }
    public void LoadListViewPhongBan(){
        listPhongBan=new ArrayList<PhongBanDTO>();
        listPhongBan =dbPhongBan.layAllPhongBan();
        adapter=new Custom_Listview_PhongBan(this,R.layout.custom_listview_phongban,listPhongBan);
        listviewPhongBan.setAdapter(adapter);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_chucnang,menu);
        menu.setHeaderTitle("Chức năng");
        if(v.getId()==R.id.listPhongBan) {
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
        }
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuThem){
            final Dialog dal=new Dialog(this);
            dal.setTitle("Thêm phòng ban");
            dal.setContentView(R.layout.layout_themphongban);
            editTenPhongBan= (EditText) dal.findViewById(R.id.editTenPhongBan);
            btnThem= (Button) dal.findViewById(R.id.btnThem);
            dal.show();

            btnThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PhongBanDTO phongban=new PhongBanDTO();
                    phongban.setTenPhongBan(editTenPhongBan.getText().toString());
                    dbPhongBan.themPhongBan(phongban);
                    Toast.makeText(getApplication(),"Thêm thành công",Toast.LENGTH_LONG).show();
                    LoadListViewPhongBan();
                    dal.dismiss();
                }
            });

        }
        if(id == R.id.menuXoa){
            String maphongban=listPhongBan.get(position).getMaPhongBan();
            if(dbPhongBan.XoaPhongBan(maphongban)!=-1){
                Toast.makeText(getApplication(),"Đã xóa",Toast.LENGTH_LONG).show();
                LoadListViewPhongBan();
            }else{
                Toast.makeText(getApplication(),"Không xóa được",Toast.LENGTH_LONG).show();
            }

        }
        if(id == R.id.menuSua){
            final Dialog dalSua=new Dialog(this);
            dalSua.setTitle("Sửa phòng ban");
            dalSua.setContentView(R.layout.layout_suaphongban);
            final EditText editMaPhongBanSua= (EditText) dalSua.findViewById(R.id.editMaPhongBanSua);
           final EditText editTenPhongBanSua= (EditText) dalSua.findViewById(R.id.editTenPhongBanSua);
            Button btnSua= (Button) dalSua.findViewById(R.id.btnSua);
            editMaPhongBanSua.setEnabled(false);
            editMaPhongBanSua.setText(listPhongBan.get(position).getMaPhongBan());

            dalSua.show();
            btnSua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PhongBanDTO phongban=new PhongBanDTO();
                    phongban.setMaPhongBan(listPhongBan.get(position).getMaPhongBan());
                    phongban.setTenPhongBan(editTenPhongBanSua.getText().toString());
                    if(dbPhongBan.SuaPhongBan(phongban)!=-1){
                        Toast.makeText(getApplication(),"Đã sửa",Toast.LENGTH_LONG).show();
                        LoadListViewPhongBan();
                        dalSua.dismiss();
                    }else{
                        Toast.makeText(getApplication(),"Không sửa được",Toast.LENGTH_LONG).show();
                    }

                }
            });


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
