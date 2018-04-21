/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ticket;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connects the model and the view by handling events from the view
 * and sending them to the model.
 * 
 * @author Mauricio Azcona
 * @version Build 1.4 March 2, 2018
 */

// bridges the GUI and the storaging class
public class TicketController {
    TicketModel ticketModel;
    TicketView ticketView;
    
    int ticketNum = 0;

    /**
     * 
     * @param model the model
     * @param view  the view
     */
    public TicketController(TicketModel model, TicketView view) {
        this.ticketModel = model;
        this.ticketView = view;
        attachHandlers();
    }
    
    /**
     * Attaches handlers
     */
    
    public void attachHandlers(){
            ticketView.getSubmit().setOnAction(e -> {
                Ticket currentTicket = new Ticket();
                try{
                currentTicket.setNumber(Integer.parseInt(ticketView.getTicketNumber().getText()));
                } catch(Exception error) { System.out.println(error);}
                
                currentTicket.setLicense(ticketView.getLicensePlate().getText());         
                currentTicket.setState(ticketView.getState().getText());
                currentTicket.setPermit(ticketView.getPermitNumber().getText());
                currentTicket.setMake(ticketView.getVehicleMake().getText());
                currentTicket.setColor(ticketView.getColor().getText());
                currentTicket.setLocation(ticketView.getLocation().getText());
                currentTicket.setIssuer(ticketView.getIssuer().getText());
                currentTicket.setDate(ticketView.getDate().getText());
                currentTicket.setTime(ticketView.getTime().getText());
                
                //Saves ticket directly to file (and not to ticket DB)
                try{
                   System.out.println("TRYING TO UPDATE");
                ticketModel.update(currentTicket);
                }
                catch(Exception exception) {System.out.println("Could not save to file.\n");
                }
                ticketView.clearFields();
        });
            
        ticketView.getBack().setOnAction(e -> {
            if(ticketModel.numOfTickets()>0 && ticketNum>0){
                ticketNum--;
                try {
                    ticketView.getBottomBox().getChildren().clear();
                    String something = (
                            "Ticket Number: "+ ticketModel.getTicket(ticketNum).getNumber()+"\n"
                            + "License Plate: "+ ticketModel.getTicket(ticketNum).getLicense() + "\n"
                            + "State: " + ticketModel.getTicket(ticketNum).getState() + "\n"
                            + "Permit: " + ticketModel.getTicket(ticketNum).getPermit() + "\n"
                            + "Make/Model: " + ticketModel.getTicket(ticketNum).getMake() + "\n"
                            + "Color: " + ticketModel.getTicket(ticketNum).getColor() + "\n"
                            + "Location: " + ticketModel.getTicket(ticketNum).getLocation() + "\n"
                            + "Issued By: " + ticketModel.getTicket(ticketNum).getIssuer() + "\n"
                            + "Paid: " + ticketModel.getTicket(ticketNum).getPaid()+ "\n"                            
                            );
                    ticketView.getBottomLabel().setText(something); 
                    ticketView.getBottomBox().getChildren().add(ticketView.getBottomLabel());                    
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            
        });
        
        ticketView.getForward().setOnAction(e -> {
            if(ticketModel.numOfTickets()>0 && ticketNum<ticketModel.numOfTickets()){
                ticketNum++;
                try {
                    ticketView.getBottomBox().getChildren().clear();
                    String something = (
                            "Ticket Number: "+ ticketModel.getTicket(ticketNum).getNumber()+"\n"
                            + "License Plate: "+ ticketModel.getTicket(ticketNum).getLicense() + "\n"
                            + "State: " + ticketModel.getTicket(ticketNum).getState() + "\n"
                            + "Permit: " + ticketModel.getTicket(ticketNum).getPermit() + "\n"
                            + "Make/Model: " + ticketModel.getTicket(ticketNum).getMake() + "\n"
                            + "Color: " + ticketModel.getTicket(ticketNum).getColor() + "\n"
                            + "Location: " + ticketModel.getTicket(ticketNum).getLocation() + "\n"
                            + "Issued By: " + ticketModel.getTicket(ticketNum).getIssuer() + "\n"
                            + "Paid: " + ticketModel.getTicket(ticketNum).getPaid()+ "\n"                            
                            );
                    ticketView.getBottomLabel().setText(something); 
                    ticketView.getBottomBox().getChildren().add(ticketView.getBottomLabel());                    
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        
        ticketView.getModify().setOnAction(e -> {
            ticketModel.modify(ticketNum);
        });


    }
    
    
}
