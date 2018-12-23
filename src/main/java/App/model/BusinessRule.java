package App.model;

import javax.json.JsonObject;

public abstract class BusinessRule<T extends BusinessRule<?>> {

   protected final T self;
   protected int id;
   protected String type;
   protected String description;
   protected String example;
   protected String name;
   protected JsonObject triggerEvents;

  // fluid interface building

   public BusinessRule(final Class<T> selfClass) {
      this.self = selfClass.cast(this);
   }

   public T id(final int id){
      this.id = id;
      return self;
   }
   public T type(final String type) {
      this.type = type;
      return self;
   }

   public T description(final String description) {
      this.description = description;
      return self;
   }
   public T name(final String name){
      this.name = name;
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

   public int getID(){
      return this.id;
   }
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