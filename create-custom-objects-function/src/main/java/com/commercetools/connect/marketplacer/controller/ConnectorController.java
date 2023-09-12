package com.commercetools.connect.marketplacer.controller;

import com.commercetools.connect.marketplacer.service.CreateCustomObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ConnectorController {

    @Autowired
    CreateCustomObjectService createCustomObjectService;

    @PostMapping("/")
    public String createCustomObjects(@RequestBody String requestBody) {
        try {
            return createCustomObjectService.createCustomObjects(requestBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
