package org.rhb.vhr.controller.sys.basic;

import org.rhb.vhr.model.JobLevel;
import org.rhb.vhr.model.RespBean;
import org.rhb.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevel() {
        return jobLevelService.getAllJobLevel();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1)
            return RespBean.ok("添加成功");
        else {
            return RespBean.error("添加失败");
        }

    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1)
            return RespBean.ok("更新成功");
        else {
            return RespBean.error("添加失败");
        }
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelById(Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1)
            return RespBean.ok("删除成功！");
        else {
            return RespBean.error("删除失败");
        }
    }

    @DeleteMapping("/pi")
    public RespBean deletePositionByIds(Integer[] ids) {
        if (jobLevelService.deletePositionByIds(ids) == ids.length) {
            return RespBean.ok("批量删除成功！");
        }
        return RespBean.error("批量删除失败！");
    }


}