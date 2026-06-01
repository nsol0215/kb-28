package main.java.ch03_class.basic.sec07.exam02;

public class KoreanExample {
    public static void main(String[] args) {

        // Korean 객체 생성
        Korean korean = new Korean("박자바", "011225-1234567");
        System.out.println("korean.nation:"+korean.nation);
        System.out.println("korean.name:"+korean.name);
        System.out.println("korean.ssn:"+korean.ssn);
        System.out.println();
        // 또다른 Korean 객체 생성
        Korean korean2 = new Korean("김자바","930525-0654321");
        System.out.println("korean2.nation:"+korean.nation);
        System.out.println("korean2.name:"+korean.name);
        System.out.println("korean2.ssn:"+korean.ssn);
    }
}
