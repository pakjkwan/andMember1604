package com.hanbit.app.myandroid2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hanbit.app.myandroid2.global.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-04-27.
 */
public class MemberDAO extends SQLiteOpenHelper{
    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음


    public MemberDAO(Context context) {
        super(context, Constants.DB_HANBIT, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXIST"
                        + Constants.TABLE_MEMBER
                        + "( uid TEXT PRIMARY KEY,"
                        + "password TEXT,"
                        + "name TEXT);"
        );
    }
// 데이터베이스 종류와 버전이 변경되면 실행하여 종류변경 및 버전업 한다
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Member");
        this.onCreate(db);
    }

    public void insert(MemberDTO member) {
        SQLiteDatabase db = this.getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO Member VALUES('" + member.getUid() + "', "
                + member.getPassword() + ", '" + member.getName() + "');");
        db.close();
    }
    public List<MemberDTO> selectAll(){
        List<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }
    public List<MemberDTO> selectByName(MemberDTO member){
        List<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }
    public MemberDTO selectByID(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO login(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public int count(){
        return 0;
    }
    public String getResult(MemberDTO member) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Member WHERE uid='" + member.getUid() + "';");
        db.close();
        String result = "";
        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM Member", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " , "
                    + cursor.getString(1)
                    + " , "
                    + cursor.getString(2)
                    + "\n";
        }

        return result;
    }

    public void update(MemberDTO member) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Member SET password=" + member.getPassword() + " WHERE uid='" + member.getUid() + "';");
        db.close();
    }

    public void delete(MemberDTO member) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Member WHERE uid='" + member.getUid() + "';");
        db.close();
    }



}
