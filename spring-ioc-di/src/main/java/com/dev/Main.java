package com.dev;

import com.dev.config.AppConfig;
import com.dev.services.MailService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[]args){
        /*
        MailService mailService = new MailService();
        mailService.sendEmail("abc@gmail.com","welcome from MR !");
        */

        /*
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        MailService mailService = beanFactory.getBean("mailService",MailService.class);
        mailService.sendEmail("abc@gmail.com","welcome from MR !");
         */

        /*
       BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
       MailService mailService = (MailService) beanFactory.getBean("mailService");
       mailService.sendEmail("abc@gmail.com", "welcome from MR >>>");
         */

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MailService mailService = context.getBean("mailService",MailService.class);
        System.out.println(mailService);
        mailService.sendEmail("abc@gmail.com", "welcome from MR :::");


        ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        MailService mailService1 = context1.getBean("mailService",MailService.class);
        System.out.println(mailService1);
        mailService1.sendEmail("bcd@gmail.com", "welcome from HR :::");


        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        MailService mailService2 = context2.getBean("mailService",MailService.class);
        System.out.println(mailService2);
        mailService2.sendEmail("cdf@gmail.com", "welcome from CR :::");


        ApplicationContext context3 = new ClassPathXmlApplicationContext("spring.xml");
        MailService prMailService3 = context3.getBean("prototypeMailService",MailService.class);
        System.out.println(prMailService3);
        prMailService3.sendEmail("kuo@gmail.com", "welcome from KR :::");

        ApplicationContext context4 = new ClassPathXmlApplicationContext("spring.xml");
        MailService prMailService4 = context4.getBean("prototypeMailService",MailService.class);
        System.out.println(prMailService4);
        prMailService4.sendEmail("uhg@gmail.com", "welcome from PR :::");


    }
}
