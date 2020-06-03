package org.rhb.vhr.controller;

import org.rhb.vhr.model.Hr;
import org.rhb.vhr.model.RespBean;
import org.rhb.vhr.model.Role;
import org.rhb.vhr.service.HrService;
import org.rhb.vhr.service.Hr_RoleService;
import org.rhb.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    Hr_RoleService hr_roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keyWords) {
        Integer id = HrUtils.getCurrentHr().getId();
        return hrService.getAllHrs(id, keyWords);
    }

    @PostMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr)) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }


    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return hrService.getAllRoles();
    }

    /*操作hr_role表，先根据hrid删除，再根据hrid和rids插入（rids即传过来的角色数组）*/
    @PutMapping("/")
    public RespBean updateHrWithRoles(Integer hrid, Integer[] rids) {
        if (hr_roleService.updateHrWithRoles(hrid, rids)) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }

    }

    @DeleteMapping("/{rid}")
    public RespBean delHr(@PathVariable Integer rid) {
        if (hrService.delHr(rid)) {
            return RespBean.ok("删除成功！");

        } else {
            return RespBean.error("删除失败");
        }
    }


}