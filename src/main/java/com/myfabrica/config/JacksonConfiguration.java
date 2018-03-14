/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 *
 * @author Dmartinezb
 */
@Configuration
public class JacksonConfiguration {
    
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        //Registering Hibernate4Module to support lazy objects
        Hibernate5Module hm = new Hibernate5Module();
        hm.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
        hm.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
        
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRAP_EXCEPTIONS); //new
        mapper.disable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS); //new
        mapper.disable(SerializationFeature.FAIL_ON_SELF_REFERENCES); //new
        
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.WRAP_EXCEPTIONS , false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.registerModule(hm);
        
        
        
        SimpleModule dateMappingModule = new SimpleModule();
        dateMappingModule.addSerializer(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date fecha, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                jsonGenerator.writeString(dateFormat.format(fecha));
            }
        });
        dateMappingModule.addDeserializer(Date.class, new JsonDeserializer<Date>() {
            
            @Override
            public Date deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
                try {
                    return dateFormat.parse(jp.getValueAsString());
                } catch (ParseException ignored) {}
                
                return dc.parseDate(jp.getValueAsString());
            }
        });
        mapper.registerModule(dateMappingModule);
        
        
        messageConverter.setObjectMapper(mapper);
        return messageConverter;
    }
    
    
}

