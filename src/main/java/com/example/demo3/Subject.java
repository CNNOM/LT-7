package com.example.demo3;

public interface Subject {
    // Уведомления всех наблюдателей
    public void notifyAllObserver();

    // Добавления наблюдателя
    public void attach(Observer obs);

    // Удаления наблюдателя
    public void detach(Observer obs);

    int getState();

    void setState(int time);
}