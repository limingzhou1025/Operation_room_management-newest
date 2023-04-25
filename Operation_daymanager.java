package manager;

import model.Operation_day;
import pub.DBConn;

import java.sql.*;
import java.util.ArrayList;

public class Operation_daymanager {
    //增加修改和删除
    public int addoperationday(Operation_day od) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        int i = 0;
        String sql = "insert into Operation_day values('" +
                od.getId() +"','" +
                od.getPatientid() +"','" +
                od.getDoctorid() +"','" +
                od.getPartid() +"''" +
                od.getOperationid() +"','" +
                od.getAdmissionday() +"','" +
                od.getPlanningday() +"','" +
                od.getRealoperationday() +"','" +
                od.getLatestoperationday() +"','" +
                od.getMinoperation() +"','" +
                od.getMostoperation() +"','" +
                od.getMaxoperation() +"','" +
                od.getInfection() +"')";
        try {
            statement = connection.createStatement();
            i = statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return i;
    }

    public int deleteoperationclass(String id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        int i = 0;
        String sql;
        sql = "delete from Operation_day where id='" +
                id +"'";
        try {
            statement = connection.createStatement();
            i = statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public int updateoperationday(String id, String patientid,
                                  String doctorid, String partid,
                                  String operationid, Date admissionday,
                                  Date planningday, Date realoperationday,
                                  Date latestoperationday, Integer minoperation,
                                  Integer mostoperation, Integer maxoperation,
                                  Double infection)
    {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        int i = 0;
        String sql;
        sql = "update Operation_day set id='" +
                id +"',patientid='" +
                patientid +"', doctorid='" +
                doctorid +"', partid='" +
                partid +"', operationid='" +
                operationid +"', admissionday='" +
                admissionday +"', planningday='" +
                planningday +"', realoperationday='" +
                realoperationday +"', latestoperationday='" +
                latestoperationday +"', minoperation='" +
                minoperation +"', mostoperation='" +
                mostoperation +"', maxoperation='" +
                maxoperation +"', infection='" +
                infection +"'";
        try {
            statement = connection.createStatement();
            i = statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    //选出固定科室在某时间段入院的病人
    public ArrayList selectpatient(String partname, String beginday, String overday){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String sql;
        ArrayList arrayList = new ArrayList();
        sql = "select patientid from Operation_day where partname='" +
                partname +"'and (admissionday between'" +
                beginday +"'and'" +
                overday +"')";
        Operation_day od = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                od = new Operation_day();
                od.setPatientid(resultSet.getString("patientid"));
                arrayList.add(od.getPatientid());
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arrayList;
    }
    public ArrayList<Integer> selectpatientoperationduration(String partname, String beginday, String overday){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String sql;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        sql = "select operationduration from Operation_day where partname='" +
                partname +"'and (admissionday between'" +
                beginday +"'and'" +
                overday +"')";
        Operation_day od = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                od = new Operation_day();
                od.setOperationduration(resultSet.getInt("operationduration"));
                arrayList.add(od.getOperationduration());
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arrayList;
    }
    public ArrayList<Integer> selectpatientinfection(String partname, String beginday, String overday){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String sql;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        sql = "select infection from Operation_day where partname='" +
                partname +"'and (admissionday between'" +
                beginday +"'and'" +
                overday +"')";
        Operation_day od = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                od = new Operation_day();
                od.setInfection(Integer.valueOf(resultSet.getString("infection")));
                arrayList.add(od.getInfection());
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arrayList;
    }
    public ArrayList<java.util.Date> selectpatientadmissionday(String partname, String beginday, String overday){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String sql;
        ArrayList<java.util.Date> arrayList = new ArrayList<>();
        sql = "select admissionday from Operation_day where partname='" +
                partname +"'and (admissionday between'" +
                beginday +"'and'" +
                overday +"')";
        Operation_day od = null;
        DBConn dbConn = new DBConn();
        connection = dbConn.getConn();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                od = new Operation_day();
                od.setAdmissionday(resultSet.getDate("admissionday"));
                arrayList.add(od.getAdmissionday());
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arrayList;
    }



}
