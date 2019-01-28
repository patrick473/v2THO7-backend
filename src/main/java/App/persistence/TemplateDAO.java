package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public ArrayList<Template> getTemplateByRuleTypeAndDatabaseType(int ruletypeid, int databasetypeid) {
        ArrayList<Template> templates = new ArrayList<>();
        try {

            Connection con = this.jdbcInstance.getConnection();
            String stmt = "select * from template where ruletype = ? and databasetype = ?";
            PreparedStatement pstmt = con.prepareStatement(stmt);
            pstmt.setInt(1, ruletypeid);
            pstmt.setInt(2, databasetypeid);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Template template = new Template(
                        rs.getInt("id"),
                        rs.getInt("databasetype"),
                        rs.getInt("ruletype"),
                        rs.getString("template"),
                        rs.getBoolean("isconstraint"));

                templates.add(template);
            }

            return templates;
        }
        catch(Exception e) {
            e.printStackTrace();
            return templates;
        }
    }

    public ArrayList<Template> getAllTemplates() {
        ArrayList<Template> templates = new ArrayList<>();
        try {

            Connection con = this.jdbcInstance.getConnection();
            String stmt = "select * from template";
            PreparedStatement pstmt = con.prepareStatement(stmt);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Template template = new Template(
                        rs.getInt("id"),
                        rs.getInt("databasetype"),
                        rs.getInt("ruletype"),
                        rs.getString("template"),
                        rs.getBoolean("isconstraint"));

                templates.add(template);
            }

            return templates;
        }
        catch(Exception e) {
            e.printStackTrace();
            return templates;
        }
    }

    public Template getTemplate(int id) {
        try {

            Connection con = this.jdbcInstance.getConnection();
            String stmt = "select * from template where id = ?";
            PreparedStatement pstmt = con.prepareStatement(stmt);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                Template template = new Template(
                        rs.getInt("id"),
                        rs.getInt("databasetype"),
                        rs.getInt("ruletype"),
                        rs.getString("template"),
                        rs.getBoolean("isconstraint"));

                return template;
            }else {
                return null;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
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

    public Template updateTemplate(Template template) {
        try{

            Connection con = this.jdbcInstance.getConnection();
            String statement = "update template set databasetype = ?, ruletype = ?, template = ?, isconstraint = ? where id = ?";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1, template.sqldialect());
            pstmt.setInt(2, template.businessruleType());
            pstmt.setString(3, template.templatestring());
            pstmt.setBoolean(4, template.isConstraint());
            pstmt.setInt(5, template.id());

            if(pstmt.executeUpdate() == 1) {
                return template;
            }
            else {
                return null;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}