package com.lopputyo.lopputyoapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.lopputyo.lopputyoapp.data.MyDataClass;
import com.lopputyo.lopputyoapp.data.StudentData;
import com.lopputyo.lopputyoapp.service.StudentService;

@RestController
public class MyRestController {

    @Autowired
    StudentService pStudentService;
    
    @GetMapping("students")
    public List<StudentData> getStudents() throws Exception{
        pStudentService.SaveToFile();
        return pStudentService.getAllStudents();
    }

    @GetMapping("classes")
    public List<MyDataClass> getClasses(){
        return pStudentService.getAllClasses();
    }

    @GetMapping("courses")
    public List<MyDataClass> getCourses(){
        return pStudentService.getAllCourses();
    }


    @GetMapping("classes/{name}")
    public List<MyDataClass> getClassesByName(@PathVariable String classId){
        return pStudentService.getClassesByName(classId);
    }

    @GetMapping("students/{name}")
    public List<StudentData> getStudentDatas(@PathVariable String name){
        return pStudentService.getStudentsByClassId(name);
    }

    @GetMapping("courses/{name}")
    public List<MyDataClass> getCourseDatas(@PathVariable String name){
        return pStudentService.getCoursesByName(name);
    }


    @PostMapping("addstudents")
    public StudentData addStudents(@RequestBody StudentData studentsData){
    pStudentService.addStudents(studentsData);
    //pStudentService.SaveToFile();
    return studentsData;
    }

    @PostMapping("addclass")
    public String addClasses(@RequestBody StudentData studentData){

        pStudentService.students.add(studentData);

        return "Lisäys onnistui!";
    }

    @PostMapping("addcourses")
    public String addCourses(@RequestBody StudentData studentData){

        pStudentService.students.add(studentData);

        return "Lisäys onnistui!";
    }

    @DeleteMapping("students/delete/{id}")
    public void deleteStudentsById(@PathVariable long Id){
        pStudentService.deleteStudentsById(Id);
    }

}