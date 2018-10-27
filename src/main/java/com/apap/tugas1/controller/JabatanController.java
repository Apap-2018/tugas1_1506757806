package com.apap.tugas1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.service.JabatanService;

@Controller
public class JabatanController {

	private long id;
	@Autowired
	private JabatanService jabatanService;
	
	
	@RequestMapping(value = "/jabatan/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("jabatan", new JabatanModel());
		return "tambah-jabatan";
	}
	
	@RequestMapping(value = "/jabatan/add", method = RequestMethod.POST)
	private String addJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		jabatanService.addJabatan(jabatan);
		return "sukses-tambah-jabatan";
	}
	
	@RequestMapping("/jabatan/view")
	private String viewJabatanById(@RequestParam(value = "idJabatan") long id, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanById(id);
		model.addAttribute("jabatan", jabatan);
		return "view-jabatan";
	}
	
	@RequestMapping(value = "/jabatan/ubah", method = RequestMethod.GET)
	private String updateJabatan(@RequestParam("idJabatan") Long id, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanById(id);
		model.addAttribute("jabatan", jabatan);
		return "update-jabatan";
	}

	 @RequestMapping(value = "/jabatan/ubah/submit", method = RequestMethod.POST)
	 private String updateJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		 //jabatan.setId(jabatan.getId());
		 Long id = jabatan.getId();
		 //model.addAttribute("idnya", id);
		 jabatanService.updateJabatan(id, jabatan);
		 model.addAttribute("jabatan", jabatan);
	     return "sukses-update-jabatan";
	 }
	 
	 @RequestMapping(value = "/jabatan/hapus", method = RequestMethod.GET)
	 private String deleteJabatan(@RequestParam("idJabatan") Long id, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanById(id);
		model.addAttribute("jabatan", jabatan);
		return "delete-jabatan";
	 }

	 @RequestMapping(value = "/jabatan/hapus/submit", method = RequestMethod.POST)
	 private String deleteJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		 Long id = jabatan.getId();
		 jabatanService.deleteJabatan(id);
	     return "sukses-delete-jabatan";
	 }
	 
	 @RequestMapping(value = "/jabatan/viewall", method = RequestMethod.GET)
		private String viewAllJabatan(Model model) {
			List<JabatanModel> listJabatan = jabatanService.findAll();
		
			model.addAttribute("listJabatan", listJabatan);
			
			return "view-all-jabatan";
		}
	 
}
