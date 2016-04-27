package com.hanbit.app.myandroid2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by USER on 2016-04-27.
 */
public class MemberDAO {
    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public static final String DB_HANBIT = "HANBIT.db";
    public static final String TABLE_MEMBER = "MEMBER";
    public static final int DB_VERSION = 1;

    Context mContext = null;
    private static MemberDAO instance = null;
    private SQLiteDatabase sqlLite = null;

    public static MemberDAO getInstance(Context context){
        if (instance == null){
            instance = new MemberDAO(context);
        }
        return instance;
    }
    private MemberDAO(Context context){
        mContext = context;
        sqlLite = context.openOrCreateDatabase(
                DB_HANBIT,
                Context.MODE_PRIVATE,
                null
        );
        // 만일 DB 에 테이블이 존재하지 않으면 생성한다
        sqlLite.execSQL("CREATE TABLE IF NOT EXIST"
                        + TABLE_MEMBER
                        + "( uid TEXT PRIMARY KEY,"
                        + "password TEXT,"
                        + "name TEXT);"
        );
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수

    public void insert(String uid, String password, String name) {
        // DB에 입력한 값으로 행 추가
        sqlLite.execSQL("INSERT INTO MEMBER VALUES('" + uid + "', " + password + ", '" + name + "');");
        sqlLite.close();
    }

    public void update(String password, String uid) {
        // 입력한 항목과 일치하는 행의 가격 정보 수정
        sqlLite.execSQL("UPDATE MEMBER SET password=" + password + " WHERE uid='" + uid + "';");
        sqlLite.close();
    }

    public void delete(String uid) {
        // 입력한 항목과 일치하는 행 삭제
        sqlLite.execSQL("DELETE FROM MEMBER WHERE uid='" + uid + "';");
        sqlLite.close();
    }

    public String getResult(String uid) {
        // 읽기가 가능하게 DB 열기
        sqlLite.execSQL("DELETE FROM MEMBER WHERE uid='" + uid + "';");
        sqlLite.close();
        String result = "";
        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = sqlLite.rawQuery("SELECT * FROM MEMBER", null);
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



}
