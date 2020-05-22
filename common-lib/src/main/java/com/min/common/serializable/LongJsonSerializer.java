package com.min.common.serializable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
/**
 * @author min
 * Serialize
 * String -> Long
 */
public class LongJsonSerializer extends JsonSerializer<Long> {
    /**
     * Serialize.
     *
     * @param value              the value
     * @param jsonGenerator      the json generator
     * @param serializerProvider the serializer provider
     *
     * @throws IOException the io exception
     */
    @Override
    public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String text = (value == null ? null : String.valueOf(value));
        if (text != null) {
            jsonGenerator.writeString(text);
        }
    }
}
