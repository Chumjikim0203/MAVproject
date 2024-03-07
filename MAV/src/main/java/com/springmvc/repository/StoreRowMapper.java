package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Store;

public class StoreRowMapper implements RowMapper<Store> {

<<<<<<< HEAD
    @Override
    public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
        Store store = new Store();
        
        store.setStoreId(rs.getString("storeId"));
        store.setStoreName(rs.getString("storeName"));
        store.setStoreAddr(rs.getString("storeAddr"));
        store.setStoreCategory(rs.getString("storeCategory"));
        store.setStoreCode(rs.getString("storeCode"));
        store.setStorePhone01(rs.getString("storePhone01"));
        store.setStorePhone02(rs.getString("storePhone02"));
        store.setStorePhone03(rs.getString("storePhone03"));
        store.setStoreImages(rs.getString("storeImages"));
        store.setStoreInfomation(rs.getString("storeInfomation"));
        store.setStoreNotice(rs.getString("storeNotice"));
        store.setStoreApprove(rs.getBoolean("storeApprove"));
        
        return store;
    }
=======
	@Override
	public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
		Store store = new Store();
		store.setStoreAddr(rs.getString("storeAddr"));
		store.setStoreApprove(rs.getBoolean("storeApprove"));
		store.setStoreCategory(rs.getString("storeCategory"));
		store.setStoreCode(rs.getString("storeCode"));
		store.setStoreId(rs.getString("storeId"));
//		store.setStoreImages(rs.getString("storeImages"));
		store.setStoreInfomation(rs.getString("storeInfomation"));
		store.setStoreName(rs.getString("storeName"));
		store.setStoreNotice(rs.getString("storeNotice"));
		store.setStorePhone01(rs.getString("storePhone01"));
		store.setStorePhone02(rs.getString("storePhone02"));
		store.setStorePhone03(rs.getString("storePhone03"));
		store.setStoreCode(rs.getString("storeCode"));
	      return store;
	}

>>>>>>> origin/PMS
}
