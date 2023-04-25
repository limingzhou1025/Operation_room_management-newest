package manager;

import model.Part;
import pub.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

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

    //查询所有科室名称
    public ArrayList findallpart() throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql;
        ArrayList<String> arrayList = new ArrayList<>();
        sql = "select partname from part";
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        Part part = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                part = new Part();
                part.setPartname(resultSet.getString("partname"));
                arrayList.add(part.getPartname());
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arrayList;


    }

    public Vector find(String jt1, String jt2) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Vector<Object> list = new Vector<>();
        String sql;
        if (jt1.equals("")){
            if (jt2.equals("")){
                sql = "select * from part";
            }else{
                sql = "select * from part where (charge_name='" +
                        jt2 +"' or charge_id = '" +
                        jt2 +"')";
            }
        }else{
            if (jt2.equals("")){
                sql = "select * from part where (partid='" +
                        jt1 +"' or partname='" +
                        jt1 +"')";
            }else{
                sql = "select * from part where (partid='" +
                        jt1 +"' or partname='" +
                        jt1 +"') and (charge_name='" +
                        jt2 +"' or charge_id='" +
                        jt2 +"')";
            }
        }
        Part part = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            int i = 0;
            while (rs.next()){
                part = new Part();
                part.setPartid(rs.getString("partid"));
                part.setPartname(rs.getString("partname"));
                part.setCharge_name(rs.getString("charge_name"));
                part.setCharge_id(rs.getString("charge_id"));
                part.setDoctor_num(rs.getString("doctor_num"));
                part.setFree_doctor_num(rs.getString("free_docotor_num"));
                part.setPatient_num(rs.getString("patient_num"));
                part.setFree_patient_num(rs.getString("free_patient_num"));
                list.add(i,"科室编号：" +part.getPartid() +" "
                +"科室名称："+part.getPartname() +" "
                +"主任姓名："+part.getCharge_name() +" "
                +"主任工号："+part.getCharge_id() +" "
                +"医生数量："+part.getDoctor_num() +" "
                +"空闲医生数量："+part.getFree_doctor_num() +" "
                +"病人数量："+part.getFree_doctor_num() +" "
                +"病人数量："+part.getPatient_num() +" "
                +"未做手术病人数量："+part.getFree_patient_num());
                i++;

            }
            rs.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}