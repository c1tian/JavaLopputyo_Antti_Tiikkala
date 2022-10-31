package com.lopputyo.lopputyoapp.service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopputyo.lopputyoapp.data.MyDataClass;
import com.lopputyo.lopputyoapp.data.StudentData;

@Service
public class StudentService {
    public List<StudentData> students = new ArrayList<>();
    public List<MyDataClass> dataClasses = new ArrayList<>();


    public StudentService(){
        students.add(new StudentData("Konsta Juola", "TVT21SPL"));
        students.add(new StudentData("Antti Tiikkala", "TVT17SPO"));
        students.add(new StudentData("Hannu Juopperi", "TVT22SPL"));
        students.add(new StudentData("Antti Lassila", "TVV14SPP"));
        students.add(new StudentData("Olli Vanttaja", "TVT20SPO"));
        students.add(new StudentData("Kalevi Ruutikainen", "TVT19SPL"));

        MyDataClass class1 = new MyDataClass("Tietotekniikan Sovellusprojekti");
        class1.students.add(students.get(0));
        class1.students.add(students.get(2));
        class1.students.add(students.get(3));

        MyDataClass class2 = new MyDataClass("Soveltava Fysiikka");
        class2.students.add(students.get(1));
        class2.students.add(students.get(2));

        MyDataClass class3 = new MyDataClass("Ohjelmoinnin perusteet");
        class3.students.add(students.get(4));
        class3.students.add(students.get(5));
        class3.students.add(students.get(1));

        dataClasses.add(class1);
        dataClasses.add(class2);
        dataClasses.add(class3);
        
    }



    public List<MyDataClass> getClassesByName(String name){
        List<MyDataClass> found = new ArrayList<>();

        for (MyDataClass myDataClass : dataClasses) {
            if(myDataClass.getCourseId().equals(name)){
                found.add(myDataClass);
            }
            
        }
        return found;
    }

    public List<MyDataClass> getCoursesByName(String name){
        List<MyDataClass> found = new ArrayList<>();

        for (MyDataClass myDataClass : dataClasses) {
            if(myDataClass.getCourseId().equals(name)){
                found.add(myDataClass);
            }
            
        }
        return found;
    }

    public List<StudentData> getStudentsByClassId(String name){
        List<MyDataClass> classIdDataClasses = getClassesByName(name);

        List<StudentData> classIdStudents = new ArrayList<>();

        for (MyDataClass myDataClass : classIdDataClasses) {
            classIdStudents.addAll(myDataClass.students);
        }

        return classIdStudents;
    }

    @Autowired
    FileService fileService;
    public Object addStudents;

    public void savePersistentData(){
        fileService.writeStudentsToFile(students);
    }

    public void addStudents(StudentData studentData){
        students.add(studentData);
    }

    public List<StudentData> getAllStudents(){
        return students;
    }

    public List<MyDataClass> getAllClasses(){
        return dataClasses;
    }

    public List<MyDataClass> getAllCourses(){
        return dataClasses;
    }
    
    public StudentData getById(long id){
        for (StudentData studentData : students) {
            if(studentData.getId() == id){
                return studentData;
            }            
        }
        return null;
    }



    public void deleteStudentsById(long id) {
    }

    public void SaveToFile() throws Exception{
        File f = new File("C:\\OAMK\\koodinpaska\\2.Vuosi\\Java\\jdk-18.0.2.1\\lopputyoapp\\studentFile.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);

        for (StudentData studentData : students) {
            fw.write(studentData.getName()+"---");
            fw.write(studentData.getClassId()+System.lineSeparator());
        }

        fw.close();
    } 

}
