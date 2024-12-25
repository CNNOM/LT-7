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
        this.timeLabel = timeLabel;
        this.startTime = LocalTime.now();
        subject.attach(this);
    }

    @Override
    public void update(int state) {
        elapsedSeconds++;
        String formattedStartTime = startTime.format(formatter);
        String text = "Прошло " + elapsedSeconds + " с, запущено в " + formattedStartTime;

        timeLabel.setText(text);
    }
}