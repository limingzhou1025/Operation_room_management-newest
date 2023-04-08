package manager;
import manager.*;
import pub.DBConn;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import model.Patient;
import java.sql.SQLException;
import java.util.Vector;
public class PatientManager {
    //添加患者信息
    public int addPatient(Patient p){
        Connection conn= null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "insert into Patient values('" +
                    p.pid +"','" +
                    p.pname +"','" +
                    p.page +"','" +
                    p.psex +"','" +
                    p.ppart +"','" +
                    p.pphone +"','" +
                    p.pill +"')";
            try{
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
            return  i;
    }
    //删除患者信息
    public int deletepatient(String pid) throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "delete from Patient where pid='" +
                    pid +"'";
            try {
                stmt = conn.createStatement();
                i = stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return  i;
    }
    //修改患者信息
    public int updatePatient(String pid, String pname, String page, String psex, String ppart, String pphone, String pill){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            int i = 0;
            String sql;
            sql = "update Patient set pid='" +
                    pid +"', pname='" +
                    pname +"', page='" +
                    page +"', psex='" +
                    psex +"', ppart='" +
                    ppart +"', pphone='" +
                    pphone +"', pill='" +
                    pill +"'";
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
    //根据患者编号查询患者信息
    public Patient findpatient(String pid){
        Connection conn = null;
        Statement stmt =null;
        ResultSet rs = null;
            String sql;
            sql = "select * from Patient where pid='" +
                    pid +"'";
            Patient p = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()){
                    p = new Patient();
                    p.setPid(rs.getString("pid"));
                    p.setPname(rs.getString("pname"));
                    p.setPage(rs.getString("page"));
                    p.setPpart(rs.getString("psex"));
                    p.setPphone(rs.getString("pphone"));
                    p.setPill(rs.getString("pill"));
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch (SQLException ex3){
                ex3.printStackTrace();
            }
            return p;
    }
    //根据患者姓名查询患者信息
    public Patient findpatientpname(String pname){
        Connection conn = null;
        Statement stmt =null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Patient where pname='" +
                pname +"'";
        Patient p = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                p = new Patient();
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setPage(rs.getString("page"));
                p.setPpart(rs.getString("psex"));
                p.setPphone(rs.getString("pphone"));
                p.setPill(rs.getString("pill"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return p;
    }
    //根据患者性别来查询患者信息
    public Patient findpatientpage(String page){
        Connection conn = null;
        Statement stmt =null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Patient where page='" +
                page +"'";
        Patient p = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                p = new Patient();
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setPage(rs.getString("page"));
                p.setPpart(rs.getString("psex"));
                p.setPphone(rs.getString("pphone"));
                p.setPill(rs.getString("pill"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return p;
    }
    //根据患者年龄范围来查询患者信息
    public Patient findpatientpage(String page, String page1){
        Connection conn = null;
        Statement stmt =null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Patient where page<='" +
                page1 +"' and page>='" +
                page +"'";
        Patient p = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                p = new Patient();
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setPage(rs.getString("page"));
                p.setPpart(rs.getString("psex"));
                p.setPphone(rs.getString("pphone"));
                p.setPill(rs.getString("pill"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return p;
    }
    //根据患者所属部门查询患者信息
    public Patient findpatientppart(String ppart){
        Connection conn = null;
        Statement stmt =null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Patient where ppart='" +
                ppart +"'";
        Patient p = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                p = new Patient();
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setPage(rs.getString("page"));
                p.setPpart(rs.getString("psex"));
                p.setPphone(rs.getString("pphone"));
                p.setPill(rs.getString("pill"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return p;
    }
    //根据患者手机号来查询患者信息
    public Patient findpatientpphone(String pphone){
        Connection conn = null;
        Statement stmt =null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Patient where pphone='" +
                pphone +"'";
        Patient p = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                p = new Patient();
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setPage(rs.getString("page"));
                p.setPpart(rs.getString("psex"));
                p.setPphone(rs.getString("pphone"));
                p.setPill(rs.getString("pill"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return p;
    }

}
