package com.hue.husc.it.nhuquynh.quanlynv.DAO;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 10/19/2016.
 */
public class Database extends SQLiteOpenHelper {
    private static String DATABASE_NAME ="QLNhanVien";
    private static int DATABASE_VERSION = 1;

    public static  String TABLE_NHANVIEN = "NhanVien";
    public static String MaNV_NhanVien = "MaNV";
    public static String TenNV_NhanVien = "TenNV";
    public static String SDT_NhanVien = "SoDT";
    public static String GioiTinh_NhanVien = "GioiTinh";
    public static String DiaChi_NhanVien = "DiaChi";
    public static String Email_NhanVien = "Email";
    public static String Luong_NhanVien = "Luong";
    public  static String NgaySinh_NhanVien="Ngaysinh";
    public static String TABLE_PHONGBAN = "PhongBan";
    public static String MaPB_PhongBan = "MaPB";
    public static String TenPB_PhongBan  = "TenPB";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taoBangNhanVien = "CREATE TABLE " + TABLE_NHANVIEN + " (\n" +
                "    " + MaNV_NhanVien + "     INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                     NOT NULL,\n" +
                "    " + TenNV_NhanVien + "    TEXT    NOT NULL,\n" +
                "    " + SDT_NhanVien + "     TEXT,\n" +
                "    " + NgaySinh_NhanVien + "    TEXT,\n" +
                "    " + GioiTinh_NhanVien + " TEXT    NOT NULL,\n" +
                "    " + DiaChi_NhanVien + "   TEXT,\n" +
                "    " + Email_NhanVien + "    TEXT,\n" +
                "    " + MaPB_PhongBan + "    INTEGER CONSTRAINT PK_MAPB_NHANVIEN REFERENCES PhongBan(MaPB),\n" +
                "    " + Luong_NhanVien + "    INTEGER\n" +
                ");";


        String taoBangPhongBan = "CREATE TABLE " + TABLE_PHONGBAN + " (\n" +
                "    " + MaPB_PhongBan + "  INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                  NOT NULL,\n" +
                "    " + TenPB_PhongBan + "    UNIQUE\n" +
                "                  NOT NULL\n" +
                ");";
        db.execSQL(taoBangPhongBan);
        db.execSQL("INSERT INTO PhongBan (\n" +
                "                        MaPB,\n" +
                "                        TenPB\n" +
                "                    )\n" +
                "                    VALUES (\n" +
                "                        1,\n" +
                "                        'Công nghệ thông tin'\n" +
                "                    );\n");
        db.execSQL(taoBangNhanVien);
<<<<<<< HEAD
        /*db.execSQL("INSERT INTO PhongBan (\n" +
                "                         TenPB,\n" +
                "                         MaPB\n" +
                "                     )\n" +
                "                     VALUES (\n" +
                "                         'Điện Tử Viễn Thông',\n" +
                "                         1\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Toán',\n" +
                "                         2\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Công nghệ thông tin',\n" +
                "                         3\n" +
                "                     );\n");
        db.execSQL("INSERT INTO NhanVien (\n" +
                "                         Luong,\n" +
                "                         Email,\n" +
                "                         DiaChi,\n" +
                "                         GioiTinh,\n" +
                "                         SoDT,\n" +
                "                         TenNV,\n" +
                "                         MaNV\n" +
                "                     )\n" +
                "                     VALUES (\n" +
                "                         NULL,\n" +
                "                         'a@gmail.com',\n" +
                "                         'Quảng Bình',\n" +
                "                         'Nữ',\n" +
                "                         12345678,\n" +
                "                         'Trần Nữ Như Quỳnh',\n" +
                "                         1\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         NULL,\n" +
                "                         'b@gmail.com',\n" +
                "                         'Huế',\n" +
                "                         'Nam',\n" +
                "                         12345678,\n" +
                "                         'Nguyễn Thị Lan',\n" +
                "                         2\n" +
                "                     );\n");
    */
=======
        db.execSQL("INSERT INTO NhanVien (\n" +
                "                        MaNV,\n" +
                "                        TenNV,\n" +
                "                        SoDT,\n" +
                "                        GioiTinh,\n" +
                "                       DiaChi,\n" +
                "                        Email,\n" +
                "                      Luong,\n" +
                "                       Ngaysinh,\n" +
                "                        MaPB\n" +
                "                    )\n" +
                "                    VALUES (\n" +
                "                        4,\n" +
                "                        'Nguyễn Thị Thanh',\n" +
                "                        '01633968489',\n" +
                "                        'Nữ',\n" +
                "                        'Huế',\n" +
                "                        'thanhnguyenthi@gmail.com',\n" +
                "                        300000,\n" +
                "                        '20-4-1995',\n" +
                "                        1\n" +
                "                    );\n");
        db.execSQL("INSERT INTO NhanVien (\n" +
                "                        MaNV,\n" +
                "                        TenNV,\n" +
                "                        SoDT,\n" +
                "                        GioiTinh,\n" +
                "                       DiaChi,\n" +
                "                        Email,\n" +
                "                      Luong,\n" +
                "                       Ngaysinh,\n" +
                "                        MaPB\n" +
                "                    )\n" +
                "                    VALUES (\n" +
                "                        5,\n" +
                "                        'Trần Nữ Như Quỳnh',\n" +
                "                        '01633968489',\n" +
                "                        'Nữ',\n" +
                "                        'Huế',\n" +
                "                        'trnnq@gmail.com',\n" +
                "                        300000,\n" +
                "                        '20-5-1995',\n" +
                "                        1\n" +
                "                    );\n");


>>>>>>> f8adcdc7edad66d985116ddb75e7dd8aa7fe6704
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CROP TABLE IF EXISTS "+TABLE_PHONGBAN);
        db.execSQL("CROP TABLE IF EXISTS "+TABLE_NHANVIEN);
        onCreate(db);
    }
}
