package com.dev;

import com.dev.services.impls.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[]args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"web.xml"});
        EmployeeServiceImpl employeeService =  context.getBean("employeeServiceImpl", EmployeeServiceImpl.class);
        employeeService.getMsgString();
    }
}
