package com.lopputyo.lopputyoapp.data;

import java.util.ArrayList;
import java.util.List;

public class MyDataClass {

    private long id;
    private String courseId;
    public List<StudentData> students = new ArrayList<>();

    private static long idCounter=0;

    public MyDataClass() {
        this("");
    }

    public long getId() {
        return this.id;
    }

    public String getCourseId() {
        return this.courseId;
    }


    public MyDataClass(String courseId) {
        this.id = idCounter++;
        this.courseId = courseId;
    }

}
