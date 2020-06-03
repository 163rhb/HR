package org.rhb.vhr.exception;

import org.rhb.vhr.model.Positions;
import org.rhb.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Position;
import java.util.List;

@RestController
@RequestMapping("/my")
public class MyCtroller{
    @Autowired
    PositionService positionService;

    @GetMapping("/datas")
    public List<Positions> getAllPositions(){
        return  positionService.getAllPosition();

    }


}
