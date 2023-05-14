package com.example.player.util;

import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert;
/**
 * 操作 mediaPlayer
 */
public class Player {

    private PlayList playList;

    //播放器组件
    private static MediaPlayer mediaPlayer;
    //播放速率
    private static Double playRate = 1.0;

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        Player.mediaPlayer = mediaPlayer;
    }

    private static void setRate() {
        mediaPlayer.setRate(playRate);
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
            AlertInfo.showAlert("最高速率为4倍速！");
        }
    }

    public static void slowPlay(){
        if (playRate >0.25) {
            playRate -= 0.25;
            setRate();
        } else {
            AlertInfo.showAlert("最低速率为0.25倍速！");
        }
    }

    public static void nextPlay(){

    }

    public static void prePlay(){

    }

}
