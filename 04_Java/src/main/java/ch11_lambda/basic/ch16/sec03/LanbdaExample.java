package main.java.ch11_lambda.basic.ch16.sec03;

public class LanbdaExample {
    public static void main(String[] args) {

        Person person = new Person();

        // 매개변수가 두 개일 경우
        person.action1((String name, String job) -> {
                System.out.print(name + "이");
                System.out.println(job + "을 합니다.");

        });
        person.action1((String name, String job) -> {
            System.out.println(name + "이 "+ job + "을 합니다.");});

    }}
