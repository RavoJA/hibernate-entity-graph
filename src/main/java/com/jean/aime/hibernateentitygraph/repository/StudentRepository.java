package com.jean.aime.hibernateentitygraph.repository;


import com.jean.aime.hibernateentitygraph.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, CustomStudentRepository {

    @Query("SELECT s FROM Student s  " +
            " join fetch s.level l " +
            " join fetch s.department d " +
            " join fetch s.formations f " +
            "  where s.id =:id ")
    Student fetchWithFormations(@Param("id") Long id);

}
