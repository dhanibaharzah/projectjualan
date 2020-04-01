package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.entityPK.TrHeaderPenjualanPK;

public interface TrHeaderPenjualanDao extends JpaRepository<TrHeaderPenjualan, TrHeaderPenjualanPK> {
	@Query("select head, cust.namaCustomer, kar.namaKaryawan "
			+ "from TrHeaderPenjualan head, MstCustomer cust, MstKaryawan kar "
			+ "where head.kodeCustomer = cust.kodeCustomer and head.kodeKaryawan = kar.kodeKaryawan")
	public List<Object[]> listAll();
}
