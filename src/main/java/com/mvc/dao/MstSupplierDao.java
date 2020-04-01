package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstSupplier;
import com.mvc.entityPK.MstSupplierPK;

public interface MstSupplierDao extends JpaRepository<MstSupplier, MstSupplierPK> {
	@Query("select supp, kota.namaKota "
			+ "from MstSupplier supp, MstKota kota "
			+ "where supp.kodeKota = kota.kodeKota")
	public List<Object[]> listAll();
	
	@Query("select supp from MstSupplier supp where supp.namaSupplier = :namaSupplier")
	public MstSupplier findByNamaSupplier(@Param("namaSupplier")String namaSupplier);
}
