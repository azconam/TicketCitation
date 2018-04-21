/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.util.ArrayList;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides a model to store tickets
 * 
 * @author Mauricio Azcona
 * @version Build 1.4 March 2, 2018
 */

// class used to store the tickets
public class TicketModel {
    
    String query;
    Connection conn;

    public void TicketModel() throws Exception{
        getConnection();
    }
    
    public Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/ticketsdb";
            String username = "root";
            String password = "K-G2Y6NWqXF.UM";
            Class.forName(driver);
                        
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch(Exception e){System.out.println(e);}
        return null;
    }
    
    public void update(Ticket currentTicket) throws Exception{
        try{

            Statement stmt = conn.createStatement();
            query = "insert into tickets (ticketNum ,plate, state, permitNum, make,"
                    + " color, violation, date, time, location, issuedby, paid)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, currentTicket.getNumber());
            ps.setString(2, currentTicket.getLicense());
            ps.setString(3, currentTicket.getState());
            ps.setString(4, currentTicket.getPermit());
            ps.setString(5, currentTicket.getMake());
            ps.setString(6, currentTicket.getColor());
            ps.setInt(7, currentTicket.getViolation());
            ps.setString(8, currentTicket.getDate());
            ps.setString(9, currentTicket.getLocation());
            ps.setString(10, currentTicket.getTime());
            ps.setString(11, currentTicket.getIssuer());
            ps.setBoolean(12, currentTicket.getPaid());
            ps.execute();

        } catch(Exception e){System.out.println(e);}
        
    }   
   
    public Ticket getTicket(int ticketPos) throws Exception{ // changed from public static to public
        try{
            
            Ticket retrieved = new Ticket();            
            query = "SELECT * from tickets";
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            rs.absolute(ticketPos);
            retrieved.setNumber(rs.getInt("ticketNum"));
            retrieved.setLicense(rs.getString("plate"));
            retrieved.setState(rs.getString("state"));
            retrieved.setPermit(rs.getString("permitNum"));
            retrieved.setMake(rs.getString("make"));
            retrieved.setColor(rs.getString("color"));
            retrieved.setDate(rs.getString("date"));
            retrieved.setViolation(rs.getInt("violation"));
            retrieved.setTime(rs.getString("time"));
            retrieved.setLocation(rs.getString("location"));
            retrieved.setIssuer(rs.getString("issuedby"));
            retrieved.setPaid(rs.getBoolean("paid"));
            
            
            return retrieved;
        } catch(Exception e){System.out.println(e);}
        return null;
    }
    
    public int numOfTickets(){
        query = "SELECT COUNT(*) from tickets";
        try {
            Statement stmt = conn.createStatement();
            PreparedStatement st = conn.prepareStatement(query);    
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            return rs.getInt("count(*)");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    return -1;
    }
    
    public void modify(int number){
        query = "update tickets set paid = ? where ticketNUM = ?";
  
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setBoolean(1, true);
            preparedStmt.setInt(2, number);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    
    
}
