package com.commercetools.connect.marketplacer.controller;

import com.commercetools.connect.marketplacer.model.MarketplacerRequest;
import com.commercetools.connect.marketplacer.service.ConnectorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
public class ConnectorController {

    private static final Logger logger = Logger.getLogger(ConnectorController.class.getName());

    final ConnectorService connectorService;

    @Autowired
    public ConnectorController(ConnectorService connectorService) {
        this.connectorService = connectorService;
    }

    @PostMapping("/")
    public String createVariants(@RequestBody String requestBody) {
        logger.info("Request : " + requestBody);
        try {
            return connectorService.createVariants(requestBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
