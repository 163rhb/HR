package org.rhb.vhr.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Department implements Serializable {
    private Integer id;

    private String name;
    private Integer parentId;
    private String depPath;
    private Boolean enabled;
    private Boolean isParent;

    private List<Department> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }


}
