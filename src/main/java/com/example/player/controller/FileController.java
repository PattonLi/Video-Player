package com.example.player.controller;

import com.example.player.util.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private static MediaView mediaView;

    public static void setMediaView(MediaView mediaView) {
        FileController.mediaView = mediaView;
    }

    public static void loadVideo(File file){
        //load
        String filepath = file.toURI().toString();
        System.out.println("filepath = " + filepath);
        //set media view
        Media media = new Media(filepath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        System.out.println("mediaPlayer initialize");
        Player.setMediaPlayer(mediaPlayer);
        //bind
        Volume.bindVolume();
        ProgSlider.bindProgressBar();
        MediaLayout.bindSize(mediaView);

    }

    public static void openFile() {
        //文件选择器
        AlertInfo.showAlert("你可以选择一个文件!");
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file(*.*)", "*.*");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            AlertInfo.showAlert("你没有选择文件！！");
        } else {
            loadVideo(file);
            //设置播放列表
            PlayList.setIndex(0);
            PlayList.setLenOfPlaylist(1);
            List<File> fileList = new ArrayList<>();
            fileList.add(file);
            PlayList.setPlaylist(fileList);
        }
    }

    public static void openFolder() {
        AlertInfo.showAlert("你可以选择一个或多个文件!");
        //文件选择器
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Files");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                System.out.println("Selected file: " + file.getAbsolutePath());
            }
            //默认第一个视频播放
            loadVideo(selectedFiles.get(0));
            //设置播放列表
            PlayList.setIndex(0);
            PlayList.setLenOfPlaylist(selectedFiles.size());
            PlayList.setPlaylist(selectedFiles);
        } else {
            AlertInfo.showAlert("你没有选择文件！");
        }

    }
}
