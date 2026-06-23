package main.java.ch01_variable_type_operator.basic.ch02.sec06;

public class StringExample {
    public static void main(String[] args) {
        String name = "홍길동";
        String job = "프로그래머";

        System.out.println(name);
        System.out.println(job);

        System.out.println("나는 \"자바\"를 배웁니다.");
        // 출력 : 나는 "자바"를 배웁니다
        // -> ""에 오류내지 않기 위해 \를 사용

        System.out.print("나는\n");
        System.out.print("자바를\n");
        System.out.print("배웁니다.");

        // -> println 대신 사용
    }
}
