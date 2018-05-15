package JavaFXApplication11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;
import java.io.Serializable;
import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.util.Collection;
import java.util.Date;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.util.Callback;
import static jdk.nashorn.internal.objects.NativeMath.E;

public class JavaFXApplication11 extends Application {

    public int ID;
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
    Button FeadBAck = new Button("FeadBack");

    Button BREG;

    // Cafeteria Cf=new Cafeteria();
    //creat a list
    BorderPane Bp;
    BorderPane BP1;
    ScrollPane sp;
    ScrollPane sp1;

    public static int p;

    ListView<String> lv;
    private ArrayList<String> flagtitles = new ArrayList<>();
    ArrayList<String> items = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Integer> productsIDs = new ArrayList<>();
    ArrayList<Integer> productsQ = new ArrayList<>();
    ArrayList<String> newValuee = new ArrayList<>();

    //creat a pane
    GridPane root = new GridPane();
    GridPane pane = new GridPane();
    GridPane cort = new GridPane();

    @Override
    public void start(final Stage primaryStage) throws Exception {

        CafeteriaClient.connect();

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
        pane.add(FeadBAck, 9, 6);

        BE.setOnAction((ActionEvent event1) -> {
            try {
                //get the user name and the pass then choose th type
                ID = Integer.parseInt(tf.getText());
                JavaFXApplication11.p = CafeteriaClient.login(Integer.parseInt(tf.getText()), tff.getText());
                
        switch (p) {
//            case (0):
//                //wrong input
//                JOptionPane.showMessageDialog(null, "wrong input ");

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
//                pane.add(FeadBAck, 1, 12);

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
                    pane.add(FeadBAck, 4, 16);

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
                    pane.add(FeadBAck, 4, 16);

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
                    try {
                        products = CafeteriaClient.getProducts();
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //but all in pane
                    root.add(l1, 8, 5);
                    root.add(tf1, 8, 6);

                    root.add(B7, 8, 13);
                    root.add(B8, 8, 14);
//                    pane.add(FeadBAck, 8, 15);

                    B7.setOnAction((ActionEvent event8) -> {
                        //update the product; with id :
                        for (Product product : products) {
                            if (product.ProductID == Integer.parseInt(tf1.getText())) {

                            }
                        }
//                        product P = new Product(Integer.parseInt(tf1.getText());,products. , p, true)
                        Integer.parseInt(tf1.getText());

                    });
                    B8.setOnAction((ActionEvent event7) -> {

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
                    pane.add(FeadBAck, 3, 18);

                    lv = new ListView<>(FXCollections.observableArrayList(flagtitles));
                    lv.setPrefSize(300, 400);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    Bp = new BorderPane();
                    sp = new ScrollPane();
                    Bp.setLeft(new ScrollPane(lv));
                    root.add(Bp, 4, 12);

                    B7.setOnAction((ActionEvent event15) -> {

                        try {
                            // update the menu
                            for (int i = 0; i < CafeteriaClient.getProducts().size(); i++) {
                                flagtitles.add(CafeteriaClient.getProducts().get(i).ProductName);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    B8.setOnAction((ActionEvent event11) -> {

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
                    B7.setOnAction((ActionEvent event111) -> {

                        //calculate the profit 
                    });
                    B8.setOnAction((ActionEvent event12) -> {

                        B7.setVisible(false);
                        B8.setVisible(false);
                        FeadBAck.setVisible(false);

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
                Button UIC = new Button();
                UIC.setText("update information");
                root.add(MO, 3, 12);
                root.add(UIC, 3, 15);

                MO.setOnAction((ActionEvent event2) -> {

                    B7 = new Button();
                    B7.setText("confirm");
                    Button B10 = new Button();
                    B10.setText("update");
                    System.out.println("created buttons");
                    root.add(B7, 4, 13);
                    root.add(B10, 4, 14);
                    try {
                        for (int i = 0; i < CafeteriaClient.getProducts().size(); i++) {
                            flagtitles.add(CafeteriaClient.getProducts().get(i).ProductName);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    lv = new ListView<>(FXCollections.observableArrayList(flagtitles));
                    lv.setPrefSize(150, 200);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    Bp = new BorderPane();
                    sp = new ScrollPane();
                    Bp.setLeft(new ScrollPane(lv));
                    root.add(Bp, 4, 12);
                    root.add(FeadBAck, 4, 15);

                    //add to cort 
                    lv.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                        // change the label text value to the newly selected
                        items.add(newValue);
                    });

                    B10.setOnAction((ActionEvent event19) -> {
                        Bp.setOnMouseDragged((javafx.scene.input.MouseEvent ee) -> {
                            try {
                                for (int i = 0; i < CafeteriaClient.getProducts().size(); i++) {
                                    flagtitles.add(CafeteriaClient.getProducts().get(i).ProductName);
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            lv.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                                // change the label text value to the newly selected
                                items.add(newValue);

                            });
                        });
                        Button B9 = new Button();
                        B9.setText("confirm");
                        B9.setOnAction((ActionEvent event8) -> {
                            //show the bill 
                            for (int i = 0; i < items.size(); i++) {
                                cort.add(new Label(items.get(i)), i, i + 1);
                            }
                            B7.setVisible(false);
                            B10.setVisible(false);
                            Bp.setVisible(false);
                            FeadBAck.setVisible(false);

                        });
                    });

                    B7.setOnAction((ActionEvent event17) -> {

                        //show the bill then hide  
                        for (int i = 0; i < items.size(); i++) {
                            cort.add(new Label(items.get(i)), i, i + 1);
                        }
                        Scene scc;
                        scc = new Scene(cort, 200, 200);
                        Button Bdone = new Button();
                        Bdone.setText("confirm");
                        cort.add(Bdone, 2, 1);
                        for (String item : items) {
                            for (Product product : products) {
                                if (item.equals(product.ProductName)) {
                                    productsIDs.add(product.ProductID);
                                    productsQ.add(1);
                                    break;
                                }
                            }
                        }
                        Bdone.setOnAction((ActionEvent event8) -> {
                            try {
                                CafeteriaClient.makeOrder(ID, productsIDs, productsQ, false);

                            } catch (IOException ex) {
                                Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });

                        primaryStage.setScene(scc);
                        primaryStage.show();
                        //hide the button
                        B7.setVisible(false);
                        B10.setVisible(false);
                        Bp.setVisible(false);
                        FeadBAck.setVisible(false);

                    });

                });

                UIC.setOnAction((ActionEvent event2) -> {

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
                    root.add(l1, 7, 5);
                    root.add(tf1, 7, 6);
                    root.add(l2, 7, 7);
                    root.add(tf2, 7, 8);
                    root.add(l3, 7, 9);
                    root.add(tf3, 7, 10);
                    root.add(l5, 7, 11);
                    root.add(tf5, 7, 12);
                    root.add(l6, 7, 13);
                    root.add(tf6, 7, 14);
                    root.add(l7, 7, 15);
                    root.add(tf7, 7, 16);
                    root.add(l4, 7, 17);
                    root.add(tf4, 7, 18);
                    Button BB = new Button("update");
                    root.add(BB, 7, 19);
                    BB.setOnAction((ActionEvent event8) -> {

                        try {
                            CafeteriaClient.editCustomer(Integer.parseInt(tf1.getText()), tf2.getText(), tf7.getText(), tf6.getText(), tf5.getText(), tf3.getText());
                        } catch (Exception ex) {
                            Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                        BB.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Now you updated it Yay!!");

                    });
                });
                primaryStage.setTitle("Welcome!");
                primaryStage.setScene(scene);
                primaryStage.show();
                break;

//            case (3):
//                //sales man 
//                Button BMO = new Button();
//                BMO.setText("Make order");
//                Button PI = new Button();
//                PI.setText("print inovices");
//                Button UA = new Button();
//                UA.setText("Update account ");
//
//                root.add(BMO, 4, 1);
//                root.add(PI, 4, 15);
//                root.add(FeadBAck, 4, 16);
//
//                BMO.setOnAction((ActionEvent event) -> {
//
//                    lv = new ListView<>(FXCollections.observableArrayList(flagtitles));
//                    lv.setPrefSize(200, 250);
//                    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//                    Bp = new BorderPane();
//                    sp = new ScrollPane();
//                    Bp.setLeft(new ScrollPane(lv));
//                    root.add(Bp, 4, 12);
//
//                    B8 = new Button();
//                    B8.setText("Done!");
//                    B7 = new Button();
//                    B7.setText("ADD");
//
//                    //creating a labels
//                    l1 = new Label("type of pay ");
//                    l2 = new Label("Enter the Product ID");
//                    l3 = new Label("Enter the Quantety");
//                    l4 = new Label("Enter the tottal Price");
//
//                    //creating a textfield
//                    tf1 = new TextField();
//                    tf2 = new TextField();
//                    tf3 = new TextField();
//                    tf4 = new TextField();
//
//                    //put it on greed
//                    root.add(l1, 20, 13);
//                    root.add(tf1, 20, 14);
//                    root.add(l2, 20, 7);
//                    root.add(tf2, 20, 8);
//                    root.add(l3, 20, 9);
//                    root.add(tf3, 20, 10);
//                    root.add(l4, 20, 11);
//                    root.add(tf4, 20, 12);
//                    root.add(B7, 20, 15);
//                    root.add(B8, 20, 16);
//                    root.add(FeadBAck, 20, 18);
//
//                    //cleck on B7
//                    B7.setOnAction((ActionEvent event2) -> {
//                        // add in DB
//
//                    });
//                    B8.setOnAction((ActionEvent event1) -> {
//
//                        l1.setVisible(false);
//                        l2.setVisible(false);
//                        l3.setVisible(false);
//                        l4.setVisible(false);
//                        //hide the text filed
//                        tf1.setVisible(false);
//                        tf2.setVisible(false);
//                        tf3.setVisible(false);
//                        tf4.setVisible(false);
//                        //hide the button
//                        B7.setVisible(false);
//                        B8.setVisible(false);
//                        Bp.setVisible(false);
//                        FeadBAck.setVisible(false);
//
//                    });
//
//                });
//                PI.setOnAction((ActionEvent event) -> {
//
//                    B8 = new Button();
//                    B8.setText("Done!");
//                    B7 = new Button();
//                    B7.setText("ADD");
//                    // print invoices ask ??
//                    B7.setOnAction((ActionEvent event2) -> {
//
//                    });
//                    B8.setOnAction((ActionEvent event1) -> {
//
//                        B7.setVisible(false);
//                        B8.setVisible(false);
//                        FeadBAck.setVisible(false);
//
//                    });
//                });
//
//                UA.setOnAction((ActionEvent event) -> {
//
//                    l1 = new Label("enter the account id ");
//                    tf1 = new TextField();
//                    B8 = new Button();
//                    B8.setText("Done!");
//                    B7 = new Button();
//                    B7.setText("update");
//                    // print invoices ask ??
//                    B7.setOnAction((ActionEvent event2) -> {
//                        //update by the id
//                        tf1.getText();
//                    });
//                    B8.setOnAction((ActionEvent event1) -> {
//
//                        l1.setVisible(false);
//
//                        //hide the text filed
//                        tf1.setVisible(false);
//
//                        //hide the button
//                        B7.setVisible(false);
//                        B8.setVisible(false);
//                        FeadBAck.setVisible(false);
//
//                    });
//                });
//
//                primaryStage.setTitle("Welcome!");
//                primaryStage.setScene(scene);
//                primaryStage.show();
//                break;
        }

        FeadBAck.setOnAction((ActionEvent event198) -> {
            l1 = new Label("enter the feadback subject");
            tf1 = new TextField();
            l2 = new Label("enter the details");
            tf2 = new TextField();
            pane.add(l1, 1, 1);
            pane.add(tf1, 1, 2);
            pane.add(l2, 1, 3);
            pane.add(tf2, 1, 4);
            Button b = new Button("send");
            pane.add(b, 1, 3);
            b.setOnAction((ActionEvent event8) -> {
                try {
                    CafeteriaClient.addFeedback(tf1.getText(), tf2.getText());
                } catch (IOException ex) {
                    Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        });

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
//            pane.add(FeadBAck, 9, 20);

            B8.setOnAction((ActionEvent event2) -> {
                try {
                    //get the name and the id and the pass and put it in db
//w8888
                    CafeteriaClient.registerNewUser(new Customer(Integer.parseInt(tf1.getText()), tf2.getText(), tf7.getText(), tf6.getText(), tf5.getText()), tf3.getText());
                } catch (IOException ex) {
                    Logger.getLogger(JavaFXApplication11.class.getName()).log(Level.SEVERE, null, ex);
                }

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
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

// classes 
class BoughtProduct {

    Order order;
    String ProductName;
    double ProductPiecePrice;
    int ProductQuantity;
}

class CafeteriaClient {

    private static Socket socket;
    private static String ServerAddress = "10.42.0.1";
    private static int PortNumber = 14190;
    private static DataInputStream InputFromServer;
    private static DataOutputStream OutputToServer;

    public static void connect() throws Exception {

        socket = new Socket(ServerAddress, PortNumber);
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
        OutputToServer.writeUTF(UserPassword);
        OutputToServer.flush();

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

    public static void addFeedback(String FeedbackSubject, String FeedbackDetails) throws IOException {

        sendRequest(RequestCode.AddFeedback);

        OutputToServer.writeUTF(FeedbackDetails);
    }

    public static ArrayList<Product> getProducts() throws IOException {

        sendRequest(RequestCode.GetProducts);

        ArrayList<Product> products = new ArrayList<>();

        int ProductID;
        String ProductName;
        double ProductPrice;
        boolean ProductAvailable;

        int NumberOfProducts = InputFromServer.readInt();
        System.out.println(NumberOfProducts);
        for (int i = 0; i < NumberOfProducts; i++) {
            ProductID = InputFromServer.readInt();
            ProductName = InputFromServer.readUTF();
            ProductPrice = InputFromServer.readDouble();
            ProductAvailable = InputFromServer.readBoolean();

            products.add(new Product(ProductID, ProductName, ProductPrice, ProductAvailable));
        }
        return products;
    }

    public static void makeOrder(int CustomerID, ArrayList<Integer> ProductsIDs, ArrayList<Integer> ProductsQuantities, boolean OrderPaid) throws IOException {

        sendRequest(RequestCode.MakeOrder);
        OutputToServer.writeInt(CustomerID);
        OutputToServer.flush();
        int NumberOfProducts = ProductsIDs.size();
        OutputToServer.writeInt(NumberOfProducts);
        OutputToServer.flush();

        for (int i = 0; i < NumberOfProducts; i++) {
            OutputToServer.writeInt(ProductsIDs.get(i));
            OutputToServer.writeInt(ProductsQuantities.get(i));
            OutputToServer.flush();

        }
        OutputToServer.writeBoolean(OrderPaid);
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
        for (int i = 0; i < NumberOdOrders; i++) {
            OrderID = InputFromServer.readInt();
            TotalBill = InputFromServer.readDouble();
            OrderPaid = InputFromServer.readBoolean();
            IssueDate = InputFromServer.readUTF();

            orders.add(new Order(OrderID, customer, IssueDate, TotalBill, OrderPaid));

        }

        return orders;
    }

    public static void editCustomer(int customerID, String customerName, String customerDepartment, String customerTelephone, String customerEmail, String password) throws Exception {

        sendRequest(RequestCode.EditCustomer);

        OutputToServer.writeInt(customerID);
        OutputToServer.writeUTF(customerName);
        OutputToServer.writeUTF(customerDepartment);
        OutputToServer.writeUTF(customerTelephone);
        OutputToServer.writeUTF(customerEmail);
        OutputToServer.writeUTF(password);

        OutputToServer.flush();

    }
}

class Customer implements Serializable {

    public int CustomerID;
    public String CustomerName;
    public String CustomerDepartment;
    public String CustomerTelephone;
    public String CustomerEmail;

    public Customer(int customerID, String customerName, String customerDepartment, String customerTelephone, String customerEmail) {

        CustomerID = customerID;
        CustomerName = customerName;
        CustomerDepartment = customerDepartment;
        CustomerTelephone = customerTelephone;
        CustomerEmail = customerEmail;
    }

}

class Feedback implements Serializable {

    int FeedbackID;
    Customer FeedbackWriter;
    Date FeedbackDate;
    String FeedbackSubject;
    String FeedbackDetails;

}

class Order implements Serializable {

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

class Product implements Serializable {

    int ProductID;
    public String ProductName;
    double ProductPrice;
    boolean ProductAvailable;

    public Product(int productID, String productName, double productPrice, boolean productAvailable) {

        ProductID = productID;
        ProductName = productName;
        ProductPrice = productPrice;
        ProductAvailable = productAvailable;
    }

    Product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class User {

    int UserID;
    String UserPassword;

}

class RequestCode {

    static final int RegisterNewUser = 1;
    static final int login = 2;
    static final int GetProducts = 3;
    static final int GetCustomerBill = 4;
    static final int MakeOrder = 5;
    static final int EditProduct = 6;
    static final int GetAllBills = 7;
    static final int AddProduct = 8;
    static final int PayCustomerBills = 9;
    static final int ChangePassword = 10;
    static final int GetCustomerOrders = 11;
    static final int AddFeedback = 12;
    static final int EditCustomer = 13;

}
