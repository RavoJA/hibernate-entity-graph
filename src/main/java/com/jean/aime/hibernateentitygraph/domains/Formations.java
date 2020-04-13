package com.jean.aime.hibernateentitygraph.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "students")
public class Formations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "formations")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    public Formations(String name) {
        this.name = name;
    }
}
