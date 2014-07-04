/*
   File: Inventory.java
   July 03 2014     Kalyan Kasyap   Implementation of JavaBeans component named Inventory
*/

package com.data.model;
import java.util.List;

// Inventory JavaBean
public class Inventory {

    // Inventory properties
    private String name;            /* set name for the Inventory */
    private String date;            /* set date for the Inventory */
    private String day;             /* set day for the Inventory  */
    private List<String> items;     /* set items to the Inventory */

    /**
     * Creates a new instance of Inventory
     */
    public Inventory() {            /* Implementation goes here */
    }
    
    /**
     * Getters/Setters a convention to provide abstraction over property access
     * @return 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
    
    // Overriding toString() of Object class to display formatted string
    @Override
    public String toString(){
        
        // create StringBuilder instance
        StringBuilder sb = new StringBuilder();
        
        // appending to StringBuilder instance
        sb.append("Hello ").append(this.getName()).append(" today is ").append(this.getDate()).append(" and its a ").append(this.getDay())
          .append(";").append(System.getProperty("line.separator")).append("Buy the following items from the market, ");
        
        // iterate through items and append to StringBuilder instance
        this.getItems().stream().forEach((item) -> {
            sb.append(item).append(", ");
        });     
        
        // convert StringBuilder object to String
        return sb.toString();        
        
    } // end of method
    
} // end of class
