package com.deltacodex.rmi.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Message extends Remote {
    public String New_message(String name) throws RemoteException;
}
