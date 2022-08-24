package com.Chuangyungchu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Chuangyungchu.entity.Nurse;

@Repository
public interface NurseDao extends JpaRepository<Nurse, Integer> {
	

}
