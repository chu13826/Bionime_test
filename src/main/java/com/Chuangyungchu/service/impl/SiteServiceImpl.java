package com.Chuangyungchu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Chuangyungchu.dao.SiteDao;
import com.Chuangyungchu.entity.Site;
import com.Chuangyungchu.service.SiteService;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {
	
	@Autowired
	SiteDao siteDao;
	
	@Override
	public List<Site> findAll(){
		return siteDao.findAll();
	}
	
	@Override
	public Site saveOrUpdate(Site site) {
		return siteDao.save(site);
	}
	
	@Override
	public void deleteBySiteId(Integer siteId) {
		siteDao.deleteById(siteId);
	}
	
	@Override
	public Optional<Site> findById(Integer siteId) {
		return siteDao.findById(siteId);
	}

	@Override
	public List<Site> findBySiteName(String siteName) {
		return siteDao.findBySiteName(siteName);
	}

	@Override
	public Optional<Site> findSiteBySiteName(String siteName) {
		return siteDao.findSiteBySiteName(siteName);
	}
}
