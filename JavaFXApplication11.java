package JavaFXApplication11;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;
import java.awt.Choice;
import java.awt.event.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

public class JavaFXApplication11 extends Application {

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

    //creat add&done
    Button B7;
    Button B8;
    Button BREG;

    // Cafeteria Cf=new Cafeteria();
    //creat a list
    BorderPane Bp;
    BorderPane BP1;
    ScrollPane sp;
    ScrollPane sp1;
    int p;

    ListView<String> lv;
    private String[] flagtitles = {"product Name ---> ID",
        "pizza --> 1",
        "coffe --> 2",
        "tea --> 3",
        "biskets --> 4",
        "ships --> 5",
        "snadwich --> 6",
        "choc --> 7"};
    
    //creat a pane
    GridPane root = new GridPane();
    GridPane pane = new GridPane();
    GridPane cort = new GridPane();

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Button BE = new Button();
        BE.setText("ENTER");
        BREG = new Button();
        BREG.setText("Regestration");
        Label l = new Label("enter the ID ");
        TextField tf = new TextField();
        Label ll = new Label("enter the pass ");
        TextField tff = new PasswordField();
        Scene sc = new Scene(pane, 500, 400);
        Scene scene = new Scene(root, 500, 400);

        pane.add(l, 1, 1);
        pane.add(tf, 1, 2);
        pane.add(ll, 1, 3);
        pane.add(tff, 1, 4);
        pane.add(BE, 1, 5);
        pane.add(BREG, 9, 5);
        javafxapplication11.CafeteriaClient.connect();

