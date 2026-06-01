package main.java.ch04_inheritance_polymorphism.basic.sec04.exam01;

public class Computer extends Calculator{
    @Override
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return 3.14159 * r * r;
    }
}
