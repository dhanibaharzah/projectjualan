package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstProvinsiDao;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.entity.MstProvinsi;
import com.mvc.entityPK.MstProvinsiPK;
import com.mvc.service.MstProvinsiSvc;

@Service
@Transactional
public class MstProvinsiSvcImpl implements MstProvinsiSvc {

	@Autowired
	MstProvinsiDao dao;
	
	@Override
	public List<MstProvinsiDto> listAll() {
		// TODO Auto-generated method stub
		List<MstProvinsiDto> dtos = new ArrayList<MstProvinsiDto>();
		List<MstProvinsi> list = dao.findAll();
		for(MstProvinsi prov : list) {
			MstProvinsiDto dto = new MstProvinsiDto();
			dto.setKodeProvinsi(prov.getKodeProvinsi());
			dto.setNamaProvinsi(prov.getNamaProvinsi());
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstProvinsiDto dto) {
		// TODO Auto-generated method stub
		MstProvinsi p = new MstProvinsi();
		p.setKodeProvinsi(dto.getKodeProvinsi());
		p.setNamaProvinsi(dto.getNamaProvinsi());
		
		dao.save(p);
	}

	@Override
	public void update(MstProvinsiDto dto) {
		// TODO Auto-generated method stub
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(dto.getKodeProvinsi());
		MstProvinsi p = dao.findOne(pk);

		p.setNamaProvinsi(dto.getNamaProvinsi());
		
		dao.save(p);
	}

	@Override
	public void delete(String kodeProvinsi) {
		// TODO Auto-generated method stub
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(kodeProvinsi);
		dao.delete(pk);
		
	}

	@Override
	public MstProvinsiDto findOne(String kodeProvinsi) {
		// TODO Auto-generated method stub
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(kodeProvinsi);
		MstProvinsi p = dao.findOne(pk);
		
		if (p == null) {
			return null;
		} else {
			MstProvinsiDto dto = new MstProvinsiDto();
			dto.setKodeProvinsi(p.getKodeProvinsi());
			dto.setNamaProvinsi(p.getNamaProvinsi());
			
			return dto;
		}
	}

	@Override
	public MstProvinsiDto findOneByNamaProvinsi(String namaProvinsi) {
		// TODO Auto-generated method stub
		MstProvinsi p = dao.findByNamaProvinsi(namaProvinsi);
		
		if (p == null) {
			return null;
		} else {
			MstProvinsiDto dto = new MstProvinsiDto();
			dto.setKodeProvinsi(p.getKodeProvinsi());
			dto.setNamaProvinsi(p.getNamaProvinsi());
			
			return dto;
		}
	}

}
