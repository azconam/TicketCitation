/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Consists of basic information 
 * on the person getting a ticket, their vehicle,
 * and the reason for the ticket.
 * 
 * @author Mauricio
 * @version 1.4 Build March 3, 2018
 */

public class Ticket {

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return the number (ticket number)
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the (ticket) number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the license (plate)
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license the license (plate) to set
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * @return the permit
     */
    public String getPermit() {
        return permit;
    }

    /**
     * @param permit the permit to set
     */
    public void setPermit(String permit) {
        this.permit = permit;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the violation
     */
    public int getViolation() {
        return violation;
    }

    /**
     * @param violation the violation to set
     */
    public void setViolation(int violation) {
        this.violation = violation;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }


    /**
     * @return the issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * @param issuer the issuer to set
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    
    /**
     * 
     * @param paid the paid status
     */
    public void setPaid(boolean paid){
        this.paid = paid;
    }
    /**
     * 
     * @return the paid status
     */
    public boolean getPaid(){
        return paid;
    }
    
    private int number;
    private String license;
    private String permit;
    private String state;
    private String make;
    private String color;
    private int violation;
    private String date;
    private String location;
    private String time;
    private String issuer;
    private boolean paid;
    
}
