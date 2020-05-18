package com.bawei.lige.service;


import com.bawei.lige.dao.ShopDao;
import com.bawei.lige.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    @Resource
    private ShopDao shopDao;

    public Page<Shop> list (Integer current, Integer size,Shop shop){
        Specification<Shop> specification=new Specification<Shop>() {
            @Override
            public Predicate toPredicate(Root<Shop> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates=new ArrayList<>();
                if(!StringUtils.isEmpty(shop.getName())){
                    predicates.add(cb.like(root.get("name"),"%".concat(shop.getName()).concat("%")));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));

            }
        };
        Pageable of= PageRequest.of(current-1,size);
        return shopDao.findAll(specification,of);
    }

    public Shop save(@RequestBody Shop shop){
        return shopDao.save(shop);
    }

    public boolean delete(Integer id){
        shopDao.deleteById(id);
        return true;
    }



}
