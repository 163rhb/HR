package org.rhb.vhr.controller.sys.basic;

import org.rhb.vhr.model.Positions;
import org.rhb.vhr.model.RespBean;
import org.rhb.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Positions> getAllPositions() {
        return positionService.getAllPosition();
    }

    /*参数以json形式传递，所以加注解*/
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Positions positions) {
        if (positionService.addPosition(positions) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败");


    }

    @PutMapping("/")
    public RespBean updatePositions(@RequestBody Positions position) {
        if (positionService.updatePositions(position) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/")
    public RespBean deletePositionById( Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/pi")
    public RespBean deletePositionByIds(Integer[] ids) {
        if (positionService.deletePositionByIds(ids) == ids.length) {
            return RespBean.ok("批量删除成功！");
        }
        return RespBean.error("批量删除失败！");
    }
}


