package com.mk.springboot.tutorial.bitcoins.repository;

import com.mk.springboot.tutorial.bitcoins.model.BitCoinDataModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
@Qualifier("offline")
public class BitCoinOfflinePriceRepository implements BitCoinPriceRepository {
    @Override
    public BitCoinDataModel getPriceData(Optional<String> currency) {
        BitCoinDataModel offlineDataModel = new BitCoinDataModel();
        offlineDataModel.setTime(new Date());
        offlineDataModel.setCurrencyDescription("Description not available");
        offlineDataModel.setCurrencyRate("Not Available");
        offlineDataModel.setCurrencyCode(currency.orElse("USD").toUpperCase());
        offlineDataModel.setDisclaimer("These are hard coded values, retrieved in offline mode");
        offlineDataModel.setChartName("OFFLINE");
        return offlineDataModel;
    }
}
