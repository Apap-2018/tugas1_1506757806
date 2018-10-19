package com.apap.tugas1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.InstansiModel;

@Repository
public interface InstansiDb extends JpaRepository<InstansiModel, Long> {

}
