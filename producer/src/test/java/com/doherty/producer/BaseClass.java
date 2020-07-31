package com.doherty.producer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseClass {

    @Autowired
    PersonRestController personRestController;

    @MockBean
    PersonService personService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(personRestController);
        Mockito.when(personService.findPersonById(1L))
                .thenReturn(new Person(1L, "foo", "bar"));
    }
}
