package org.rhb.vhr.service;

import org.rhb.vhr.mapper.RoleMapper;
import org.rhb.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public boolean addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.addRole(role);
    }

    public boolean delRole(Integer rid) {
        return roleMapper.delRole(rid);
    }
}
