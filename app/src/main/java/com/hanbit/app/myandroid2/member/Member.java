package com.hanbit.app.myandroid2.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hanbit.app.myandroid2.R;

public class Member extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.loginFormBtn :
                startActivity(new Intent(this,Login.class));break;
            case R.id.joinFormBtn :
                startActivity(new Intent(this,Join.class));break;
        }
    }

}
