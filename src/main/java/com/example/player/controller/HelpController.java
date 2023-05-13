package com.example.player.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelpController {
    public static void showInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dev Info");
        alert.setHeaderText(null);
        Text text = new Text("\ndeveloped by sysu 李鹏图   \n" +
                "all rights reserved.");
        text.setFont(new Font("SimSuncss", 15));
        alert.getDialogPane().setContent(text);
        alert.showAndWait();
    }

    public static void showAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("personal");
        alert.setHeaderText(null);
        Text text = new Text("welcome to my github page!\n" +
                "click here:");
        text.setFont(new Font("SimSuncss", 15));
        Hyperlink hyperlink = new Hyperlink("https://www.github.com/PattonLi");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(text,hyperlink);
        alert.getDialogPane().setContent(vBox);
        hyperlink.setOnAction((ActionEvent e) -> {
            //open link
            Desktop desktop = Desktop.getDesktop();
            try {
                URI uri = new URI(hyperlink.getText());
                desktop.browse(uri);
            } catch (IOException | URISyntaxException ex) {
                System.out.println("error = " + ex);
            }
        });
        alert.showAndWait();
    }
}
