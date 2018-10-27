package com.apap.tugas1.service;

import java.util.Optional;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {
	
	@Autowired
	private PegawaiDb pegawaiDb;
	

	@Override
	public PegawaiModel getPegawaiDb() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<PegawaiModel> getPegawaiByNip(String nip) {	
		return pegawaiDb.findByNip(nip);
	}
}
