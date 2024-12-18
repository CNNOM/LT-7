package com.example.demo3;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class ComponentThree extends Observer {
    private PathTransition pathTransition;
    private ImageView imageView;
    private int elapsedSeconds = 0;
    private static final int ANIMATION_INTERVAL = 20; // Интервал анимации в секундах

    public ComponentThree(Subject subject, ImageView imageView) {
        this.imageView = imageView;
        subject.attach(this);

        // Создаем Path для анимации
        Path path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(200, 0));
        path.getElements().add(new LineTo(200, 200));
        path.getElements().add(new LineTo(0, 200));
        path.getElements().add(new LineTo(100, 200));
        path.getElements().add(new LineTo(0, 0));

        // Создаем PathTransition для анимации
        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(ANIMATION_INTERVAL));
        pathTransition.setPath(path);
        pathTransition.setNode(imageView);
        pathTransition.setCycleCount(1); // Анимация будет проигрываться один раз
        pathTransition.playFromStart();
    }

    @Override
    public void update(int state) {
        elapsedSeconds++;
        if (elapsedSeconds % ANIMATION_INTERVAL == 0) {
            // Запускаем анимацию
            pathTransition.playFromStart();
            System.out.println("Animation started");
        }
    }
}