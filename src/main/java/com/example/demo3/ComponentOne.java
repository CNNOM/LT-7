package com.example.demo3;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ComponentOne extends Observer {
    private Label timeLabel;
    private int elapsedSeconds = 0;
    private LocalTime startTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ComponentOne(Subject subject, Label timeLabel) {
        this.subject = subject;
        this.timeLabel = timeLabel;
        this.startTime = LocalTime.now();
        subject.attach(this);
    }

    @Override
    public void update(Subject st) {
        Platform.runLater(() -> {
            elapsedSeconds++;
            String formattedStartTime = startTime.format(formatter);
            timeLabel.setText("Прошло " + elapsedSeconds + " с, запущено в " + formattedStartTime);
        });
    }
}