package org.rhb.vhr.service;

import org.rhb.vhr.mapper.DepartmentMapper;
import org.rhb.vhr.mapper.EmployeeMapper;
import org.rhb.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    public boolean addDep(Department dep) {
        dep.setEnabled(true);
        dep.setIsParent(false);
        //插入新部门
        departmentMapper.addDep(dep);
        //通过新部门名字获取新部门的id
        Integer id = departmentMapper.getId(dep.getName());
        String idc = id.toString();
        //获取父部门的路径
        String path = departmentMapper.getParentPath(dep.getParentId());
        //更新父部门的isParent属性
        departmentMapper.updateIsParent(dep.getParentId());
        String newdepPath = path + "." + idc;
        //更新新部门的路径属性
        return departmentMapper.updatePath(newdepPath, id);
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();

    }


    public boolean delDep(Integer id) {
        //获取父部门id
        Integer parentId = departmentMapper.getParentId(id);
        //检查父节点id为这个id有多少个，如果只有一个，则更新父节点的isParent为true
        Integer sons = departmentMapper.checkSon(parentId);
        if (sons == 1) {
            departmentMapper.updateIsnParent(parentId);
        }
        return departmentMapper.delDep(id);
    }


    public boolean checkIsParentById(Integer id) {
        return departmentMapper.checkIsParentById(id);
    }

    public boolean checkIsHasEmployee(Integer id) {
        if (employeeMapper.checkIsHasEmployee(id) != 0)
            return true;
        else {
            return false;
        }
    }

    public Department getNewDep(String name) {
        return departmentMapper.getNewDep(name);

    }


}
