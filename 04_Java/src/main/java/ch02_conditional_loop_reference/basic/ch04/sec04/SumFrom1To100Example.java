package main.java.ch02_conditional_loop_reference.basic.ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i<=100; i++){
            sum = sum + i;

        }
        System.out.print("1~100 합 :" + sum);
    }
}