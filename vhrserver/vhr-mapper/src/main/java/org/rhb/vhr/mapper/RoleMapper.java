package org.rhb.vhr.mapper;


import org.rhb.vhr.model.Role;

public interface RoleMapper {

    boolean addRole(Role role);

    boolean delRole(Integer rid);
}
