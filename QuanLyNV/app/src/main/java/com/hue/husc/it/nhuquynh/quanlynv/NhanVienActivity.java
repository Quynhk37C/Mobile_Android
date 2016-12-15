package com.hue.husc.it.nhuquynh.quanlynv;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.hue.husc.it.nhuquynh.quanlynv.Adapter.Custom_Listview_NhanVien;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.Database;
import com.hue.husc.it.nhuquynh.quanlynv.DAO.NhanVienDAO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dell on 2016-10-25.
 */

/**
 * Created by dell on 2016-10-25.
 */


public class    NhanVienActivity extends AppCompatActivity {
    NhanVienDAO dbNhanVien;
    List<NhanVienDTO> listNV;
    Custom_Listview_NhanVien adapter;
    ListView listViewNV;
    int vitri;
    int idnhanvien;
    EditText inputSearch;
    public  static int RESULT_CAPNHATNHANVIEN = 100;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_nhanvien);
        final LinearLayout layout_nhanvien= (LinearLayout) findViewById(R.id.layout_nhanvien);
        registerForContextMenu(layout_nhanvien);
        dbNhanVien = new NhanVienDAO(this);

        LoadListViewNhanVien();
        registerForContextMenu(listViewNV);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        LoadListViewNhanVien();

        registerForContextMenu(listViewNV);
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              //  NhanVienActivity.this.adapter.getFilter().filter(charSequence);
                listNV=dbNhanVien.LoadNhanvien(charSequence.toString());
                LoadListViewNhanVien();


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

        listViewNV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                return false;
            }
        });
        listViewNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent ichitietnhanvien=new Intent(NhanVienActivity.this,ChitietNhanVienActivity.class);
                int id=listNV.get(i).getManv();
                ichitietnhanvien.putExtra("manv",id);
                startActivity(ichitietnhanvien);
            }
        });
    }

    private  void LoadListViewNhanVien(){
        listNV = new ArrayList<NhanVienDTO>();
        listNV = dbNhanVien.LoadAllNhanvien();
        adapter = new Custom_Listview_NhanVien(this,R.layout.custom_layout_nhanvien,listNV);

        listViewNV = (ListView)findViewById(R.id.listNhanVien);
        listViewNV.setAdapter(adapter);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_chucnang,menu);
        if(v.getId() == R.id.listNhanVien){
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
        }
    }
    private  void XoaNhanVien(){
         idnhanvien=listNV.get(vitri).getManv();
        if(dbNhanVien.Xoa(idnhanvien)!= -1){
            Toast.makeText(getApplicationContext(),"Xóa thành công",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Xóa thất bại",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.menuThem){
            Intent iThemNhanVien=new Intent(NhanVienActivity.this,ThemNhanVienActivity.class);
            startActivity(iThemNhanVien);
        }
        if(id == R.id.menuXoa){

            XoaNhanVien();
            LoadListViewNhanVien();
        }
        if(id == R.id.menuSua){
            Intent iCapNhatNhanVien = new Intent(NhanVienActivity.this,CapNhatNhanVienActivity.class);
            int idnhanvien = listNV.get(vitri).getManv();
            iCapNhatNhanVien.putExtra("manv",idnhanvien);
            startActivityForResult(iCapNhatNhanVien,RESULT_CAPNHATNHANVIEN);
            LoadListViewNhanVien();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CAPNHATNHANVIEN && resultCode == RESULT_OK){
            LoadListViewNhanVien();
        }
    }
}
