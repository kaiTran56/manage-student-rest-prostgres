package com.tranquyet.repository;

import com.tranquyet.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "studentRepository")
@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity findOneById(Long id);

    @Query(value = "select * from student where delete_tag is null", nativeQuery = true)
    List<StudentEntity> getAll();

    @Query(value = "select * from student where course_id = :idCourse", nativeQuery = true)
    List<StudentEntity> getStudentByCourse(@Param("idCourse") Long idCourse);
}
