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
 * @author mparish2
 */
public class DateUtilitiesJDK8 {
    /*
     students should complete this lab by one week from today: Create a custom "DateUtilities" class similar to the one demonstrated 
     by your instructor. However, yours should use the new Java 8 Date/Time API. You must provide a minimum of two methods for converting Date/Time
     objects to formatted strings; and you must provide a minimum of two methods to convert formatted strings to Date/Time objects. And you must 
     provide at least one method for performing Date/Time arithmetic, such as the number of months, days, minutes, etc., between two dates.
     Experimentation is crucial to your success!
    */
    
    
    // Singleton Pattern
    /*
        In software engineering, the singleton pattern is a design pattern that restricts the instantiation of a class to one object.
    This is useful when exactly one object is needed to coordinate actions across the system. The concept is sometimes generalized 
    to systems that operate more efficiently when only one object exists, or that restrict the instantiation to a certain number of
    objects. https://en.wikipedia.org/wiki/Singleton_pattern
    */
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
     * 
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
      * 
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
      * 
      * @param dateString
      * @return 
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
      * 
      * @param dateTimeString
      * @return
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
     
    public LocalDate SubDays(LocalDate d, long daysToSub){
      return d.minusDays(daysToSub);
    }
    
     
     
    public static void main(String[] args) {
     DateUtilitiesJDK8 dateUtilities = DateUtilitiesJDK8.getInstance();
     
     LocalDateTime today = LocalDateTime.now();
     LocalDate today2 = LocalDate.now();
     
     System.out.println("Test Date ISO_LOCAL_DATE_Time: " + dateUtilities.toString(today));
      
        System.out.println("Test ToDate: " + dateUtilities.toDate("2010-Jan-04"));
        System.out.println("Test2 ToDate2: " + dateUtilities.toDate2("2012-Feb-12 10:15"));
        System.out.println("Test3 MinusDay: " + dateUtilities.SubDays(today2,6));
    }  
}