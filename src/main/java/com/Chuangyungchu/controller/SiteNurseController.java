package com.Chuangyungchu.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Chuangyungchu.entity.Nurse;
import com.Chuangyungchu.entity.Site;
import com.Chuangyungchu.service.NurseService;
import com.Chuangyungchu.service.SiteService;

@Controller
public class SiteNurseController {

	@Autowired
	SiteService siteService;

	@Autowired
	NurseService nurseService;

	// 站點列表
	@RequestMapping("/sitelist")
	public String showSiteList(Model model) {
		model.addAttribute("sitelist", siteService.findAll());
		return "sitelist.html";
	}

	// 護士列表
	@RequestMapping("/nurselist")
	public String showNurseList(Model model) {
		model.addAttribute("nurselist", nurseService.findAll());
		return "nurselist.html";
	}

	// 前往新增站點表單
	@RequestMapping("/sitecreate")
	public String showSiteForm() {
		return "sitecreate.html";
	}

	// 前往新增護士表單
	@RequestMapping("/nursecreate")
	public String showNurseForm(Model model, @ModelAttribute("nurse") Nurse nurse) {
		model.addAttribute("sitelist", siteService.findAll());
		return "nurseform.html";
	}

	// 前往站點資訊表單
	@RequestMapping("/sitedetail/{id}")
	public String showSiteDetail(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("site", siteService.findById(id).get());
		model.addAttribute("nursesitelist", siteService.findById(id).get().getAssignedNurses());
		return "sitedetail.html";
	}

	// 前往護士資訊表單
	@RequestMapping("/nursedetail/{id}")
	public String showNurseDetail(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("nurse", nurseService.findById(id).get());
		model.addAttribute("sitelist", siteService.findAll());
		return "nurseform.html";
	}

	// 新增更新站點
	@PostMapping("/sitesave")
	public String saveOrUpdateSite(@ModelAttribute("site") Site site) {
		siteService.saveOrUpdate(site);
		return "redirect:./";
	}

	// 新增更新護士
	@PostMapping("/nursesave")
	public String saveOrUpdateNurse(@ModelAttribute("nurse") Nurse nurse) {
		nurseService.saveOrUpdate(nurse);
		return "redirect:./";
	}

	// 刪除站點
	@GetMapping("/sitedelete/{id}")
	public String siteDelete(@PathVariable("id") Integer id) {
		siteService.deleteBySiteId(id);
		return "redirect:/sitelist";
	}

	// 刪除護士
	@GetMapping("/nursedelete/{id}")
	public String nurseDelete(@PathVariable("id") Integer id) {
		nurseService.deleteByNurseId(id);
		return "redirect:/nurselist";
	}

	// 驗證護士員編重複
	@PostMapping("/nurse/checkEmployeeNumber")
	@ResponseBody
	public ResponseEntity<Optional<Nurse>> findByEmployeeNumber(@RequestBody Nurse nurse) {
		Optional<Nurse> check = nurseService.findNurseByEmployeeNumber(nurse.getEmployeeNumber());
		if (check != null) {
			return ResponseEntity.status(HttpStatus.OK).body(check);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	// 驗證站點名稱重複
	@PostMapping("/site/checkSiteName")
	@ResponseBody
	public ResponseEntity<Optional<Site>> findBySiteName(@RequestBody Site site) {
		Optional<Site> checkSite = siteService.findSiteBySiteName(site.getSiteName());
		if (checkSite != null) {
			return ResponseEntity.status(HttpStatus.OK).body(checkSite);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

}
