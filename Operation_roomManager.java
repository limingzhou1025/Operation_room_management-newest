package manager;

import model.Operation_room;
import pub.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class Operation_roomManager {
    //添加手术室信息
    public int addoperationromm(Operation_room or){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "insert into operation_room values('" +
                    or.getOrid() +"','" +
                    or.getOrname() +"','" +
                    or.getOrclass() +"','" +
                    or.getOrstate() +"')";
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
    //删除手术室信息
    public int deleteoperationroom(String orid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "delete from operation_room where orid='" +
                    orid +"'";
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
    //更新手术室信息
    public int updateoperationroom(String orid, String orname, String orclass, String orstate){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn =db.getConn();
            int i = 0;
            String sql;
            sql = "update operation_room set orid='" +
                    orid +"', orname='" +
                    orname +"', orclass='" +
                    orclass +"', orstate='" +
                    orstate +"'where orid = '" +
                    orid +"'";
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
    //根据手术室id查询手术室信息
    public Operation_room findoperationroomorid(String orid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql =  "select * from operation_room where orid='" +
                orid +"'";
        Operation_room or = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                or = new Operation_room();
                or.setOrid(rs.getString("orid"));
                or.setOrname(rs.getString("orname"));
                or.setOrclass(rs.getString("orclass"));
                or.setOrstate(rs.getString("orstate"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return or;

    }

    //根据手术室等级查询手术室信息
    public ArrayList findoperationroomorclass(String orclass){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        ArrayList<String> arrayList = new ArrayList<String>();
        sql =  "select orname from operation_room where orclass in(select cid from operation_class where cname='" +
                orclass +"')";
        Operation_room or = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                or = new Operation_room();
                or.setOrname(rs.getString("orname"));
                arrayList.add(or.getOrname());
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return arrayList;

    }
    //根据手术室状态查询手术室信息
    public Operation_room findoperationroomorstate(String orstate){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql =  "select * from operation_room where orstate='" +
                orstate +"'";
        Operation_room or = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                or = new Operation_room();
                or.setOrid(rs.getString("orid"));
                or.setOrname(rs.getString("orname"));
                or.setOrclass(rs.getString("orclass"));
                or.setOrstate(rs.getString("orstate"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return or;

    }
    public Vector find(String jt1, String jc)throws SQLException{
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        Vector list = new Vector<>();
        String sql;
        if (jt1.equals("")){
            if (jc.equals("不限")){
                sql = "select * from operation_room";
            }else{
                sql = "select * from operation_room where orstate='" +
                        jc +"'";
            }
        }else{
            if (jc.equals("不限")){
                sql = "select * from operation_room where (orid='" +
                        jt1 +"' or orname='" +
                        jt1 +"' or orclass='" +
                        jt1 +"')";
            }else{
                sql = "select * from operation_room where(orid='" +
                        jt1 +"' or orname='" +
                        jt1 +"' or orclass='" +
                        jt1 +"') and (orstate='" +
                        jc +"')";
            }
        }
        Operation_room or = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            int i =0;
            while (rs.next()){
                or = new Operation_room();
                or.setOrid(rs.getString("orid"));
                or.setOrname(rs.getString("orname"));
                or.setOrclass(rs.getString("orclass"));
                or.setOrstate(rs.getString("orstate"));
                list.add(i,"编号：" +or.getOrid() +" "
                +"名称：" +or.getOrname() +" "
                +"层级：" +or.getOrclass() +" "
                +"状态：" +or.getOrstate() );
                i++;
            }
            rs.close();
            st.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
