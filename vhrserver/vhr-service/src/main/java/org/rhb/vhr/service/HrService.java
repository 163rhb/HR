package org.rhb.vhr.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.rhb.vhr.mapper.HrMapper;
import org.rhb.vhr.model.Hr;
import org.rhb.vhr.model.Role;
import org.rhb.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*QueryWrapper<Hr> qw=new QueryWrapper<>();
        Hr hrsult = (Hr) hrMapper.selectOne(qw.eq("name","刘红雨"));
        if(hrsult==null)
        {
           throw new UsernameNotFoundException("用户名不存在!");
        }*/

        Hr hr = hrMapper.loadUserByUsername(username);

        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(Integer id, String keyWords) {
        return hrMapper.getAllHrs(id, keyWords);
    }
    public boolean updateHr(Hr hr) {
        return hrMapper.updateHr(hr);
    }
    public List<Role> getAllRoles() {
        return hrMapper.getAllRoles();
    }
    public boolean delHr(Integer rid) {
        return hrMapper.delHr(rid);
    }
    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }
}
