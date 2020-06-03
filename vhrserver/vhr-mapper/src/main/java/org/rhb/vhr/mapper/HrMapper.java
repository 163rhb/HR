package org.rhb.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.rhb.vhr.model.Hr;
import org.rhb.vhr.model.Role;


import java.util.List;

public interface HrMapper extends BaseMapper {

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("key") String keyWords);

    boolean updateHr(Hr hr);

    List<Role> getAllRoles();

    boolean delHr(Integer rid);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);

}
