package com.example.player.util;

import com.example.player.controller.FileController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayList {
    public static List<String> getNameList() {
        return nameList;
    }

    private static List<File> playlist;
    private static List<String> nameList=new ArrayList<>();
    private static int index;
    private static int lenOfPlaylist;
    private static ListView listView;
    private static ObservableList<String> observableItemList;

    public static void setListView(ListView listView) {
        PlayList.listView = listView;

        //add mouse click
        listView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) { // 双击事件
                Object selectedItem = listView.getSelectionModel().getSelectedItem();
                AlertInfo.showAlert("你选择跳转到: " + selectedItem.toString());
                //停止播放
                Player.stopPlay();
                int nextIndex = observableItemList.indexOf(selectedItem);
                FileController.loadVideo(playlist.get(nextIndex));
            }
        });
    }

    public static void setPlaylist(List<File> playlist) {
        PlayList.playlist = playlist;
        nameList.clear();
        for (int i = 0; i < playlist.size(); i++) {
            File file = playlist.get(i);
            nameList.add(file.getName());

        }
        observableItemList = FXCollections.observableList(nameList);
        listView.setItems(observableItemList);
    }

    public static void setIndex(int index) {
        PlayList.index = index;
    }

    public static void setLenOfPlaylist(int lenOfPlaylist) {
        PlayList.lenOfPlaylist = lenOfPlaylist;
    }

    public static List<File> getPlaylist() {
        return playlist;
    }

    public static int getIndex() {
        return index;
    }

    public static int getLenOfPlaylist() {
        return lenOfPlaylist;
    }
}
