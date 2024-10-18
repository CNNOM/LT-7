package com.example.task7;

import java.util.Observer;

public interface Subject {
    //уведомления всех наблюдателей
    public void notifyAllObserver();

    //добавления наблюдателя
    public void attach(Observer obs);

    //удаления наблюдателя
    public void detach(Observer obs);

    int getState();

    void setState(int time);
}
