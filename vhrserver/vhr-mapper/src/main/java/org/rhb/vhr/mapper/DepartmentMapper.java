package org.rhb.vhr.mapper;
import org.rhb.vhr.model.Department;


import java.util.List;

public interface DepartmentMapper {
     int a=1;
     List<Department> getAllDepartments(Integer pid);

    String getParentPath(Integer parentId);

    boolean addDep(Department dep);

    Integer getId(String name);

    boolean updatePath(String depPath, Integer id);

    boolean delDep(Integer id);

    void updateIsParent(Integer parentId);

    boolean checkIsParentById(Integer id);

    Department getNewDep(String name);

    Integer getParentId(Integer id);

    Integer checkSon(Integer pid);

    void updateIsnParent(Integer parentId);

    List<Department> getAllDepartmentsWithOutChildren();
}
