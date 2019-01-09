package App.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;

public class test {
    public static void main(String[] args) {
        String text = "$firstname $lastname";
        Map<String,String> bindings = new HashMap<String,String>();
        bindings.put("firstname","patrick");
        bindings.put("lastname", "kottman");
       

        SimpleTemplateEngine engine = new SimpleTemplateEngine();
         try {
            Writable template = engine.createTemplate(text).make(bindings);
            System.out.println(template.toString());
         } catch(Exception e){
             System.out.println(e);
         }

    }
}