package com.restDeneme.resDeneme.Contoller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

public class RandomData {
    @RestController
    @RequestMapping("/random")
    public class RandomDataEndpoint {

        @Autowired
        private ObjectMapper objectMapper;

        @GetMapping("/persons")
        public JsonNode getRandomPersons() {

            Faker faker = new Faker();
            ArrayNode persons = objectMapper.createArrayNode();

            for (int i = 0; i < 10; i++) {
                persons.add(objectMapper.createObjectNode()
                        .put("firstName", faker.name().firstName())
                        .put("lastName", faker.name().lastName())
                        .put("title", faker.name().title())
                        .put("suffix", faker.name().suffix())
                        .put("address", faker.address().streetAddress())
                        .put("city", faker.address().cityName())
                        .put("country", faker.address().country()));
            }

            return persons;
        }
    }


}
