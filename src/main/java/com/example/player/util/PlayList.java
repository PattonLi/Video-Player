package com.example.player.util;

import java.util.List;

public class PlayList {
    private static List playlist;
    private static int index;
    private static int lenOfPlaylist;

    public static void setPlaylist(List playlist) {
        PlayList.playlist = playlist;
    }

    public static void setIndex(int index) {
        PlayList.index = index;
    }

    public static void setLenOfPlaylist(int lenOfPlaylist) {
        PlayList.lenOfPlaylist = lenOfPlaylist;
    }

    public static List getPlaylist() {
        return playlist;
    }

    public static int getIndex() {
        return index;
    }

    public static int getLenOfPlaylist() {
        return lenOfPlaylist;
    }
}
