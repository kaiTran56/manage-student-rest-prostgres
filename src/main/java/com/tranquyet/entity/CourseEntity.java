package com.tranquyet.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "course")
@Entity
public class CourseEntity extends AbstractEntity{

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<StudentEntity> student = new ArrayList<>();

}
