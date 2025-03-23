package org.aryan.springjdbcex;

import org.aryan.springjdbcex.model.Student;
import org.aryan.springjdbcex.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

    public static void main(String[] args) {


        ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class);
        Student s = context.getBean(Student.class);

        s.setEnrollmentNo(105);
        s.setName("Aryanee");
        s.setMarks(93);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s);

        List<Student> students = service.getStudents();
        System.out.println(students);

    }
}
