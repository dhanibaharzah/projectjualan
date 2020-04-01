package com.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstKaryawan;
import com.mvc.entityPK.MstKaryawanPK;

public interface MstKaryawanDao extends JpaRepository<MstKaryawan, MstKaryawanPK> {

	@Query("select k from MstKaryawan k "
		 + "where k.username = :username")
	public MstKaryawan findUserByUsername(@Param("username")String username);
	
}
