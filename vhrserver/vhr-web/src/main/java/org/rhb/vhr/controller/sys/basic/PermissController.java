package org.rhb.vhr.controller.sys.basic;

import org.rhb.vhr.model.Menu;
import org.rhb.vhr.model.RespBean;
import org.rhb.vhr.model.Role;
import org.rhb.vhr.service.MenuRoleService;
import org.rhb.vhr.service.PermissService;
import org.rhb.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    PermissService permissService;
    /* @Autowired
     MenuService menuService;*/
    @Autowired
    MenuRoleService menuRoleService;
    @Autowired
    RoleService roleService;


    @GetMapping("/")
    public List<Role> getAllRoles() {
        return permissService.getAllRoles();
    }

    @GetMapping("/allmenus")
    public List<Menu> getAllMenus() {
        return permissService.getAllMenus();

    }

    @GetMapping("/mid/menus/{id}")
    public List<Integer> getMidByRid(@PathVariable Integer id) {
        return permissService.getMenusByRid(id);

    }

    @PutMapping("/")
    public RespBean updatePermiss(Integer rid, Integer[] mids) {

        if (menuRoleService.updatePermiss(rid, mids)) {
            return RespBean.ok("更新成功");


        } else {
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role)) {
            return RespBean.ok("添加角色成功");
        } else {
            return RespBean.error("添加角色失败");
        }
    }

    @DeleteMapping("/{rid}")
    public RespBean delRole(@PathVariable Integer rid) {
        if (roleService.delRole(rid)) {
            return RespBean.ok("删除角色成功");
        }
        return RespBean.error("删除角色失败");
    }

}