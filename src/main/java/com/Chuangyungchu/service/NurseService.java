package com.Chuangyungchu.service;

import java.util.List;
import java.util.Optional;

import com.Chuangyungchu.entity.Nurse;

public interface NurseService {

	List<Nurse> findAll();

	Nurse saveOrUpdate(Nurse nurse);

	void deleteByNurseId(Integer nurseId);

	Optional<Nurse> findById(Integer nurseId);

}
