package com.crud.service;

import com.crud.entity.TeacherRecord;
import com.crud.repository.TeacherRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherRecordService {

    //create
    @Autowired
    public TeacherRecordRepo teacherRecordRepo;
    public TeacherRecord createTeacher(TeacherRecord saveData){

        TeacherRecord teacherData = new TeacherRecord();
        teacherData.setName(saveData.getName());
        teacherData.setEmail(saveData.getEmail());
        TeacherRecord dataSaved = this.teacherRecordRepo.save(teacherData);
        return dataSaved;
    }

    //read  tecId = 10  -> customerRecord : name,email
    public TeacherRecord teacherById(int tecId){

        TeacherRecord teacherData =  this.teacherRecordRepo.findById(tecId).get();
        return teacherData;
    }

    //UPDATE DATA BY ID
    public TeacherRecord updateTeacher(int tecId, TeacherRecord updateData){
        //first of all to check the teacher id available in db
        TeacherRecord data = this.teacherRecordRepo.findById(tecId).get();
        TeacherRecord newData = new TeacherRecord();
        if(data.getName()!=null){
            newData.setTecId(tecId);
            newData.setName(updateData.getName());
            newData.setEmail(updateData.getEmail());
            this.teacherRecordRepo.save(newData);
        }
        else {
            System.out.println("Teacher id:"+tecId+" is not found in Database");
        }
        return newData;
    }

    //delete
     public String deleteTeacher(int tecId){
        this.teacherRecordRepo.deleteById(tecId);
        return "user deleted with id :"+tecId+"Successfully !!!!";
     }

}
