package JavaFXApplication11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;

public class JavaFXApplication11 extends Application {
// creat a file 

    File Doctor = new File("Docotr's file.txt");
    File product = new File("product's file.txt");

//creat a labels
    Label l1;
    Label l2;
    Label l3;
    Label l4;
//creat a textfield
    TextField tf1;
    TextField tf2;
    TextField tf3;
    TextField tf4;

    Button B7;
    Button B8;

//    private String[] flagtitles = {"pizza:1 ", "coffe:2 ", "tea:3", "biskets:4", "ships:5", "snadwich:6", "choc:7"};
    //creat a pane  
    GridPane root = new GridPane();
    //craet a file writer 
    FileWriter f1 = null;

    @Override
    public void start(final Stage primaryStage) {
//        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagtitles));
//        lv.setPrefSize(400, 600);
//        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        BorderPane BP = new BorderPane();
//        ScrollPane sp = new ScrollPane();
//        BP.setLeft(new ScrollPane(lv));
//        //creat a butten 
        Button B1 = new Button();
        Button B2 = new Button();
        Button B3 = new Button();
        Button B4 = new Button();
        Button B5 = new Button();
        Button B6 = new Button();

        //set the button names 
        B1.setText("ADD Doctor");
        B2.setText("ADD Proudect");
        B3.setText("show products");
        B4.setText("show Doctor's list");
        B5.setText("show pill");
        B6.setText("update quantity");

        //put buttons in a pane 
        root.add(B1, 0, 0);
        root.add(B2, 0, 1);
        root.add(B3, 1, 0);
        root.add(B4, 1, 1);
        root.add(B5, 2, 0);
        root.add(B6, 2, 1);
//        root.add(BP, 1, 1);
        // craet a scene
        Scene scene = new Scene(root, 500, 400);
        //cleck on B1
        B1.setOnAction((ActionEvent event) -> {
            B7 = new Button();
            B8 = new Button();
            B7.setText("ADD");
            B8.setText("Done!");
            //creating a labels 
            l1 = new Label("Enter the Doctor name ");
            l2 = new Label("Enter the doctor id");
            l3 = new Label("Enter the departmnent");
            l4 = new Label("Enter the Title");
            //creating a textfield
            tf1 = new TextField();
            tf2 = new TextField();
            tf3 = new TextField();
            tf4 = new TextField();
            //but in labelB7 = new Button();
            B8 = new Button();
            root.add(l1, 3, 3);
            root.add(tf1, 3, 4);
            root.add(l2, 3, 5);
            root.add(tf2, 3, 6);
            root.add(l3, 3, 7);
            root.add(tf3, 3, 8);
            root.add(l4, 3, 9);
            root.add(tf4, 3, 10);
            root.add(B7, 3, 11);
            root.add(B8, 3, 12);

            //cleck on B7
            B7.setOnAction((ActionEvent event1) -> {
                //scan from user 
                String o = tf1.getText();
                int i = Integer.parseInt(tf2.getText());
                String x = tf3.getText();
                String y = tf4.getText();

                try {
                    //writing in file doctor
                    f1 = new FileWriter(Doctor);
                    f1.write(o + ",");
                    f1.write(i + ",");
                    f1.write(x + ",");
                    f1.write(y + "");
                    f1.close();

                } catch (IOException ex) {
                    Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                }
//                Scanner sc = new Scanner(f);
//                while (sc.hasNext()) {
//                    System.out.println(f.canRead());
//                }
            });

            B8.setOnAction((ActionEvent event1) -> {

                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                //hide the text filed
                tf1.setVisible(false);
                tf2.setVisible(false);
                tf3.setVisible(false);
                tf4.setVisible(false);
                //hide the button
                B7.setVisible(false);
                B8.setVisible(false);

            });
        });

        //click on B2
        B2.setOnAction((ActionEvent event) -> {
            B7 = new Button();
            B8 = new Button();
            B7.setText("ADD");
            B8.setText("Done!");
            //craet a label 
            l1 = new Label();
            l2 = new Label();
            l3 = new Label();
            l4 = new Label();
            //creat  a textfield    
            tf4 = new TextField();
            tf3 = new TextField();
            tf2 = new TextField();
            tf1 = new TextField();
            //but the labels name 
            l1.setText("enter the proudect name");
            l2.setText("enter the proudect id");
            l3.setText("enter the proudect price");
            l4.setText("enter the proudect quantity");
            //but all in pane 
            root.add(l1, 3, 3);
            root.add(tf1, 3, 4);
            root.add(l2, 3, 5);
            root.add(tf2, 3, 6);
            root.add(l3, 3, 7);
            root.add(tf3, 3, 8);
            root.add(l4, 3, 9);
            root.add(tf4, 3, 10);
            root.add(B7, 3, 11);
            root.add(B8, 3, 12);
            B7.setOnAction((ActionEvent event1) -> {

                String o = tf1.getText();
                int i = Integer.parseInt((String) tf2.getText());
                String x = tf3.getText();
                String y = tf4.getText();

                try {
                    //writing in file proudect
                    f1 = new FileWriter(product);
                    f1.write(o + ",");
                    f1.write(i + ",");
                    f1.write(x + ",");
                    f1.write(y + "");
                    f1.close();

                } catch (IOException ex) {
                    Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                }
//                Scanner sc = new Scanner(f);
//                while (sc.hasNext()) {
//                    System.out.println(f.canRead());
//                }
            });
            B8.setOnAction((ActionEvent event1) -> {

                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                //hide the text filed
                tf1.setVisible(false);
                tf2.setVisible(false);
                tf3.setVisible(false);
                tf4.setVisible(false);
                //hide the button
                B7.setVisible(false);
                B8.setVisible(false);

            });
        });

        B3.setOnAction((ActionEvent event) -> {

        });

        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
// file for every button 
// btn show just will read the file 
// complete the btn 
