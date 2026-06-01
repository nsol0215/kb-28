package main.java.ch02_conditional_loop_reference.basic.ch04.sec04;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++ ){
            System.out.println("***"+ i + "단 ***");
            for(int j = 1; j<=9; j++){
                System.out.printf("%d x  %d = %d%n", i, j, i*j);
            }
        }
    }
}