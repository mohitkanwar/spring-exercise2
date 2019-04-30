package com.mk.springboot.tutorial.bitcoins.repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mk.springboot.tutorial.bitcoins.model.BitCoinDataModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Repository
@Qualifier("online")
public class BitCoinOnlinePriceRepository implements BitCoinPriceRepository {

    @Override
    public BitCoinDataModel getPriceData(Optional<String> currency) {
        BitCoinDataModel model = new BitCoinDataModel();
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        if(currency.isPresent()){
            url = url.replace(".json","/"+currency.get()+".json");
        }

        try {
            String response = run(url);
            JsonParser jsonParser = new JsonParser();
            String time = jsonParser.parse(response)
                    .getAsJsonObject().getAsJsonObject("time")
                    .getAsJsonPrimitive("updated").getAsString();
            DateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss Z");

          model.setTime(sdf.parse(time));
          model.setChartName("ONLINE");
          model.setDisclaimer(jsonParser.parse(response)
                  .getAsJsonObject().getAsJsonPrimitive("disclaimer").getAsString());

              JsonObject currencyData = jsonParser.parse(response)
                      .getAsJsonObject().getAsJsonObject("bpi").getAsJsonObject(currency.orElse("USD").toUpperCase());
              model.setCurrencyRate(currencyData.getAsJsonPrimitive("rate").getAsString());
              model.setCurrencyCode(currencyData.getAsJsonPrimitive("code").getAsString());
              model.setCurrencyDescription(currencyData.getAsJsonPrimitive("description").getAsString());
        } catch (IOException|ParseException e) {
            throw new RuntimeException(e);
        }


        return model;
    }

    String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
