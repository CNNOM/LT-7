package com.example.demo3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class ComponentTwo extends Observer {
    private MediaPlayer mediaPlayer;
    private Timeline timeline;
    private long restartInterval; // Время через которое перезапускать видео
    private MediaView mediaView;
    private int elapsedSeconds = 0;


    public ComponentTwo(Subject subject, String videoPath, long restartInterval, MediaView mediaView) {
        this.subject = subject;
        this.restartInterval = restartInterval;
        this.mediaView = mediaView;
        subject.attach(this);

        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.play();
    }

    @Override
    public void update(Subject st) {
        elapsedSeconds++;
        if (elapsedSeconds % this.restartInterval == 0) {
            mediaPlayer.stop();
            mediaPlayer.play();
            System.out.println("update");
        }
    }
}