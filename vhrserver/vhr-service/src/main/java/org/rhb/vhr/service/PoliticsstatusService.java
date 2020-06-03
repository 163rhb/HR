package org.rhb.vhr.service;

import org.rhb.vhr.mapper.PoliticsstatusMapper;
import org.rhb.vhr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsStatus() {
        return politicsstatusMapper.getAllPoliticsStatus();
    }
}
