package org.example.Settings;
public class AppSettings {

    private String ipAddress;
    private int port;
    private String dbName;
    private String login;
    private String password;

    private static AppSettings currentAppSettings;

    private AppSettings(String ipAddress, int port, String dbName, String login, String password) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.dbName = dbName;
        this.login = login;
        this.password = password;
    }

    public AppSettings()
    {
        //nothing
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDbName() {
        return this.dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppSettings getCurrentAppSettings() {
        if(currentAppSettings == null)
        {
            currentAppSettings = new AppSettings("",0,"","","");
        }
        return currentAppSettings;
    }

    public void setAppSettings(String[] args){
        if(args.length == 5) {
            currentAppSettings = new AppSettings(args[0], Integer.parseInt(args[1]), args[2], args[3], args[4]);
        }
        else {
            currentAppSettings = new AppSettings("192.168.0.64",3307,"steam_market","adam_room","Inventory123#");
        }
    }
}
