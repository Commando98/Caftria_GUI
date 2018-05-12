/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.io.Serializable;

public class Product implements Serializable {

    int ProductID;
    String ProductName;
    double ProductPrice;
    boolean ProductAvailable;

    public Product(int productID, String productName, double productPrice, boolean productAvailable) {

        ProductID = productID;
        ProductName = productName;
        ProductPrice = productPrice;
        ProductAvailable = productAvailable;
    }
}
