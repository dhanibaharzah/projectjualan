package com.mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class TrDetailPenjualanDto {
	@NotEmpty(message = "Silakan isi Kode Detail")
	private String kodeDetail;
	
	@NotEmpty(message = "Silakan isi Diskon")
	private int diskon;
	
	@NotEmpty(message = "Silakan isi Harga Satuan")
	private int hargaSatuan;
	
	@NotEmpty(message = "Silakan isi Nama Barang")
	private String namaBarang;
	
	@NotEmpty(message = "Silakan isi No Nota")
	private String noNota;
	
	@NotEmpty(message = "Silakan isi Quantity")
	private int qty;
	
	@NotEmpty(message = "Silakan isi Sub Total")
	private int subtotal;

	public String getKodeDetail() {
		return kodeDetail;
	}

	public void setKodeDetail(String kodeDetail) {
		this.kodeDetail = kodeDetail;
	}

	public int getDiskon() {
		return diskon;
	}

	public void setDiskon(int diskon) {
		this.diskon = diskon;
	}

	public int getHargaSatuan() {
		return hargaSatuan;
	}

	public void setHargaSatuan(int hargaSatuan) {
		this.hargaSatuan = hargaSatuan;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public String getNoNota() {
		return noNota;
	}

	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
}
