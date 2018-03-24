/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.util.ArrayList;
import java.io.*;

/**
 * Provides a model to store tickets
 * 
 * @author Mauricio Azcona
 * @version Build 1.4 March 2, 2018
 */

// class used to store the tickets
public class TicketModel {

    
    String filename = "tickets.dat";
    
    private int ticketNum = 0;
   
    public void saveTicket(Ticket currentTicket) throws IOException{
        File file = new File(filename);
        file.createNewFile();
        FileWriter writer = new FileWriter(file, true);
        
        writer.write(currentTicket.getNumber()+System.lineSeparator());
        writer.write(currentTicket.getLicense()+System.lineSeparator());
        writer.write(currentTicket.getState()+System.lineSeparator());
        writer.write(currentTicket.getPermit()+System.lineSeparator());
        writer.write(currentTicket.getMake()+System.lineSeparator());        
        writer.write(currentTicket.getColor()+System.lineSeparator());
        writer.write(currentTicket.getViolation()+System.lineSeparator());
        writer.write(currentTicket.getDate()+System.lineSeparator());
        writer.write(currentTicket.getLocation()+System.lineSeparator());
        writer.write(currentTicket.getTime()+System.lineSeparator());
        writer.write(currentTicket.getIssuer()+System.lineSeparator());
        writer.write(currentTicket.getPaid()+System.lineSeparator());
        writer.flush();
        writer.close();
    }
    
    public boolean checkEmpty(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));     
            if (br.readLine() == null) {
                return true;
            }
        }catch(Exception e){ System.out.println(e);}
        return false;
    }
    
    public void readFile(){
        String line = null;
        int linesAlreadyRead = 0;
        linesAlreadyRead = (ticketNum-ticketsDB.size())*10;
        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);  
             while(linesAlreadyRead>0){
                 br.readLine();
                 linesAlreadyRead--;
            }
            while((line = br.readLine()) != null){
                Ticket t = new Ticket();
                t.setNumber(Integer.parseInt(line));
                t.setLicense(br.readLine());
                t.setState(br.readLine());
                t.setPermit(br.readLine());
                t.setMake(br.readLine());
                t.setColor(br.readLine());
                br.readLine();
                br.readLine();
                t.setLocation(br.readLine());
                br.readLine();
                t.setIssuer(br.readLine());
                br.readLine();
                
                ticketsDB.add(t);
            }
        } 
       catch(Exception exception) {
           System.out.println(exception);
          }
    }
    
    /**
     * @return the ticketsDB
     */
    public ArrayList<Ticket> getTicketsDB() {
        return ticketsDB;
    }

    /**
     * @param ticketsDB the ticketsDB to set
     */
    public void setTicketsDB(ArrayList<Ticket> ticketsDB) {
        this.ticketsDB = ticketsDB;
    }
    
    /**
     * 
     * @param currentTicket 
     */
    public void addTicket(Ticket currentTicket){
        getTicketsDB().add(currentTicket);
    }
    
    /**
     * @return the ticketNum
     */
    public int getTicketNum() {
        return ticketNum;
    }

    /**
     * @param ticketNum the ticketNum to set
     */
    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }
        
    private ArrayList<Ticket> ticketsDB = new ArrayList<Ticket>();
    
}
