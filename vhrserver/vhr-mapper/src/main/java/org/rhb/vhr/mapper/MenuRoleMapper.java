package org.rhb.vhr.mapper;

import org.apache.ibatis.annotations.Param;


public interface MenuRoleMapper {

    void deletePermissByRid(Integer rid);

    Integer insertMids(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
