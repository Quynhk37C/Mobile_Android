package com.hue.husc.it.nhuquynh.quanlynv.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hue.husc.it.nhuquynh.quanlynv.DTO.PhongBanDTO;

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

    public void themPhongBan(PhongBanDTO phongban){
        db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.TABLE_PHONGBAN,phongban.getTenPhongBan());
        db.insert(Database.TABLE_PHONGBAN,null,values);
        db.close();
    }
}
