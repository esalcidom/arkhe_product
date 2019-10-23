package com.product.arkhe.com_product_arkhe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Attrribute
 */
@Entity
@Table(name = "TABLE_ATTRIBUTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attribute {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ATTR_TYPE_ID", referencedColumnName = "ID", nullable = false)
    private AttributeType attrType;
    @Column(name = "VALUE")
    private String value;
}