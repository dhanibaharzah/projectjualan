package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvc.entity.MstBarang;
import com.mvc.entityPK.MstBarangPK;

public interface MstBarangDao extends JpaRepository<MstBarang, MstBarangPK> {
	@Query("select bar, sup.namaSupplier "
			+ "from MstBarang bar, MstSupplier sup "
			+ "where bar.kodeSupplier = sup.kodeSupplier")
	public List<Object[]> listAll();
}
