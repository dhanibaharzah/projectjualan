package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstBarangDao;
import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstSupplierDto;
import com.mvc.entity.MstBarang;
import com.mvc.entity.MstSupplier;
import com.mvc.entityPK.MstBarangPK;
import com.mvc.service.MstBarangSvc;

@Service
@Transactional
public class MstBarangSvcImpl implements MstBarangSvc{
	
	@Autowired
	MstBarangDao dao;
	
	@Override
	public List<MstBarangDto> listAll() {
		List<MstBarangDto> dtos = new ArrayList<MstBarangDto>();
		List<Object[]> list = dao.listAll();
		//List<MstBarang> list = dao.findAll();
		for(Object[] o : list){
			MstBarangDto dto = new MstBarangDto();
			MstBarang b = (MstBarang) o[0];
			dto.setKodeBarang(b.getKodeBarang());
			dto.setNamaBarang(b.getNamaBarang());
			dto.setKodeSupplier(b.getKodeSupplier());
			dto.setStokBarang(b.getStokBarang());
			dto.setNamaSupplier((String) o[1]);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstBarangDto dto) {
		MstBarang kar = new MstBarang();
		kar.setKodeBarang(dto.getKodeBarang());
		kar.setNamaBarang(dto.getNamaBarang());
		kar.setKodeSupplier(dto.getKodeSupplier());
		kar.setStokBarang(dto.getStokBarang());
		
		dao.save(kar);
	}

	@Override
	public void update(MstBarangDto dto) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(dto.getKodeBarang());
		MstBarang kar = dao.findOne(pk);
		
		kar.setNamaBarang(dto.getNamaBarang());
		kar.setKodeSupplier(dto.getKodeSupplier());
		kar.setStokBarang(dto.getStokBarang());
		
	}

	@Override
	public void delete(String kodeBarang) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(kodeBarang);
		dao.delete(pk);
	}
	
	@Override
	public MstBarangDto findOne(String kodeBarang){
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(kodeBarang);
		MstBarang b = dao.findOne(pk);
		MstBarangDto dto = new MstBarangDto();

		dto.setKodeBarang(b.getKodeBarang());
		dto.setNamaBarang(b.getNamaBarang());
		dto.setKodeSupplier(b.getKodeSupplier());
		dto.setStokBarang(b.getStokBarang());
		
		return dto;
	}


}
