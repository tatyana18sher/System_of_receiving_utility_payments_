package Systemofreceiving.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Systemofreceiving.beans.Accounts;
import Systemofreceiving.beans.Service;
 
public class DBUtils {
 
    public static Accounts findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password from Accounts a " //
                + " where a.User_Name = ? and a.Password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            Accounts user = new Accounts();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 
    public static Accounts findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password from Accounts a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            Accounts user = new Accounts();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }
 
    public static List<Service> queryService(Connection conn) throws SQLException {
        String sql = "Select a.ServiceId a.ServiceName, a.Client, a.Offence_type, a.Payment from Service a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Service> list = new ArrayList<Service>();
        while (rs.next()) {
        	String service_id = rs.getString("ServiceId");
            String service_name = rs.getString("ServiceName");
            String client = rs.getString("Client");
            float payment = rs.getFloat("Payment");
            Service service = new Service();
            service.setServiceId(service_id);
            service.setServiceName(service_name);
            service.setClient(client);
            service.setPayment(payment);
            list.add(service);
        }
        return list;
    }
 
    public static Service findService(Connection conn, String service_id) throws SQLException {
        String sql = "Select a.ServiceId a.ServiceName, a.Client, a.Offence_type, a.Payment from Service a where a.ServiceId=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, service_id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	String service_name = rs.getString("ServiceName");
            String client = rs.getString("Client");
            float payment = rs.getFloat("Payment");
            Service service = new Service(service_id, service_name, client, payment);
            return service;
        }
        return null;
    }
 
    public static void updateService(Connection conn, Service service) throws SQLException {
        String sql = "Update Service set ServiceName=?, Client=?,Payment=? where ServiceId=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, service.getServiceName());
        pstm.setString(2, service.getClient());
        pstm.setFloat(4, service.getPayment());
        pstm.executeUpdate();
    }
 
    public static void insertService(Connection conn, Service service) throws SQLException {
        String sql = "Insert into Service(ServiceId, ServiceName, Client, Payment) values (?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, service.getServiceId());
        pstm.setString(2, service.getServiceName());
        pstm.setString(3, service.getClient());
        pstm.setFloat(4, service.getPayment());
 
        pstm.executeUpdate();
    }
 
    public static void deleteService(Connection conn, String service_id) throws SQLException {
        String sql = "Delete From Service where ServiceId= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, service_id);
 
        pstm.executeUpdate();
    }
 
}
