package com.mk.springboot.tutorial.bitcoins.service;

import com.mk.springboot.tutorial.bitcoins.formobjects.BitCoinPriceData;
import com.mk.springboot.tutorial.bitcoins.model.BitCoinDataModel;
import com.mk.springboot.tutorial.bitcoins.repository.BitCoinPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BitCoinPriceCheckDefaultService implements BitCoinPriceCheckService {

    @Autowired
    @Qualifier("offline")
    private BitCoinPriceRepository offlineRepository;

    @Autowired
    @Qualifier("online")
    private BitCoinPriceRepository onlineRepository;
    @Override
    public BitCoinPriceData getPrice(Optional<String> currency) {
        BitCoinDataModel bitCoinData;
        try {
            bitCoinData = onlineRepository.getPriceData(currency);
        }
        catch (RuntimeException e) {
            bitCoinData =offlineRepository.getPriceData(currency);
        }

        return getPriceDataFromModel(bitCoinData);
    }

    private BitCoinPriceData getPriceDataFromModel(BitCoinDataModel bitCoinData) {
        BitCoinPriceData priceData = new BitCoinPriceData();
        priceData.setChartName(bitCoinData.getChartName());
        priceData.setCurrencyCode(bitCoinData.getCurrencyCode());
        priceData.setCurrencyDescription(bitCoinData.getCurrencyDescription());
        priceData.setCurrencyRate(bitCoinData.getCurrencyRate());
        priceData.setDisclaimer(bitCoinData.getDisclaimer());
        priceData.setTime(bitCoinData.getTime());
        return priceData;
    }
}
