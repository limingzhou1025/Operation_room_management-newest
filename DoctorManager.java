package manager;
import java.sql.ResultSet;
import pub.DBConn;
import java.sql.*;
import java.sql.Connection.*;
import model.*;
import java.util.Vector;
public class DoctorManager {
    //添加医生信息
    public int addDoctor(Doctor d){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql = "insert into Doctor values('"+ d.getDid() +"', '" +
                    d.getDname() +"','" +
                    d.getDtitle() +"','" +
                    d.getDpart() +"','" +
                    d.getDspe() +"','" +
                    d.getDphone() +"','" +
                    d.getSex() +"')";
            try{
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();

            }catch (Exception e1){
                e1.printStackTrace();
            }
            return i;
    }
    //删除医生信息
    public int deleterDoctor(String did) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "delete from Doctor where did='" + did +  "'";
            try{
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return i;
    }
    //修改医生信息
    public int updateDoctor(
            String did,
            String dname,
            String dtitle,
            String dpart,
            String dspe,
            String dphone,
            String dsex) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql ="update Doctor set did='"+ did +"','" +
                    dname +"','" +
                    dtitle +"','" +
                    dpart +"','" +
                    dspe +"','" +
                    dphone +"','" +
                    dsex +"' where did='" +
                    did +"'";
            try{
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return i;

    }
    //根据工号查询医生信息
    public Doctor findDoctor(String did) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Doctor where did='" +
                did +"'";
            Doctor d = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            try{
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()){
                    d = new Doctor();
                    d.setDid(rs.getString("did"));
                    d.setDname(rs.getString("dname"));
                    d.setDtitle(rs.getString("dtitle"));
                    d.setDpart(rs.getString("dpart"));
                    d.setDspe(rs.getString("dspe"));
                    d.setDphone(rs.getString("dphone"));
                    d.setSex(rs.getString("desx"));
                }
                rs.close();;
                stmt.close();
                conn.close();
            }catch (SQLException ex3){
                ex3.printStackTrace();
            }
            return d;
    }

    //根据姓名查询医生信息
    public Doctor findDoctorname(String dname) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Doctor where dname='" +
                dname + "'";
        Doctor d = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d = new Doctor();
                d.setDid(rs.getString("did"));
                d.setDname(rs.getString("dname"));
                d.setDtitle(rs.getString("dtitle"));
                d.setDpart(rs.getString("dpart"));
                d.setDspe(rs.getString("dspe"));
                d.setDphone(rs.getString("dphone"));
                d.setSex(rs.getString("desx"));
            }
            rs.close();
            ;
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return d;
    }
    //根据职称查询医生信息
    public Doctor findDoctortitle(String dtitle) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Doctor where dtitle='" +
                dtitle + "'";
        Doctor d = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d = new Doctor();
                d.setDid(rs.getString("did"));
                d.setDname(rs.getString("dname"));
                d.setDtitle(rs.getString("dtitle"));
                d.setDpart(rs.getString("dpart"));
                d.setDspe(rs.getString("dspe"));
                d.setDphone(rs.getString("dphone"));
                d.setSex(rs.getString("desx"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return d;
    }
    //根据科室查询医生信息
    public Doctor findDoctorpart(String dpart) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Doctor where dpart='" +
                dpart + "'";
        Doctor d = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d = new Doctor();
                d.setDid(rs.getString("did"));
                d.setDname(rs.getString("dname"));
                d.setDtitle(rs.getString("dtitle"));
                d.setDpart(rs.getString("dpart"));
                d.setDspe(rs.getString("dspe"));
                d.setDphone(rs.getString("dphone"));
                d.setSex(rs.getString("desx"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return d;
    }
    //根据专长查询医生信息
    public Doctor findDoctorspe(String dspe) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Doctor where dspe='" +
                dspe + "'";
        Doctor d = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d = new Doctor();
                d.setDid(rs.getString("did"));
                d.setDname(rs.getString("dname"));
                d.setDtitle(rs.getString("dtitle"));
                d.setDpart(rs.getString("dpart"));
                d.setDspe(rs.getString("dspe"));
                d.setDphone(rs.getString("dphone"));
                d.setSex(rs.getString("desx"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return d;
    }
    //根据电话查询医生信息
    public Doctor findDoctorphone(String dphone) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Doctor where dphone='" +
                dphone + "'";
        Doctor d = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d = new Doctor();
                d.setDid(rs.getString("did"));
                d.setDname(rs.getString("dname"));
                d.setDtitle(rs.getString("dtitle"));
                d.setDpart(rs.getString("dpart"));
                d.setDspe(rs.getString("dspe"));
                d.setDphone(rs.getString("dphone"));
                d.setSex(rs.getString("desx"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return d;
    }
    //根据性别查询医生信息
    public Doctor findDoctorsex(String dsex) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Doctor where dsex='" +
                dsex + "'";
        Doctor d = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d = new Doctor();
                d.setDid(rs.getString("did"));
                d.setDname(rs.getString("dname"));
                d.setDtitle(rs.getString("dtitle"));
                d.setDpart(rs.getString("dpart"));
                d.setDspe(rs.getString("dspe"));
                d.setDphone(rs.getString("dphone"));
                d.setSex(rs.getString("desx"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return d;
    }
}


