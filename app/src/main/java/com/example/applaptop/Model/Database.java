package com.example.applaptop.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public Database(@Nullable Context context) {
        super(context, "dinhvuong.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(email varchar PRIMARY KEY, " +
                "password varchar," +
                "name varchar," +
                "SDT varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(db);
    }

    // Kiểm tra email tồn tai chưa
    public boolean checkEmail(String email) {
        db = this.getReadableDatabase();
        String sql = "select * from Users where email = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{email});
        return cursor.getCount() > 0;
    }

    // Chức năng đăng ký
    public boolean insert(String email, String password, String name, String sdt) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("SDT", sdt);
        long result = db.insert("Users", null, contentValues);
        return result > 0;
    }

    public boolean insertSanPham(String  name, int gia, String  loai) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("gia", gia);
        contentValues.put("loai",loai);
        long result = db.insert("sanpham",null,contentValues);
        return result > 0;
    }


    // chức năng đăng nhập
    public boolean login(String email, String password) {
        db = this.getReadableDatabase();
        String sql = "select * from Users where email = ? and password = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{email, password});

        if (cursor.getCount() > 0) return true;
        else return false;
    }

    // lấy thong tin user
    public User getUser(String email) {
        User s = new User();
        db = this.getReadableDatabase();
        String sql = "select * from Users where email = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{email});
        if (cursor != null) {
            cursor.moveToNext();
            s.setEmail(email);
            s.setPassword(cursor.getString(1));
            s.setName(cursor.getString(2));
            s.setPhone(cursor.getString(3));

            return s;
        }
        return null;
    }

    public boolean checkPhone_Email(String phone, String email) {
        db = this.getReadableDatabase();
        String sql = "select * from Users where SDT = ? and email = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{phone, email});

        return cursor.getCount() > 0;
    }

    public Boolean changePassword(String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", pass);
        int result = db.update("Users", values, "email = ? ", new String[]{email});
        return result > 0;
    }

    public Boolean updateInfo(User s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", s.getEmail());
        values.put("password", s.getPassword());
        values.put("name", s.getName());
        values.put("SDT", s.getPhone());
        int result = db.update("Users", values, "email = ? ", new String[]{s.getEmail()});
        return result > 0;
    }

//    public ArrayList<LapTop> getAllData() {
//        ArrayList<LapTop> list = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "select * from Product";
//        Cursor rs = db.rawQuery(sql, null);
//        if (rs != null) {
//            while (rs.moveToNext()) {
//                String id = rs.getString(0);
//                String name = rs.getString(1);
//                String cpu = rs.getString(2);
//                String ram = rs.getString(3);
//                String disk = rs.getString(4);
//                Double price = rs.getDouble(5);
//                String preview = rs.getString(6);
//                String screen = rs.getString(7);
//                String type = rs.getString(8);
//                LapTop e = new LapTop(id, name, cpu, ram, disk, price, preview, screen, type);
//                list.add(e);
//            }
//        }
//        return list;
//    }
//
//    public ArrayList<LapTop> getListProduct(String types) {
//        ArrayList<LapTop> list = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "select * from Product where type = ?";
//        Cursor rs = db.rawQuery(sql, new String[]{String.valueOf(types)});
//        if (rs != null) {
//            while (rs.moveToNext()) {
//                String id = rs.getString(0);
//                String name = rs.getString(1);
//                String cpu = rs.getString(2);
//                String ram = rs.getString(3);
//                String disk = rs.getString(4);
//                Double price = rs.getDouble(5);
//                String preview = rs.getString(6);
//                String screen = rs.getString(7);
//                String type = rs.getString(8);
//                LapTop e = new LapTop(id, name, cpu, ram, disk, price, preview, screen, type);
//                list.add(e);
//            }
//        }
//        return list;
//    }
//
//    public LapTop getLapTop(String pid) {
//        LapTop e = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "Select * from Product where id = ?";
//        Cursor rs = db.rawQuery(sql, new String[]{String.valueOf(pid)});
//        if (rs != null) {
//            rs.moveToNext();
//            String id = rs.getString(0);
//            String name = rs.getString(1);
//            String cpu = rs.getString(2);
//            String ram = rs.getString(3);
//            String disk = rs.getString(4);
//            Double price = rs.getDouble(5);
//            String preview = rs.getString(6);
//            String screen = rs.getString(7);
//            String type = rs.getString(8);
//            e = new LapTop(id, name, cpu, ram, disk, price, preview, screen, type);
//        }
//        return e;
//    }
//
//    public boolean addProduct(LapTop e) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("id", e.getId());
//        values.put("name", e.getName());
//        values.put("cpu", e.getCpu());
//        values.put("ram", e.getRam());
//        values.put("disk", e.getDisk());
//        values.put("price", e.getPrice());
//        values.put("preview", e.getPreview());
//        values.put("screen", e.getScreen());
//        values.put("type", e.getType());
//        long result = db.insert("LapTop", null, values);
//        return result > 0;
//    }

}
