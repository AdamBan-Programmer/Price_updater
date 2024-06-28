package org.example.Connection;

public class ServerError {

    public void tooManyRequestError()
    {
        System.out.println("Too many Requests !");
        System.exit(0);
    }

    public void internalServerError()
    {
        System.out.println("Item updating failed.");
    }
}
