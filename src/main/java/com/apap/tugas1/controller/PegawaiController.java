/*PegawaiController.java*/
package com.apap.tugas1.controller;
/*import com.apap.tugas1apap.model.InstansiModel;
import com.apap.tugas1apap.model.JabatanModel;
import com.apap.tugas1apap.model.PegawaiModel;
import com.apap.tugas1apap.model.ProvinsiModel;
*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;

@Controller
public class PegawaiController {
	
	@Autowired
	private PegawaiService pegawaiService;

	@Autowired
	private JabatanService jabatanService;
	
	@RequestMapping("/")
	private String home(Model model){
		model.addAttribute("daftarJabatan", jabatanService.getAllJabatan());
		return "home";
	}


	@RequestMapping(value = "/pegawai", method = RequestMethod.GET)
	private String viewPegawai(@RequestParam("nip") String nip, Model model) {
		PegawaiModel pegawai = pegawaiService.getPegawaiByNip(nip).get();
		/*List<CarModel> car = dealer.getListCar();
		model.addAttribute("listCar",car);
		model.addAttribute("dealer",dealer);*/
		
		
		
		model.addAttribute("pegawai", pegawai);
		return "view-pegawai";
	}
}
//	
//	@RequestMapping(value = "/pegawai/tambah" , method = RequestMethod.GET)
//	private String addPegawai(Model model) {
//		PegawaiModel pegawai = new PegawaiModel();
//		List<ProvinsiModel> listProvinsi = provinsiService.getAllProvinsi();
//		model.addAttribute("pegawai", pegawai);
//		model.addAttribute("listProvinsi", listProvinsi);
//		return "add-pegawai";
//		
//	}
//	
//	@RequestMapping(value = "/pegawai/tambah", method = RequestMethod.POST)
//	private String addPegawaiSubmit() {
//		
//	}
//}	

	
	//@RequestMapping(value="/pegawai")
	/*public String viewPegawai(@RequestParam(value="nip", String nip, Model model)) {
		PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNIP(nip);
		List<JabatanModel> listJabatanModel = pegawai.getJabatan();
		double gaji = 0.0;
		get gaji pokok gitu2
		
		model.addAttribute("pegawai", pegawai);
		model.addAttribute("listJabatanModel", listJabatanModel);
		model.addAttribute("gaji", gaji);
		return "view-pegawai";
	}*/


	/*@RequestMapping(value = "/pegawai/tambah", method = RequestMethod.GET)
	private String addPegawai(Model model){
		model.addAttribute("pegawai", new PegawaiModel());
		return "add-pegawai";
	}*/
	

