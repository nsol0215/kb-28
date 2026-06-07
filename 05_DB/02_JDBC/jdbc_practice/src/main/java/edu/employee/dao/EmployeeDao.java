package edu.employee.dao;

import edu.employee.vo.EmployeeVO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {


    List<EmployeeVO> getDepartmentEmployees(EmployeeVO employeeVO) throws SQLException;

    List<EmployeeVO> getDeptAvgSal();

    List<EmployeeVO> getWorkingEmployees();

    int increaseSalary(String deptCode);

    List<EmployeeVO> getEmployeesWithoutPhone();
}
