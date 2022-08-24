package com.Chuangyungchu.service;

import java.util.List;
import java.util.Optional;

import com.Chuangyungchu.entity.Site;

public interface SiteService {

	List<Site> findAll();

	Site saveOrUpdate(Site site);

	void deleteBySiteId(Integer siteId);

	Optional<Site> findById(Integer siteId);
	
	List<Site> findBySiteName(String siteName);


}
