package com.learn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.model.Student;
import com.learn.repo.StudentRepo;

@SpringBootApplication
public class MUniversityServiceApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(MUniversityServiceApplication.class, args);
	}


	@Autowired
	StudentRepo srepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*
		 * Optional<Student>
		 * stud=srepo.findByDegreecertificateNoAndUniversityCode("123", "123");
		 * System.out.println(stud);
		 */
		
	}

}
