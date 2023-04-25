package manager;

import model.Operation_class;
import pub.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

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
    public Vector find(String jt) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Vector list = new Vector();
        String sql;
        if (jt.equals("")){
            sql = "select * from operation_class";
        }else{
            sql = "select * from operation_class where (cid='" +
                    jt +"' or cname='" +
                    jt +"')";
        }
        Operation_class oc= null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int i = 0;
            while (resultSet.next()){
                oc = new Operation_class();
                oc.setCid(resultSet.getString("cid"));
                oc.setCname(resultSet.getString("cname"));
                oc.setCnumber(resultSet.getString("cnumber"));
                oc.setC_busy_number(resultSet.getString("c_busy_number"));
                oc.setC_free_number(resultSet.getString("c_free_number"));
                list.add(i,"层级编号：" +oc.getCid() +" "
                + "层级名称：" +oc.getCname() +" "
                + "数量：" +oc.getCnumber() +" "
                + "忙碌数量：" +oc.getC_busy_number() +" "
                + "空闲数量：" +oc.getC_free_number());
                i++;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return list;
    }
    //查询所有手术室层级信息
    public ArrayList findallclass() throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql;
        ArrayList<String> arrayList = new ArrayList<>();
        sql = "select cname from operation_class";
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        Operation_class oc = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                oc = new Operation_class();
                oc.setCname(resultSet.getString("cname"));
                arrayList.add(oc.getCname());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arrayList;
    }

}
