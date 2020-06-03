package org.rhb.vhr.mapper;


import org.rhb.vhr.model.Menu;
import org.rhb.vhr.model.Role;

import java.util.List;

public interface PermissMapper {
    List<Role> getAllRoles();

    List<Menu> getAllMenus();
}
