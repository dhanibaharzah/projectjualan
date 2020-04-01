package com.mvc.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MstBarangDto {

	@NotEmpty(message = "Silakan isi Kode Barang")
	private String kodeBarang;

	@NotEmpty(message = "Silakan isi Kode Supplier")
	private String kodeSupplier;

	@NotEmpty(message = "Silakan isi Nama Barang")
	private String namaBarang;

	@NotNull(message = "Silakan isi Stok Barang")
	private Integer stokBarang;
	
	private String namaSupplier;

	public String getNamaSupplier() {
		return namaSupplier;
	}

	public void setNamaSupplier(String namaSupplier) {
		this.namaSupplier = namaSupplier;
	}

	public String getKodeBarang() {
		return kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	public String getKodeSupplier() {
		return kodeSupplier;
	}

	public void setKodeSupplier(String kodeSupplier) {
		this.kodeSupplier = kodeSupplier;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public Integer getStokBarang() {
		return stokBarang;
	}

	public void setStokBarang(Integer stokBarang) {
		this.stokBarang = stokBarang;
	}
	
}
