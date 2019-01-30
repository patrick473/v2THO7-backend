package App.databasebs.model.serializers;

import java.io.IOException;
import java.util.Map;

import App.databasebs.model.Column;
import App.databasebs.model.Database;
import App.databasebs.model.Table;
import com.fasterxml.jackson.core.JsonGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DatabaseSerializer extends StdSerializer<Database> {

    public DatabaseSerializer() {
        this(null);
    }
    public DatabaseSerializer(Class<Database> d){
        super(d);
    }

    @Override
    public void serialize(Database value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", value.id());
        jgen.writeStringField("name", value.name());
        jgen.writeStringField("username", value.username());
        jgen.writeStringField("password", value.password());
        jgen.writeStringField("host", value.host());
        jgen.writeStringField("schema", value.schema());
        jgen.writeStringField("port", value.port());

        jgen.writeArrayFieldStart("type");
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.dialect().id());
        jgen.writeStringField("dialect", value.dialect().jdbctypecode());
        jgen.writeStringField("dialect", value.dialect().triggertemplate());
        jgen.writeStringField("dialect", value.dialect().constrainttemplate());
        jgen.writeEndObject();
        jgen.writeEndArray();

        jgen.writeArrayFieldStart("tables");
        for (Table table: value.tables()) {
            jgen.writeStartObject();
            jgen.writeNumberField("id", table.id());
            jgen.writeStringField("name", table.name());
            jgen.writeArrayFieldStart("columns");
            for(Column column: table.columns()) {
                jgen.writeStartObject();
                jgen.writeNumberField("id", column.id());
                jgen.writeStringField("name", column.name());
                jgen.writeStringField("datatype", column.datatype());
                jgen.writeEndObject();
            }
            jgen.writeEndArray();
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
        jgen.writeEndObject();


    }

}