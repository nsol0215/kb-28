package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2 // 콘솔에 내가 원하는 메시지로 출력 가능.
public class HomeController {
    // 하나의 http 요청당 서버에서는 메서드 하나랑 정의

    // 어떤 주소로 (/), 어떤 방법으로 (get)
    // --> get 요청으로 들어온 것 중에 주소가 / 이거인 것은 home 메서드를 실행시켜줘
    @GetMapping("/")
    public String home() {
        log.info("================> HomController /");
        return "index";                          // View의 이름
    }
}