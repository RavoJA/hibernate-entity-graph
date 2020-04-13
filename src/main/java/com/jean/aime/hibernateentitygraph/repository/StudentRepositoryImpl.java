package com.jean.aime.hibernateentitygraph.repository;

import com.jean.aime.hibernateentitygraph.domains.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudentRepositoryImpl implements CustomStudentRepository {

    @PersistenceContext
    private EntityManager em;

    private static final String QUERY = " SELECT s FROM Student s  where s.id =:id ";

    public Student findStudentByEntityGraph(Long id) {
        EntityGraph<Student> graph = this.em.createEntityGraph(Student.class);
        graph.addAttributeNodes("department", "level");

        return em.createQuery(QUERY, Student.class)
                .setParameter("id", id)
                .setHint("javax.persistence.loadgraph", graph)
                .getSingleResult();
    }


    public Student findStudentByFetch(Long id) {
        return em.createQuery(QUERY, Student.class).setParameter("id", id).getSingleResult();
    }
}