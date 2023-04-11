package manager;

import model.Part;
import pub.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class PartManager {
    //添加科室信息
    public int addpart(Part p) {
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        int i = 0;
        String sql;
        int i1 = Integer.valueOf(p.getDoctor_num());
        int i2 = Integer.valueOf(p.getFree_doctor_num());
        int i3 = Integer.valueOf(p.getPatient_num());
        int i4 = Integer.valueOf(p.getFree_patient_num());
        sql = "insert into part values('" +
                p.getPartid() + "','" +
                p.getPartname() + "','" +
                p.getCharge_name() + "','" +
                p.getCharge_id() + "','" +
                i1 +"','" +
                i2 +"','" +
                i3 +"','" +
                i4 +"')";
        try {
            stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return i;
    }

    //删除科室信息
    public int deletepart(String partname) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        int i = 0;
        String sql;
        sql = "delete from part where partname='" +
                partname + "'";
        try {
            stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //修改科室信息
    public int updatepart(String partid, String partname, String charge_name,
                          String charge_id, String doctor_num, String free_doctor_num,
                          String patient_num, String free_patient_num) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        int i = 0;
        int i1 = Integer.parseInt(doctor_num);
        int i2 = Integer.parseInt(free_doctor_num);
        int i3 = Integer.parseInt(patient_num);
        int i4 = Integer.parseInt(free_patient_num);
        String sql;
        sql = "update part set partid='" +
                partid +"', partname='" +
                partname +"', charge_name='" +
                charge_name +"', charge_id='" +
                charge_id +"', doctor_num='" +
                i1 +"', free_docotor_num='" +
                i2 +"', patient_num='" +
                i3 +"', free_patient_num='" +
                i4 +"' where partid='" +
                partid +"'";
        try {
            stmt = conn.createStatement();
            i = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //根据科室id查询科室信息
    public Part findpart(String partid) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from part where partid='" +
                partid +"'";
        Part p = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                p = new Part();
                p.setPartid(rs.getString("partid"));
                p.setPartname(rs.getString("partname"));
                p.setCharge_name(rs.getString("charge_name"));
                p.setCharge_id(rs.getString("charge_id"));
                p.setDoctor_num(rs.getString("doctor_num"));
                p.setFree_doctor_num(rs.getString("free_docotor_num"));
                p.setPatient_num(rs.getString("patient_num"));
                p.setFree_patient_num(rs.getString("free_patient_num"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return p;
    }
    //根据科室名称查询科室信息
    public Part findpartpartname(String partname) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from part where partname='" +
                partname +"'";
        Part p = null;
        DBConn db = new DBConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                p = new Part();
                p.setPartid(rs.getString("partid"));
                p.setPartname(rs.getString("partname"));
                p.setCharge_name(rs.getString("charge_name"));
                p.setCharge_id(rs.getString("charge_id"));
                p.setDoctor_num(rs.getString("doctor_num"));
                p.setFree_doctor_num(rs.getString("free_doctor_num"));
                p.setPatient_num(rs.getString("patient_num"));
                p.setFree_patient_num(rs.getString("free_patient_num"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return p;
    }
    //根据科室负责人姓名查询科室信息
    public Part findpartcharge_name(String charge_name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from part where charge_name='" +
                charge_name +"'";
        Part p = null;
        DBConn db = new DBConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                p = new Part();
                p.setPartid(rs.getString("partid"));
                p.setPartname(rs.getString("partname"));
                p.setCharge_name(rs.getString("charge_name"));
                p.setCharge_id(rs.getString("charge_id"));
                p.setDoctor_num(rs.getString("doctor_num"));
                p.setFree_doctor_num(rs.getString("free_doctor_num"));
                p.setPatient_num(rs.getString("patient_num"));
                p.setFree_patient_num(rs.getString("free_patient_num"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return p;
    }
    //根据科室负责人工号查询科室信息
    public Part findpartcharge_id(String charge_id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from part where charge_id='" +
                charge_id +"'";
        Part p = null;
        DBConn db = new DBConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                p = new Part();
                p.setPartid(rs.getString("partid"));
                p.setPartname(rs.getString("partname"));
                p.setCharge_name(rs.getString("charge_name"));
                p.setCharge_id(rs.getString("charge_id"));
                p.setDoctor_num(rs.getString("doctor_num"));
                p.setFree_doctor_num(rs.getString("free_doctor_num"));
                p.setPatient_num(rs.getString("patient_num"));
                p.setFree_patient_num(rs.getString("free_patient_num"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return p;
    }
}