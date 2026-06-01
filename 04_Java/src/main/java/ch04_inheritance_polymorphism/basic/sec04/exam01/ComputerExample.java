package main.java.ch04_inheritance_polymorphism.basic.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        int r= 10;
        Calculator calculator = new Calculator();
        System.out.println("원 면적:" + calculator.areaCircle(r));
// 클래스 이름으로 부르지 말고, 만들어둔 객체 변수로 불러라
        Computer computer = new Computer();
        System.out.println("원 면적"+ computer.areaCircle(r));
    }
}
