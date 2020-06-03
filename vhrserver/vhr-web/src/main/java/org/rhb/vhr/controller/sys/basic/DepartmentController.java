package org.rhb.vhr.controller.sys.basic;

import org.rhb.vhr.model.Department;
import org.rhb.vhr.model.RespBean;
import org.rhb.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep) {
        if (departmentService.addDep(dep)) {
            Department newDep = departmentService.getNewDep(dep.getName());
            return RespBean.ok("添加部门成功！", newDep);
        } else {
            return RespBean.error("添加部门失败");
        }
    }
    @DeleteMapping("/{id}")
    public RespBean delDep(@PathVariable Integer id) {
        if (departmentService.checkIsParentById(id))
            return RespBean.error("该部门还有子部门，不可删除！");
        if (departmentService.checkIsHasEmployee(id))
            return RespBean.error("该部门下还有员工，不可删除！");
        if (departmentService.delDep(id))
            return RespBean.ok("删除成功");
        else {
            return RespBean.error("删除部门失败");
        }

    }

}