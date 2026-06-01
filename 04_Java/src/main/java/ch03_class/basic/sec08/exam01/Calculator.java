package main.java.ch03_class.basic.sec08.exam01;

import org.w3c.dom.ls.LSOutput;

public class Calculator {

    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    int plus(int x, int y) {
        int result = x + y;
        return result;
    }
    double divide(int x, int y){
            double result = (double)x / (double)y;
            return result;

//        double divide(double x, double y){
//            double result = x / y;
//            return result;
        // 이것도 써도 되는 건지 확인(가능)
        }
    }














    // --------------------------------------------------
//
//    //리턴값이 없는 메소드 선언
//    void powerOn() {
//        System.out.println("전원을 켭니다.");
//    }
//    //리턴값이 없는 메소드 선언
//    void powerOff() {
//        System.out.println("전원을 끕니다.");
//    }
//
//    //호출 시 두 정수 값을 전달받고,
//    //호출한 곳으로 결과값 int를 리턴하는 메소드 선언
//    int plus(int x, int y) {
//        int result = x + y;
//        return result; //리턴값 지정;
//    }
//        //호출 시 두 정수 값을 전달받고,
//        // 호출한 곳으로 결과값 double을 리턴하는 메소드선언
//        double divide(int x, int y) {
//            double result = (double)x / (double)y;
//            return result; //리턴값 지정;
//         }
//
//}
