package manager;

import model.Doctor;
import pub.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    //删除医生信息，因为删除信息是一个较为敏感的行为，因此只能从系统管理那里删除医生信息，其他信息同样也是
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
            sql ="update Doctor set did='" +
                    did +"', dname='" +
                    dname +"', dtitle='" +
                    dtitle +"', dpart='" +
                    dpart +"', dspe='" +
                    dspe +"', dphone='" +
                    dphone +"', dsex='" +
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
                    d.setSex(rs.getString("dsex"));
                }
                rs.close();;
                stmt.close();
                conn.close();
            }catch (SQLException ex3){
                ex3.printStackTrace();
            }
            return d;
    }
    public Vector<Object> find(String jt1, String jt2, String jt3) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Vector<Object> list = new Vector<>();
        String sql;
        if (jt1.equals("")){
            if (jt2.equals("")){
                if (jt3.equals("不限")){
                    sql = "select * from Doctor";
                }else{
                    sql ="select * from Doctor where (dsex='" +
                            jt3 +"')";
                }
            }else{
                if (jt3.equals("不限")){
                    sql = "select * from Doctor where  (dname='" +
                            jt2 +"' or dpart='" +
                            jt2 +"' or dtitle='" +
                            jt2 +"') ";
                }else{
                    sql = "select * from Doctor where  (dname='" +
                            jt2 +"' or dpart='" +
                            jt2 +"' or dtitle='" +
                            jt2 +"') and (dsex='" +
                            jt3 +"')";
                }
            }
        }else{
            if (jt2.equals("")){
                if (jt3.equals("不限")){
                    sql ="select * from Doctor where (did='" +
                            jt1 +"' or dphone='" +
                            jt1 +"')";
                }else{
                    sql = "select * from Doctor where (did='" +
                            jt1 +"' or dphone='" +
                            jt1 +"') and (dsex='" +
                            jt3 +"')";
                }
            }else{
                if (jt3.equals("不限")){
                    sql = "select * from Doctor where (did='" +
                            jt1 +"' or dphone='" +
                            jt1 +"') and (dname='" +
                            jt2 +"' or dpart='" +
                            jt2 +"' or dtitle='" +
                            jt2 +"')";
                }else{
                    sql = sql = "select * from Doctor where (did='" +
                            jt1 +"' or dphone='" +
                            jt1 +"') and (dname='" +
                            jt2 +"' or dpart='" +
                            jt2 +"' or dtitle='" +
                            jt2 +"') and (dsex='" +
                            jt3 +"')";
                }

            }
        }
        Doctor d = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()){
                d = new Doctor();
                d.setDid(rs.getString("did"));
                d.setDname(rs.getString("dname"));
                d.setDtitle(rs.getString("dtitle"));
                d.setDpart(rs.getString("dpart"));
                d.setDspe(rs.getString("dspe"));
                d.setDphone(rs.getString("dphone"));
                d.setSex(rs.getString("dsex"));
                list.add(i,"工号：" +d.getDid() +" "
                + "姓名：" +d.getDname() +" "
                + "职称：" +d.getDtitle() +" "
                + "科室：" +d.getDpart() +" "
                + "电话：" +d.getDphone() +" "
                + "性别：" +d.getSex());
                i++;
            }
            rs.close();
            statement.close();
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return list;


    }
    public ArrayList<String> selectdoctor(String partname){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String sql;
        ArrayList<String> vector = new ArrayList<String>();
        sql = "select dname from Doctor where dpart='" +
                partname +"'";
        Doctor d = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                d = new Doctor();
                d.setDid(resultSet.getString("did"));
                vector.add(d.getDid());
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vector;
    }



}


