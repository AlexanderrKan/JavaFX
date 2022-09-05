package com.example.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import org.controlsfx.control.ListActionView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
        @Override
        public void start (Stage primaryStage) throws FileNotFoundException {
            Pane pane = new Pane();
            Image image = new Image(new FileInputStream("src/456.jpg"));
            ImageView imageView = new ImageView(image);
            imageView.smoothProperty();
            Label level1 = new Label("Picture",imageView);
            level1.setContentDisplay(ContentDisplay.BOTTOM);
            pane.getChildren().add(level1);


            Pane pane1 = new Pane();
            CheckBox checkBox = new CheckBox("Yes");
            CheckBox checkBox1 = new CheckBox("No");
            Text text = new Text("Is it Avatar?");
            Text text1 = new Text();
            pane.getChildren().addAll(checkBox, checkBox1,text,text1);
            checkBox.setLayoutX(20);
            checkBox.setLayoutY(20);
            checkBox1.setLayoutX(20);
            checkBox1.setLayoutY(40);
            text.setLayoutX(20);
            text.setLayoutY(10);
            text1.setLayoutX(20);
            text1.setLayoutY(80);

            Pane pane2 = new Pane();
            TextField textField = new TextField();
            Text text2 = new Text();
            textField.setLayoutX(20);
            textField.setLayoutY(100);
            text2.setX(200);
            text2.setY(250);
            pane.getChildren().addAll(textField, text2);

            EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(checkBox.isSelected() && !checkBox1.isSelected())
                        text1.setText("Yes is selected");
                    else if(checkBox.isSelected() && checkBox1.isSelected())
                        text1.setText("Yes and NO are selected");
                    else if(!checkBox.isSelected() && checkBox1.isSelected())
                        text1.setText("No are selected");
                    else text1.setText("Nothing is selected");

                }
            };




            checkBox.setOnAction(handler);
            checkBox1.setOnAction(handler);
            Scene scene = new Scene(pane, 300, 300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaFX Application");
            primaryStage.show();
        }
    }
// установка надписи
//        Text text = new Text("Hello!");
//        text.setLayoutY(80);    // установка положения надписи по оси Y
//        text.setLayoutX(80);   // установка положения надписи по оси X
//
//        Group group = new Group(text);