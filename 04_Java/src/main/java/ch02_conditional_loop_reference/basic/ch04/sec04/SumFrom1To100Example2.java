package main.java.ch02_conditional_loop_reference.basic.ch04.sec04;

public class SumFrom1To100Example2 {
    public static void main(String[] args) {
        int sum = 0;
        int num = 1;
        while (num <= 100){
            sum += num;
            num ++;

        }
        System.out.println("1~100까지의합:"+sum);
    }
}
