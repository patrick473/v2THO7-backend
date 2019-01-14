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
            String statement = "insert into template(databasetype,ruletype,template,isconstraint) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1,brtypeid);
            pstmt.setString(2,key);
            pstmt.setString(3, value);
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