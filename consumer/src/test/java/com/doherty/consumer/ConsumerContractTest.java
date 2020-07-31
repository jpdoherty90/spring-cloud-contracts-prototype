package com.doherty.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = { "com.doherty:producer:+:stubs:8585" }, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ConsumerContractTest {


    @Test
    public void get_person_from_service_contract() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Person> personResponseEntity = restTemplate.getForEntity("http://localhost:8585/person/1", Person.class);

        assertEquals(personResponseEntity.getBody().getId(), 1L);
        assertEquals(personResponseEntity.getBody().getName(), "foo");
        assertEquals(personResponseEntity.getBody().getSurname(), "bar");

    }


}