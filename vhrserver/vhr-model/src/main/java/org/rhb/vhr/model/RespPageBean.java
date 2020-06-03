package org.rhb.vhr.model;

import lombok.Data;

import javax.validation.constraints.Max;
import java.util.List;

@Data
public class RespPageBean {
    /*当前展示的数据，一共查询了多少条数据*/
    private Long total;
        private List<?> data;
}
