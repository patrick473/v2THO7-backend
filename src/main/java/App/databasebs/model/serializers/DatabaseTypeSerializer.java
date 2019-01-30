package App.databasebs.model.serializers;

import java.io.IOException;
import java.util.Map;

import App.databasebs.model.Column;
import App.databasebs.model.DatabaseType;
import App.databasebs.model.Table;
import com.fasterxml.jackson.core.JsonGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DatabaseTypeSerializer extends StdSerializer<DatabaseType> {

    public DatabaseTypeSerializer() {
        this(null);
    }
    public DatabaseTypeSerializer(Class<DatabaseType> t){
        super(t);
    }

    @Override
    public void serialize(DatabaseType value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", value.id());
        jgen.writeStringField("dialect", value.jdbctypecode());
        jgen.writeStringField("triggertemplate", value.triggertemplate());
        jgen.writeStringField("constrainttemplate", value.constrainttemplate());
        jgen.writeEndObject();


    }

}