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
            if(pstmt.executeUpdate() == 1) {
                con.close();
                return true;
            }
            else {
                con.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTemplate(int id) {
        try {

            Connection con = this.jdbcInstance.getConnection();
            String statement = "delete from template where id = ?";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1, id);

            if(pstmt.executeUpdate() == 1) {
                return true;
            }
            else {
                return false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}