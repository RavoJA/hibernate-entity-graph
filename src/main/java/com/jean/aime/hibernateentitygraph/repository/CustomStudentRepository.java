package com.jean.aime.hibernateentitygraph.repository;

import com.jean.aime.hibernateentitygraph.domains.Student;
import org.springframework.stereotype.Repository;


public interface CustomStudentRepository {
    Student findStudentByEntityGraph(Long id);

    Student findStudentByFetch(Long id);
}
