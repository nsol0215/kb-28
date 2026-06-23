package main.java.ch01_variable_type_operator.basic.ch02.sec09;

public class PrimitiveAndStringConversionExample {
    public static void main(String[] args) {

        // parse : 문자열에서 숫자로 변경
        int value1 = Integer.parseInt("10");
        double value2 =  Double.parseDouble("3.14");
        boolean value3 =  Boolean.parseBoolean("true");
        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        System.out.println("value3: " + value3);

        // valueof : 숫자에서 문자열로 변경
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);

        // 외부에서 들어온 글자를 내부에서 연산하려고 숫자·논리로 바꿀 땐 ➡️ parse...
        // 내부에서 연산한 결과를 외부에 보여주거나 저장하려고 글자로 바꿀 땐 ➡️ String.valueOf()
    }
}