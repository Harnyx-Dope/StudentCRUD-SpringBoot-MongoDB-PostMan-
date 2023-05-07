package com.example.SpringMongoStudent.Repo;

import com.example.SpringMongoStudent.Entity.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Students,String> {
}
