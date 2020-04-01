package com.mvc.service;

import java.util.List;

import com.mvc.dto.TrHeaderPenjualanDto;

public interface TrHeaderPenjualanSvc {
	public List<TrHeaderPenjualanDto> listAll();
	public void save(TrHeaderPenjualanDto dto);
	public void update(TrHeaderPenjualanDto dto);
	public void delete(String noNota);
	public TrHeaderPenjualanDto findOne(String noNota);
}
