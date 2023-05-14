package com.example.player.util;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Slider;

public class Volume {
    private static Slider volSlider;

    public static void setVolSlider(Slider volSlider) {
        Volume.volSlider = volSlider;
    }

    public static void bindVolume(){
        //绑定音量条
        volSlider.setValue(Player.getMediaPlayer().getVolume() * 100);
        volSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Player.getMediaPlayer().setVolume(volSlider.getValue() / 100);
            }
        });
    }
}
