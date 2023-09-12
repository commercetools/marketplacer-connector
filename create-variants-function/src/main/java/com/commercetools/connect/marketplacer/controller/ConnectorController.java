package com.commercetools.connect.marketplacer.controller;

import com.commercetools.connect.marketplacer.model.MarketplacerRequest;
import com.commercetools.connect.marketplacer.service.ConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ConnectorController {

    @Autowired
    ConnectorService connectorService;

    @GetMapping("/")
    public String createVariantsFunction(MarketplacerRequest marketplacerRequest) {
        try {
            return connectorService.createVariantsFuncion(marketplacerRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
