package com.hanbit.app.myandroid2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by USER on 2016-04-27.
 */
public class MemberActivity2 extends Activity {
    private Context context;
    MemberDAO memberDAO = new MemberDAO(context,
            "Member.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        context = this;

        findViewById(R.id.joinBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText joinUid = (EditText)findViewById(R.id.joinUid);
                EditText joinPassword = (EditText)findViewById(R.id.joinPassword);
                EditText joinName = (EditText)findViewById(R.id.joinName);

                String uid = joinUid.getText().toString();
                String password = joinPassword.getText().toString();
                String name = joinName.getText().toString();

                memberDAO.insert(uid, password, name);
                /*result.setText(memberDAO.getResult());*/

            }
        });
        findViewById(R.id.loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText loginUid = (EditText)findViewById(R.id.loginUid);
                EditText loginPassword = (EditText)findViewById(R.id.loginPassword);
                String uid = loginUid.getText().toString();
                String password = loginPassword.getText().toString();
               /* result.setText(memberDAO.getResult());*/
            }
        });
        findViewById(R.id.boardBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        findViewById(R.id.writeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

}
