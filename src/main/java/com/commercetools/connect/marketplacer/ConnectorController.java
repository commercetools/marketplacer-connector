package com.commercetools.connect.marketplacer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectorController {

    @GetMapping("/")
    public String hello() {
        return new StringBuilder().append("Hello World").toString();
    }
}
