package org.rhb.vhr.service;

import org.rhb.vhr.mapper.NationMapper;
import org.rhb.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;


    public List<Nation> getAllNations() {
        return nationMapper.getALLNations();

    }
}
