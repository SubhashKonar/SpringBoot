package com.learn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.Individual;

@Repository
public interface IndividualRepo extends JpaRepository<Individual, Long> {

}
