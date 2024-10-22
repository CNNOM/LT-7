package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.MediaView;

public class HelloController {
    @FXML
    private Label timeLabel;

    @FXML
    private Label animationLabel;

    @FXML
    private MediaView mediaView;

    private TimeServer timeServer;
    private ComponentOne componentOne;
    private ComponentTwo componentTwo;
    private ComponentThree componentThree;

    @FXML
    public void initialize() {
        // Создаем экземпляр TimeServer
        timeServer = new TimeServer();

        // Создаем компоненты и передаем им TimeServer
        componentOne = new ComponentOne(timeServer, timeLabel);
//        componentTwo = new ComponentTwo(timeServer, HelloApplication.class.getResource("video.mp4").toExternalForm(), 10, mediaView);
//        componentThree = new ComponentThree(timeServer, animationLabel);

        // Пример изменения состояния TimeServer
        timeServer.setState(1);
    }
}