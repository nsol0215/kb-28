package org.scoula.jdbc_ex.dao;

import org.edu.member.common.JDBCUtil;
import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.dao.UserDao;
import org.scoula.jdbc_ex.dao.UserDaoImpl;
import org.scoula.jdbc_ex.domain.UserVO;


import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class UserDaoTest {

    UserDao dao = new UserDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    void create() throws SQLException {
        UserVO user = new UserVO("app","1234",
                                "app","admin");
        int count =  dao.create(user);
        Assertions.assertEquals(1,count);
    }

    @Test
    void getList() {
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}