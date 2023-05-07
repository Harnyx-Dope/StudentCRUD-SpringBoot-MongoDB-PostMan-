package com.example.SpringMongoStudent.Service;

import com.example.SpringMongoStudent.Entity.Students;
import com.example.SpringMongoStudent.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo stu;
    public   String saveorupdate(Students student) {
        stu.save(student);
        return student.getId();
    }


    public Iterable<Students> findall() {
        return stu.findAll();
    }

    public void delete(String id) {
        try {
            stu.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    public Students findbyid(String id) {
        try{
            return stu.findById(id).get();

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        return null;
    }
}
