package org.example.Connection;

import org.example.Items.ObservedItem;
import org.example.Settings.HibernateSettings;
import org.example.Items.UpdatedItem;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public class SQL_Operations {

    HibernateSettings hibernateSettingsController = new HibernateSettings();

    //returns open session
    private Session getConnectionWithDB() throws ServiceException, NullPointerException {
        return hibernateSettingsController.getHibernateProperty().openSession();
    }

    //returns list of items added to 'observed' table
    public List<ObservedItem> getObservedItems() throws ServiceException, NullPointerException {
        SQLQuery query = getConnectionWithDB().createSQLQuery("CALL GetObservedItems();");
        query.addEntity(ObservedItem.class);
        return query.list();
    }

    //sends items price record to 'results' table
    public void sendUpdatedDataIntoDb(UpdatedItem itemToSend) throws ServiceException, NullPointerException {
        Session session = getConnectionWithDB();
        session.beginTransaction();
        session.save(itemToSend);
        session.getTransaction().commit();
        session.close();
    }

    //increase's item updates number
    public void increaseItemUpdatesNumber(int index) {
        Session session = getConnectionWithDB();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("CALL UpdateObservedItem(" + index + ");");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    //increase's updater
    public void increaseUpdatesCounter() {
        Session session = getConnectionWithDB();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("CALL IncreaseUpdatesCounter();");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
