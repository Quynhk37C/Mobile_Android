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
        db.execSQL("INSERT INTO PhongBan (\n" +
                "                        MaPB,\n" +
                "                        TenPB\n" +
                "                    )\n" +
                "                    VALUES (\n" +
                "                        2,\n" +
                "                        'Khoa toán'\n" +
                "                    );\n");
        db.execSQL("INSERT INTO PhongBan (\n" +
                "                        MaPB,\n" +
                "                        TenPB\n" +
                "                    )\n" +
                "                    VALUES (\n" +
                "                        3,\n" +
                "                        'Khoa lý'\n" +
                "                    );\n");
        db.execSQL(taoBangNhanVien);

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
                "                        3000000,\n" +
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
                "                        3000000,\n" +
                "                        '20-5-1995',\n" +
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
                "                        6,\n" +
                "                        'Lê Văn Lưu',\n" +
                "                        '01633968489',\n" +
                "                        'Nam',\n" +
                "                        'Huế',\n" +
                "                        'trnnq@gmail.com',\n" +
                "                        3000000,\n" +
                "                        '10-5-1995',\n" +
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
                "                        7,\n" +
                "                        'Hồ Văn Anh',\n" +
                "                        '0163396848',\n" +
                "                        'Nam',\n" +
                "                        'Huế',\n" +
                "                        'trnnq@gmail.com',\n" +
                "                        3000000,\n" +
                "                        '10-5-1899',\n" +
                "                        2\n" +
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
                "                        8,\n" +
                "                        'Hồ Văn Anh',\n" +
                "                        '0163396848',\n" +
                "                        'Nam',\n" +
                "                        'Huế',\n" +
                "                        'trnnq@gmail.com',\n" +
                "                        3000000,\n" +
                "                        '10-5-1899',\n" +
                "                        2\n" +
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
                "                        9,\n" +
                "                        'Nguyên Vĩnh',\n" +
                "                        '01219166501',\n" +
                "                        'Nam',\n" +
                "                        'Thanh Hóa',\n" +
                "                        'nguyenvinh@gmail.com',\n" +
                "                        5000000,\n" +
                "                        '10-5-1899',\n" +
                "                        3\n" +
                "                    );\n");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CROP TABLE IF EXISTS "+TABLE_PHONGBAN);
        db.execSQL("CROP TABLE IF EXISTS "+TABLE_NHANVIEN);
        onCreate(db);
    }
}
