package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstProvinsiDto;

public interface MstProvinsiSvc {
	public List<MstProvinsiDto> listAll();
	public void save(MstProvinsiDto dto);
	public void update(MstProvinsiDto dto);
	public void delete(String kodeProvinsi);
	public MstProvinsiDto findOne(String kodeProvinsi);
	public MstProvinsiDto findOneByNamaProvinsi(String namaProvinsi);
}
