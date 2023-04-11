package manager;
import model.Operation_class;
import pub.DBConn;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class Operation_classManager {
    //添加手术室等级信息
    public int addoperationclass(Operation_class oc){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            int i1 = Integer.parseInt(oc.getCnumber());
            int i2 = Integer.parseInt(oc.getC_busy_number());
            int i3 = Integer.parseInt(oc.getC_free_number());
            String sql;
            sql = "insert into operation_class values('" +
                    oc.getCid() +"','" +
                    oc.getCname() +"','" +
                    i1 +"','" +
                    i2 +"','" +
                    i3 +"')";
            try {
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
            return i;
    }
    //删除手术室等级信息
    public int deleteoperationclass(String cid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn =db.getConn();
            int i = 0;
            String sql;
            sql = "delete from operation_class where cid='" +
                    cid +"'";
            try {
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return i;
    }
    //修改手术室等级信息
    public int updateoperationclass(String cid, String cname, String cnumber, String c_busy_number, String c_free_number){
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            int i1 = Integer.parseInt(cnumber);
            int i2 = Integer.parseInt(c_busy_number);
            int i3 = Integer.parseInt(c_free_number);
            sql = "update operation_class set cid='" +
                    cid +"', cname='" +
                    cname +"',cnumber='" +
                    i1 +"', c_busy_number='" +
                    i2 +"', c_free_number='" +
                    i3 +"' where cid='" +
                    cid +"'";
            try {
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return i;
    }
    //按照手术室层级id来查询手术室信息
    public Operation_class findoperationclasscid(String cid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            String sql;
            sql = "select * from operation_class where cid='" +
                    cid +"'";
            Operation_class oc = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()){
                    oc = new Operation_class();
                    oc.setCid(rs.getString("cid"));
                    oc.setCname(rs.getString("cname"));
                    oc.setCnumber(rs.getString("cnumber"));
                    oc.setC_busy_number(rs.getString("c_busy_number"));
                    oc.setC_free_number(rs.getString("c_free_number"));
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch (SQLException ex3){
                ex3.printStackTrace();
            }
            return oc;

    }
    //按照手术层级名称来查询手术室信息
    public Operation_class findoperationclasscname(String cname){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from operation_class where cname='" +
                cname +"'";
        Operation_class oc = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                oc = new Operation_class();
                oc.setCid(rs.getString("cid"));
                oc.setCname(rs.getString("cname"));
                oc.setCnumber(rs.getString("cnumber"));
                oc.setC_busy_number(rs.getString("c_busy_number"));
                oc.setC_free_number(rs.getString("c_free_number"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return oc;

    }
}
