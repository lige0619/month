package com.bawei.lige.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_shop")
public class Shop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String address;
    private String date;
    private String price;
    private String miaoshu;
    private String maidian;
    private String pic;



}
