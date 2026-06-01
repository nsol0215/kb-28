package main.java.ch09_collection_generic.collection.set.ex;

import java.util.*;

public class SetEx {
    // 컬렉션 특징 : 객체만 저장(기본 자료형 저장X), 크기 제한 X, 다양한 기능 제공

    // Set(집합)
    // - (주머니 안에서 어떤 걸 꺼낼지 모르니,) 중복 데이터 저장 불가 (같은 객체를 덮어 씌움)
    // - 순서를 유지하지 않음 (index X)
    // -> get() 메서드가 없음

    public void ex1() {
        // 기본적인 Set 사용법

        // Hashset은 대표적인 자식클래스
        // Set<String> set = new HashSet<String>();
        //-> 자식에 String 써도 되고 안써도 됨 (타입 추론)

        // HashSet : hashCode()를 이용해서 중복 비교
        // 사용조건1: 저장되는 객체에 hashCode() 오버라이딩 필수
        // 사용조건2: 저장되는 객체에 equals() 오버라이딩 필수

        // String, Integer 등 Java 제공 객체는
        // 기본적으로 hashCode(), equals() 등이 오버라이딩 되어있음
        Set<String> set = new HashSet<>();
        // (보충) 자바에서 객체란 ? new 연산자를 이용해서 heap 영역에 할 당한 것, () -> 생성자, set은 참조변수, 참조변수를 이용해서 heap으로 가면 그게 객체

        // 1. boolean set.add(E e): 추가
        set.add("딸기");
        set.add("포도");
        set.add("오렌지");
        set.add("체리");

        System.out.println(set);
        // Hashset은 순서 유지 X
        // 출력 -> [체리, 포도, 오렌지, 딸기]

        // 중복 저장 여부 확인 -> 중복 저장 X
        set.add("망고");
        set.add("망고");
        set.add("망고");

        System.out.println(set);
        // 출력 -> [체리, 포도, 망고, 오렌지, 딸기]

        // set에 null 저장 가능하나 1개만 가능함 (중복X)
        set.add(null);
        set.add(null);
        set.add(null);
        // 출력 -> [null, 체리, 포도, 망고, 오렌지, 딸기]
        System.out.println(set);

        // 2. int set.size() : 저장된 객체의 수 반환
        System.out.println(set.size());
        // 출력 -> 6

        // 3. boolean remove(E e)
        // - e와 똑같은 요소가 있으면 제거하고 true를 반환
        //   없으면 false를 반환

        // set에 딸기가 존재한다면
        if (set.remove("딸기")) {
            System.out.println("딸기가 제거되었습니다.");
        } else {
            System.out.println("딸기가 없습니다");
        }

        System.out.println(set);
        // 출력 -> [null, 체리, 포도, 망고, 오렌지] (딸기 제거)

        // 4. boolean set.contains(E e)
        // 여기서 boolean은 (반환형) 이 메소드를 출력하고 나면 반환하겠다는 의미
        // - set에 저장된 객체 중 e와 똑같은 객체가 있으면 true,
        //   없으면 false

        // 망고가 있다면 : 망고 있음
        // 망고가 없다면 : 망고 없음
        System.out.println("망고" + (set.contains("망고") ? "있음" : "없음"));

        // 5. void set.clear() : set에 저장된 객체 모두 지움
        set.clear();
        System.out.println(set);
        // 출력문 안에 적으면 오류 -> void로 반환할게 없는데 어떻게 출력하나

        // 6. boolean set. isEmpty()
        // - set에 저장된 객체가 없다면(비어있다면) true, 아니면 false
        System.out.println("set이 " + (set.isEmpty() ? "비어있음" : "비어있지않음")); // 비어있니?
        System.out.println("set이 " + (set.size() == 0 ? "비어있음" : "비어있지않음")); // 안에 객체 0개니?


    }

    public void ex2() {
        // Set에 저장된 값 꺼내 쓰기


        Set<String> set = new HashSet<>();
        set.add("딸기라떼");
        set.add("블루베리 스무디");
        set.add("흑당퐁라떼");
        set.add("아바라");

        // 1. Iterator(반복자)
        // - 컬렉션에서 제공하는 컬렉션 객체 반복 접근자
        // (컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할)


        /// Iterator set.iterator()
        // set의 내용을 순차(반복) 접근할 수 있는 형태로 변경해서 반환
        Iterator<String> it = set.iterator();

        // boolean it.hasNext()
        // - 다음 꺼낼 요소가 있으면 true, 없으면 false 반환
        while (it.hasNext()) {
            // E it.next() : 다음 요소를 꺼내서 반환
            System.out.println(it.next());
        }

        System.out.println("-------------------------------------");

        // 2. 향상된 for문
        // for(자료형 변수명 : 배열명 또는 컬렉션명)
        for (String str : set) {
            System.out.println(str);

        }
    }

    public void lotto() {
        // 로또 번호 (1 ~ 45, 난수, 6개, 중복X, 오름차순)
        // Math.random(); -> 이건 반환값 하나밖에 없음

        Random random = new Random(); // 난수 객체 생성

        // <Int>는 자료형이라 오류 -> Integer로
        // Set<Integer> lotto = new HashSet<>(); // -> 순서 유지 안됨
        // Set<Integer> lotto = new LinkedHashSet<>(); // -> 순서 유지
        Set<Integer> lotto = new TreeSet<>(); // -> 오름차순


        System.out.println(lotto.size());
        // 처음에는 0개

        // lotto에 난수 6개 추가
        while (lotto.size() < 6) {

        // random.nextInt(n): 0 <= x < n
        //                   0이상 n미만 난수 하나
            lotto.add(random.nextInt(45) + 1);
        // int값이 자동으로 Integer로 포장 (Auto Boxing)되어 lotto에 추가

            System.out.println(lotto + " ");

        }

        System.out.println(lotto);
    }

}
