module com.example.player {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens com.example.player to javafx.fxml;
    exports com.example.player;
    exports com.example.player.controller;
    opens com.example.player.controller to javafx.fxml;
}