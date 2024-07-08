# Steam Price Updater:
It's a simple script updating price of items by getting data from Steam. It's a second part of my project, where i created an application for traders on steam market. Main application was written in Android Java. You can add items which you want to track. Item price updates time depends on how many items you have added to observe. It helps to buy and sell an items in optimal moments. 

# About:
- I created this app to make better decisions on Steam market. In this code i used Spring Boot and Hibernate framework. I had to create my own database using MariaDB and phpmyadmin. This application read items price using Steam API and sends it into database. 

# How to use:
1. Create your database.
2. click 'code' and 'download ZIP'
3. Unpack ZIP folder and open it into Intellij.
4. Modify database name and columne's names in code.
5. Build an artifact.
6. Create bash script.
7. Run jar file with starting parameters in the Command Line.

# Example:
- starting parameters: 1.IP 2.Port 3.Database_name 4.Login 5.Password

java -jar C:\Users\...\SteamPriceUpdater.jar 192.168.0.6 3307 myDbName mylogin myPassword

![price_updater_effect](https://github.com/AdamBan-Programmer/Steam_price_updater/assets/137770072/c955949a-238c-4026-82f4-9ba0f1deff77)


![image](https://github.com/AdamBan-Programmer/Steam_price_updater/assets/137770072/352a0540-2d4f-46db-af82-1568d974404a)




# Requirements:
- Windows 10.

- Java 17 or higher.

