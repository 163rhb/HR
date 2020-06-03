package org.rhb.vhr.model;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Meta meta;

    private Integer parentId;
    private Boolean enabled;
    private List<Menu> children;
    // 这个菜单项需要哪些角色才可以访问
    private List<Role> roles;

}
