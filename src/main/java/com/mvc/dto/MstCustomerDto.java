package com.mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class MstCustomerDto {

	@NotEmpty(message = "Silakan isi Kode Customer")
	private String kodeCustomer;

	@NotEmpty(message = "Silakan isi Alamat Customer")
	private String alamatCustomer;

	@NotEmpty(message = "Silakan isi Email Customer")
	private String emailCustomer;

	@NotEmpty(message = "Silakan isi Jenis Kelamin")
	private String jenisKelamin;

	@NotEmpty(message = "Silakan isi Kode Kota")
	private String kodeKota;

	@NotEmpty(message = "Silakan isi Nama Customer")
	private String namaCustomer;
	
	private String namaKota;

	public String getNamaKota() {
		return namaKota;
	}

	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}

	public String getKodeCustomer() {
		return kodeCustomer;
	}

	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}

	public String getAlamatCustomer() {
		return alamatCustomer;
	}

	public void setAlamatCustomer(String alamatCustomer) {
		this.alamatCustomer = alamatCustomer;
	}

	public String getEmailCustomer() {
		return emailCustomer;
	}

	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getKodeKota() {
		return kodeKota;
	}

	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}

	public String getNamaCustomer() {
		return namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}

	
}