package com.example.project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SomeConfig.class)
@IntegrationTest
@WebAppConfiguration
public class ApplicationTests {

    @Value("${management.port}")
    int managementPort;

    @Value("${server.port}")
    int serverPort;

    RestTemplate restTemplate;


    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }


    @Test
    public void overridingOfPropertiesWorksAsExpected() {
        assertThat(serverPort, is(9100));
        assertThat(managementPort, is(9101));
    }


    @Test
    public void canFetchController() {
        Map<String, String> map = restTemplate.getForObject("http://localhost:9100/", Map.class);

        assertThat(map.get("greeting"), is("hello"));
    }


    @Test
    public void canFetchHealthCheck() {
        String health = restTemplate.getForObject("http://localhost:9101/health", String.class);

        assertThat(health, is("ok"));
    }
}