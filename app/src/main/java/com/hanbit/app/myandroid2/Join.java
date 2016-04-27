package com.hanbit.app.myandroid2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Join extends Activity {
    public MemberDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = MemberDAO.getInstance(this);
        setContentView(R.layout.join);

    }
    public void onClick(View v){
        EditText uid = (EditText) findViewById(R.id.joinUid);
        EditText password = (EditText) findViewById(R.id.joinPassword);
        EditText name = (EditText) findViewById(R.id.joinName);
        switch (v.getId()){
            case R.id.joinBtn :
               /* ContentValues values = new ContentValues();
                values.put("uid", uid.getText().toString());
                values.put("password", password.getText().toString());
                values.put("name", name.getText().toString());*/
                dao.insert(uid.getText().toString(),
                        password.getText().toString(),
                        name.getText().toString());
                break;
            case R.id.loginBtn :
                break;
        }


    }

}
