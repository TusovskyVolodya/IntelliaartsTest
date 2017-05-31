package com.intelliarts.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelliarts.exception.IncorrectRateException;
import com.intelliarts.model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utils {
    public static Date parseDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Double currencyConverter(Double costs, Currency fromCurrency, Currency toCurrency) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = fixerCurrencyReader(fromCurrency.name(), toCurrency.name());
        if(jsonString == null) {
            throw new IncorrectRateException();
        }
        Double result = costs;
        try {
            JsonNode rootNode = mapper.readTree(jsonString);
            double rate = Double.parseDouble(rootNode.get("rates").get(toCurrency.name()).asText());
            result = costs * rate;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String fixerCurrencyReader(String fromCurrency, String toCurrency) {
        try {
            URL url = new URL("http://api.fixer.io/latest?symbols=" + fromCurrency + "," + toCurrency);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            reader.close();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
