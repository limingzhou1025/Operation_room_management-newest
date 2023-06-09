package manager;

import model.Operation;
import pub.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OperationManager {
    //添加手术信息
    public int addoperation(Operation o){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "insert into Operation values ('" +
                    o.getOpid() +"','" +
                    o.getOpname() +"','" +
                    o.getOrid() +"','" +
                    o.getDname() +"','" +
                    o.getDid() +"','" +
                    o.getPname() +"','" +
                    o.getPid() +"','" +
                    o.getOstate() +"','" +
                    o.getBegin_time() +"','" +
                    o.getEsti_over_time() +"','" +
                    o.getRea_over_time() +"','" +
                    Integer.parseInt(o.getDuration()) +"')";
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
    //不能删除手术信息，只能添加修改和查询
    //修改手术信息
    public int updateoperation(String opid, String opname, String orid, String dname, String did, String pname,
                               String pid, String ostate, String begin_time, String esti_over_time, String rea_over_time, String duration){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            int i = 0;
            String sql;
            sql = "update Operation set opid='" +
                    opid +"', opname='" +
                    opname +"', orid='" +
                    orid +"', did='" +
                    did +"', pid='" +
                    pid +"', ostate='" +
                    ostate +"', begin_time='" +
                    begin_time +"', esti_over_time='" +
                    esti_over_time +"', rea_over_time='" +
                    rea_over_time +"', duration='" +
                    Integer.parseInt(duration) +"' where opid='" +
                    opid +"'";
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
   //根据手术id查询手术信息
    public Operation findoperation(String opid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
            String sql;
            sql = "select * from Operation where opid='" +
                    opid +"'";
            Operation o = null;
            DBConn db = new DBConn();
            conn = db.getConn();
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()){
                    o = new Operation();
                    o.setOpid(rs.getString("opid"));
                    o.setOpname(rs.getString("opname"));
                    o.setOrid(rs.getString("orid"));
                    o.setDname(rs.getString("dname"));
                    o.setDid(rs.getString("did"));
                    o.setPname(rs.getString("pname"));
                    o.setPid(rs.getString("pid"));
                    o.setOstate(rs.getString("ostate"));
                    o.setBegin_time(rs.getString("begin_time"));
                    o.setEsti_over_time(rs.getString("esti_over_time"));
                    o.setRea_over_time(rs.getString("rea_over_time"));
                    o.setDuration(rs.getString("duration"));
                }
            }catch (SQLException ex3){
                ex3.printStackTrace();
            }
            return o;
    }
    //根据手术名称查询手术信息
    public Operation findoperationopname(String opname){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Operation where opname='" +
                opname +"'";
        Operation o = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                o = new Operation();
                o.setOpid(rs.getString("opid"));
                o.setOpname(rs.getString("opname"));
                o.setOrid(rs.getString("orid"));
                o.setDname(rs.getString("dname"));
                o.setDid(rs.getString("did"));
                o.setPname(rs.getString("pname"));
                o.setPid(rs.getString("pid"));
                o.setOstate(rs.getString("ostate"));
                o.setBegin_time(rs.getString("begin_time"));
                o.setEsti_over_time(rs.getString("esti_over_time"));
                o.setRea_over_time(rs.getString("rea_over_time"));
                o.setDuration(rs.getString("duration"));
            }
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return o;
    }
    //根据手术室编号查询手术信息
    public Operation findoperationorid(String orid){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Operation where orid='" +
                orid +"'";
        Operation o = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                o = new Operation();
                o.setOpid(rs.getString("opid"));
                o.setOpname(rs.getString("opname"));
                o.setOrid(rs.getString("orid"));
                o.setDname(rs.getString("dname"));
                o.setDid(rs.getString("did"));
                o.setPname(rs.getString("pname"));
                o.setPid(rs.getString("pid"));
                o.setOstate(rs.getString("ostate"));
                o.setBegin_time(rs.getString("begin_time"));
                o.setEsti_over_time(rs.getString("esti_over_time"));
                o.setRea_over_time(rs.getString("rea_over_time"));
                o.setDuration(rs.getString("duration"));
            }
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return o;
    }
    //根据手术医生姓名查询手术信息
    public Operation findoperationdname(String dname){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Operation where dname='" +
                dname +"'";
        Operation o = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                o = new Operation();
                o.setOpid(rs.getString("opid"));
                o.setOpname(rs.getString("opname"));
                o.setOrid(rs.getString("orid"));
                o.setDname(rs.getString("dname"));
                o.setDid(rs.getString("did"));
                o.setPname(rs.getString("pname"));
                o.setPid(rs.getString("pid"));
                o.setOstate(rs.getString("ostate"));
                o.setBegin_time(rs.getString("begin_time"));
                o.setEsti_over_time(rs.getString("esti_over_time"));
                o.setRea_over_time(rs.getString("rea_over_time"));
                o.setDuration(rs.getString("duration"));
            }
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return o;
    }
    //根据患者姓名查询手术信息
    public Operation findoperationpname(String pname){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Operation where pname='" +
                pname +"'";
        Operation o = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                o = new Operation();
                o.setOpid(rs.getString("opid"));
                o.setOpname(rs.getString("opname"));
                o.setOrid(rs.getString("orid"));
                o.setDname(rs.getString("dname"));
                o.setDid(rs.getString("did"));
                o.setPname(rs.getString("pname"));
                o.setPid(rs.getString("pid"));
                o.setOstate(rs.getString("ostate"));
                o.setBegin_time(rs.getString("begin_time"));
                o.setEsti_over_time(rs.getString("esti_over_time"));
                o.setRea_over_time(rs.getString("rea_over_time"));
                o.setDuration(rs.getString("duration"));
            }
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return o;
    }
    //根据状态来查询手术信息
    public Operation findoperationostate(String ostate){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql;
        sql = "select * from Operation where ostate='" +
                ostate +"'";
        Operation o = null;
        DBConn db = new DBConn();
        conn = db.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                o = new Operation();
                o.setOpid(rs.getString("opid"));
                o.setOpname(rs.getString("opname"));
                o.setOrid(rs.getString("orid"));
                o.setDname(rs.getString("dname"));
                o.setDid(rs.getString("did"));
                o.setPname(rs.getString("pname"));
                o.setPid(rs.getString("pid"));
                o.setOstate(rs.getString("ostate"));
                o.setBegin_time(rs.getString("begin_time"));
                o.setEsti_over_time(rs.getString("esti_over_time"));
                o.setRea_over_time(rs.getString("rea_over_time"));
                o.setDuration(rs.getString("duration"));
            }
        }catch (SQLException ex3){
            ex3.printStackTrace();
        }
        return o;
    }

    public Vector find(String jt1, String jt2, String jc) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Vector list = new Vector();
        String sql;
        /*sql = "select * from Operation where (opid='" +
                jt1 +"' or opname='" +
                jt1 +"' or orid='" +
                jt1 +"') and (dname='" +
                jt2 +"' or did='" +
                jt2 +"' or pname='" +
                jt2 +"' or pid='" +
                jt2 +"') and ostate='" +
                jc +"'";*/
        if (jt1.equals("")){
            if (jt2.equals("")){
                if (jc.equals("不限")){
                    sql = "select * from Operation";
                }else{
                    sql = "select * from Operation where ostate='" +
                            jc +"'";
                }
            }else{
                if (jc.equals("不限")){
                    sql = "select * from Operation where (dname='" +
                            jt2 +"' or did='" +
                            jt2 +"' or pname='" +
                            jt2 +"' or pid='" +
                            jt2 +"') ";
                }else{
                    sql = "select * from Operation where (dname='" +
                            jt2 +"' or did='" +
                            jt2 +"' or pname='" +
                            jt2 +"' or pid='" +
                            jt2 +"') and ostate='" +
                            jc +"'";
                }
            }
        }else{
            if (jt2.equals("")){
                if (jc.equals("不限")){
                    sql = "select * from Operation where (opid='" +
                            jt1 +"' or opname='" +
                            jt1 +"' or orid='" +
                            jt1 +"') ";
                }else{
                    sql = "select * from Operation where (opid='" +
                            jt1 +"' or opname='" +
                            jt1 +"' or orid='" +
                            jt1 +"') and ostate='" +
                            jc +"'";
                }
            }else{
                if (jc.equals("不限")){
                    sql = "select * from Operation where (opid='" +
                            jt1 +"' or opname='" +
                            jt1 +"' or orid='" +
                            jt1 +"') and (dname='" +
                            jt2 +"' or did='" +
                            jt2 +"' or pname='" +
                            jt2 +"' or pid='" +
                            jt2 +"')";
                }else{
                    sql = "select * from Operation where (opid='" +
                            jt1 +"' or opname='" +
                            jt1 +"' or orid='" +
                            jt1 +"') and (dname='" +
                            jt2 +"' or did='" +
                            jt2 +"' or pname='" +
                            jt2 +"' or pid='" +
                            jt2 +"') and ostate='" +
                            jc +"'";
                }
            }
        }
        Operation o = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int i = 0;
            while (resultSet.next()){
                o = new Operation();
                o.setOpid(resultSet.getString("opid"));
                o.setOpname(resultSet.getString("opname"));
                o.setOrid(resultSet.getString("orid"));
                o.setDname(resultSet.getString("dname"));
                o.setDid(resultSet.getString("did"));
                o.setPname(resultSet.getString("pname"));
                o.setPid(resultSet.getString("pid"));
                o.setOstate(resultSet.getString("ostate"));
                list.add(i,"编号：" +o.getOpid() +" "
                +"名称：" +o.getOpname() +" "
                +"手术室号：" +o.getOrid() +" "
                +"医生姓名：" +o.getDname() +" "
                +"工号：" +o.getDid() +" "
                +"患者姓名：" +o.getPname() +" "
                +"病号：" +o.getPid() +" "
                +"手术状态：" +o.getOstate());
                i ++;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return list;
    }



}
