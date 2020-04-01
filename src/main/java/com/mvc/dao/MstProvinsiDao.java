package com.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstProvinsi;
import com.mvc.entityPK.MstProvinsiPK;

public interface MstProvinsiDao extends JpaRepository<MstProvinsi, MstProvinsiPK> {
	@Query("select prov from MstProvinsi prov where prov.namaProvinsi = :namaProvinsi")
	public MstProvinsi findByNamaProvinsi(@Param("namaProvinsi")String namaProvinsi);
}
