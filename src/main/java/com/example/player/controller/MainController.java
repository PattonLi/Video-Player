package com.example.player.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.player.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;


public class MainController implements Initializable {
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider volSlider;
    @FXML
    private Slider progSlider;
    @FXML
    private Pane mediaLayout;
    @FXML
    private ListView list;
    @FXML
    private Label playStatus;
    @FXML
    private Label progStatus;

    //文件打开，关闭
    @FXML
    private void openVideo(ActionEvent event) {
        FileController.openFile();
        System.out.println("open success");
    }

    @FXML
    private void openFolder(ActionEvent event) {
        FileController.openFolder();
        System.out.println("open success");
    }

    @FXML
    private void clearPlaylist(ActionEvent event) {
        FileController.openFile();
        System.out.println("open success");
    }

    //initialize
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Volume.setVolSlider(volSlider);
        System.out.println("Volume initialize");
        ProgSlider.setProgSlider(progSlider);
        System.out.println("progSlider initialize");
        FileController.setMediaView(mediaView);
        System.out.println("mediaView initialize");
        MediaLayout.setPane(mediaLayout);
        System.out.println("mediaLayout initialize");
        PlayList.setListView(list);
        System.out.println("list initialize");
        StatusController.setProgStatus(progStatus);
        System.out.println("progStatus initialize");
        StatusController.setPlayStatus(playStatus);
        System.out.println("playStatus initialize");
    }

    //播放、暂停、停止
    @FXML
    private void playVideo(ActionEvent event) {
        System.out.println("start play");
        Player.startPlay();
    }

    @FXML
    private void pauseVideo(ActionEvent event) {
        Player.pausePlay();
        System.out.println("pause play");
    }

    @FXML
    private void StopVideo(ActionEvent event) {
        Player.stopPlay();
        System.out.println("stop play");
    }

    //调整速率
    @FXML
    private void fastVideo(ActionEvent event) {
        Player.fastPlay();
        System.out.println("faster play");
    }

    @FXML
    private void slowVideo(ActionEvent event) {
        Player.slowPlay();
        System.out.println("slower play");
    }

    //切换影片
    @FXML
    private void preVideo(ActionEvent event) {
        Player.prePlay();
        System.out.println("back play");
    }

    @FXML
    private void nextVideo(ActionEvent event) {
        Player.nextPlay();
        System.out.println("forward play");
    }

    //帮助菜单栏
    @FXML
    private void showInfo(ActionEvent event) {
        HelpController.showInfo();
    }

    @FXML
    private void showAbout(ActionEvent event) {
        HelpController.showAbout();
    }
}
