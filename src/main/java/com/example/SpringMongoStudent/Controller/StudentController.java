package com.example.SpringMongoStudent.Controller;


import com.example.SpringMongoStudent.Entity.Students;
import com.example.SpringMongoStudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/Student/")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/Register")
    private   String StudentREg(@RequestBody Students student)
    {
        String id=studentService.saveorupdate(student);
        return id;

    }
    @GetMapping("/all")
     private Iterable<Students> getStudents()
    {
        return  studentService.findall();

    }
    @PutMapping("/editstu/{id}")
    private Students update(@RequestBody Students stu, @PathVariable(name = "id") String id)
    {
        stu.setId(Integer.parseInt(id));
        studentService.saveorupdate(stu);
        return stu;
    }
    @DeleteMapping("/DeleteOne/{id}")
    private Iterable<Students> Delete(@PathVariable(name = "id") String id)
    {
        studentService.delete(id);
        return studentService.findall();
    }
    @GetMapping("/stu/{id}")
    private Students getbyid(@PathVariable(name = "id") String id)
    {
        return studentService.findbyid(id);
    }

}
