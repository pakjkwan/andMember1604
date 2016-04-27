package com.hanbit.app.myandroid2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MemberActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);
        findViewById(R.id.joinBtn).setOnClickListener(redirectPageTo(JoinActivity.class));
        findViewById(R.id.loginBtn).setOnClickListener( redirectPageTo(Login.class) );
    }

    private View.OnClickListener redirectPageTo(final Class klazz) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), klazz));
            }
        };
    }

}
