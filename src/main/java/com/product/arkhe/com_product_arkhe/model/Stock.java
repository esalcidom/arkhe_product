package com.product.arkhe.com_product_arkhe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    @OneToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    private Product product;
    @OneToOne
    @JoinColumn(name = "PRODUCT_ATTR_VAL_ID", referencedColumnName = "ID", nullable = false)
    private ProductAttributeValue productAttrVal;
    @Column(name = "AMOUNT")
    private long amount;
}