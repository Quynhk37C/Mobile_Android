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
 * Created by dell on 2016-10-25.
 */

public class NhanVienDAO {
    Context context;
    Database dbhelper;
    SQLiteDatabase db;
    public NhanVienDAO(Context context){
        this.context = context;
        dbhelper = new Database(context);
    }
    public int Xoa(int id){
        db = dbhelper.getWritableDatabase();
        return db.delete(Database.TABLE_NHANVIEN,Database.MaNV_NhanVien + "=?", new String[]{String.valueOf(id)});
    }
    public void themNhanVien(NhanVienDTO nhanvien){
        db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.TenNV_NhanVien,nhanvien.getTennv());
        values.put(Database.SDT_NhanVien,nhanvien.getSdt());
        values.put(Database.NgaySinh_NhanVien,nhanvien.getNgaysinh());
        values.put(Database.GioiTinh_NhanVien,nhanvien.getGioitinh());
        values.put(Database.DiaChi_NhanVien,nhanvien.getDiachi());
        values.put(Database.Email_NhanVien,nhanvien.getEmail());
        values.put(Database.Luong_NhanVien,nhanvien.getLuong());
        values.put(Database.MaPB_PhongBan,nhanvien.getMapb());
        db.insert(Database.TABLE_NHANVIEN,null,values);
        db.close();
    }
    public List<NhanVienDTO> LoadAllNhanvien(){
        List<NhanVienDTO> list=new ArrayList<NhanVienDTO>();
        db= dbhelper.getWritableDatabase();
        String sql="SELECT * FROM "+Database.TABLE_NHANVIEN;
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            NhanVienDTO nhanvien=new NhanVienDTO();
            nhanvien.setManv(Integer.parseInt(c.getString(c.getColumnIndex(Database.MaNV_NhanVien))));
            nhanvien.setTennv(c.getString(c.getColumnIndex(Database.TenNV_NhanVien)));
            nhanvien.setDiachi(c.getString(c.getColumnIndex(Database.DiaChi_NhanVien)));
            nhanvien.setEmail(c.getString(c.getColumnIndex(Database.Email_NhanVien)));
            nhanvien.setGioitinh(c.getString(c.getColumnIndex(Database.GioiTinh_NhanVien)));
            nhanvien.setLuong(Integer.parseInt(c.getString(c.getColumnIndex(Database.Luong_NhanVien))));
            nhanvien.setNgaysinh(c.getString(c.getColumnIndex(Database.NgaySinh_NhanVien)));
            nhanvien.setSdt(c.getString(c.getColumnIndex(Database.SDT_NhanVien)));
            nhanvien.setMapb(c.getString(c.getColumnIndex(Database.MaPB_PhongBan)));
            list.add(nhanvien);
            c.moveToNext();
        }
        return list;
    }
}
