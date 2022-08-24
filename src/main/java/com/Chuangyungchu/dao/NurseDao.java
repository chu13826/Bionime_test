package com.Chuangyungchu.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Chuangyungchu.entity.Nurse;

@Repository
public interface NurseDao extends JpaRepository<Nurse, Integer> {
	
	Optional<Nurse> findNurseByEmployeeNumber(final Integer employeeNumber);
}
