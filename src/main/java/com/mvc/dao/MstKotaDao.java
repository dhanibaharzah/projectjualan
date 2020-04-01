package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstKota;
import com.mvc.entityPK.MstKotaPK;

public interface MstKotaDao extends JpaRepository<MstKota, MstKotaPK> {
	@Query("select kota, prov.namaProvinsi "
			+ "from MstKota kota, MstProvinsi prov "
			+ "where kota.kodeProvinsi = prov.kodeProvinsi")
	public List<Object[]> listAll();
	
	@Query("select kota from MstKota kota where kota.namaKota = :namaKota")
	public MstKota findByNamaKota(@Param("namaKota")String namaKota);
}
