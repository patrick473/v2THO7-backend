package App.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import App.model.templatebs.Category;

/**
 * ParameterDAO
 */
public class CategoryDAO {

    JDBCSingleton jdbcInstance;
    public CategoryDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }


    public Category getCategory(int id){
        Category category = new Category();
        try {
            Connection con = this.jdbcInstance.getConnection();
            
            PreparedStatement pstmt = con.prepareStatement("select * from category where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                category = new Category(rs.getInt(1),rs.getString(2));
            }
            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }
        return category;
    }
    public boolean createCategory(String name) {

        try {
            Connection con = this.jdbcInstance.getConnection();
            String statement = "insert into category(category) values(?)";
            PreparedStatement pstmt = con.prepareStatement(statement);
            
            pstmt.setString(1, name);
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