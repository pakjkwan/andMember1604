package com.hanbit.app.myandroid2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class JoinActivity extends Activity {
    private String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        EditText joinUid = (EditText) findViewById(R.id.joinUid);
        EditText joinPassword = (EditText) findViewById(R.id.joinPassword);
        EditText joinName = (EditText) findViewById(R.id.joinName);

        String uid = joinUid.getText().toString();
        String password = joinPassword.getText().toString();
        String name = joinName.getText().toString();

                /*result.setText(memberDAO.getResult());*/
    }

}
