package com.Chuangyungchu.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Nurse")
@EntityListeners(AuditingEntityListener.class)
@Component
public class Nurse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer nurseId;

	@Column(nullable = false, unique = true)
	private Integer employeeNumber;

	@Column(nullable = false)
	private String nurseName;

	@LastModifiedDate
	@Column(columnDefinition = "DATETIME", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date nurseUpdateTime;

	@CreatedDate
	@Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date nurseCreateTime;

	@ManyToMany
	@JoinTable(name = "assigned_sites", joinColumns = @JoinColumn(name = "nurse_nurseId"), inverseJoinColumns = @JoinColumn(name = "site_siteId"))
	private Set<Site> assignedSites = new HashSet<>();

	public void addSite(Site site) {
		this.assignedSites.add(site);
		site.getAssignedNurses().add(this);
	}

	public void removeSite(Site site) {
		this.getAssignedSites().remove(site);
		site.getAssignedNurses().remove(this);
	}

	public Nurse() {
	}

	public Nurse(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Integer getNurseId() {
		return nurseId;
	}

	public void setNurseId(Integer nurseId) {
		this.nurseId = nurseId;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public Date getNurseUpdateTime() {
		return nurseUpdateTime;
	}

	public void setNurseUpdateTime(Date nurseUpdateTime) {
		this.nurseUpdateTime = nurseUpdateTime;
	}

	public Date getNurseCreateTime() {
		return nurseCreateTime;
	}

	public void setNurseCreateTime(Date nurseCreateTime) {
		this.nurseCreateTime = nurseCreateTime;
	}

	public Set<Site> getAssignedSites() {
		return assignedSites;
	}

	public void setAssignedSites(Set<Site> assignedSites) {
		this.assignedSites = assignedSites;
	}

}
