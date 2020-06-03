package org.rhb.vhr.mapper;

import org.apache.ibatis.annotations.Param;

public interface Hr_RoleMapper {

    void deleteHrWithRoles(Integer hrid);

    boolean addHrWithRoles(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}
