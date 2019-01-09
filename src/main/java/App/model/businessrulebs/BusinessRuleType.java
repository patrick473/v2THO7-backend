package App.model.businessrulebs;

import java.util.ArrayList;
import java.util.Map;

/**
 * BusinessRuleType
 */
public class BusinessRuleType {

    private String name;
    private String nameCode;
    private String explanation;
    private String example;
    private boolean constraintPossible;
    private ArrayList<Operator> possibleOperators;
    private Map<String,String> parameters;
    private Category category;
}