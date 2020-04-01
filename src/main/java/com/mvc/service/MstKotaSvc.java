package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstKotaDto;

public interface MstKotaSvc {
	public List<MstKotaDto> listAll();
	public void save(MstKotaDto dto);
	public void update(MstKotaDto dto);
	public void delete(String kodeKota);
	public MstKotaDto findOne(String kodeKota);
	public MstKotaDto findOneByNamaKota(String namaKota);
}
