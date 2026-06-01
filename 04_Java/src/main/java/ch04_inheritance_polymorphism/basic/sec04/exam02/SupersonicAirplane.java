package main.java.ch04_inheritance_polymorphism.basic.sec04.exam02;

public class SupersonicAirplane extends Airplane {
   // 비행모드에 1과 2가 있다
    // final은 변수 변경 금지(재정의 금지)
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    // 현재 상태
    public int flyMode= NORMAL;

    @Override
    public void fly() {
        if(flyMode == SUPERSONIC) {
            System.out.println("초음속비행합니다.");
        } else { super.fly();
        }
    }
}
