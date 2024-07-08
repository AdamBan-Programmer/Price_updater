package org.example.Connection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Items.UpdatedItem;
import org.glassfish.jaxb.runtime.v2.runtime.output.Encoded;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Steam_Connection {

    //returns items price from steam market (API)
    public String getSteamPriceByName(String itemName) throws JsonProcessingException {
        URI uri = UriComponentsBuilder
                .fromUriString("https://steamcommunity.com/market/priceoverview/?currency=6&appid=730&")
                .queryParam("market_hash_name", itemName)
                .encode()
                .build().toUri();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        UpdatedItem item = objectMapper.readValue(result, UpdatedItem.class);
        return item.getPrice();
    }
}
