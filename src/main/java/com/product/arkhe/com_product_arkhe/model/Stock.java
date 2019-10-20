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
 * Stock
 */
@Entity
@Table(name = "TABLE_ATTRIBUTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "PRODUCT_ID")
    private long productId;
    @Column(name = "PRODUCT_ATTR_VAL_ID")
    private long productAttrValId;
    @Column(name = "AMOUNT")
    private long amount;
}