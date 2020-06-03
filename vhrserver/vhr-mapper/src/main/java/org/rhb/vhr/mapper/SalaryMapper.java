package org.rhb.vhr.mapper;

import org.rhb.vhr.model.Salary;

import java.util.List;

public interface SalaryMapper {

    List<Salary> getAllSalary();

    Integer insertSelective(Salary salary);

    Integer deleteByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Salary salary);
}
