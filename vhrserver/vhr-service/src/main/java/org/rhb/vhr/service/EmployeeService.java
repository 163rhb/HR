package org.rhb.vhr.service;

import org.rhb.vhr.mapper.EmployeeMapper;
import org.rhb.vhr.model.Employee;
import org.rhb.vhr.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    public final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    EmployeeMapper employeeMapper;
    SimpleDateFormat yearFormat = new SimpleDateFormat("YYYY");
    SimpleDateFormat monthFormat = new SimpleDateFormat("mm");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");


    public RespPageBean getAllEmpByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }

        List<Employee> data = employeeMapper.getAllEmpByPage(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;


    }

    public boolean addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        boolean res = employeeMapper.addEmp(employee);
        if(res)
        {
            Employee emp=employeeMapper.getEmpById(employee.getId());
            logger.info(emp.toString());
            rabbitTemplate.convertAndSend("rhb.mail",emp);
        }
        return res;
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }

    public Integer maxWorkId() {
        return employeeMapper.maxWorkId();
    }

    public boolean delEmp(Integer id) {
        return employeeMapper.delEmp(id);
    }

    public boolean updateEmp(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }


    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> list = employeeMapper.getEmployeeByPageWithSalary(page, size);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(employeeMapper.getTotal(null, null));
        return respPageBean;
    }

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return employeeMapper.updateEmployeeSalaryById(eid,sid);
    }
}
