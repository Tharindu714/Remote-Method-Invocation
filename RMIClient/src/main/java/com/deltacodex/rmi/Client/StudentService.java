package com.deltacodex.rmi.Client;

import com.deltacodex.rmi.model.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentService extends Remote {
    public List<Student> getStudents() throws RemoteException;
}
