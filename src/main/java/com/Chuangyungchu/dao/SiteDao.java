package com.Chuangyungchu.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Chuangyungchu.entity.Site;

@Repository
public interface SiteDao extends JpaRepository<Site, Integer> {

	List<Site> findBySiteName(String siteName);
	
	Optional<Site> findSiteBySiteName(final String siteName);
	
}
