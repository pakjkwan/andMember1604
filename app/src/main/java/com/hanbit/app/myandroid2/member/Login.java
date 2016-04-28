package com.hanbit.app.myandroid2.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.hanbit.app.myandroid2.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void onClick(View v){
        MemberService service = new MemberServiceImpl();
        MemberDTO member = new MemberDTO();
        EditText uid = (EditText) findViewById(R.id.loginUid);
        EditText password = (EditText) findViewById(R.id.loginPassword);
        member.setUid(uid.toString());
        member.setPassword(password.toString());
        switch (v.getId()){
            case R.id.loginBtn :service.join(member);break;
        }
    }

}
