package manager;

import model.Operation_day;
import pub.DBConn;

import java.sql.*;

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

}
