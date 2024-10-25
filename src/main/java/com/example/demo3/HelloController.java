package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.nio.file.Paths;

public class HelloController {
    @FXML
    private MediaView mediaView;

    private MediaPlayer mediaPlayer;

    @FXML
    private Label timeLabel;

    @FXML
    private Label animationLabel;
    @FXML
    private ImageView animationImageView;

    private TimeServer timeServer;
    private ComponentOne componentOne;
    private ComponentTwo componentTwo;
    private ComponentThree componentThree;

    @FXML
    public void initialize() {
        timeServer = new TimeServer();

        componentOne = new ComponentOne(timeServer, timeLabel);

        // Укажите путь к видеофайлу
        String videoPath = Paths.get("src/main/resources/com/example/demo3/video.mp4").toUri().toString();
        String videoPath2 = Paths.get("src/main/resources/com/example/demo3/rickroll.mp4").toUri().toString();

        componentTwo = new ComponentTwo(timeServer, videoPath2, 10, mediaView);

        String imagePath = Paths.get("src/main/resources/com/example/demo3/fett4hire-doomcock.gif").toUri().toString();
        Image image = new Image(imagePath);
        animationImageView.setImage(image);
        componentThree = new ComponentThree(timeServer, animationImageView);

        timeServer.setState(1);
    }
}