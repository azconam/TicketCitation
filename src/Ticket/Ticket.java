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
 *
 * @author Mauricio
 */

public class Ticket {

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license the license to set
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 
     * @param month
     * @param day
     * @param year
     * @throws ParseException 
     */
    public void setDate(String month, int day, int year) throws ParseException {
        DateFormat fmt = new SimpleDateFormat("MMMM dd yyyy", Locale.US);
        Date date = fmt.parse(month+" "+ day + " "+ year);
        this.date = date;
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
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * 
     * @param hour
     * @param min
     * @param day 
     */
    public void setTime(int hour, int min, boolean day) {
        this.time = time;
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
     * @param paid 
     */
    public void setPaid(boolean paid){
        this.paid = paid;
    }
    /**
     * 
     * @return paid
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
    private Date date;
    private String location;
    private Date time;
    private String issuer;
    private boolean paid;
    
}
