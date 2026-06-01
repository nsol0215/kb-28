package main.java.ch03_class.basic.sec14;

public class Car {
    //필드 선언
    private int speed;
    private boolean stop;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
            return;
        } else {
            this.speed = speed;
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        if (stop == true) {
            this.speed = 0;
        } else {
            this.stop = stop;
        }
    }
}
