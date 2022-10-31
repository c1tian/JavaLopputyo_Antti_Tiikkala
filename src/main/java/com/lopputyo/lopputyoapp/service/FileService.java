package com.lopputyo.lopputyoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lopputyo.lopputyoapp.data.StudentData;


@Service
public class FileService {
    
    public void writeStudentsToFile(List<StudentData> studentDatas){
        //Tallentaa tiedostotyökaluilla opiskelijat tiedostoon
    }

    public List<StudentData> readStudentsFromFile(){
        //Lukee opiskelijat tiedostosta ja palauttaa olioina
        return null;
    }

}