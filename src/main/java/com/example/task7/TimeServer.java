package com.example.task7;

import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Observable;
import java.util.ArrayList;
import java.util.List;



public class TimeServer extends Observable implements Subject {
    private int timeState = 0;
    private List<Observer> observers = new ArrayList<>();

    public TimeServer(){
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L;
        /*
        delay — это время задержки перед первым выполнением задачи.
        В данном случае задержка составляет 1000 миллисекунд (1 секунда).
        period — это интервал времени между последовательными выполнениями задачи.
        В данном случае период равен 1000 миллисекунд (1 секунда) * 60 (минут) * 60 (часов) * 24 (дней), что составляет 24 часа.
        */


        //вызывает метод tick(), который будет выполняться каждый раз, когда таймер сработает.
        TimerTask task = new TimerTask() {
            public void run() {
                tick();
            }
        };

        timer.schedule(task, delay, period);
    }

    private void tick(){
        timeState++;
        notifyAllObserver();
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(this, null);
        }
    }

    @Override
    public void attach(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public int getState() {
        return timeState;
    }

    @Override
    public void setState(int time) {
        this.timeState = time;
        notifyAllObserver();
    }
}
