package br.com.intelipost.sdk.util;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonLoader {

    public static <T> T loadFile(Class<T> type,String name)  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.findAndRegisterModules();

            Path path = get(JsonLoader.class.getResource(name).toURI());
            return objectMapper.readValue(readAllBytes(path), type);
        } catch (Exception e) {
            throw new RuntimeException("Fail while Loading JSON file...", e);
        }
    }
}
