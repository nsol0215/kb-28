package main.java.ch03_class.basic.sec07.exam01.run;

import main.java.ch03_class.basic.sec07.exam01.service.ClsService;
import main.java.ch03_class.basic.sec07.exam01.vo.Student;

public class ClsRun { // 실행용 클래스
    public static void main(String[] args) {
        Student std = new Student();

        // Student의 ex 메서드 호출
//        std.ex();

        ClsService service = new ClsService();
        service.ex1(); // 접근 제한자 예제 확인
        service.ex2(); // static 예제 확인
        service.ex3();
    }

}
