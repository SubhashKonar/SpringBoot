package com.learn.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.CIBILScore;

@Repository
public interface CIBILRepo extends JpaRepository<CIBILScore, Long> {

	List<CIBILScore> findByPan(String pan);
}
