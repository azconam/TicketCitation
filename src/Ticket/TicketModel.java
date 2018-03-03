/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */

// class used to store the tickets
public class TicketModel {
    
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
    
    private ArrayList<Ticket> ticketsDB = new ArrayList<Ticket>();
    
}
