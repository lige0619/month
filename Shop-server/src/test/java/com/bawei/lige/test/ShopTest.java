package com.bawei.lige.test;


import com.bawei.lige.dao.ShopDao;
import com.bawei.lige.entity.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopTest {


    @Resource
    private ShopDao shopDao;

    @Test
    public void save(){
        Shop shop = new Shop();
        shop.setId(18);
        shop.setName("张三");
        shop.setAddress("2015-08-08");
        shop.setMaidian("sdf");
        shop.setMiaoshu("sga");
        shop.setPrice("288");
        Shop shops = shopDao.save(shop);

        System.out.println(shops);
    }

    @Test
    public void delete(){
        Shop shop = new Shop();
        shop.setId(18);
        shopDao.delete(shop);

    }

}
