package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;

//package com.apap.tugas1.JabatanModel;
//
public interface JabatanService {
	void addJabatan(JabatanModel jabatan);
	List<JabatanModel> getAllJabatan();
	JabatanModel getJabatanById(long id);
	void updateJabatan(Long id, JabatanModel jabatan);
	void updateJabatan(JabatanModel jabatan);
	void deleteJabatan(Long id);
	List<JabatanModel> findAll();
}
