package org.example.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public String getSystemDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date).toString();
    }

}
