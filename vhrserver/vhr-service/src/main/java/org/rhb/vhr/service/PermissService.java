package org.rhb.vhr.service;

import org.rhb.vhr.mapper.PermissMapper;
import org.rhb.vhr.model.Menu;
import org.rhb.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PermissService {
    @Autowired
    PermissMapper permissMapper;
    @Autowired
    MenuService menuService;

    public List<Role> getAllRoles() {
        return permissMapper.getAllRoles();
    }

    public List<Menu> getAllMenus() {
        return permissMapper.getAllMenus();
    }

    public List<Integer> getMenusByRid(Integer id) {
        return menuService.getMenusByRid(id);
    }
}
