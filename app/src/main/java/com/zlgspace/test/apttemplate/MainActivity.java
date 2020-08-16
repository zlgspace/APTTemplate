package com.zlgspace.test.apttemplate;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zlgspace.msgpraser.annotation.CallbackMethod;
import com.zlgspace.test.apttemplate.msgpraser.BaseActivity;
import com.zlgspace.test.apttemplate.msgpraser.MsgDefinition_Callback;
import com.zlgspace.test.apttemplate.msgpraser.ParserManager;
import com.zlgspace.test.apttemplate.msgpraser.bean.ABean;
import com.zlgspace.test.apttemplate.singleinstance.DeviceType;
import com.zlgspace.test.apttemplate.singleinstance.SingleDeviceState;

public class MainActivity  extends BaseActivity {

    private static final String TAG = "MainActivity";

    private String msgA = "{" +
            "\"head\":\"A\"," +
            "\"body\":{\"name\":\"张三\"}" +
            "}";

    private String msgB = "{" +
            "\"head\":\"B\"," +
            "\"body\":{\"name\":\"李三\"}" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //这里是通过按钮模拟发送消息
        findViewById(R.id.mABtn).setOnClickListener(view -> {
            ParserManager.getCallback().callback(msgA);
        });

        findViewById(R.id.mBBtn).setOnClickListener(view -> {
            ParserManager.getCallback().callback(msgB);
        });

        findViewById(R.id.mCBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingleDeviceState.setDevName("ZLG");
                SingleDeviceState.setDevType(DeviceType.PHONE);
                SingleDeviceState.setRunning(true);
            }
        });

        findViewById(R.id.mDBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"SingleDeviceState:"+SingleDeviceState.getDeviceStateInstance().toString());
            }
        });
    }


    //必须要通过@CallbackMethod注解标记函数，才能被正确回调，这里是以函数名称为消息号进行回调的示例
    @CallbackMethod
    public void A(ABean a) {
        Log.d(TAG,"rcv A msg");
    }

    //这里是对回调函数绑定了消息号，进行回调示例
    @CallbackMethod(MsgDefinition_Callback.B)
    public void confStart(){
        Log.d(TAG,"rcv B msg");
    }

}