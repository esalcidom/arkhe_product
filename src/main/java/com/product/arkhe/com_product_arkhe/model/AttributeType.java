package com.product.arkhe.com_product_arkhe.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ProductAttributeValue
 */
@Entity
@Table(name = "TABLE_ATTRIBUTE_TYPE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AttributeType {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AttributeType)) {
            return false;
        }
        AttributeType attributeType = (AttributeType) o;
        return this.name.equals(attributeType.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    
}