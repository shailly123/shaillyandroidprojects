package com.example.shaillypanchal.headyecommerce.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by shaillypanchal on 03/03/18.
 */

public class CommonUtils {


    public static ObjectMapper getDeserializationFeature() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
