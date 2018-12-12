package App.model;

public class EntityOtherRule extends StrictDataConstraint<EntityOtherRule> implements ISerializable {
    private String statement;
    private String otherColumn;
    private String otherTable;

    EntityOtherRule() {
        super(EntityOtherRule.class);
    }

    public EntityOtherRule statement(String statement) {
        this.statement = statement;
        return self;
    }

    public EntityOtherRule otherColumn(String otherColumn) {
        this.otherColumn = otherColumn;
        return self;
    }

    public EntityOtherRule otherTable(String otherTable) {
        this.otherTable = otherTable;
        return self;
    }

    public String getStatement() {
        return this.statement;
    }

    public String getOthercolumn() {
        return this.otherColumn;
    }

    public String getOthertable() {
        return this.otherTable;
    }

    @Override
    public String generateCode() {
        return "Beep";
    }
}