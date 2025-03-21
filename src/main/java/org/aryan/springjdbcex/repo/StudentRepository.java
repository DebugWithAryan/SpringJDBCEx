package org.aryan.springjdbcex.repo;

import org.aryan.springjdbcex.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public void save(Student s) {
        System.out.println("Student Added");
    }

    public List<Student> findAll() {

        List<Student> students = new ArrayList<>();
        return students;



    }
}
