/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.sql.Time;
import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Provides a GUI for inputing ticket information and displaying
 * payment information
 * 
 * @author Mauricio Azcona
 * @version Build 1.4 March 2, 2018
 */
public class TicketView extends BorderPane {

    /**
     * @return the date
     */
    public TextField getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(TextField date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public TextField getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(TextField time) {
        this.time = time;
    }

    private TextField ticketNumber = new TextField();
    private TextField licensePlate = new TextField();
    private TextField state = new TextField();
    private TextField permitNumber = new TextField();
    private TextField vehicleMake = new TextField();
    private TextField color = new TextField();
    private TextField location = new TextField();
    private TextField issuer = new TextField();
    private TextField date = new TextField();
    private TextField time = new TextField();
    
    // lastTicketNum is used to properly cycle thru the tickets when printing
    // avoids out of index error
    private int lastTicketNum = -1;
    
    private Button submit = new Button("Submit");
    private Button back = new Button("<<");
    private Button forward = new Button(">>");
    private Button modify = new Button("Paid");
    
    private GridPane gp = new GridPane();
    private HBox topBox = new HBox();
    private HBox bottomBox = new HBox();
    private VBox leftBox = new VBox();
    private TextArea rightBox = new TextArea();
    private VBox violationTypes = new VBox();
    
    Image image = new Image("utrgvLogo.jpg");
    ImageView img = new ImageView(image);

    Label title = new Label("Parking Citation");
    Label ticketNumberLabel = new Label("Ticket Number");
    Label licenseLabel = new Label("License Plate");
    Label stateLabel = new Label("State");
    Label permitLabel = new Label("Permit Number");
    Label makeLabel = new Label("Make/Model");
    Label colorLabel = new Label("Color");
    Label violationLabel = new Label("Violation");
    Label dateLabel = new Label("Date");
    Label locationLabel = new Label("Location");
    Label timeLabel = new Label("Time");
    Label issuerLabel = new Label("Issued by");
    
    
    final ToggleGroup violation = new ToggleGroup();
    RadioButton rb1 = new RadioButton("Vehicle has no parking permit");
    RadioButton rb2 = new RadioButton("Parked in No Parking Area/Space");
    RadioButton rb3 = new RadioButton("Parked in Fire Lane");
    RadioButton rb4 = new RadioButton("Parked in Handicap Space");
    RadioButton rb5 = new RadioButton("Parked in Reserved or Assigned Space");
    RadioButton rb6 = new RadioButton("Blocking Driveway, Access, or Other Vehicle");
    RadioButton rb7 = new RadioButton("Parked in 2 Spaces");
    RadioButton rb8 = new RadioButton("Expired Meter");
    RadioButton rb9 = new RadioButton("Other");
    
    Tooltip markedPaid = new Tooltip("Mark current ticket as paid");
    Tooltip goback = new Tooltip("Show previous ticket");
    Tooltip goforward = new Tooltip("Show next ticket");
    
    private Label bottomLabel = new Label();
        
        
   /**
     * TicketView Constructor
     * 
     * Sets up the GUI that is divided in five parts:
     * a form with TextFields in the center, a title banner on top,
     * a text area with payment information on the right, a navigation panel
     * on the left for cycling through tickets, and a display area on the bottom
     * for viewing tickets.
     */
    public void TicketView() {
        
        bottomLabel.setFont(Font.font("Arial", 16));
        
        /*
        The center consists of the form
        the top of title
        the bottom the print ticket area
        the right side of the GUI a textbox w/ payment info
        */
        
        this.setCenter(getGp());
        this.setTop(getTopBox());
        this.setBottom(getBottomBox());
        this.setRight(getRightBox());

        // to disable editing
        getRightBox().setEditable(false);
        getRightBox().setMaxSize(350, 400);

        
        getGp().setHgap(10);
        getGp().setVgap(10);
        
        

        // left box contains "<<", ">>" and "paid" buttons
        getLeftBox().setPrefWidth(200);
        getLeftBox().setAlignment(Pos.CENTER);
        getLeftBox().setSpacing(10);
        getLeftBox().getChildren().addAll(getSubmit(), getBack(), getForward(), getModify());
        this.setLeft(getLeftBox());

        
        img.setFitHeight(150);
        img.setFitWidth(150);
        // to resize the image without distorting x:y ratio
        img.setPreserveRatio(true);
        
        
        
        title.setFont(Font.font("Arial", 30));
                
        rb1.setToggleGroup(violation);
        rb2.setToggleGroup(violation);
        rb3.setToggleGroup(violation);
        rb4.setToggleGroup(violation);
        rb5.setToggleGroup(violation);
        rb6.setToggleGroup(violation);
        rb7.setToggleGroup(violation);
        rb8.setToggleGroup(violation);
        rb9.setToggleGroup(violation);
        getViolationTypes().getChildren().addAll(
                rb1, rb2, rb3, rb4, rb5,
                rb6, rb7, rb8, rb9
        );
        
        
        getTopBox().getChildren().add(title);
        getTopBox().setAlignment(Pos.CENTER);
        
        getRightBox().setText(
            "Payments can be made at the following office:\n" +
            "\nBussiness Office, Tandy 107\n" +
            "Monday thru Friday: 8:00 AM - 5:00 PM\n" +
            "\n$25 per citation, other fees may apply\n" +
            "$100 for boot removal\n" +
            "\nPayment can be mailed to the following address:\n" +
            "\nTSC\nC/O Finance Dept\nAttn: Parking Enforcement\n" + 
            "80 Fort Brown\n" + 
            "Brownsville, TX 78520\n" +
            "\nDO NOT MAIL IN CASH!\n"
        );
       
        
        
        getBack().setTooltip(goback);
        getForward().setTooltip(goforward);
        getModify().setTooltip(markedPaid);
        
        
        getGp().add(img, 0, 0, 2, 2);
        getGp().add(ticketNumberLabel, 1, 0);
        getGp().add(getTicketNumber(), 1, 1);
        getGp().add(licenseLabel, 0, 2);
        getGp().add(getLicensePlate(), 0, 3);
        getGp().add(stateLabel, 1, 2);
        getGp().add(getState(), 1, 3);
        getGp().add(permitLabel, 2, 2);
        getGp().add(getPermitNumber(), 2, 3);
        getGp().add(makeLabel, 0, 4);
        getGp().add(getVehicleMake(), 0, 5);
        getGp().add(colorLabel, 1, 4);
        getGp().add(getColor(), 1, 5);
        getGp().add(violationLabel, 1, 6);
        getGp().add(getViolationTypes(), 1, 7);
        getGp().add(dateLabel, 0, 8);
        getGp().add(getDate(), 0, 9);
        getGp().add(locationLabel, 1, 8);
        getGp().add(getLocation(), 1, 9);
        getGp().add(timeLabel, 0, 10);
        getGp().add(getTime(), 0, 11);
        getGp().add(issuerLabel, 1, 10);
        getGp().add(getIssuer(), 1, 11);
        
        getBottomBox().setAlignment(Pos.CENTER);
        getBottomBox().setPadding(new Insets(10, 0, 0, 0));
        
    }
    
    /**
     * Clears the form text fields
     * after clicking the submit button in preparation
     * for a new submission
     */
    public void clearFields(){
        ticketNumber.clear();
        licensePlate.clear();
        state.clear();
        permitNumber.clear();
        vehicleMake.clear();
        color.clear();
        // date = new Date();
        location.clear();
        // time = new Date();
        issuer.clear();
        date.clear();
        time.clear();

    }
    
    // For a possible redesign where tickets are printed through the Text Fields
    /*
    public void updateTicketView(Ticket currentTicket){
        ticketNumber.setText(Integer.toString(currentTicket.getNumber()));
        licensePlate.setText(currentTicket.getLicense());
        state.setText(currentTicket.getState());
        permitNumber.setText(currentTicket.getPermit());
        vehicleMake.setText(currentTicket.getMake());
        color.setText(currentTicket.getColor());
        // date = new Date();
        location.setText(currentTicket.getLocation());
        // time = new Date();
        issuer.setText(currentTicket.getIssuer());
    }
    
    */

   /**
    * Used for determining how many tickets have already
    * been submitted
     * @return the lastTicketNum
     */
    public int getLastTicketNum() {
        return lastTicketNum;
    }

    /**
     * @param lastTicketNum the lastTicketNum to set
     */
    public void setLastTicketNum(int lastTicketNum) {
        this.lastTicketNum = lastTicketNum;
    }
    
    /**
     * @return the bp
     */
    public BorderPane getBp() {
        return this;
    }

    
    /**
     * @return the gp
     */
    public GridPane getGp() {
        return gp;
    }

    /**
     * @param gp the gp to set
     */
    public void setGp(GridPane gp) {
        this.gp = gp;
    }

    /**
     * @return the topBox
     */
    public HBox getTopBox() {
        return topBox;
    }

    /**
     * @param topBox the topBox to set
     */
    public void setTopBox(HBox topBox) {
        this.topBox = topBox;
    }

    /**
     * @return the bottomBox
     */
    public HBox getBottomBox() {
        return bottomBox;
    }

    /**
     * @param bottomBox the bottomBox to set
     */
    public void setBottomBox(HBox bottomBox) {
        this.bottomBox = bottomBox;
    }

    /**
     * @return the leftBox
     */
    public VBox getLeftBox() {
        return leftBox;
    }

    /**
     * @param leftBox the leftBox to set
     */
    public void setLeftBox(VBox leftBox) {
        this.leftBox = leftBox;
    }

    /**
     * @return the rightBox
     */
    public TextArea getRightBox() {
        return rightBox;
    }

    /**
     * @param rightBox the rightBox to set
     */
    public void setRightBox(TextArea rightBox) {
        this.rightBox = rightBox;
    }

    /**
     * @return the violationTypes
     */
    public VBox getViolationTypes() {
        return violationTypes;
    }

    /**
     * @param violationTypes the violationTypes to set
     */
    public void setViolationTypes(VBox violationTypes) {
        this.violationTypes = violationTypes;
    }

    /**
     * @return the ticketNumber
     */
    public TextField getTicketNumber() {
        return ticketNumber;
    }

    /**
     * @param ticketNumber the ticketNumber to set
     */
    public void setTicketNumber(TextField ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * @return the licensePlate
     */
    public TextField getLicensePlate() {
        return licensePlate;
    }

    /**
     * @param licensePlate the licensePlate to set
     */
    public void setLicensePlate(TextField licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @return the state
     */
    public TextField getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(TextField state) {
        this.state = state;
    }

    /**
     * @return the permitNumber
     */
    public TextField getPermitNumber() {
        return permitNumber;
    }

    /**
     * @param permitNumber the permitNumber to set
     */
    public void setPermitNumber(TextField permitNumber) {
        this.permitNumber = permitNumber;
    }

    /**
     * @return the vehicleMake
     */
    public TextField getVehicleMake() {
        return vehicleMake;
    }

    /**
     * @param vehicleMake the vehicleMake to set
     */
    public void setVehicleMake(TextField vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    /**
     * @return the color
     */
    public TextField getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(TextField color) {
        this.color = color;
    }

    
    /**
     * @return the location
     */
    public TextField getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(TextField location) {
        this.location = location;
    }


    /**
     * @return the issuer
     */
    public TextField getIssuer() {
        return issuer;
    }

    /**
     * @param issuer the issuer to set
     */
    public void setIssuer(TextField issuer) {
        this.issuer = issuer;
    }


    /**
     * @return the ticketTotal
     */
    public Button getModify() {
        return modify;
    }

    /**
     * @param modify the modify to set
     */
    public void Modify(Button modify) {
        this.modify = modify;
    }

    /**
     * @return the submit
     */
    public Button getSubmit() {
        return submit;
    }

    /**
     * @return the back
     */
    public Button getBack() {
        return back;
    }

    /**
     * @return the forward
     */
    public Button getForward() {
        return forward;
    }
    
        /**
     * @return the bottomLabel
     */
    public Label getBottomLabel() {
        return bottomLabel;
    }

    /**
     * @param bottomLabel the bottomLabel to set
     */
    public void setBottomLabel(Label bottomLabel) {
        this.bottomLabel = bottomLabel;
    }

    
}
