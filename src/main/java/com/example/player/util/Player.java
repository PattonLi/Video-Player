package com.example.player.util;

import com.example.player.controller.FileController;
import com.example.player.controller.StatusController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


/**
 * 操作 mediaPlayer
 */
public class Player {


    //播放器组件
    private static MediaPlayer mediaPlayer;
    //播放速率
    private static Double playRate = 1.0;

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        Player.mediaPlayer = mediaPlayer;
        StatusController.onPlay(mediaPlayer);
    }

    private static void setRate() {
        mediaPlayer.setRate(playRate);
    }

    public static void startPlay() {
        playRate = 1.0;
        setRate();
        mediaPlayer.play();
        StatusController.setPlayStatusText("正在播放："+PlayList.getNameList().get(PlayList.getIndex())+" 播放速率："+playRate);
    }

    public static void pausePlay() {
        mediaPlayer.pause();
        StatusController.setPlayStatusText("暂停播放："+PlayList.getNameList().get(PlayList.getIndex())+" 播放速率："+playRate);
    }

    public static void stopPlay() {
        mediaPlayer.stop();
        StatusController.setPlayStatusText("停止播放："+PlayList.getNameList().get(PlayList.getIndex())+" 播放速率："+playRate);
    }

    public static void fastPlay() {
        if (playRate < 4.0) {
            playRate += 0.5;
            setRate();
            StatusController.setPlayStatusText("正在播放："+PlayList.getNameList().get(PlayList.getIndex())+" 播放速率："+playRate);
        } else {
            AlertInfo.showAlert("最高速率为4倍速！");
        }
    }

    public static void slowPlay(){
        if (playRate >0.25) {
            playRate -= 0.25;
            setRate();
            StatusController.setPlayStatusText("正在播放："+PlayList.getNameList().get(PlayList.getIndex())+" 播放速率："+playRate);
        } else {
            AlertInfo.showAlert("最低速率为0.25倍速！");
        }
    }

    public static void nextPlay(){
        int index = PlayList.getIndex();
        int len = PlayList.getLenOfPlaylist();
        if (index==len-1){
            AlertInfo.showAlert("已经是最后一个视频！");
        }else {
            PlayList.setIndex(index+1);
            stopPlay();
            FileController.loadVideo(PlayList.getPlaylist().get(index));
        }
    }

    public static void prePlay(){
        int index = PlayList.getIndex();
        int len = PlayList.getLenOfPlaylist();
        if (index==0){
            AlertInfo.showAlert("已经是第一个视频！");
        }else {
            PlayList.setIndex(index-1);
            stopPlay();
            FileController.loadVideo(PlayList.getPlaylist().get(index));
        }
    }

}
