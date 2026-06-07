package edu.employee.dao;



import edu.employee.vo.EmployeeVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static edu.common.JDBCUtil.getConnection;

public class EmployeeDaoImpl implements EmployeeDao {

    private Connection conn = getConnection();


    // 부서별 직원 정보 조회
    @Override
    public List<EmployeeVO> getDepartmentEmployees(EmployeeVO employeeVO) throws SQLException {
        List<EmployeeVO> list = new ArrayList<>();


        String sql = "SELECT E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME, E.BONUS, E.ENT_YN " +
                "FROM EMPLOYEE E " +
                "JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID " +
                "JOIN JOB J ON E.JOB_CODE = J.JOB_CODE " +
                "WHERE D.DEPT_TITLE = ? " +
                "ORDER BY E.BONUS DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employeeVO.getDeptTitle());

            try (ResultSet rs = pstmt.executeQuery()) {
                pstmt.setString(1, employeeVO.getDeptTitle());

                while (rs.next()) {
                    EmployeeVO vo = new EmployeeVO();
                    vo.setEmpName(rs.getString("EMP_NAME"));
                    vo.setDeptTitle(rs.getString("DEPT_TITLE"));
                    vo.setJobName(rs.getString("JOB_NAME"));
                    vo.setBonus(rs.getString("BONUS"));
                    vo.setEntYn(rs.getString("ENT_YN"));
                    list.add(vo);
                }
            }

            return list;
        }

    }

    // 부서·직급별 평균 급여 조회
    @Override
    public List<EmployeeVO> getDeptAvgSal() {
        List<EmployeeVO> list = new ArrayList<>();

        String sql = "SELECT D.DEPT_TITLE, J.JOB_NAME, COUNT(*) AS EMP_COUNT, ROUND(AVG(E.SALARY)) AS AVG_SAL " +
                "FROM EMPLOYEE E " +
                "JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID " +
                "JOIN JOB J ON E.JOB_CODE = J.JOB_CODE " +
                "WHERE E.ENT_YN = 'N' " +
                "GROUP BY D.DEPT_TITLE, J.JOB_NAME " +
                "HAVING AVG(E.SALARY) >= 3000000 " +
                "ORDER BY AVG_SAL DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EmployeeVO vo = new EmployeeVO();
                vo.setDeptTitle(rs.getString("DEPT_TITLE"));
                vo.setJobName(rs.getString("JOB_NAME"));
                vo.setEmployeeCount(rs.getInt("EMP_COUNT"));
                vo.setAvgSalary(rs.getDouble("AVG_SAL"));
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

    // 재직 중인 직원 목록 조회
    @Override
    public List<EmployeeVO> getWorkingEmployees() {
        List<EmployeeVO> list = new ArrayList<>();

        String sql = "SELECT D.DEPT_TITLE, J.JOB_NAME, E.EMP_NAME, E.SALARY " +
                "FROM EMPLOYEE E " +
                "LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID " +
                "JOIN JOB J ON E.JOB_CODE = J.JOB_CODE " +
                "WHERE E.ENT_YN = 'N' " +
                "ORDER BY J.JOB_NAME ASC " +
                "LIMIT 10";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EmployeeVO vo = new EmployeeVO();
                vo.setDeptTitle(rs.getString("DEPT_TITLE"));
                vo.setJobName(rs.getString("JOB_NAME"));
                vo.setEmpName(rs.getString("EMP_NAME"));
                vo.setSalary(rs.getInt("SALARY"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int increaseSalary(String deptCode) {

        String sql = "UPDATE EMPLOYEE SET SALARY = SALARY * 1.1 WHERE DEPT_CODE = ?";

        int result = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deptCode);

            result = pstmt.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public List<EmployeeVO> getEmployeesWithoutPhone() {
        List<EmployeeVO> list = new ArrayList<>();

        String sql = "SELECT E.EMP_NAME, E.PHONE, D.DEPT_TITLE " +
                "FROM EMPLOYEE E " +
                "LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID " +
                "WHERE E.PHONE IS NULL " +
                "ORDER BY E.EMP_NAME DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EmployeeVO vo = new EmployeeVO();
                vo.setEmpName(rs.getString("EMP_NAME"));
                vo.setPhone(rs.getString("PHONE"));
                vo.setDeptTitle(rs.getString("DEPT_TITLE"));
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }
}
