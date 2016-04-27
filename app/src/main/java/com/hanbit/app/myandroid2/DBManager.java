package com.hanbit.app.myandroid2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by USER on 2016-04-27.
 */
public class DBManager {
    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "Hanbit.db";
    static final String TABLE_STUDENTS = "Students";

    Context mContext = null;
    private static DBManager mDbManager = null;
    private SQLiteDatabase mDatabase = null;

    public static DBManager getInstance(Context context){
        if (mDbManager == null){
            mDbManager = new DBManager(context);
        }
        return mDbManager;
    }
    private DBManager(Context context){
        mContext = context;
        // 만일 DB 에 테이블이 존재하지 않으면 생성한다
        mDatabase.execSQL("CREATE TABLE IF NOT EXIST"
               + TABLE_STUDENTS
               + "( uid TEXT PRIMARY KEY,"
               + "password TEXT,"
               + "name TEXT);"
        );
    }
    public long insert(ContentValues val){
        /*
        execSQL 메소드를 이용해서 직접 SQL 문으로 레코드에 추가하기
        mDatabase.execSQL("INSERT INTO TABLE_STUDENTS(uid,password,name)"
        +"VALUES('"+hong+"','"+1+"','"+홍길동+"')")
        반환값은 몇번째 행에 입력되었는 지 값을 알려주고
        그 타입은 long 이다
        * */
        return mDatabase.insert(TABLE_STUDENTS,null,val);
    }

}
