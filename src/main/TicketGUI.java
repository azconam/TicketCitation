/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Ticket.TicketController;
import Ticket.TicketModel;
import Ticket.TicketView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author Mauricio
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
