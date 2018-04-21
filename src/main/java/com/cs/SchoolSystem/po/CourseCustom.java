package com.cs.SchoolSystem.po;

/**
 * Created by asus on 2018/4/12.
 */
public class CourseCustom extends Course {
    //所属院系名
    private String collegeName;

    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getcollegeName() {
        return collegeName;
    }
}
