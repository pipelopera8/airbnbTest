package com.flypass.airbnb.general.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {        
        return (value == null || !value) ? "N" : "Y";            
        }    

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return "Y".equals(value);
        }
    }