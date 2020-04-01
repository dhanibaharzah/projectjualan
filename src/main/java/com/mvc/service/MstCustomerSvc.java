package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstCustomerDto;

public interface MstCustomerSvc {
	public List<MstCustomerDto> listAll();
	public void save(MstCustomerDto dto);
	public void update(MstCustomerDto dto);
	public void delete(String kodeCustomer);
	public MstCustomerDto findOne(String kodeCustomer);
}
