package com.mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class MstProvinsiDto {
	@NotEmpty(message = "Silakan isi Nama Provinsi")
	private String namaProvinsi;
	
	@NotEmpty(message = "Silakan isi Kode Provinsi")
	private String kodeProvinsi;

	public String getNamaProvinsi() {
		return namaProvinsi;
	}

	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}

	public String getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
}
