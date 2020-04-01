package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.TrHeaderPenjualanDao;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.entityPK.TrHeaderPenjualanPK;
import com.mvc.service.TrHeaderPenjualanSvc;

@Service
@Transactional
public class TrHeaderPenjualanSvcImpl implements TrHeaderPenjualanSvc {
	
	@Autowired
	TrHeaderPenjualanDao dao;

	@Override
	public List<TrHeaderPenjualanDto> listAll() {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.listAll();
		List<TrHeaderPenjualanDto> dtos = new ArrayList<TrHeaderPenjualanDto>();
		
		for(Object[] o : list) {
			TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
			TrHeaderPenjualan thp = (TrHeaderPenjualan) o[0];
			
			dto.setNoNota(thp.getNoNota());
			dto.setGlobalDiskon(thp.getGlobalDiskon());
			dto.setHargaTotal(thp.getHargaTotal());
			dto.setTanggalTransaksi(thp.getTanggalTransaksi());
			dto.setNamaCustomer((String)o[1]);
			dto.setNamaKaryawan((String)o[2]);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(TrHeaderPenjualanDto dto) {
		// TODO Auto-generated method stub
		TrHeaderPenjualan thp = new TrHeaderPenjualan();
		thp.setNoNota(dto.getNoNota());
		thp.setKodeCustomer(dto.getKodeCustomer());
		thp.setKodeKaryawan(dto.getKodeKaryawan());
		thp.setGlobalDiskon(dto.getGlobalDiskon());
		thp.setHargaTotal(dto.getHargaTotal());
		thp.setTanggalTransaksi(dto.getTanggalTransaksi());
		
		dao.save(thp);
	}

	@Override
	public void update(TrHeaderPenjualanDto dto) {
		// TODO Auto-generated method stub
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(dto.getNoNota());
		TrHeaderPenjualan thp = dao.findOne(pk);
		
		thp.setNoNota(dto.getNoNota());
		thp.setKodeCustomer(dto.getKodeCustomer());
		thp.setKodeKaryawan(dto.getKodeKaryawan());
		thp.setGlobalDiskon(dto.getGlobalDiskon());
		thp.setHargaTotal(dto.getHargaTotal());
		thp.setTanggalTransaksi(dto.getTanggalTransaksi());
		
		dao.save(thp);		
	}

	@Override
	public void delete(String noNota) {
		// TODO Auto-generated method stub
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(noNota);
		dao.delete(pk);
	}

	@Override
	public TrHeaderPenjualanDto findOne(String noNota) {
		// TODO Auto-generated method stub
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(noNota);
		TrHeaderPenjualan thp = dao.findOne(pk);
		TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
		
		dto.setNoNota(thp.getNoNota());
		dto.setKodeCustomer(thp.getKodeCustomer());
		dto.setKodeKaryawan(thp.getKodeKaryawan());
		dto.setGlobalDiskon(thp.getGlobalDiskon());
		dto.setHargaTotal(thp.getHargaTotal());
		dto.setTanggalTransaksi(thp.getTanggalTransaksi());
		return dto;
	}

}
