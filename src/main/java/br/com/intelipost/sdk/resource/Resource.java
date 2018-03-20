package br.com.intelipost.sdk.resource;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import br.com.intelipost.sdk.response.Response;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.lang.reflect.ParameterizedType;

public abstract class Resource<REQUEST, RESPONSE> {

    protected ObjectMapper objectMapper;
    protected String apiKey;
    private String apiUrl;

    public Resource(String apiKey) {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        this.objectMapper.findAndRegisterModules();

        this.apiKey = apiKey;
        this.apiUrl = "https://api.intelipost.com.br/api/v1";
    }

    protected Response doGetRequest(String path) throws Exception {

        JsonNode json = Request.Get(apiUrl + path)
                                    .addHeader("api_key", apiKey)
                                    .execute()
                                    .handleResponse(httpResponse -> objectMapper.readTree(httpResponse.getEntity().getContent()));

        return processResponse(json);
    }

    protected Response doPostRequest(String path, REQUEST requestBody) throws Exception {


        JsonNode json = Request.Post(apiUrl + path)
                                    .addHeader("api_key", apiKey)
                                    .bodyString(objectMapper.writeValueAsString(requestBody), ContentType.APPLICATION_JSON)
                                    .execute()
                                    .handleResponse(httpResponse -> objectMapper.readTree(httpResponse.getEntity().getContent()));

        return processResponse(json);
    }

    private Response<RESPONSE> processResponse(JsonNode json) throws Exception{
        Response<RESPONSE> response = parseJson(json);
        handleError(response);
        return response;
    }

    private void handleError(Response response) throws Exception {
        if (response.getStatus().equals("ERROR")) {
            throw new Exception(response.getMessages().toString());
        }
    }

    private Response<RESPONSE> parseJson(JsonNode json) throws Exception {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        String typeName = parameterizedType.getActualTypeArguments()[1].getTypeName();

        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Response.class, Class.forName(typeName));

        Response<RESPONSE> response = objectMapper.readValue(json.toString(),javaType);

        return response;
    }
}
