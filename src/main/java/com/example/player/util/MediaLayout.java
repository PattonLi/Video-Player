package com.example.player.util;

import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;

public class MediaLayout {
    private static Pane pane;

    public static void setPane(Pane mediaLayout) {
        MediaLayout.pane = mediaLayout;
    }
    
    public static void bindSize(MediaView mediaView){
        //绑定界面大小
        mediaView.setFitWidth(1150);
//        mediaView.setPreserveRatio(true);
//        mediaView.fitWidthProperty().bind(pane.getScene().widthProperty());
//        mediaView.fitHeightProperty().bind(pane.getScene().heightProperty());
    }
}
