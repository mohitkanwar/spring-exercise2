package com.mk.springboot.tutorial;

import com.mk.springboot.tutorial.bitcoins.BitCoinPriceCheckController;
import com.mk.springboot.tutorial.bitcoins.formobjects.BitCoinPriceData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        BitCoinPriceCheckController bitCoinPriceCheckController = applicationContext.getBean(BitCoinPriceCheckController.class);

        BitCoinPriceData data = bitCoinPriceCheckController.getCurrentPriceforCurrency(Optional.empty());
        System.out.println(data);

        BitCoinPriceData dataINR = bitCoinPriceCheckController.getCurrentPriceforCurrency(Optional.of("INR"));
        System.out.println(dataINR);
    }
}
