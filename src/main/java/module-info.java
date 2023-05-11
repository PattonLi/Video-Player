module com.example.player {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.player to javafx.fxml;
    exports com.example.player;
}