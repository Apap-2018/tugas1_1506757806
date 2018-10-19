/*PegawaiController.java*/
package com.apap.tugas1apap.controller;
/*import com.apap.tugas1apap.model.InstansiModel;
import com.apap.tugas1apap.model.JabatanModel;
import com.apap.tugas1apap.model.PegawaiModel;
import com.apap.tugas1apap.model.ProvinsiModel;
*/
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apap.tugas1apap.service.PegawaiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PegawaiController {
	@Autowired
	private PegawaiService pegawaiService;
	
	@RequestMapping("/")
	private String home(){
		return "home";
	}
		
	@RequestMapping(value="/pegawai")
	public String viewPegawai(@RequestParam(value="nip", String nip, Model model)) {
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNIP(nip);
		List<JabatanModel> listJabatanModel = pegawai.getJabatan();
		double gaji = 0.0;
		/*get gaji pokok gitu2*/
		
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("listJabatanModel", listJabatanModel);
		model.addAttribute("gaji", gaji);
		return "view-pegawai";
	}
}	


	/*@RequestMapping(value = "/pegawai/tambah", method = RequestMethod.GET)
	private String addPegawai(Model model){
		model.addAttribute("pegawai", new PegawaiModel());
		return "add-pegawai";
	}*/
	

