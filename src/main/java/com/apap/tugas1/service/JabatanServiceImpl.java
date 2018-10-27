package com.apap.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService{

	@Autowired
	private JabatanDb jabatanDb;
	
	@Override
	public void addJabatan(JabatanModel jabatan) {
		jabatanDb.save(jabatan);
	}

	@Override
	public List<JabatanModel> getAllJabatan() {
		return jabatanDb.findAll();
	}

	@Override
	public JabatanModel getJabatanById(long id) {
		return jabatanDb.findById(id);
	}

	@Override
	public void updateJabatan(JabatanModel jabatan) {
		JabatanModel jabatanUpdate = jabatanDb.getOne(jabatan.getId());
		jabatanUpdate.setNama(jabatan.getNama());
		jabatanUpdate.setDeskripsi(jabatan.getDeskripsi());
		jabatanUpdate.setGajiPokok(jabatan.getGajiPokok());
        jabatanDb.save(jabatan);		
	}

	@Override
	public void updateJabatan(Long id, JabatanModel jabatan) {
		 	JabatanModel jabatanUpdate = jabatanDb.getOne(id);
	        jabatanUpdate.setDeskripsi(jabatan.getDeskripsi());
	        jabatanUpdate.setGajiPokok(jabatan.getGajiPokok());
	        jabatanUpdate.setId(jabatan.getId());
	        jabatanUpdate.setNama(jabatan.getNama());
	        jabatanDb.save(jabatanUpdate);		
	}

	@Override
	public void deleteJabatan(Long id) {
		jabatanDb.deleteById(id);		
	}

	@Override
	public List<JabatanModel> findAll() {
		return jabatanDb.findAll();
	}

}