/*PegawaiController.java*/
package com.apap.tugas1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;

@Controller
public class PegawaiController {
	
	@Autowired
	private PegawaiService pegawaiService;

	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private ProvinsiService provinsiService;
	
	@RequestMapping("/")
	private String home(Model model){
		model.addAttribute("daftarJabatan", jabatanService.getAllJabatan());
		return "home";
	}


	@RequestMapping(value = "/pegawai", method = RequestMethod.GET)
	private String viewPegawai(@RequestParam("nip") String nip, Model model) {

		PegawaiModel pegawai;
		try {
		 pegawai = pegawaiService.getPegawaiByNip(nip).get();
		} catch (Exception e) {
			return "error/404";
		}
		
		model.addAttribute("pegawai", pegawai);


		List<JabatanModel> jabatanList = pegawai.getJabatanPegawaiList();
		
		double gajiPokok = 0;
		for (JabatanModel jabatan : pegawai.getJabatanPegawaiList()) {
			if (gajiPokok <= jabatan.getGajiPokok()) {
				gajiPokok = jabatan.getGajiPokok();
			}
		}
		int gaji = (int) (gajiPokok + (pegawai.getInstansi().getProvinsi().getPresentaseTunjangan()/100 * gajiPokok));
		model.addAttribute("gaji", gaji);
		
		model.addAttribute("daftarJabatan", jabatanList);
		
		return "view-pegawai";
	}
	
	@RequestMapping("/pegawai/cari")
	private String cariPegawai(Model model) {
		return "find-pegawai";
	}

	




}