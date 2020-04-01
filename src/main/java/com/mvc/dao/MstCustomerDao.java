package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvc.entity.MstCustomer;
import com.mvc.entityPK.MstCustomerPK;

public interface MstCustomerDao extends JpaRepository<MstCustomer, MstCustomerPK> {
	@Query("select cus, kot.namaKota "
			+ "from MstCustomer cus, MstKota kot "
			+ "where cus.kodeKota = kot.kodeKota")
	public List<Object[]> listAll();
}
