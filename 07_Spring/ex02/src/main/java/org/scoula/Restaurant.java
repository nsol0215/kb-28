package org.scoula;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Restaurant {

    @Autowired //스프링이 자동을 ram에 어디에 찾아서 주소를 아래 변수에 넣어줌.
    //inject, 주입
    private Chef chef; //chef가 램에 어디에 있는지 주소만 알면 찾을 수 있음.

}
