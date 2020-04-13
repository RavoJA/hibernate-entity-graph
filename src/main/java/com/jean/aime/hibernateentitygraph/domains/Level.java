package com.jean.aime.hibernateentitygraph.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = "students")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Level(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "level")
    @JsonIgnore
    private List<Student> students;


}
