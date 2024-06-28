package org.example.Connection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Items.UpdatedItem;
import org.springframework.web.client.RestTemplate;

public class Steam_Connection {

    //returns items price from steam market (API)
    public String getSteamPriceByName(String itemName) throws JsonProcessingException {
        final String uri = "https://steamcommunity.com/market/priceoverview/?currency=6&appid=730&market_hash_name=" + itemName;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        UpdatedItem item = objectMapper.readValue(result, UpdatedItem.class);
        return item.getPrice();
    }
}
