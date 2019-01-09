package App.model.businessrulebs;

import java.util.Map;

/**
 * BusinessRule
 */
public class BusinessRule {

    private String name;
    private boolean applied;
    private Operator operator;
    private Map<String,String> bindings;
    private BusinessRuleType type;
    
}