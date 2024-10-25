package com.example.demo3;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Signal extends Observer {
    int count;
    int start;
    String file;
    Media sound;
    MediaPlayer mediaPlayer;
    Boolean state;


    public Signal(Subject subject) {
        this.count = 0;
        this.state = false;
        this.start = subject.getState();
        this.file = "";
        this.sound = new Media(new File(file).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
    }



    //Устанавливает количество итераций (count) и активирует сигнал (state = true).
    public void onComp(int count) {
        this.count = count;
        this.state = true;
    }

    // Деактивирует сигнал (state = false) и останавливает воспроизведение медиаконтента (mediaPlayer.stop()).
    public void offComp() {
        this.state = false;
        mediaPlayer.stop();
    }

    // Останавливает воспроизведение медиаконтента
    public void delComo() {
        mediaPlayer.stop();
    }


    // Этот метод вызывается, когда объект Subject уведомляет наблюдателей об изменении состояния.
    @Override
    public void update(Subject st) {
        if (state) {
            if (st.getState() == start + count) {
                mediaPlayer.play();
                start += count;
            }
            if (st.getState() == start + 2){
                mediaPlayer.stop();
                state = false;
            }
        }
    }
}
