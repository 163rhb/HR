package org.rhb.vhr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("joblevel")
public class JobLevel implements Serializable {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;

    private String name;

    private String titleLevel;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;

    public JobLevel(String name) {
        this.name = name;
    }

    public JobLevel() {
    }
}
