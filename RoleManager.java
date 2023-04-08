package manager;
import model.User;
import pub.DBConn;
import model.Doctor;
import model.Patient;

import javax.management.relation.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Vector;
import java.util.concurrent.Callable;

public class RoleManager {
    //创建角色
    public int addrole(User u){
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "insert into user values('" +
                    u.getUseid() +"','" +
                    u.getName() +"','" +
                    u.getUsername() +"','" +
                    u.getPassword() +"','" +
                    u.getRole() +"')";
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
    //删除角色
    public int deleterole(String useid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "delete from user where useid='" +
                    useid +"'";
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
    //修改角色
    public int updaterole(String useid, String name, String username, String password,
                          String role){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i =0;
            String sql;
            sql = "update user set useid='" +
                    useid +"', name='" +
                    name +"', username='" +
                    username +"', password='" +
                    password +"',role='" +
                    role +"'";
            try {
                stmt =conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return i;
    }
    //根据工号、病号查询角色
    public User findroleuseid(String useid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            String sql;
            sql = "select * from user where useid='" +
                    useid +"'";
            User u = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()){
                    u = new User();
                    u.setUseid(rs.getString("useid"));
                    u.setName(rs.getString("name"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setRole(rs.getString("role"));
                }
                rs.close();
                conn.close();
            }catch (SQLException ex3){
                ex3.printStackTrace();
            }
            return u;
    }
    //根据姓名查询角色
    public User findrolename(String name){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from user where name='" +
                name +"'";
        User u = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                u = new User();
                u.setUseid(rs.getString("useid"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
            }
            rs.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return u;
    }
    //根据用户名查询角色
    public User findroleusername(String username){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from user where username='" +
                username +"'";
        User u = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                u = new User();
                u.setUseid(rs.getString("useid"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
            }
            rs.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return u;
    }
    //根据用户角色查询角色
    public User findrolerole(String role){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from user where role='" +
                role +"'";
        User u = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                u = new User();
                u.setUseid(rs.getString("useid"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
            }
            rs.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return u;
    }
}
