package org.scoula;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class RestaurantTest {

    @Autowired
    private Restaurant restaurant; //주소가 들어있어야함.

    @Test
    void getChef() {
        assertNotNull(restaurant); //문제가 없으면 출력되는 것이 없음.
        //문제가 있을때만 문제내용을 출력함.
        log.info(restaurant);
        log.info("--------------------");
        log.info(restaurant.getChef());
    }
}