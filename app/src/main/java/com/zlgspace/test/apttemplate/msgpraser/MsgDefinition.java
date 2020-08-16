package com.zlgspace.test.apttemplate.msgpraser;


import com.zlgspace.msgpraser.annotation.BindEntity;
import com.zlgspace.msgpraser.annotation.CallbackInterface;
import com.zlgspace.test.apttemplate.msgpraser.bean.ABean;
import com.zlgspace.test.apttemplate.msgpraser.bean.BBean;
import com.zlgspace.test.apttemplate.msgpraser.bean.CBean;
import com.zlgspace.test.apttemplate.msgpraser.bean.DBean;
import com.zlgspace.test.apttemplate.msgpraser.bean.EBean;

@CallbackInterface
public enum MsgDefinition {
    @BindEntity(ABean.class) A,
    @BindEntity(BBean.class) B,
    @BindEntity(CBean.class) C,
    @BindEntity(DBean.class) D,
    @BindEntity(EBean.class) E,
    @BindEntity F,
}
