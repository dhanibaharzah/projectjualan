package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstSupplierDao;
import com.mvc.dto.MstSupplierDto;
import com.mvc.entity.MstSupplier;
import com.mvc.entityPK.MstSupplierPK;
import com.mvc.service.MstSupplierSvc;

@Service
@Transactional
public class MstSupplierSvcImpl implements MstSupplierSvc {
	
	@Autowired
	private MstSupplierDao dao;

	@Override
	public List<MstSupplierDto> listAll() {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.listAll();
		List<MstSupplierDto> dtos = new ArrayList<MstSupplierDto>();
		
		for (Object[] s : list) {
			MstSupplierDto dto = new MstSupplierDto();
			MstSupplier supp = (MstSupplier) s[0];
			
			dto.setKodeSupplier(supp.getKodeSupplier());
			dto.setNamaSupplier(supp.getNamaSupplier());
			dto.setAlamatSupplier(supp.getAlamatSupplier());
			dto.setTelpSupplier(supp.getTelpSupplier());
			dto.setEmailSupplier(supp.getEmailSupplier());
			dto.setNamaKota((String)s[1]);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstSupplierDto dto) {
		// TODO Auto-generated method stub
		MstSupplier supp = new MstSupplier();
		supp.setKodeSupplier(dto.getKodeSupplier());
		supp.setNamaSupplier(dto.getNamaSupplier());
		supp.setAlamatSupplier(dto.getAlamatSupplier());
		supp.setTelpSupplier(dto.getTelpSupplier());
		supp.setEmailSupplier(dto.getEmailSupplier());
		supp.setKodeKota(dto.getKodeKota());
		
		dao.save(supp);
	}

	@Override
	public void update(MstSupplierDto dto) {
		// TODO Auto-generated method stub
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(dto.getKodeSupplier());
		MstSupplier supp = dao.findOne(pk);
		
		supp.setNamaSupplier(dto.getNamaSupplier());
		supp.setAlamatSupplier(dto.getAlamatSupplier());
		supp.setTelpSupplier(dto.getTelpSupplier());
		supp.setEmailSupplier(dto.getEmailSupplier());
		supp.setKodeKota(dto.getKodeKota());
	}

	@Override
	public void delete(String kodeSupplier) {
		// TODO Auto-generated method stub
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(kodeSupplier);
		dao.delete(pk);
	}

	@Override
	public MstSupplierDto findOne(String kodeSupplier) {
		// TODO Auto-generated method stub
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(kodeSupplier);
		MstSupplier supp = dao.findOne(pk);
		
		if (supp == null) {
			return null;
		} else {
			MstSupplierDto dto = new MstSupplierDto();
			dto.setKodeSupplier(supp.getKodeSupplier());
			dto.setNamaSupplier(supp.getNamaSupplier());
			dto.setAlamatSupplier(supp.getAlamatSupplier());
			dto.setTelpSupplier(supp.getTelpSupplier());
			dto.setEmailSupplier(supp.getEmailSupplier());
			dto.setKodeKota(supp.getKodeKota());
			
			return dto;
		}
		
	}

	@Override
	public MstSupplierDto findOneByNamaSupplier(String namaSupplier) {
		// TODO Auto-generated method stub
		MstSupplier s = dao.findByNamaSupplier(namaSupplier);
		
		if (s == null) {
			return null;
		} else {
			MstSupplierDto dto = new MstSupplierDto();
			dto.setKodeSupplier(s.getKodeKota());
			dto.setNamaSupplier(s.getNamaSupplier());
			dto.setAlamatSupplier(s.getAlamatSupplier());
			dto.setTelpSupplier(s.getTelpSupplier());
			dto.setEmailSupplier(s.getEmailSupplier());
			dto.setKodeKota(s.getKodeKota());
			
			return dto;
		}
	}

}