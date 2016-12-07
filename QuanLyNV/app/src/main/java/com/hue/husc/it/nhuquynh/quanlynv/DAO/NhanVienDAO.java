package com.hue.husc.it.nhuquynh.quanlynv.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentSender;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hue.husc.it.nhuquynh.quanlynv.DTO.NhanVienDTO;
import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016-10-25.
 */

public class NhanVienDAO{
    Context context;
    Database dbhelper;
    SQLiteDatabase db;
    public NhanVienDAO(Context context){
        this.context = context;
        dbhelper = new Database(context);
    }
    public NhanVienDTO LayNhanVienTheoMa(int id){
        db = dbhelper.getWritableDatabase();
        String sql=" select * from "+ Database.TABLE_NHANVIEN + "," +Database.TABLE_PHONGBAN+
                " where " + Database.TABLE_NHANVIEN + "." +Database.MaPB_PhongBan+ " = "
                + Database.TABLE_PHONGBAN+ "." +Database.MaPB_PhongBan + " and " +Database.MaNV_NhanVien + " = "+ id;
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        NhanVienDTO nhanvien=new NhanVienDTO();
        while (!c.isAfterLast()){
            nhanvien.setDiachi(c.getString(c.getColumnIndex(Database.DiaChi_NhanVien)));
            nhanvien.setEmail(c.getString(c.getColumnIndex(Database.Email_NhanVien)));
            nhanvien.setGioitinh(c.getString(c.getColumnIndex(Database.GioiTinh_NhanVien)));
            nhanvien.setLuong(Integer.parseInt(c.getString(c.getColumnIndex(Database.Luong_NhanVien))));
            nhanvien.setNgaysinh(c.getString(c.getColumnIndex(Database.NgaySinh_NhanVien)));
            nhanvien.setSdt(c.getString(c.getColumnIndex(Database.SDT_NhanVien)));
            nhanvien.setTenphongban(c.getString(c.getColumnIndex(Database.TenPB_PhongBan)));
            nhanvien.setTennv(c.getString(c.getColumnIndex(Database.TenNV_NhanVien)));
            c.moveToNext();
        }
        return nhanvien;
    }
    public  int demSoNV(){
        List<NhanVienDTO> list=new ArrayList<NhanVienDTO>();
        db= dbhelper.getWritableDatabase();
        String sql="SELECT * FROM "+Database.TABLE_NHANVIEN;
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        int dem =0;
        while (!c.isAfterLast()){
            dem++;
            c.moveToNext();
        }
        return dem;
    }

    public int CapNhatNhanVien(NhanVienDTO nhanvien){
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
        return db.update(Database.TABLE_NHANVIEN,values,Database.MaNV_NhanVien+ "=?",new String[]{String.valueOf(nhanvien.getManv())});
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
    public int Xoa(int id){
        db = dbhelper.getWritableDatabase();
        return db.delete(Database.TABLE_NHANVIEN,Database.MaNV_NhanVien + "=?", new String[]{String.valueOf(id)});
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

    public List<NhanVienDTO> layNhanVienTheoPhong(int mapb){
        List<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        db = dbhelper.getWritableDatabase();
        String sql=" select * from "+ Database.TABLE_NHANVIEN+","+ Database.TABLE_PHONGBAN+
                " where "+ Database.TABLE_NHANVIEN + "." + Database.MaPB_PhongBan + " = "
                +Database.TABLE_PHONGBAN + "." + Database.MaPB_PhongBan + " and " + Database.TABLE_NHANVIEN + "."+ Database.MaPB_PhongBan +" = " + mapb;
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            NhanVienDTO nhanvien=new NhanVienDTO();
            nhanvien.setDiachi(c.getString(c.getColumnIndex(Database.DiaChi_NhanVien)));
            nhanvien.setEmail(c.getString(c.getColumnIndex(Database.Email_NhanVien)));
            nhanvien.setGioitinh(c.getString(c.getColumnIndex(Database.GioiTinh_NhanVien)));
            nhanvien.setLuong(Integer.parseInt(c.getString(c.getColumnIndex(Database.Luong_NhanVien))));
            nhanvien.setNgaysinh(c.getString(c.getColumnIndex(Database.NgaySinh_NhanVien)));
            nhanvien.setSdt(c.getString(c.getColumnIndex(Database.SDT_NhanVien)));
            nhanvien.setTennv(c.getString(c.getColumnIndex(Database.TenNV_NhanVien)));
            nhanvien.setManv(Integer.parseInt(c.getString(c.getColumnIndex(Database.MaNV_NhanVien))));
            list.add(nhanvien);
            c.moveToNext();
        }
        return list;
    }
}
