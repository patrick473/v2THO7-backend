package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import App.model.templatebs.Template;

/**
 * ParameterDAO
 */
public class TemplateDAO {

    JDBCSingleton jdbcInstance;
    public TemplateDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }

    public boolean createTemplate(Template template) {

        try {
            Connection con = this.jdbcInstance.getConnection();
            String statement = "insert into template(databasetype,ruletype,template,isconstraint) values(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1,template.sqldialect());
            pstmt.setInt(2,template.businessruleType());
            pstmt.setString(3,template.templatestring());
            if(template.isConstraint()){
                pstmt.setString(4, "1");
            }
            else{
                pstmt.setString(4, "0");
            }
            int amount = pstmt.executeUpdate();
           ;
            con.close();
            return amount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}