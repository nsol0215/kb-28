package main.java.ch05_abstract_interface.sec08;

import main.java.ch05_abstract_interface.sec04.RemoteControl;

import java.net.URL;

public class SmartTelevision implements RemoteControl,Searchable {
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다");
    }

    @Override
    public void setVolume(int volume) {

    }

    @Override
    public void search(String url) {
        System.out.println(url + "을 검색합니다");
    }
}
