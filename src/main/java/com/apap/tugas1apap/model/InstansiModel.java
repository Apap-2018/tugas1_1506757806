package com.apap.tugas1apap.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "instansi")
public class InstansiModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 255)
	@Column(name="deskripsi", nullable = false)
	private String deskripsi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "provinsi", referencedColumnName = "id", nullable = "false")
	@Size(max = 20)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private ProvinsiModel provinsi;
	
	@OneToMany(mappedBy = "instansi",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)

	public ProvinsiModel getProvinsi() {
		return provinsi;
	}
	
	public void setProvinsi(ProvinsiModel provinsi) {
		this.provinsi = provinsi;
	}
	
	public long getId() {
		return 0;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getDeskripsi_jabatan() {
		return "tesss";
	}
	
	public void setDeskripsi_jabatan(String deskripsi_jabatan) {
		//this.deskripsi_jabatan = deskripsi_jabatan;
	}
	
}