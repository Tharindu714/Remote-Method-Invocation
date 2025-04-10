package com.deltacodex.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(555);
            registry.bind("Message_Service", new MessageImpl());
            registry.bind("Student_Service", new StudentServiceImpl());
            System.out.println("RMI Server Started ---->> Run RMIClient Side to View Results");
        } catch (Exception re) {
            re.printStackTrace();
        }
    }
}
