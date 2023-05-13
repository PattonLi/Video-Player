package com.example.player.controller;

import com.example.player.util.AlertInfo;
import com.example.player.util.Player;
import com.example.player.util.ProgSlider;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import java.io.File;

public class FileController {
    public static void openFile(MediaView mediaView){
        //文件选择器
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file(*.mp4)", "*.mp4");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        String filepath = file.toURI().toString();
        System.out.println("filepath = " + filepath);
        System.out.println("file.getName() = " + file.getName());

        //判断路径是否正确
        if (filepath != null) {
            //set media view
            Media media = new Media(filepath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            System.out.println("mediaPlayer initialize");
            Player.setMediaPlayer(mediaPlayer);
            //绑定界面大小
            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();
            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            //bind
            ProgSlider.bindProgressBar();
        } else {
            AlertInfo.showAlert("你的路径选择错误！");
        }
    }
}
