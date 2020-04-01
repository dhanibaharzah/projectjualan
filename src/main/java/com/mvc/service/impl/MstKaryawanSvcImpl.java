package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstKaryawanDao;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.entity.MstKaryawan;
import com.mvc.entityPK.MstKaryawanPK;
import com.mvc.service.MstKaryawanSvc;

@Service
@Transactional
public class MstKaryawanSvcImpl implements MstKaryawanSvc{
	
	@Autowired
	MstKaryawanDao dao;
	
	@Override
	public List<MstKaryawanDto> listAll() {
		List<MstKaryawanDto> dtos = new ArrayList<MstKaryawanDto>();
		List<MstKaryawan> list = dao.findAll();
		for(MstKaryawan p : list){
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(p.getKodeKaryawan());
			dto.setNamaKaryawan(p.getNamaKaryawan());
			dto.setPassword(p.getPassword());
			dto.setUsername(p.getUsername());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(MstKaryawanDto dto) {
		MstKaryawan kar = new MstKaryawan();
		kar.setKodeKaryawan(dto.getKodeKaryawan());
		kar.setNamaKaryawan(dto.getNamaKaryawan());
		kar.setPassword(dto.getPassword());
		kar.setUsername(dto.getUsername());
		
		dao.save(kar);
	}

	@Override
	public void update(MstKaryawanDto dto) {
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(dto.getKodeKaryawan());
		MstKaryawan kar = dao.findOne(pk);
		
		kar.setNamaKaryawan(dto.getNamaKaryawan());
		kar.setUsername(dto.getNamaKaryawan());
		kar.setPassword(dto.getPassword());
		
	}

	@Override
	public void delete(String kodeKaryawan) {
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(kodeKaryawan);
		dao.delete(pk);
	}
	
	@Override
	public MstKaryawanDto findOne(String kodeKaryawan){
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(kodeKaryawan);
		MstKaryawan p = dao.findOne(pk);
		
		if(p == null) {
			return null;
		} else {
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(p.getKodeKaryawan());
			dto.setNamaKaryawan(p.getNamaKaryawan());
			dto.setPassword(p.getPassword());
			dto.setUsername(p.getUsername());
			
			return dto;
		}
	}

	@Override
	public MstKaryawanDto findOneByUsername(String username) {
		// TODO Auto-generated method stub
		MstKaryawan p = dao.findUserByUsername(username);
		
		if(p == null) {
			return null;
		} else {
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(p.getKodeKaryawan());
			dto.setNamaKaryawan(p.getNamaKaryawan());
			dto.setPassword(p.getPassword());
			dto.setUsername(p.getUsername());
			
			return dto;
		}
	}

}
