package com.example.ProjectSpringboot.config;

import java.time.Instant;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Configurable;


@Configurable
public class GsonInstantAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return Instant.parse(json.getAsString());
    }

    @Override
    public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(DateTimeFormatter.ISO_INSTANT.format(src));
    }
}