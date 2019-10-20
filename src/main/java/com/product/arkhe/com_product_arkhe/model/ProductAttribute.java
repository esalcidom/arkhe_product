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
 * ProductAttribute
 */
@Entity
@Table(name = "PRODUCT_ATTR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductAttribute {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "PRODUCT_ID")
    private long productId;
    @Column(name = "ATTR_ID")
    private long attributeId;
}