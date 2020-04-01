package com.mvc.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class TrHeaderPenjualanDto {
	@NotEmpty(message = "Silakan isi No Nota")
	private String noNota;

	@NotEmpty(message = "Silakan isi Global Diskon")
	private int globalDiskon;

	@NotEmpty(message = "Silakan isi Harga Total")
	private int hargaTotal;

	@NotEmpty(message = "Silakan isi Kode Customer")
	private String kodeCustomer;

	@NotEmpty(message = "Silakan isi Kode Karyawan")
	private String kodeKaryawan;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Silakan isi Tanggal Transaksi")
	private Date tanggalTransaksi;
	
	private String namaCustomer;
	
	private String namaKaryawan;

	public String getNoNota() {
		return noNota;
	}

	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}

	public int getGlobalDiskon() {
		return globalDiskon;
	}

	public void setGlobalDiskon(int globalDiskon) {
		this.globalDiskon = globalDiskon;
	}

	public int getHargaTotal() {
		return hargaTotal;
	}

	public void setHargaTotal(int hargaTotal) {
		this.hargaTotal = hargaTotal;
	}

	public String getKodeCustomer() {
		return kodeCustomer;
	}

	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}

	public String getKodeKaryawan() {
		return kodeKaryawan;
	}

	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}

	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}

	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}

	public String getNamaCustomer() {
		return namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
		
}
