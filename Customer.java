package javafxapplication11;

import java.io.Serializable;

public class Customer implements Serializable {

    int CustomerID;
    String CustomerName;
    String CustomerDepartment;
    String CustomerTelephone;
    String CustomerEmail;

    public Customer(int customerID, String customerName, String customerDepartment, String customerTelephone, String customerEmail) {

        CustomerID = customerID;
        CustomerName = customerName;
        CustomerDepartment = customerDepartment;
        CustomerTelephone = customerTelephone;
        CustomerEmail = customerEmail;
    }
}
