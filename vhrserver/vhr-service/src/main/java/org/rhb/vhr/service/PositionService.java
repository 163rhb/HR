package org.rhb.vhr.service;

import org.rhb.vhr.mapper.PositionMapper;
import org.rhb.vhr.model.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public Integer addPosition(Positions positions) {
        positions.setEnabled(true);
        positions.setCreateDate(new Date());
        return positionMapper.addPosition(positions);
    }

    public List<Positions> getAllPosition() {

        return positionMapper.getAllPosition();
    }

    public Integer updatePositions(Positions position) {

        return positionMapper.updatePositions(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionMapper.deletePositionById(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
