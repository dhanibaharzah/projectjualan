package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstKotaDao;
import com.mvc.dto.MstKotaDto;
import com.mvc.entity.MstKota;
import com.mvc.entityPK.MstKotaPK;
import com.mvc.service.MstKotaSvc;

@Service
@Transactional
public class MstKotaSvcImpl implements MstKotaSvc {

	@Autowired
	MstKotaDao dao;
	
	@Override
	public List<MstKotaDto> listAll() {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.listAll();
		List<MstKotaDto> dtos = new ArrayList<MstKotaDto>();
		
		for (Object[] k : list) {
			MstKotaDto dto = new MstKotaDto();
			MstKota kota = (MstKota) k[0];
			dto.setKodeKota(kota.getKodeKota());
			dto.setNamaKota(kota.getNamaKota());
			dto.setNamaProvinsi((String)k[1]);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstKotaDto dto) {
		// TODO Auto-generated method stub
		MstKota k = new MstKota();
		k.setKodeKota(dto.getKodeKota());
		k.setNamaKota(dto.getNamaKota());
		k.setKodeProvinsi(dto.getKodeProvinsi());
		
		dao.save(k);
	}

	@Override
	public void update(MstKotaDto dto) {
		// TODO Auto-generated method stub
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(dto.getKodeKota());
		MstKota k = dao.findOne(pk);
		
		k.setNamaKota(dto.getNamaKota());
		k.setKodeProvinsi(dto.getKodeProvinsi());
	}

	@Override
	public void delete(String kodeKota) {
		// TODO Auto-generated method stub
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(kodeKota);
		dao.delete(pk);
	}

	@Override
	public MstKotaDto findOne(String kodeKota) {
		// TODO Auto-generated method stub
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(kodeKota);
		MstKota k = dao.findOne(pk);
		
		if (k == null) {
			return null;
		} else {
			MstKotaDto dto = new MstKotaDto();
			dto.setKodeKota(k.getKodeKota());
			dto.setNamaKota(k.getNamaKota());
			dto.setKodeProvinsi(k.getKodeProvinsi());
			
			return dto;
		}
	}

	@Override
	public MstKotaDto findOneByNamaKota(String namaKota) {
		// TODO Auto-generated method stub
		MstKota k = dao.findByNamaKota(namaKota);
		
		if (k == null) {
			return null;
		} else {
			MstKotaDto dto = new MstKotaDto();
			dto.setKodeKota(k.getKodeKota());
			dto.setNamaKota(k.getNamaKota());
			dto.setKodeProvinsi(k.getKodeProvinsi());
			
			return dto;
		}
		
	}
	
}
