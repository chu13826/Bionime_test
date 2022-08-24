package com.Chuangyungchu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Chuangyungchu.dao.NurseDao;
import com.Chuangyungchu.entity.Nurse;
import com.Chuangyungchu.service.NurseService;

@Service
@Transactional
public class NurseServiceImpl implements NurseService {

	@Autowired
	NurseDao nurseDao;

	@Override
	public List<Nurse> findAll() {
		return nurseDao.findAll();
	}

	@Override
	public Nurse saveOrUpdate(Nurse nurse) {
		return nurseDao.save(nurse);
	}

	@Override
	public void deleteByNurseId(Integer nurseId) {
		nurseDao.deleteById(nurseId);
	}

	@Override
	public Optional<Nurse> findById(Integer nurseId) {
		return nurseDao.findById(nurseId);
	}

	@Override
	public Optional<Nurse> findNurseByEmployeeNumber(final Integer employeeNumber) {
		return nurseDao.findNurseByEmployeeNumber(employeeNumber);

	}
}
