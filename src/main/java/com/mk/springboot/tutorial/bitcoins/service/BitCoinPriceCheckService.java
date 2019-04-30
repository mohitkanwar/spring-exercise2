package com.mk.springboot.tutorial.bitcoins.service;

import com.mk.springboot.tutorial.bitcoins.formobjects.BitCoinPriceData;

import java.util.Optional;

public interface BitCoinPriceCheckService {
    BitCoinPriceData getPrice(Optional<String> currency);

}
