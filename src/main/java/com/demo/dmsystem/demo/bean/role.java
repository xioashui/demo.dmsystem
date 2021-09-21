package com.demo.dmsystem.demo.bean;

public class role {
    private String role_id;
    private String name;
    private String namezh;

    @Override
    public String toString() {
        return "role{" +
                "role_id='" + role_id + '\'' +
                ", name='" + name + '\'' +
                ", namezh='" + namezh + '\'' +
                '}';
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamezh() {
        return namezh;
    }

    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }
}
