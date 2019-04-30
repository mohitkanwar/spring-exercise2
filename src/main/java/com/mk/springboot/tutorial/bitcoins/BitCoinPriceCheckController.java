package com.mk.springboot.tutorial.bitcoins;

import com.mk.springboot.tutorial.bitcoins.formobjects.BitCoinPriceData;
import com.mk.springboot.tutorial.bitcoins.service.BitCoinPriceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BitCoinPriceCheckController {

    @Autowired
    private BitCoinPriceCheckService bitCoinPriceCheckService;


    public BitCoinPriceData getCurrentPriceforCurrency(Optional<String> currency){
       return bitCoinPriceCheckService.getPrice(currency);
    }
}
