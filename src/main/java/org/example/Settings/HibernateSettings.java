package org.example.Settings;

import org.example.Items.ObservedItem;
import org.example.Items.UpdatedItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.spi.ServiceException;

public class HibernateSettings {

    AppSettings settingsController = new AppSettings();

    // Hibernate connection settings
    public SessionFactory getHibernateProperty() throws NullPointerException {
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", "jdbc:mysql://" + settingsController.getCurrentAppSettings().getIpAddress() + ":" + settingsController.getCurrentAppSettings().getPort() + "/" + settingsController.getCurrentAppSettings().getDbName())
                    .setProperty("hibernate.connection.username", settingsController.getCurrentAppSettings().getLogin())
                    .setProperty("hibernate.connection.password", settingsController.getCurrentAppSettings().getPassword())
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            configuration.addAnnotatedClass(ObservedItem.class);
            configuration.addAnnotatedClass(UpdatedItem.class);
            return configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
