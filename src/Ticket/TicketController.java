/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ticket;

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
                
                //Saves ticket directly to file (and not to ticket DB)
                try{
                ticketModel.saveTicket(currentTicket);
                }
                catch(Exception exception) {System.out.println("Could not save to file.\n");
                }
                
                ticketModel.setTicketNum(ticketModel.getTicketNum()+1);
                ticketView.clearFields();
        });
            
        ticketView.getBack().setOnAction(e -> {
            if(ticketModel.getTicketsDB().size()!=ticketModel.getTicketNum() || !ticketModel.checkEmpty()){
                ticketModel.readFile();
            }
            if(ticketView.getLastTicketNum()>0){
            ticketView.setLastTicketNum(ticketView.getLastTicketNum() - 1);
            ticketView.getBottomBox().getChildren().clear();
            String something = (
                      "Ticket Number: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getNumber() + "\n"
                    + "License Plate: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getLicense() + "\n"
                    + "State: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getState() + "\n"
                    + "Permit: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getPermit() + "\n"
                    + "Make/Model: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getMake() + "\n"
                    + "Color: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getColor() + "\n"
                    + "Location: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getLocation() + "\n"
                    + "Issued By: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getIssuer() + "\n"      
                    + "Paid: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getPaid()+ "\n"                    

               );
                ticketView.getBottomLabel().setText(something);
                ticketView.getBottomBox().getChildren().add(ticketView.getBottomLabel()); 
            }
            
        });
        
        ticketView.getForward().setOnAction(e -> {
            if(ticketModel.getTicketsDB().size()!=ticketModel.getTicketNum() || !ticketModel.checkEmpty()){
                ticketModel.readFile();
            }
            if(ticketView.getLastTicketNum()<ticketModel.getTicketsDB().size()-1 && ticketModel.getTicketsDB().size()>0){
                ticketView.getBottomBox().getChildren().clear();
                ticketView.setLastTicketNum(ticketView.getLastTicketNum() + 1);

                String something = (
                          "Ticket Number: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getNumber() + "\n"
                        + "License Plate: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getLicense() + "\n"
                        + "State: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getState() + "\n"
                        + "Permit: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getPermit() + "\n"
                        + "Make/Model: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getMake() + "\n"
                        + "Color: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getColor() + "\n"
                        + "Location: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getLocation() + "\n"
                        + "Issued By: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getIssuer() + "\n"
                        + "Paid: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getPaid()+ "\n"                    

                   );
            
                ticketView.getBottomLabel().setText(something);
                ticketView.getBottomBox().getChildren().add(ticketView.getBottomLabel()); 
            }
        });
        
        ticketView.getModify().setOnAction(e -> {
            if(ticketView.getLastTicketNum()<ticketModel.getTicketsDB().size() && ticketModel.getTicketsDB().size()>0){
                ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).setPaid(true);
                String something = (
                      "Ticket Number: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getNumber() + "\n"
                    + "License Plate: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getLicense() + "\n"
                    + "State: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getState() + "\n"
                    + "Permit: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getPermit() + "\n"
                    + "Make/Model: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getMake() + "\n"
                    + "Color: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getColor() + "\n"
                    + "Location: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getLocation() + "\n"
                    + "Issued By: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getIssuer() + "\n"
                    + "Paid: "+ ticketModel.getTicketsDB().get(ticketView.getLastTicketNum()).getPaid()+ "\n"                    

                );
            
                ticketView.getBottomLabel().setText(something);
                ticketView.getBottomBox().getChildren().clear();
                ticketView.getBottomBox().getChildren().add(ticketView.getBottomLabel()); 

            }
        });


    }
    
    
}
