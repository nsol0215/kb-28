package main.java.ch01_variable_type_operator.basic.ch02.sec01;

public class VariableUseExample {
    public static void main(String[] args) {
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간 " + minute + "분");

        int totalminute = (hour*60) + minute;
        System.out.println("총 " + totalminute + "분");
    }
}
