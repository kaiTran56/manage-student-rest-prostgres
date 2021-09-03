package com.tranquyet.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Table(name = "student")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity extends AbstractEntity {
    @Column
    private String code;
    @Column(length = 25)
    @NotEmpty(message = "Please enter the name")
    private String name;
    @Column
    private String location;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false, length = 10)
    private String phone;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "TEXT")
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    private CourseEntity course;
}
