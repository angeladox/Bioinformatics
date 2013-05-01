package org.adoxsey.bioinformatics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TempMain {

    private static String Display_Name = "CFTR";
    static Initializer init;
    
    @Autowired
    public TempMain(Initializer init){
        TempMain.init=init;
    }

    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TempMain tm = (TempMain)context.getBean("TempMain");
    }
    


}
