package main.java.ch01_variable_type_operator.basic.ch02.sec08;

public class CastingExample {
    public static void main(String[] args) {

        // 담을 수 있는 메모리 크기가 작은 곳에 큰 걸 담으려고 하니 에러 발생
        // -> "나도 이거 작은 그릇으로 옮기면 넘칠 수 있는 거 알아.
        // 하지만 지금은 10이라는 작은 숫자가 들어있어서 안 넘치니까 안전해. 그러니까 에러 내지 말고 그냥 진행해!"

        int var1 = 10;
        byte var2 = (byte)var1;
        System.out.println(var2);

        long var3 = 300;
        int var4 = (int)var3;
        System.out.println(var4);

        int var5 = 65;
        char var6 = (char)var5;
        System.out.println(var6);

        double var7 = 3.14;
        int var8 = (int)var7;
        System.out.println(var8);
    }
}
