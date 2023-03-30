package com.dev.services.impls;

import com.dev.models.Employee;
import com.dev.services.AbsEmployeeService;


public class EmployeeServiceImpl extends AbsEmployeeService {

    private String msgString;

    public String getMsgString() {
        return msgString;
    }

    public void setMsgString(String msgString) {
        this.msgString = msgString;
    }

    public EmployeeServiceImpl(String msgString) {
        this.msgString = msgString;
    }

    @Override
    protected String getString(String text) {
        return text;
    }
}
