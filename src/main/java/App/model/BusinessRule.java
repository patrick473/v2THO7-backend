package App.model;

import javax.json.JsonObject;

public abstract class BusinessRule<T extends BusinessRule<?>> {

   protected final T self;
   protected String type;
   protected String description;
   protected String example;
   protected JsonObject triggerEvents;

  // fluid interface building

   public BusinessRule(final Class<T> selfClass) {
      this.self = selfClass.cast(this);
   }

   public T type(final String type) {
      this.type = type;
      return self;
   }

   public T description(final String description) {
      this.description = description;
      return self;
   }

   public T example(final String example) {
      this.example = example;
      return self;
   }

   public T triggerEvents(final JsonObject triggerEvents) {
      this.triggerEvents = triggerEvents;
      return self;
   }

   // getters

   public String getType() {
      return this.type;
   }

   public String getDescription() {
      return this.description;
   }

   public String getExample() {
      return this.example;
   }

   public JsonObject getTriggerevents() {
      return this.triggerEvents;
   }

}