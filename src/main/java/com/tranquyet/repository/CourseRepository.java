package com.tranquyet.repository;

import com.tranquyet.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value = "courseRepository")
@Transactional
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    CourseEntity findOneByName(String name);
}
