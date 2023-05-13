package com.example.player.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.player.util.PlayList;
import com.example.player.util.Player;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;


public class MainController implements Initializable {
    private PlayList playList;
    private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;
    @FXML
    private Slider slider;
    @FXML
    private Slider seekSlider;

    private String filepath;
    @SuppressWarnings("FieldMayBeFinal")
    private Double playbackRate = 1.0;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Slect a file(*.mp4)", "*.mp4");
        fileChooser.getExtensionFilters().add(filter);

        File file = fileChooser.showOpenDialog(null);
        filepath = file.toURI().toString();
        if (filepath != null) {
            Media media = new Media(filepath);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();

            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            slider.setValue(mediaPlayer.getVolume() * 100);
            slider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(slider.getValue() / 100);
                }
            });

            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                    seekSlider.setValue(newValue.toSeconds() / mediaPlayer.getTotalDuration().toSeconds() * 100);

                }
            });

            seekSlider.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(Duration.seconds(seekSlider.getValue() * mediaPlayer.getTotalDuration().toSeconds() / 100));
                }
            });
            mediaPlayer.play();
        }
    }


    //播放、暂停、停止
    @FXML
    private void playVideo(ActionEvent event) {
        Player.startPlay();
    }
    @FXML
    private void pauseVideo(ActionEvent event) {
        Player.pausePlay();
    }
    @FXML
    private void StopVideo(ActionEvent event) {
        Player.stopPlay();
    }

    //调整速率
    @FXML
    private void fastVideo(ActionEvent event) {
        Player.fastPlay();
    }
    @FXML
    private void slowVideo(ActionEvent event) {
        Player.slowPlay();
    }

    //切换影片
    @FXML
    private void preVideo(ActionEvent event){Player.prePlay();}
    @FXML
    private void nextVideo(ActionEvent event){Player.nextPlay();}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
