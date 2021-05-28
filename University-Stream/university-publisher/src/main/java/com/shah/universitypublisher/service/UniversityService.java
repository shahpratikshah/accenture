package com.shah.universitypublisher.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shah.universitypublisher.model.Universities;
import com.shah.universitypublisher.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class UniversityService {
    private static final String UNI_TOPIC = "universities_topic";
    @Autowired
    KafkaTemplate<String, University> kafkaTemplate;

    public int load() throws IOException {
        Universities universities = new Universities();


       ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<University>> typeReference = new TypeReference<List<University>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/Users/shah/Documents/SCPAY_POC/University-Stream/university-publisher/src/main/java/com/shah/universitypublisher/service/universities.json");
        universities.setUniversities(mapper.readValue(inputStream,typeReference));

        universities
                .getUniversities()
                .stream()
                .forEach(university -> {
                    kafkaTemplate.send(UNI_TOPIC, university);
                    System.out.println("Publishing university = " + university.getName());
                });
        return universities.getUniversities().size();
    }
}
