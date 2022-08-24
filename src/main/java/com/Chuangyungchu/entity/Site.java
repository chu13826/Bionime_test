package com.Chuangyungchu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Site")
@EntityListeners(AuditingEntityListener.class)
@Component
public class Site {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer siteId;
	
	@Column(nullable = false, unique = true)
	private String siteName;
	
	@LastModifiedDate
	@Column(columnDefinition = "DATETIME", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date siteUpdateTime;
	
	@CreatedDate
	@Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date siteCreateTime;
	
	@ManyToMany(mappedBy = "assignedSites")
	private Set<Nurse> assignedNurses = new HashSet<>();
	
	public Site() {
	}
	
	public Site(String siteName) {
		this.siteName = siteName;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Date getSiteUpdateTime() {
		return siteUpdateTime;
	}

	public void setSiteUpdateTime(Date siteUpdateTime) {
		this.siteUpdateTime = siteUpdateTime;
	}

	public Date getSiteCreateTime() {
		return siteCreateTime;
	}

	public void setSiteCreateTime(Date siteCreateTime) {
		this.siteCreateTime = siteCreateTime;
	}

	public Set<Nurse> getAssignedNurses() {
		return assignedNurses;
	}

	public void setAssignedNurses(Set<Nurse> assignedNurses) {
		this.assignedNurses = assignedNurses;
	}
	
	
}
