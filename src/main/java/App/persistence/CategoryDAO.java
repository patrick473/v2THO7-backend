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


    public Category getCategory(int id, Connection con){
        Category category = new Category();
        try {
           
            
            PreparedStatement pstmt = con.prepareStatement("select * from category where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                category = new Category(rs.getInt(1),rs.getString(2));
            }
           

        } catch(Exception e){
            e.printStackTrace();
        }
        return category;
    }
  
}