package com.hanbit.app.myandroid2.member;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hanbit.app.myandroid2.R;

public class Join extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

    }
    public void onClick(View v){
        MemberService service = new MemberServiceImpl();
        MemberDTO member = new MemberDTO();
        EditText uid = (EditText) findViewById(R.id.joinUid);
        EditText password = (EditText) findViewById(R.id.joinPassword);
        EditText name = (EditText) findViewById(R.id.joinName);
        member.setUid(uid.toString());
        member.setPassword(password.toString());
        member.setName(name.toString());
        switch (v.getId()){
            case R.id.joinBtn :service.join(member);break;
        }
    }

}
