package org.rhb.vhr.controller.sys.basic;

import org.rhb.vhr.model.Hr;
import org.rhb.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    HrService hrService;

    @GetMapping("/getallhrs")
    public List<Hr>getAllHrs()
    {
        return hrService.getAllHrsExceptCurrentHr();
    }
}
