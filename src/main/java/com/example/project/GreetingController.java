package com.example.project;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class GreetingController {

    @RequestMapping
    Map<String, String> greeting() {
        return Collections.singletonMap("greeting", "hello");
    }

}
