package com.deltacodex.rmi;

import com.deltacodex.rmi.Client.StudentService;
import com.deltacodex.rmi.model.Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {

    StudentServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<Student> getStudents() throws RemoteException {
        return List.of(
                new Student(1, "Tharindu", "Bandarawela","0751441764"),
                new Student(2, "Supun", "Diyathalawa","0767890045"),
                new Student(3, "Pivithuru", "Colombo","0770001764")
        );
    }
}
