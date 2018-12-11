package com.htcs.wework.system.model.dto;

import java.util.List;

/**
 * @author zhaokaiyuan
 * @create 2018-01-10 15:39
 **/
public class RouteDto {

    private String path;
    private String component;
    private String name;
    private Meta meta;
    private Boolean hidden;
    private List<RouteDto> children;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<RouteDto> getChildren() {
        return children;
    }

    public void setChildren(List<RouteDto> children) {
        this.children = children;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public static class Meta {
        private String icon;
        private String title;
        private String role;
        private String code;
        private Boolean noTab;
        private Byte functionType;

        public static Meta builder() {
            return new Meta();
        }


        public String getIcon() {
            return icon;
        }

        public Meta setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Meta setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getRole() {
            return role;
        }

        public Meta setRole(String role) {
            this.role = role;
            return this;
        }

        public String getCode() {
            return code;
        }

        public Meta setCode(String code) {
            this.code = code;
            return this;
        }

        public Byte getFunctionType() {
            return functionType;
        }

        public Meta setFunctionType(Byte functionType) {
            this.functionType = functionType;
            return this;
        }

        public Boolean getNoTab() {
            return noTab;
        }

        public Meta setNoTab(Boolean noTab) {
            this.noTab = noTab;
            return this;
        }
    }
}
