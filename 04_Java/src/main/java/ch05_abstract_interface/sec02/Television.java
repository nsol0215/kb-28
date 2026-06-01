package main.java.ch05_abstract_interface.sec02;

public class Television implements RemoteControl {

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다");
    }
}
