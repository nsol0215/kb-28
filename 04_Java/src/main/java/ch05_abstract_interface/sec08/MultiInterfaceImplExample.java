package main.java.ch05_abstract_interface.sec08;

import main.java.ch05_abstract_interface.sec04.RemoteControl;
import main.java.ch05_abstract_interface.sec04.RemoteControlExample;

public class MultiInterfaceImplExample {
    public static void main(String[] args) {

        RemoteControl rc = new SmartTelevision();
        rc.turnOn();
        rc.turnOff();

        Searchable searchable = new SmartTelevision();
        searchable.search("https://www.youtube.com");
    }
    }
