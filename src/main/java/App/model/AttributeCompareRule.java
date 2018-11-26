package App.model;

public class AttributeCompareRule extends StrictDataConstraint implements ISerializable{

    private String comparisonType;
    private String otherColumn;
    
    AttributeCompareRule(String comparisonType, String otherColumn,String column,String table,String description,String example){
        this.comparisonType = comparisonType;
        this.otherColumn = otherColumn;
        this
    }
   
    public String getComparisonType(){
        return this.comparisonType;
    }
    
    public String getOtherColumn(){
        return this.otherColumn;
    }
    @Override
    public String generateCode() {
        return "beep" ;
    }
}