package com.jean.aime.hibernateentitygraph;

import com.jean.aime.hibernateentitygraph.domains.Formations;
import com.jean.aime.hibernateentitygraph.domains.Level;
import com.jean.aime.hibernateentitygraph.domains.Student;
import com.jean.aime.hibernateentitygraph.repository.LevelRepository;
import com.jean.aime.hibernateentitygraph.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class HibernateEntityGraphApplication {

    @Autowired
    private StudentRepository studentRepository;
@Autowired
    private LevelRepository levelRepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateEntityGraphApplication.class, args);
    }


    @PostConstruct
    @Transactional
    public void initData() {
      /*  Student student = new Student();
        student.setAddress("AMBOHIPO");
        student.setDateOfBirth(LocalDate.of(1997, 4, 2));
        student.setFirstName("Marie");
        student.setLastName("Angelette");
        student.setLevel(new Level("Level II"));
        student.getFormations().addAll(Arrays.asList(new Formations("MANAGEMENT"), new Formations("IT"), new Formations("ACOUNTING")));

        studentRepository.save(student);*/

       Student student = studentRepository.findStudentByEntityGraph(15L);
        //Level level = levelRepository.fecthWithStudents(11L);
     // log.info("result {} ", level.getStudents().size());
    }

}