        BE.setOnAction((ActionEvent event1) -> {
            try {
                //get the user name and the pass then choose th type
                p = javafxapplication11.CafeteriaClient.login(Integer.parseInt(tf.getText()), tf1.getText());
            } catch (IOException ex) {
                Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        BREG.setOnAction((ActionEvent event1) -> {
            B8 = new Button();
            B8.setText("Done!");

            l1 = new Label("Enter the  ID ");
            l2 = new Label("Enter the name");
            l3 = new Label("Enter the pass");
            l4 = new Label("Enter the type ");
            Label l5 = new Label("Enter the Email ");
            Label l6 = new Label("Enter the Mobile ");
            Label l7 = new Label("Enter the Department ");

            tf1 = new TextField();
            tf2 = new TextField();
            tf3 = new PasswordField();
            tf4 = new TextField();
            TextField tf5 = new TextField();
            TextField tf6 = new TextField();
            TextField tf7 = new TextField();

            //put it on greed
            pane.add(l1, 7, 5);
            pane.add(tf1, 7, 6);
            pane.add(l2, 7, 7);
            pane.add(tf2, 7, 8);
            pane.add(l3, 7, 9);
            pane.add(tf3, 7, 10);
            pane.add(l5, 7, 11);
            pane.add(tf5, 7, 12);
            pane.add(l6, 7, 13);
            pane.add(tf6, 7, 14);
            pane.add(l7, 7, 15);
            pane.add(tf7, 7, 16);
            pane.add(l4, 7, 17);
            pane.add(tf4, 7, 18);
            pane.add(B8, 7, 19);

            B8.setOnAction((ActionEvent event2) -> {
                //get the name and the id and the pass and put it in db 
                tf1.getText();
                tf2.getText();
                tf3.getText();
                tf3.getText();
               //get the type from vbox 

                //hide the elemnts 
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                //hide the text filed
                tf1.setVisible(false);
                tf2.setVisible(false);
                tf3.setVisible(false);
                tf4.setVisible(false);
                tf5.setVisible(false);
                tf6.setVisible(false);
                tf7.setVisible(false);
                //hide the button
                B8.setVisible(false);
                JOptionPane.showMessageDialog(null, "Now you can log in Yay!!");
            });

        });
        primaryStage.setScene(sc);
        primaryStage.show();

        switch (p) {

            case (1):
                //maneger
                root.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
                //creat buttens
                Button BAS = new Button();
                Button BDS = new Button();
                Button UI = new Button();
                Button UM = new Button();
                Button EP = new Button();

                //set the button names
                BAS.setText("ADD sales man ");
                BDS.setText("Delete sales man ");
                UI.setText("Update inventory");
                UM.setText("Update menu");
                EP.setText("Extract Profits");

                //put buttons in a pane
                root.add(BAS, 1, 2);
                root.add(UI, 1, 4);
                root.add(UM, 1, 6);
                root.add(EP, 1, 8);

                //cleck on B1
                BAS.setOnAction((ActionEvent event) -> {

                    if (l1 != null
                            || l2 != null
                            || l3 != null
                            || l4 != null
                            || tf1 != null
                            || tf2 != null
                            || tf3 != null
                            || tf4 != null) {

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
                    }
                    B8 = new Button();
                    B7 = new Button();
                    B7.setText("ADD");
                    B8.setText("Done!");
                    //creating a labels
                    l1 = new Label("Enter the sales man  ID ");
                    l2 = new Label("Enter the sales man name");
                    l3 = new Label("Enter the shift");

                    //creating a textfield
                    tf1 = new TextField();
                    tf2 = new TextField();
                    tf3 = new TextField();

                    //put it on greed
                    root.add(l1, 4, 5);
                    root.add(tf1, 4, 6);
                    root.add(l2, 4, 7);
                    root.add(tf2, 4, 8);
                    root.add(l3, 4, 9);
                    root.add(tf3, 4, 10);
                    root.add(B7, 4, 13);
                    root.add(B8, 4, 14);

                    B7.setOnAction((ActionEvent event2) -> {
                        //get the sales man data bythe maneger 

                        tf1.getText();
                        tf2.getText();
                        tf3.getText();

                    });
                    B8.setOnAction((ActionEvent event8) -> {

                        l1.setVisible(false);
                        l2.setVisible(false);
                        l3.setVisible(false);
                        //hide the text filed
                        tf1.setVisible(false);
                        tf2.setVisible(false);
                        tf3.setVisible(false);
                        //hide the button
                        B7.setVisible(false);
                        B8.setVisible(false);

                    });
                });
                BDS.setOnAction((ActionEvent event) -> {

                    if (l1 != null
                            || l2 != null
                            || l3 != null
                            || l4 != null
                            || tf1 != null
                            || tf2 != null
                            || tf3 != null
                            || tf4 != null) {

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
                    }
                    B8 = new Button();
                    B7 = new Button();
                    B7.setText("Delete");
                    B8.setText("Done!");
                    //creating a labels
                    l1 = new Label("Enter the sales man  ID ");

                    //creating a textfield
                    tf1 = new TextField();
                    tf2 = new TextField();

                    //put it on greed
                    root.add(l1, 4, 5);
                    root.add(tf1, 4, 6);

                    root.add(B7, 4, 13);
                    root.add(B8, 4, 14);

                    B7.setOnAction((ActionEvent event0) -> {
                        //delete  the sales man data by the maneger 
                        tf1.getText();

                    });
                    B8.setOnAction((ActionEvent event7) -> {

                        l1.setVisible(false);
                        tf1.setVisible(false);
                        //hide the button
                        B7.setVisible(false);
                        B8.setVisible(false);

                    });
                });

                UI.setOnAction((ActionEvent event) -> {

                    if (l1 != null
                            || l2 != null
                            || l3 != null
                            || l4 != null
                            || tf1 != null
                            || tf2 != null
                            || tf3 != null
                            || tf4 != null) {

                        l1.setVisible(false);
                        l2.setVisible(false);
                        l3.setVisible(false);
                        //hide the text filed
                        tf1.setVisible(false);
                        tf2.setVisible(false);
                        tf3.setVisible(false);
                        //hide the button
                        B7.setVisible(false);
                        B8.setVisible(false);
                    }
                    B7 = new Button();
                    B8 = new Button();
                    B7.setText("Update");
                    B8.setText("Done!");

                    l1 = new Label();
                    tf1 = new TextField();
                    l1.setText("enter the proudect id");

                    //but all in pane
                    root.add(l1, 8, 5);
                    root.add(tf1, 8, 6);

                    root.add(B7, 8, 13);
                    root.add(B8, 8, 14);

                    B7.setOnAction((ActionEvent event1) -> {
                        //update the product with id :
                        tf1.getText();

                    });
                    B8.setOnAction((ActionEvent event1) -> {

                        l1.setVisible(false);
                        tf1.setVisible(false);
                        //hide the button
                        B7.setVisible(false);
                        B8.setVisible(false);

                    });
                });

                UM.setOnAction((ActionEvent event) -> {

                    if (l1 != null
                            || l2 != null
                            || l3 != null
                            || l4 != null
                            || tf1 != null
                            || tf2 != null
                            || tf3 != null
                            || tf4 != null) {

                        l1.setVisible(false);

                        //hide the text filed
                        tf1.setVisible(false);

                        //hide the button
                        B7.setVisible(false);
                        B8.setVisible(false);
                    }
                    B8 = new Button();
                    B8.setText("Done!");
                    B7 = new Button();
                    B7.setText("Update");

                    root.add(B8, 3, 12);
                    root.add(B7, 3, 15);

                    lv = new ListView<>(FXCollections.observableArrayList(flagtitles));
                    lv.setPrefSize(300, 400);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    Bp = new BorderPane();
                    sp = new ScrollPane();
                    Bp.setLeft(new ScrollPane(lv));
                    root.add(Bp, 4, 12);

                    B7.setOnAction((ActionEvent event1) -> {

                        // update the menu 
                    });

                    B8.setOnAction((ActionEvent event1) -> {

                        Bp.setVisible(false);
                        B8.setVisible(false);
                        B7.setVisible(false);

                    });

                });

                EP.setOnAction((ActionEvent event) -> {

                    if (l1 != null
                            || l2 != null
                            || l3 != null
                            || l4 != null
                            || tf1 != null
                            || tf2 != null
                            || tf3 != null
                            || tf4 != null) {

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
                    }
                    B8 = new Button();
                    B8.setText("Done!");
                    B7 = new Button();
                    B7.setText("Calculate");
                    B7.setOnAction((ActionEvent event1) -> {

                        //calculate the profit 
                    });
                    B8.setOnAction((ActionEvent event1) -> {

                        B7.setVisible(false);
                        B8.setVisible(false);

                    });

                });

                primaryStage.setTitle("Welcome!");
                primaryStage.setScene(scene);
                primaryStage.show();
                break;

            case (2):
                //Customer 
                Button MO = new Button();
                MO.setText("Make order");

                root.add(MO, 3, 12);

                MO.setOnAction((ActionEvent event2) -> {

                    B7 = new Button();
                    B7.setText("confirm");
                    Button B10 = new Button();
                    B10.setText("update");
                    root.add(B7, 4, 13);
                    root.add(B10, 4, 14);
                    lv = new ListView<>(FXCollections.observableArrayList(flagtitles));
                    lv.setPrefSize(150, 200);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    Bp = new BorderPane();
                    sp = new ScrollPane();
                    Bp.setLeft(new ScrollPane(lv));
                    root.add(Bp, 4, 12);

                    Bp.setOnMouseDragged((javafx.scene.input.MouseEvent e) -> {
                        //add to cort 
                    });
                    B10.setOnAction((ActionEvent event1) -> {
                        Bp.setOnMouseDragged((javafx.scene.input.MouseEvent e) -> {
                            //add to cort 
                        });
                        Button B9 = new Button();
                        B9.setText("confirm");
                        B9.setOnAction((ActionEvent event8) -> {
                            //show the bill 
                            B7.setVisible(false);
                            B10.setVisible(false);
                            Bp.setVisible(false);
                        });
                    });

                    B7.setOnAction((ActionEvent event1) -> {

                        //show the bill then hide  
                        //hide the button
                        B7.setVisible(false);
                        B10.setVisible(false);
                        Bp.setVisible(false);

                    });

                });

                primaryStage.setTitle("Welcome!");
                primaryStage.setScene(scene);
                primaryStage.show();
                break;

            case (3):
                //sales man 
                Button BMO = new Button();
                BMO.setText("Make order");
                Button PI = new Button();
                PI.setText("print inovices");
                Button UA = new Button();
                UA.setText("Update account ");

                root.add(BMO, 4, 1);
                root.add(PI, 4, 15);

                BMO.setOnAction((ActionEvent event) -> {

                    lv = new ListView<>(FXCollections.observableArrayList(flagtitles));
                    lv.setPrefSize(200, 250);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    Bp = new BorderPane();
                    sp = new ScrollPane();
                    Bp.setLeft(new ScrollPane(lv));
                    root.add(Bp, 4, 12);

                    B8 = new Button();
                    B8.setText("Done!");
                    B7 = new Button();
                    B7.setText("ADD");

                    //creating a labels
                    l1 = new Label("type of pay ");
                    l2 = new Label("Enter the Product ID");
                    l3 = new Label("Enter the Quantety");
                    l4 = new Label("Enter the tottal Price");

                    //creating a textfield
                    tf1 = new TextField();
                    tf2 = new TextField();
                    tf3 = new TextField();
                    tf4 = new TextField();

                    //put it on greed
                    root.add(l1, 20, 13);
                    root.add(tf1, 20, 14);
                    root.add(l2, 20, 7);
                    root.add(tf2, 20, 8);
                    root.add(l3, 20, 9);
                    root.add(tf3, 20, 10);
                    root.add(l4, 20, 11);
                    root.add(tf4, 20, 12);
                    root.add(B7, 20, 15);
                    root.add(B8, 20, 16);

                    //cleck on B7
                    B7.setOnAction((ActionEvent event2) -> {
                        // add in DB

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
                        Bp.setVisible(false);

                    });

                });
                PI.setOnAction((ActionEvent event) -> {

                    B8 = new Button();
                    B8.setText("Done!");
                    B7 = new Button();
                    B7.setText("ADD");
                    // print invoices ask ??
                    B7.setOnAction((ActionEvent event2) -> {

                    });
                    B8.setOnAction((ActionEvent event1) -> {

                        B7.setVisible(false);
                        B8.setVisible(false);

                    });
                });

                UA.setOnAction((ActionEvent event) -> {

                    l1 = new Label("enter the account id ");
                    tf1 = new TextField();
                    B8 = new Button();
                    B8.setText("Done!");
                    B7 = new Button();
                    B7.setText("update");
                    // print invoices ask ??
                    B7.setOnAction((ActionEvent event2) -> {
                        //update by the id
                        tf1.getText();
                    });
                    B8.setOnAction((ActionEvent event1) -> {

                        l1.setVisible(false);

                        //hide the text filed
                        tf1.setVisible(false);

                        //hide the button
                        B7.setVisible(false);
                        B8.setVisible(false);

                    });
                });

                primaryStage.setTitle("Welcome!");
                primaryStage.setScene(scene);
                primaryStage.show();
                break;

        };

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
