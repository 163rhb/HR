package org.rhb.vhr.service;

import org.rhb.vhr.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MenuRoleService {
    @Autowired
    MenuRoleMapper menuRoleMapper;

    @Transactional
    public Boolean updatePermiss(Integer rid, Integer[] mids) {

        menuRoleMapper.deletePermissByRid(rid);
        if (mids == null || mids.length == 0)
            return true;
        Integer result = menuRoleMapper.insertMids(rid, mids);
        return result == mids.length;
    }
}
