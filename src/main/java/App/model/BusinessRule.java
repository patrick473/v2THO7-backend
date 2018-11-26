package App.model;

import javax.json.JsonObject;

public abstract class BusinessRule{
    protected String type;
    protected String description;
    protected String example;
    protected JsonObject triggerEvents;
}