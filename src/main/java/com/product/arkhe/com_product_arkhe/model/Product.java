package com.product.arkhe.com_product_arkhe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Product
 */
@Entity
@Table(name = "TABLE_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "ACTIVE")
    private int active;
    @Column(name = "CATEGORY_ID")
    private long categoryId;
    @Column(name = "GROUP_ID")
    private long groupId;
}