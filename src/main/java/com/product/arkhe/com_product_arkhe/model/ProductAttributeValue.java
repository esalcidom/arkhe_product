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
 * ProductAttributeValue
 */
@Entity
@Table(name = "PRODUCT_ATTR_VAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductAttributeValue {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "PRODUCT_ATTR_ID")
    private long productAttrId;
    @Column(name = "VAL")
    private String val;
}