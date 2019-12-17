package com.m4ver1k.profile.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * @author kadarsh
 * Test Helpers/Utilities.
 */
public class TestHelpers {

    /**
     * This method return a instance of ObjectMapper to serialize an object to JSON format.
     * @return ObjectMapper
     */
    public static final ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParameterNamesModule());
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
