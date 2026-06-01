package main.java.ch12.basic.sec04.exam03;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static int sum;

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1,100);
        intStream.forEach(a -> sum += a);
        System.out.println("총합:"+sum);

    }
}
