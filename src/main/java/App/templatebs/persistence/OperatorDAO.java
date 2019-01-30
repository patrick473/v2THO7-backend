package App.templatebs.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import App.templatebs.model.Operator;
import App.helpers.JDBCSingleton;
/**
 * OperatorDAO
 */
public class OperatorDAO {

    private JDBCSingleton jdbcInstance;

    public OperatorDAO() {
        this.jdbcInstance = JDBCSingleton.getInstance();
    }

    public boolean createOperator(int brtypeid, Operator op, Connection con) {
        try {
            

            Statement query = con.createStatement();
            ResultSet rs1 = query.executeQuery("select * from operator where name = '" + op.name() + "'");
            int id = 0;
            if (!rs1.next()) {
                String statement = "insert into operator(name,action) values(?,?)";
                PreparedStatement pstmt = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, op.name());
                pstmt.setString(2, op.action());
                int amount = pstmt.executeUpdate();
                id = this.findID(op.name());
            } else {
                id = rs1.getInt("id");
            }
            String statement = "insert into operatoronbusinessruletype(businessruletype,operator) values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(statement);
            pstmt.setInt(1, brtypeid);
            pstmt.setInt(2, id);
            int amount = pstmt.executeUpdate();
            System.out.print(id);
            return amount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Operator> getOperators(int businessruletype, Connection con) {
        ArrayList<Operator> operators = new ArrayList<Operator>();
        ArrayList<Integer> operatorids = new ArrayList<Integer>();
        try {
           
            PreparedStatement pstmt = con
                    .prepareStatement("select operator from operatoronbusinessruletype where businessruletype = ?");
            pstmt.setInt(1, businessruletype);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                operatorids.add(rs.getInt(1));
            }
            for (Integer opid : operatorids) {
                operators.add(this.getOperator(opid));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return operators;
    }

    public Operator getOperator(int id) {
        Operator operator = new Operator();
        try {
            Connection con = this.jdbcInstance.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from operator where id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                operator = new Operator(id, rs.getString(2), rs.getString(3));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return operator;
    }

    public int deleteOperatorsByBusinessruleType(int type, Connection con) {
        int result = 0;
        try {
            
            PreparedStatement pstmt = con
                    .prepareStatement("delete from operatoronbusinessruletype where businessruletype=?");
            pstmt.setInt(1, type);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private int findID(String name) {
        try {
            Connection con = this.jdbcInstance.getConnection();

            PreparedStatement stmt = con.prepareStatement("select id from operator where name=?");
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            int id = 0;
            if (rs.next()) {

                id = rs.getInt("id");
            }

            con.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}