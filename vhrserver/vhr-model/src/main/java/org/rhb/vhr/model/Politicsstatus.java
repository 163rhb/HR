package org.rhb.vhr.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Politicsstatus implements Serializable {
    private Integer id;

    private String name;

    public Politicsstatus(String name) {
        this.name = name;
    }


}
