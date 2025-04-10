package com.deltacodex.rmi;

import com.deltacodex.rmi.Client.Message;
import com.deltacodex.rmi.Client.StudentService;
import com.deltacodex.rmi.model.Student;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Properties;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 555);
            String[] list = registry.list();
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("RMI Client Started");

            System.out.println("-------------------------");
            System.out.println("Registry LookUp method -> Student Service");

            StudentService studentService = (StudentService) registry.lookup("Student_Service");
            List<Student> students = studentService.getStudents();

            students.forEach(stu ->
                    System.out.println(stu.getId() + ": " + stu.getName() + " is in " + stu.getAddress() + " & the mobile is " + stu.getContact()));

            System.out.println("-------------------------");
            System.out.println("Registry LookUp method -> Message Service");


            Message message = (Message) registry.lookup("Message_Service");
            System.out.println(message.New_message("RMI Client by Tharindu Chanaka ---->>"));

            System.out.println("-------------------------");
            System.out.println("Initial Context method -> Student Service");

            Properties props = new Properties();
            props.put(Context.PROVIDER_URL, "rmi://localhost:555");
            props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");

            InitialContext ctx = new InitialContext(props);
            StudentService Stu_service = (StudentService) ctx.lookup("Student_Service");

            List <Student> Stu_initial_context = Stu_service.getStudents();
            Stu_initial_context.forEach(stu_ctx->{
                System.out.println(stu_ctx.getId() + ": " + stu_ctx.getName() + " is in " + stu_ctx.getAddress()+ " & the mobile is " + stu_ctx.getContact());
            });

            System.out.println("-------------------------");
            System.out.println("Naming LookUp method -> Student Service");

            StudentService studentService_naming = (StudentService) Naming.lookup("rmi://localhost:555/Student_Service");
            List<Student> students_naming = studentService_naming.getStudents();
            students_naming.forEach(student -> {
                System.out.println(student.getId() + ": " + student.getName() + " is in " + student.getAddress()+ " & the mobile is " + student.getContact());
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
