/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Ticket.TicketController;
import Ticket.TicketModel;
import Ticket.TicketView;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 * Calls on TicketModel, TicketView, and TicketController
 * to create a GUI ticket citation system
 * 
 * @author Mauricio Azcona
 * @version 1.4 Build March 2, 2018
 */
public class TicketGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        TicketView view = new TicketView(); // the GUI form
        TicketModel model = new TicketModel(); // the storage class
        
        // the controller acts as bridge between the model and the view
        TicketController controller = new TicketController(model, view);
        
        Scene scene = new Scene(view, 1500, 900);
        view.TicketView();
        
        try {
            model.TicketModel();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        primaryStage.setTitle("Parking Ticket Citation System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
            launch(args);
	}
    
}
