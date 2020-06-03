package org.rhb.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.rhb.vhr.model.Positions;


import java.util.List;

public interface PositionMapper {

    List<Positions> getAllPosition();

    Integer addPosition(Positions record);

    Integer updatePositions(Positions record);

    Integer deletePositionById(Integer id);

    Integer deletePositionByIds(@Param("ids") Integer[] ids);
}
