package com.commercetools.connect.marketplacer.controller;

import com.commercetools.connect.marketplacer.model.MarketplacerRequest;
import com.commercetools.connect.marketplacer.service.CreateCustomObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ConnectorController {

    @Autowired
    CreateCustomObjectService createCustomObjectService;

    @GetMapping("/")
    public String createCustomObjects(MarketplacerRequest marketplacerRequest) {
        try {
            return createCustomObjectService.createCustomObjects(marketplacerRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
