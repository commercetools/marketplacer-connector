package com.commercetools.connect.marketplacer;

import com.commercetools.connect.marketplacer.model.MarketplacerRequest;
import com.commercetools.connect.marketplacer.model.Payload;
import com.commercetools.connect.marketplacer.service.ConnectorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.function.Function;

@SpringBootApplication
public class ConnectorApplication {

    @Bean
    public Function<MarketplacerRequest, Payload> uppercase() {
        return (input) -> {
            ConnectorService connectorService = new ConnectorService();
            try {
                connectorService.createVariantsFuncion(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ConnectorApplication.class, args);
    }
}