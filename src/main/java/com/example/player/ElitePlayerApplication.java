package com.example.player;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ElitePlayerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ElitePlayerApplication.class.getResource("views/player-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Elite video player");
        stage.setScene(scene);
        stage.setResizable(false); // 设置为不可调整大小
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}