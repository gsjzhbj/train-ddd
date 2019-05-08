package com.yonyou.driver.entity;

/*** 车主 ***/
public class Driver {
    private String id;
    private String name;
    private String age;
    private String totalDrive;//总单数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTotalDrive() {
        return totalDrive;
    }

    public void setTotalDrive(String totalDrive) {
        this.totalDrive = totalDrive;
    }
}
