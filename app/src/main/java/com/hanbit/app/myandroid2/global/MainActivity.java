package com.hanbit.app.myandroid2.global;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hanbit.app.myandroid2.R;
import com.hanbit.app.myandroid2.admin.Admin;
import com.hanbit.app.myandroid2.board.Board;
import com.hanbit.app.myandroid2.member.Member;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.adminBtn :
                startActivity(new Intent(this,Admin.class));break;
            case R.id.userBtn :
                startActivity(new Intent(this,Member.class));break;
            case R.id.boardBtn :
                startActivity(new Intent(this,Board.class));break;
        }
    }
}
/*
new Intent(this,Admin.class)
1번파라미터 : 같은 패키지 클래스는 this 가능
2번파라미터 : 클래스명 호출되면 같이 생성된 xml 파일이 호출됨
* */