
package javafxapplication11;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class CafeteriaClient {

    private static Socket socket;
    private static String ServerAddress = "localhost";
    private static int PortNumber = 14190;
    private static   DataInputStream InputFromServer;
    private static DataOutputStream OutputToServer;



    public static void connect() throws Exception {

        socket = new Socket(ServerAddress,PortNumber);
        InputFromServer = new DataInputStream(socket.getInputStream());
        OutputToServer = new DataOutputStream(socket.getOutputStream());

    }

    private static void sendRequest(int RequestCode) throws IOException {

        OutputToServer.writeInt(RequestCode);
        OutputToServer.flush();
    }

    public static int login(int UserID, String UserPassword) throws IOException {

        sendRequest(RequestCode.login);

        OutputToServer.writeInt(UserID);
        OutputToServer.writeChars(UserPassword);

        int response = InputFromServer.readInt();
        return response;
    }

    public static void registerNewUser(Customer customer, String password) throws IOException {

        sendRequest(RequestCode.RegisterNewUser);

        OutputToServer.writeInt(customer.CustomerID);
        OutputToServer.writeUTF(customer.CustomerName);
        OutputToServer.writeUTF(customer.CustomerDepartment);
        OutputToServer.writeUTF(customer.CustomerTelephone);
        OutputToServer.writeUTF(customer.CustomerEmail);
        OutputToServer.writeUTF(password);

        OutputToServer.flush();

    }

    public static ArrayList<Product> getProducts() throws IOException {

        sendRequest(RequestCode.GetProducts);

        ArrayList<Product> products = new ArrayList<>();

        int ProductID;
        String ProductName;
        double ProductPrice;
        boolean ProductAvailable;

        int NumberOfProducts = InputFromServer.readInt();
        for(int i = 0; i < NumberOfProducts; i++)
        {
            ProductID = InputFromServer.readInt();
            ProductName = InputFromServer.readUTF();
            ProductPrice = InputFromServer.readDouble();
            ProductAvailable = InputFromServer.readBoolean();

            products.add(new Product(ProductID, ProductName, ProductPrice, ProductAvailable));
        }
        return products;
    }

    public static void makeOrder(int CustomerID, ArrayList<Integer> ProductsIDs, ArrayList<Integer> ProductsQuantities) throws IOException {

        sendRequest(RequestCode.MakeOrder);

        OutputToServer.writeInt(CustomerID);

        int NumberOfProducts = ProductsIDs.size();
        OutputToServer.writeInt(NumberOfProducts);

        for(int i = 0; i < NumberOfProducts; i++)
        {
            OutputToServer.writeInt(ProductsIDs.get(i));
            OutputToServer.writeInt(ProductsQuantities.get(i));
        }

        OutputToServer.flush();

    }

    public static double getCustomerBill(int CustomerBill) throws IOException {

        sendRequest(RequestCode.GetCustomerBill);

        OutputToServer.writeInt(CustomerBill);
        OutputToServer.flush();

        double TotalBill = InputFromServer.readDouble();

        return TotalBill;
    }

    public static void payCustomerBills(int CustomerID) throws IOException {

        sendRequest(RequestCode.PayCustomerBills);

        OutputToServer.writeInt(CustomerID);
        OutputToServer.flush();
    }

    public static ArrayList<Order> getCustomerOrders(int CustomerID) throws IOException {

        sendRequest(RequestCode.GetCustomerOrders);

        OutputToServer.writeInt(CustomerID);
        OutputToServer.flush();

        ArrayList<Order> orders = new ArrayList<>();
        int OrderID;
        Customer customer;
        String IssueDate;
        double TotalBill;
        boolean OrderPaid;

        String CustomerName;
        String CustomerDepartment;
        String CustomerTelephone;
        String CustomerEmail;

        CustomerName = InputFromServer.readUTF();
        CustomerDepartment = InputFromServer.readUTF();
        CustomerTelephone = InputFromServer.readUTF();
        CustomerEmail = InputFromServer.readUTF();

        customer = new Customer(CustomerID, CustomerName, CustomerDepartment, CustomerTelephone, CustomerEmail);

        int NumberOdOrders = InputFromServer.readInt();
        for(int i = 0;i<NumberOdOrders; i++)
        {
            OrderID = InputFromServer.readInt();
            TotalBill = InputFromServer.readDouble();
            OrderPaid = InputFromServer.readBoolean();
            IssueDate = InputFromServer.readUTF();

            orders.add(new Order(OrderID, customer, IssueDate, TotalBill, OrderPaid ));

        }

        return orders;
    }





}
