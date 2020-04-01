package com.mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class MstKotaDto {

	@NotEmpty(message = "Silakan isi Kode Kota")
	private String kodeKota;

	@NotEmpty(message = "Silakan isi Nama Kota")
	private String namaKota;

	@NotEmpty(message = "Silakan isi Kode Provins")
	private String kodeProvinsi;
	
	private String namaProvinsi;

	public String getKodeKota() {
		return kodeKota;
	}

	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}

	public String getNamaKota() {
		return namaKota;
	}

	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}

	public String getKodeProvinsi() {
		return kodeProvinsi;
	}

	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}

	public String getNamaProvinsi() {
		return namaProvinsi;
	}

	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}
	
}
