package com.bawei.lige.dao;

import com.bawei.lige.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShopDao extends JpaRepository<Shop,Integer>, JpaSpecificationExecutor<Shop> {


}
