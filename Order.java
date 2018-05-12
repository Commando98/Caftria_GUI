/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    int OrderID;
    Customer customer;
    String IssueDate;
    double TotalBill;
    boolean OrderPaid;

    public Order(int orderID, Customer customer, String issueDate, double totalBill, boolean orderPaid) {

        OrderID = orderID;
        this.customer = customer;
        IssueDate = issueDate;
        TotalBill = totalBill;
        OrderPaid = orderPaid;
    }
}
