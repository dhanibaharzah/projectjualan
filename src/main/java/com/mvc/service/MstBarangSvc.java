package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstBarangDto;

public interface MstBarangSvc {
	public List<MstBarangDto> listAll();
	public void save(MstBarangDto dto);
	public void update(MstBarangDto dto);
	public void delete(String kodeBarang);
	public MstBarangDto findOne(String kodeBarang);
}
