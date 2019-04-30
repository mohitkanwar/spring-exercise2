package com.mk.springboot.tutorial.bitcoins.repository;

import com.mk.springboot.tutorial.bitcoins.model.BitCoinDataModel;

import java.util.Optional;

public interface BitCoinPriceRepository {
    BitCoinDataModel getPriceData(Optional<String> currency);
}
