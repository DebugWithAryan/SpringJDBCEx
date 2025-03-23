package org.aryan.springjdbcex.repo;

import org.aryan.springjdbcex.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student s) {

        String sql = "insert into student (rollno, name, marks) values(?,?,?)";
        int rows=jdbcTemplate.update(sql,s.getEnrollmentNo(),s.getName(),s.getMarks());
        System.out.println(rows + "inserted");
    }

    public List<Student> findAll() {

        String sql = "select * from student";


        //Traditional without Lamda Expression
//        RowMapper<Student> mapper = new RowMapper<Student>(){
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum)throws SQLException{
//                Student s = new Student();
//                s.setEnrollmentNo(rs.getInt("rollno"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//
//                return s;
//            }
//        };

        //With Lambda Expression
        return jdbcTemplate.query(sql,(rs,rowNum)->{
                Student s = new Student();
                s.setEnrollmentNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));

                return s;
        });


    }
}
