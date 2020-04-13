package com.jean.aime.hibernateentitygraph.repository;

import com.jean.aime.hibernateentitygraph.domains.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    @Query("SELECT l from Level l left join fetch l.students where l.id =:id ")
    Level fecthWithStudents(@Param("id") Long id);
}
