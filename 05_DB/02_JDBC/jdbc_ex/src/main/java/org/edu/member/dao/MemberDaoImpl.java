package org.edu.member.dao;

import org.edu.member.common.JDBCUtil;
import org.edu.member.run.MemberRun;
import org.edu.member.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    // JDBCUtil을 통해 Conncection 객체 가져오기
    Connection conn = JDBCUtil.getConnection();

    // 회원 등록
    @Override
    public void test() {

    }


    @Override
    // 부모한테로 던져서, throw 부모에서도 적어줘야함
    public int create(Member member) throws SQLException {

        // Statement를 사용하는 경우 sql문
        /*
        String sql = "INSERT INTO members VALUES (DEFAULT, "
                + member.getMemberId() + ", "
                + member.getMemberPw() +", "
                + member.getMemberName()+ ", "
                + member.getMemberRole()+", 'N');";
         */
        // PreparedStatement
        // - Statement의 자식으로 좀 더 향상된 기능을 제공
        // - ? (위치 홀더)를 이용하여 SQL에 작성되어지는 리터럴을 동적으로 제어
        // -> 오타 위험 감소, 가독성 상승

        // sql 문 작성 시 세미콜론 (;) 안쓰는 것이 관례
        String sql = "INSERT INTO members VALUES (DEFAULT, ? , ?, ?, ?, 'N')";

        // try - with - resources문을 사용하여 작업이 끝나면 close()가 자동 호출됨
        // try - catch - finally 사용할 필요가 없어짐.
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getMemberPw());
            pstmt.setString(3, member.getMemberName());
            pstmt.setString(4, member.getMemberName());
            // 이제 준비 끝...!

            //SELECT: execiteQuery(); -> ResultSet 반환
            // DML: executeUpdate(); -> 성공한 행의 개수 반환
            int result = pstmt.executeUpdate();

            // 성공 시 커밋
            // 조건
            if (result == 1)
                conn.commit();

            return result; // 성공한 행의 개수 반환
        }

    }

    // 회원 정보 수정
    @Override
    public int update(Member mem) throws SQLException {
        String sql = "update users set name= ?, role = ? where no = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mem.getMemberName());
            pstmt.setString(2, mem.getMemberRole());
            pstmt.setInt(3, mem.getMemberNo());

            int result = pstmt.executeUpdate();

            if (result == 1) conn.commit();

            return result;
        }

    }

    @Override
    public int delete(int member) throws SQLException {
        return 0;
    }

    @Override
    public Member get(int no) throws SQLException {
        return null;
    }

    @Override
    public List<Member> getList() throws SQLException {
        return List.of();
    }

    // 회원 부서명 조회
    @Override
    public Member getDeptName(int memberNo) throws SQLException {
        Member mem = null;

        // 여러줄로 작성하는 경우 띄어쓰기 주의!
        String sql = "select no, name, d.dept_no, dept_name " +
                "from members m " +
                "left join departments d on m.dept_no = d.dept_no " +
                "where no = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, memberNo);

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){ // no == pk == 조회 성공 시 1행만 존재
                    mem = new Member();
                    mem.setMemberNo( rs.getInt("NO") );
                    mem.setMemberName( rs.getString("NAME") );
                    mem.setDeptNo( rs.getInt("DEPT_NO") );
                    mem.setDeptName(rs.getString("DEPT_NAME"));
                }
            }
        }

        return mem; // 존재하면 mem, 없으면 null 반환
    }
}

