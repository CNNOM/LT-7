package com.example.demo1;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ComponentThree extends Observer {
    private boolean isAnimating = false;
    private Label animationLabel;
    private int elapsedSeconds = 0;

    public ComponentThree(Subject subject, Label animationLabel) {
        this.subject = subject;
        this.animationLabel = animationLabel;
        subject.attach(this);
    }

    @Override
    public void update(Subject st) {
        elapsedSeconds++;
        if (elapsedSeconds % 20 == 0) {
            startAnimation();
        }
    }

    private void startAnimation() {
        Platform.runLater(() -> {
            animationLabel.setText("Состояние анимации: Анимация");
        });
    }

    public boolean isAnimating() {
        return isAnimating;
    }
}