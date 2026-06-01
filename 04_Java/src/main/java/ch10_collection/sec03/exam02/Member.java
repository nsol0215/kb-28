package main.java.ch10_collection.sec03.exam02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, toString, equals, hashCode 등 자동 생성
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 매개변수 생성자
public class Member {
    public String name;
    public int age;
}
