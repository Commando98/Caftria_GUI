package javafxapplication1;

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
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaFXApplication1 extends Application {

    @Override
    public void start(final Stage primaryStage) {
        Button btn = new Button();
        btn.setText("ADD!");
        Label l1 = new Label("Enter the name");
        final TextField tf1 = new TextField();
        Label l2 = new Label("Enter the tottal price");
        final TextField tf2 = new TextField();

        GridPane root = new GridPane();
        root.add(btn, 5, 5);
        root.add(l1, 0, 1);
        root.add(tf1, 0, 2);
        root.add(l2, 0, 3);
        root.add(tf2, 0, 4);
        final Scene scene = new Scene(root, 300, 200);
 System.out.println("Handle ");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String o = (String) tf1.getText();
                int i = Integer.parseInt((String) tf2.getText());
                File f=new File ("File.txt");
                System.out.println("Handle ");
                FileWriter f1 = null;

                try {
                    System.out.println("before writing ");
                    f1 = new FileWriter(f);
                    System.out.println("After object ");
                    f1.write(o);
                    System.out.println("input " +o);
                    f1.close();
                } 
                catch (IOException ex) {
                    Logger.getLogger(JavaFXApplication1.class.getName()).log(Level.SEVERE, null, ex);
                }

              
            }
        });

        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
