/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.lab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * 
 * This is a new Java 8 API Date Utilities class that has a minimum of two methods for converting Date/Time
     objects to formatted strings, a minimum of two methods to convert formatted strings to Date/Time objects, and 
 * one method for performing Date/Time arithmetic
 * 
 * Singleton Pattern
 * In software engineering, the singleton pattern is a design pattern that restricts the instantiation of a class to one object.
    This is useful when exactly one object is needed to coordinate actions across the system. The concept is sometimes generalized 
    to systems that operate more efficiently when only one object exists, or that restrict the instantiation to a certain number of
    objects. https://en.wikipedia.org/wiki/Singleton_pattern
 * 
 *
 * @author mparish2
 */
public class DateUtilitiesJDK8 {
  
    
     private static DateUtilitiesJDK8 instance;
    
    // Prohibit instantiation -- support Singleton design pattern
    // or any unwanted things passed through or defaultly assigned
    private DateUtilitiesJDK8() {
    }

    /**
     * Singleton support.
     * Provides validate if instance would get assigned to null
     * @return one and only one global instance
     */
    public static DateUtilitiesJDK8 getInstance() {
        if (instance == null) {
            instance = new DateUtilitiesJDK8();
        }
        return instance;
    }
    
   //Convert Date/Time objs to formatted string (2x)  
  // (1)  
    /**
     * Takes a LocalDateTime object in the ISO_LOCAL_DATE_TIME Format and converts it into a 
     * string
     * @param date
     * @return Current Local Date/Time with the ISO_LOCAL_DATE_TIME predefined format
     * @throws IllegalArgumentException 
     */
     public String toString(LocalDateTime date) throws IllegalArgumentException{
         if(date==null){
             throw new IllegalArgumentException("DateTime passed in can't be null");
         }
         DateTimeFormatter df8 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
         return df8.format(date);
     }
     
     /**
      * Takes a LocalDate object in the ISO_LOCAL_DATE Format and converts it into a 
     * string
      * @param date
      * @return Current LocalDate with the IS0_DATE predefined format
      * @throws IllegalArgumentException 
      */
     public String toString(LocalDate date) throws IllegalArgumentException{
         if(date==null){
             throw new IllegalArgumentException("Date passed in can't be null.");
         }
         DateTimeFormatter df8 = DateTimeFormatter.ISO_LOCAL_DATE;
         return df8.format(date);
     }
     
     
     
   //Convert formatted Strings into Date/Time Objs (2x)  
     
     /**
      * Take a String date and converts it into a LocalDate
      * @param dateString
      * @return a date, converted from a string, using "yyyy-MMM-dd" pattern
      */
     
     public LocalDate toDate(String dateString)throws IllegalArgumentException{
        if(dateString==null){
             throw new IllegalArgumentException("Date passed in cant be null");
         } 
        DateTimeFormatter df8 = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate date = LocalDate.parse(dateString,df8);
        return date;
     }
     
     /**
      * Take a String datetime and converts it into a LocalDate
      * @param dateTimeString
      * @return a datetime, converted from a string, using "yyyy-MMM-dd HH:mm" pattern
      * @throws IllegalArgumentException 
      */
     
      public LocalDateTime toDate2(String dateTimeString)throws IllegalArgumentException{
        if(dateTimeString==null){
             throw new IllegalArgumentException("Date passed in cant be null");
         } 
        DateTimeFormatter df8 = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm");
        LocalDateTime date2 = LocalDateTime.parse(dateTimeString,df8);
        return date2;
     }
    
    
    
    
  //Date/Time Artithmetic between two dates (1x)  
     
     /**
      * Takes the current date and subtracts the input number of days from the current date
      * @param d = LocalDate
      * @param daysToSub
      * @return 
      */ 
      
      
    public LocalDate SubDays(LocalDate d, long daysToSub){
      return d.minusDays(daysToSub);
    }
    
     
     
     
    public static void main(String[] args) {
     DateUtilitiesJDK8 dateUtilities = DateUtilitiesJDK8.getInstance();
     
     LocalDateTime today = LocalDateTime.now();
     LocalDate today2 = LocalDate.now();
     
     System.out.println("Test Date ISO_LOCAL_DATE_Time: " + dateUtilities.toString(today));
     System.out.println("Test Date ISO_LOCAL_DATE: " + dateUtilities.toString(today2));

        System.out.println("Test ToDate: " + dateUtilities.toDate("2010-Jan-04"));
        System.out.println("Test2 ToDate2: " + dateUtilities.toDate2("2012-Feb-12 10:15"));
        System.out.println("Test3 MinusDay: " + dateUtilities.SubDays(today2,6));
    }  
}