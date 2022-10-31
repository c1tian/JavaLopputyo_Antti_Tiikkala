package com.lopputyo.lopputyoapp.data;



public class StudentData {
    
    private long id;
    private String name;
    private String classId;
    private static long idCounter=0;

    public StudentData() {
        this("", "");

    }

    public long getId() {
        return this.id;
    }

    public String getClassId() {
        return this.classId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentData(String name, String classId) {
        this.id = idCounter++;
        this.name = name;
        this.classId = classId;
    }

}

