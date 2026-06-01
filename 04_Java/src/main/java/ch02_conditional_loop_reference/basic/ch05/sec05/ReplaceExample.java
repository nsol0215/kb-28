package main.java.ch02_conditional_loop_reference.basic.ch05.sec05;

public class ReplaceExample {
    public static void main(String[] args) {
        String oldStr = "자바문자열은불변입니다. 자바문자열은String입니다.";
        String newStr = oldStr.replace("자바","JAVA") ;
        System.out.println(oldStr);
        System.out.println(newStr);
    }
}
