package com.commercetools.connect.marketplacer.service;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import com.commercetools.api.models.custom_object.CustomObject;
import com.commercetools.api.models.custom_object.CustomObjectDraft;
import com.commercetools.connect.marketplacer.model.MarketplacerRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class CreateCustomObjectService {
    private static final Gson gson = new Gson();

    private static final Logger logger = Logger.getLogger(CreateCustomObjectService.class.getName());

    public static ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("<<clientId>>")
                                .withClientSecret("<<clientSecret>>")
                                .build(),
                        ServiceRegion.GCP_US_CENTRAL1)
                .build("<<projectId>>");
        return apiRoot;
    }

    static ProjectApiRoot apiRoot = createApiClient();

    public String createCustomObjects(MarketplacerRequest marketplacerRequest) throws IOException {
//        BufferedWriter writer = response.getWriter();
//        String requestBody = CharStreams.toString(request.getReader());
//        logger.info("Request : " + requestBody);
//        MarketplacerRequest marketplacerRequest = gson.fromJson(requestBody, MarketplacerRequest.class);
        try {
            logger.info(gson.toJson(marketplacerRequest));
            JsonObject jsonResponse = new JsonObject();
            CustomObject seller = createCustomObject(marketplacerRequest);
            jsonResponse.addProperty(marketplacerRequest.getPayload().getData().getNode().getTypename(), seller.getId());
            // writer.write(gson.toJson(jsonResponse));
        } catch (Exception e) {
            String stacktrace = ExceptionUtils.getStackTrace(e);
            JsonObject jsonResponse = new JsonObject();
            // jsonResponse.addProperty("originalRequest" , requestBody);
            jsonResponse.addProperty("stackTrace" , stacktrace);
            logger.info(stacktrace);
            // writer.write(gson.toJson(jsonResponse));
        }
        // response.setContentType("application/json");
        return null;
    }

    public static CustomObject createCustomObject(MarketplacerRequest request) {
        CustomObjectDraft customObjectDraft = CustomObjectDraft.builder()
                .container(request.getPayload().getData().getNode().getTypename())
                .key(request.getPayload().getData().getNode().getId().replace("=",""))
                .value(request.getPayload().getData().getNode())
                .build();
        CustomObject customObject = apiRoot.customObjects().post(customObjectDraft).executeBlocking().getBody();
        return customObject;
    }

}

