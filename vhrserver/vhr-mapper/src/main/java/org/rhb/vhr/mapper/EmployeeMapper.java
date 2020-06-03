package org.rhb.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.rhb.vhr.model.Employee;
import org.rhb.vhr.model.RespPageBean;


import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    Integer checkIsHasEmployee(Integer id);

    List<Employee> getAllEmpByPage(@Param("page") Integer page, @Param("size") Integer size,
                                   @Param("emp") Employee employee,
                                   @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employee employee,
                  @Param("beginDateScope") Date[] beginDateScope);

    boolean addEmp(Employee employee);

    Integer maxWorkId();

    boolean delEmp(Integer id);

    boolean updateEmp(Employee employee);

    Integer addEmps(List<Employee> list);

    Employee getEmpById(Integer id);

    List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page,@Param("size") Integer size);

    Integer updateEmployeeSalaryById(@Param("eid") Integer eid,@Param("sid") Integer sid);
}
