package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstCustomerDao;
import com.mvc.dto.MstCustomerDto;
import com.mvc.entity.MstBarang;
import com.mvc.entity.MstCustomer;
import com.mvc.entityPK.MstCustomerPK;
import com.mvc.service.MstCustomerSvc;

@Service
@Transactional
public class MstCustomerSvcImpl implements MstCustomerSvc{
	
	@Autowired
	MstCustomerDao dao;
	
	@Override
	public List<MstCustomerDto> listAll() {
		List<MstCustomerDto> dtos = new ArrayList<MstCustomerDto>();
		List<Object[]> list = dao.listAll();
		//List<MstCustomer> list = dao.findAll();
		for(Object[] o : list){
			MstCustomerDto dto = new MstCustomerDto();
			MstCustomer b = (MstCustomer) o[0];
			dto.setKodeCustomer(b.getKodeCustomer());
			dto.setNamaCustomer(b.getNamaCustomer());
			dto.setAlamatCustomer(b.getAlamatCustomer());
			dto.setEmailCustomer(b.getEmailCustomer());
			dto.setJenisKelamin(b.getJenisKelamin());
			dto.setKodeKota(b.getKodeKota());
			dto.setNamaKota((String) o[1]);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstCustomerDto dto) {
		MstCustomer kar = new MstCustomer();
		kar.setKodeCustomer(dto.getKodeCustomer());
		kar.setNamaCustomer(dto.getNamaCustomer());
		kar.setAlamatCustomer(dto.getAlamatCustomer());
		kar.setEmailCustomer(dto.getEmailCustomer());
		kar.setJenisKelamin(dto.getJenisKelamin());
		kar.setKodeKota(dto.getKodeKota());
		
		dao.save(kar);
	}

	@Override
	public void update(MstCustomerDto dto) {
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(dto.getKodeCustomer());
		MstCustomer kar = dao.findOne(pk);
		
		kar.setNamaCustomer(dto.getNamaCustomer());
		kar.setAlamatCustomer(dto.getAlamatCustomer());
		kar.setEmailCustomer(dto.getEmailCustomer());
		kar.setJenisKelamin(dto.getJenisKelamin());
		kar.setKodeKota(dto.getKodeKota());
		
	}

	@Override
	public void delete(String kodeCustomer) {
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(kodeCustomer);
		dao.delete(pk);
	}
	
	@Override
	public MstCustomerDto findOne(String kodeCustomer){
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(kodeCustomer);
		MstCustomer b = dao.findOne(pk);
		MstCustomerDto dto = new MstCustomerDto();

		dto.setKodeCustomer(b.getKodeCustomer());
		dto.setNamaCustomer(b.getNamaCustomer());
		dto.setAlamatCustomer(b.getAlamatCustomer());
		dto.setEmailCustomer(b.getEmailCustomer());
		dto.setJenisKelamin(b.getJenisKelamin());
		dto.setKodeKota(b.getKodeKota());
		
		return dto;
	}


}
