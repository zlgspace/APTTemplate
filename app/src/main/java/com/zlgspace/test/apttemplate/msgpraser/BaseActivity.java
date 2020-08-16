package com.zlgspace.test.apttemplate.msgpraser;

import android.os.Bundle;


public class BaseActivity extends CallbackAdapterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParserManager.register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        ParserManager.unRegister(this);
    }
}
