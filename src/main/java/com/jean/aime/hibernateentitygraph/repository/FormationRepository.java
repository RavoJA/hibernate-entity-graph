package com.jean.aime.hibernateentitygraph.repository;

import com.jean.aime.hibernateentitygraph.domains.Formations;
import com.jean.aime.hibernateentitygraph.domains.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formations, Long> {
}
