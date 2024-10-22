package com.example.demo1;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class ComponentTwo extends Observer {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private int n;
    private int elapsedSeconds = 0;
    private MediaView mediaView;

    public ComponentTwo(Subject subject, String audioFilePath, int n, MediaView mediaView) {
        this.subject = subject;
        this.n = n;
        this.mediaView = mediaView;
        subject.attach(this);

        Media sound = new Media(new File(audioFilePath).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    @Override
    public void update(Subject st) {
        elapsedSeconds++;
        if (elapsedSeconds == n && !isPlaying) {
            mediaPlayer.play();
            isPlaying = true;
        }
    }
}