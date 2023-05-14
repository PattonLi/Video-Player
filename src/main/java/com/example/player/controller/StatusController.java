package com.example.player.controller;

import com.example.player.util.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class StatusController {
    private static Label playStatus;
    private static Label progStatus;
    private static Timeline timeline;


    public static void setPlayStatus(Label playStatus) {
        StatusController.playStatus = playStatus;
    }

    public static void setProgStatus(Label progStatus) {
        StatusController.progStatus = progStatus;
    }

    public static void setPlayStatusText(String text){
        playStatus.setText(text);
    }
    public static void setProgStatusText(String text){
        progStatus.setText(text);
    }

    private static String formatDuration(Duration duration) {
        int totalSeconds = (int) Math.floor(duration.toSeconds());
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    public static void onPlay(MediaPlayer mediaPlayer) {
        //set 时间进度
        mediaPlayer.setOnReady(() -> {
            Duration totalDuration = mediaPlayer.getMedia().getDuration();

            timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), event -> {
                        Duration currentTime = mediaPlayer.getCurrentTime();
                        StatusController.setProgStatusText("进度:" + formatDuration(currentTime)+"/"+formatDuration(totalDuration));
                    })
            );
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        mediaPlayer.setOnEndOfMedia(() -> {
            timeline.stop();
        });
    }
}
