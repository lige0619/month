package com.bawei.lige.controller;


import com.bawei.lige.entity.Shop;
import com.bawei.lige.service.ShopService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/shop/")
public class ShopController {

    @Resource
    private ShopService shopService;

    @RequestMapping("list")
    public Page<Shop> list(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "3") Integer size, Shop shop){

        return shopService.list(current,size,shop);
    }

    @RequestMapping("save")
    public Shop save(@RequestBody Shop shop){
        return shopService.save(shop);
    }

    @RequestMapping("delete")
    public boolean delete(Integer id){
        shopService.delete(id);
        return true;
    }
}
