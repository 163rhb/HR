package org.rhb.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Positions implements Serializable {
    private Integer id;

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/ShangHai")
    private Date createDate;
    private Boolean enabled;

    public Positions(String name) {
        this.name = name;
    }


}
