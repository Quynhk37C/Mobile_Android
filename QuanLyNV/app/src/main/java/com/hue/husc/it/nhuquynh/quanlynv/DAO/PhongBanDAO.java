package com.hue.husc.it.nhuquynh.quanlynv.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/20/2016.
 */
public class PhongBanDAO {
    Context context;
    Database dbhelper;
    SQLiteDatabase db;
    public PhongBanDAO(Context context){
        this.context = context;
        dbhelper = new Database(context);

    }
    public int SuaPhongBan(PhongBanDTO phongban){
        db = dbhelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Database.TenPB_PhongBan,phongban.getTenPhongBan());
        return db.update(Database.TABLE_PHONGBAN,values,Database.MaPB_PhongBan +"=?",new String[]{phongban.getMaPhongBan()});
    }
    public int XoaPhongBan(String id){
        db = dbhelper.getWritableDatabase();
        return db.delete(Database.TABLE_PHONGBAN,Database.MaPB_PhongBan +"=?",new String[]{id});
    }
    public void themPhongBan(PhongBanDTO phongban){
        db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.TenPB_PhongBan,phongban.getTenPhongBan());
        db.insert(Database.TABLE_PHONGBAN,null,values);
        db.close();
    }
    public List<PhongBanDTO> layAllPhongBan(){
        List<PhongBanDTO> list=new ArrayList<PhongBanDTO>();
       db= dbhelper.getWritableDatabase();
        String sql="SELECT * FROM "+Database.TABLE_PHONGBAN;
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            PhongBanDTO phongban=new PhongBanDTO();
            phongban.setTenPhongBan(c.getString(c.getColumnIndex(Database.TenPB_PhongBan)));
            phongban.setMaPhongBan((c.getString(c.getColumnIndex(Database.MaPB_PhongBan))));
            list.add(phongban);
            c.moveToNext();
        }
        return list;
    }

    public PhongBanDTO LayPB(String id){
        db = dbhelper.getWritableDatabase();
        String sql=" select * from "+Database.TABLE_PHONGBAN+" where MaPB = "+id+"";
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        PhongBanDTO pb = new PhongBanDTO();
        while (!c.isAfterLast()){
            pb.setMaPhongBan(c.getString(c.getColumnIndex(Database.MaPB_PhongBan)));
            pb.setTenPhongBan(c.getString(c.getColumnIndex(Database.TenPB_PhongBan)));
            c.moveToNext();
        }
        return pb;
    }
    public  int demSoNV(int id){
        List<NhanVienDTO> list=new ArrayList<NhanVienDTO>();
        db= dbhelper.getWritableDatabase();
        String sql="SELECT * FROM "+Database.TABLE_NHANVIEN+" WHERE "+Database.MaPB_PhongBan+" = "+id;
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        int dem =0;
        while (!c.isAfterLast()){
            dem++;
            c.moveToNext();
        }
        return dem;
    }
    public int getPosition(String id) {
        List<PhongBanDTO> l = layAllPhongBan();
        int n = l.size();
        int i=0;
        while(i<n){
            if(l.get(i).getTenPhongBan().equals(id))
                return i;
            else
                i++;
        }
            return 0;
    }
}
