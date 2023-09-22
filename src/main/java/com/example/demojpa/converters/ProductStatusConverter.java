package com.example.demojpa.converters;

import com.example.demojpa.enums.EmployeeStatus;
import com.example.demojpa.enums.ProductStatus;
import com.example.demojpa.models.Product;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(ProductStatus.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
