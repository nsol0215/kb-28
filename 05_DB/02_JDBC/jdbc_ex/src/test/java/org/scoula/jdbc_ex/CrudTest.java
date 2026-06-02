package org.scoula.jdbc_ex;

import org.junit.jupiter.api.*;
import java.org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {

    Connection conn;

    @BeforeEach
    void setUp() {
        conn = JDBCUtil.getConnection();
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            try (Statement st = conn.createStatement()) {
                st.executeUpdate("delete from users where id = 'winner2'");
            }
            conn.close();
        }
    }

    @Test
    @Order(1)
    @DisplayName("회원가입테스트함.")
    public void insertUser() throws SQLException {
        String sql = "insert into users(id, password, name, role) values(?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "winner2");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "win");
            pstmt.setString(4, "admin");
            int row = pstmt.executeUpdate();
            System.out.println(row);
            Assertions.assertEquals(1, row);
        }
    }

    @Test
    @Order(2)
    @DisplayName("user 목록 조회 테스트")
    public void selectUser() throws SQLException {
        String sql = "select * from users where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "admin");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        }
    }
}