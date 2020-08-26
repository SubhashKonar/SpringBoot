package com.learn.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.Student;


public interface StudentRepo extends JpaRepository<Student, Long>{

	Optional<Student>  findByDegreecertificateNoAndUniversityCode(String degreecertificateNo,String unicode);
}
