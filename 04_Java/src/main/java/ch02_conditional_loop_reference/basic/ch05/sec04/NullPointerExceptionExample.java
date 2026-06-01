package main.java.ch02_conditional_loop_reference.basic.ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
        intArray[0] = 10; // null에대해서대입연산실행
        String str = null;
        System.out.println("총문자수: " + str.length() );  // null에대해서length() 메서드호출
    }
}
