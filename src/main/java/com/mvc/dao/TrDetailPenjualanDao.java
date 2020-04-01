package com.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.entity.TrDetailPenjualan;
import com.mvc.entityPK.TrDetailPenjualanPK;

public interface TrDetailPenjualanDao extends JpaRepository<TrDetailPenjualan, TrDetailPenjualanPK> {

}
