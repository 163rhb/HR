package org.rhb.vhr.service;

import org.rhb.vhr.mapper.MenuMapper;
import org.rhb.vhr.model.Hr;
import org.rhb.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenuByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    //每次请求都要查询,而且菜单几乎没什么变化，最好加缓存，redis@Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Integer> getMenusByRid(Integer id) {
        return menuMapper.getMidsByRid(id);
    }

    /*public List<Menu> getAllMenus() {

    }*/
}
