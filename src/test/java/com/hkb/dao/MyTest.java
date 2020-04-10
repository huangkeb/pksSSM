package com.hkb.dao;

import com.hkb.pojo.Park;
import com.hkb.service.ParkService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ParkService park = context.getBean("park", ParkService.class);
        List<Park> parks = park.selectPark();
        for (Park park1 : parks) {
            System.out.println(park1);
        }
    }
}
