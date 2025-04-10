package com.deltacodex.rmi;

import com.deltacodex.rmi.Client.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageImpl extends UnicastRemoteObject implements Message {

    MessageImpl() throws RemoteException {
        super();
    }

    @Override
    public String New_message(String name) throws RemoteException {
        return "Hello " + name;
    }
}
