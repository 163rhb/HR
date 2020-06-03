package org.rhb.vhr.service;

import org.rhb.vhr.mapper.Hr_RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class Hr_RoleService {
    @Autowired
    Hr_RoleMapper hr_roleMapper;

    @Transactional
    public boolean updateHrWithRoles(Integer hrid, Integer[] rids) {
        hr_roleMapper.deleteHrWithRoles(hrid);
        return hr_roleMapper.addHrWithRoles(hrid, rids);
    }

}
