package org.example.Main;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.Connection.SQL_Operations;
import org.example.Connection.ServerError;
import org.example.Connection.Steam_Connection;
import org.example.Items.ObservedItem;
import org.example.Items.UpdatedItem;
import org.example.Settings.AppSettings;
import org.example.Utils.DateFormatter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import java.util.List;


@SpringBootApplication
public class Main {
    static AppSettings settingsController = new AppSettings();
    static ServerError serverErrorController = new ServerError();
    static Steam_Connection steamReaderController = new Steam_Connection();
    static SQL_Operations databaseController = new SQL_Operations();
    static DateFormatter systemDataController = new DateFormatter();

    // 1. IP    2. port     3.dbName    4. login    5.password
    public static void main(String[] args) {
        try {
            settingsController.setAppSettings(args);
            List<ObservedItem> observedItemList = databaseController.getObservedItems();
            updateObservedItems(observedItemList);
            databaseController.increaseUpdatesCounter();

        } catch (HttpServerErrorException.InternalServerError | JsonProcessingException e) {
            serverErrorController.internalServerError();
        } catch (HttpClientErrorException.TooManyRequests e) {
            serverErrorController.tooManyRequestError();
        } finally {
            System.exit(0);
        }
    }

    private static void updateObservedItems(List<ObservedItem> observedItemList) throws JsonProcessingException {
        for (int i = 0; i < observedItemList.size(); i++) {
            ObservedItem observedItem = observedItemList.get(i);
            UpdatedItem updatedItem = setUpdatedItemParams(observedItem);
            databaseController.sendUpdatedDataIntoDb(updatedItem);
            databaseController.increaseItemUpdatesNumber(updatedItem.getObservedId());
            System.out.println("Record Updated: " + (i + 1) + " / " + observedItemList.size());
        }
    }

    private static UpdatedItem setUpdatedItemParams(ObservedItem observedItemToUpdate) throws JsonProcessingException {
        int AUTO_INCREMENT = 0;
        String logDate = systemDataController.getSystemDate();
        int observedId = observedItemToUpdate.getId();
        String price = steamReaderController.getSteamPriceByName(observedItemToUpdate.getName());
        return new UpdatedItem(AUTO_INCREMENT, price, logDate, observedId);
    }
}