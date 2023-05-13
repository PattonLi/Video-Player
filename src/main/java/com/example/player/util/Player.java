package com.example.player.util;

import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert;

public class Player {
    //播放器组件
    private static MediaPlayer mediaPlayer;
    //播放速率
    private static Double playRate = 1.0;

    private static void setRate() {
        mediaPlayer.setRate(playRate);
    }
    private static void showAlert(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("注意");
        alert.setHeaderText("head");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void startPlay() {
        playRate = 1.0;
        setRate();
        mediaPlayer.play();
    }

    public static void pausePlay() {
        mediaPlayer.pause();
    }

    public static void stopPlay() {
        mediaPlayer.stop();
    }

    public static void fastPlay() {
        if (playRate < 4.0) {
            playRate += 0.5;
            setRate();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("最低率为0.25倍速！");
        }
    }

    public static void slowPlay(){
        if (playRate >0.25) {
            playRate -= 0.25;
            setRate();
        } else {
            showAlert("最低率为0.25倍速！");
        }
    }

}
