package org.rhb.vhr.controller.sys.basic;


import org.rhb.vhr.model.*;
import org.rhb.vhr.service.*;
import org.rhb.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;



    @RestController
    @RequestMapping("/emp/basic")
    public class EmpBasicController {
        @Autowired
        EmployeeService employeeService;
        @Autowired
        NationService nationService;
        @Autowired
        PoliticsstatusService politicsstatusService;
        @Autowired
        JobLevelService jobLevelService;
        @Autowired
        PositionService positionService;
        @Autowired
        DepartmentService departmentService;

        @GetMapping("/")
        public RespPageBean getAllEmpByPage(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "10") Integer size,
                                            Employee employee, Date[] beginDateScope) {
            return employeeService.getAllEmpByPage(page, size, employee, beginDateScope);
        }

        @PostMapping("/")
        public RespBean addEmp(@RequestBody Employee employee) {
            if (employeeService.addEmp(employee)) {
                return RespBean.ok("添加成功");
            } else {
                return RespBean.error("添加失败");
            }
        }

        @GetMapping("/getAllNations/")
        public List<Nation> getAllNations() {
            return nationService.getAllNations();
        }

        @GetMapping("/getALLPoliticsStatus/")
        public List<Politicsstatus> getAllPoliticsStatus() {
            return politicsstatusService.getAllPoliticsStatus();
        }

        @GetMapping("/getAllJopLevels/")
        public List<JobLevel> getAllJopLevels() {
            return jobLevelService.getAllJobLevel();
        }

        @GetMapping("/getAllPositions/")
        public List<Positions> getAllPositions() {
            return positionService.getAllPosition();
        }

        @GetMapping("/getMaxWorkId/")
        public RespBean getMaxWorkId() {
            Integer maxWorkId = employeeService.maxWorkId() + 1;
            String id = String.format("%08d", maxWorkId);
            return RespBean.ok("", id);
        }

        @DeleteMapping("/{id}")
        public RespBean delEmp(@PathVariable Integer id) {
            if (employeeService.delEmp(id)) {
                return RespBean.ok("删除成功!");

            } else {
                return RespBean.error("删除失败!");
            }
        }

        @PutMapping("/")
        public RespBean updateEmp(@RequestBody Employee employee) {
            if (employeeService.updateEmp(employee)) {
                return RespBean.ok("更新成功！");
            } else {
                return RespBean.error("更新失败！");
            }
        }

        @GetMapping("/deps/")
        public List<Department> getAllDepartment() {
            return departmentService.getAllDepartments();
        }

        @GetMapping("/export/")
        public ResponseEntity<byte[]> exportData() {
            List<Employee> list = (List<Employee>) employeeService.getAllEmpByPage(null, null, null, null).getData();
            return POIUtils.employeeToExcel(list);

        }

        @PostMapping("/import/")
        public RespBean importData(MultipartFile file) {

            /*throws IOException {*/


            List<Employee> list = POIUtils.excelToEmployee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsStatus(), departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPosition(), jobLevelService.getAllJobLevel());
            if (employeeService.addEmps(list) == list.size()) {
                return RespBean.ok("上传成功");
            }
            return RespBean.error("上传失败");
        }
    }



