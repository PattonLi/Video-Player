package com.example.player.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class ProgSlider {
    static Slider progSlider;

    public static void setProgSlider(Slider Slider) {
        progSlider = Slider;
    }

    public static void bindProgressBar(){
        //绑定进度条
        Player.getMediaPlayer().currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                progSlider.setValue(newValue.toSeconds() / Player.getMediaPlayer().getTotalDuration().toSeconds() * 100);
            }
        });
        progSlider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Player.getMediaPlayer().seek(Duration.seconds(progSlider.getValue() * Player.getMediaPlayer().getTotalDuration().toSeconds() / 100));
            }
        });
    }
}
