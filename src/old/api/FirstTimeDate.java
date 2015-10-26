/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mparish2
 */
public class FirstTimeDate {
    public static void main(String[] args) {
       //api Date(util) api SimpleDateFormat api Calandar
        
        // calendar is a abstract class that has date/time | getInstance is a static method (belongs to the class)
        Calendar date2 = Calendar.getInstance();
        date2.set(2050, Calendar.SEPTEMBER, 23);
        //modifying by calling the add method
        date2.add(Calendar.MONTH, -5); //makes it april (instead of september)(-5 for 2nd parameter)
        
        
//        Date date1 = new Date();
        Date date1 = date2.getTime();
        //either work. calls the tostring automatically
        System.out.println(date1.toString());
        System.out.println(date1);
        
        Date date3 = new Date();
        
        
        long diff = Math.abs(date1.getTime() - date3.getTime());
        //gets mins the have lasped between the 2 dates
        long minutes = diff/1000/60;
        
        
        boolean isAfter = date1.after(date3);
        System.out.println("date 1 is after date3: " + isAfter);
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm a");
        String fDate = sdf.format(date1);
        System.out.println(fDate);
       
        //turn string into date | (format the same)
        String date3String = "Jul 11, 1999";
        try{
            date1 = sdf.parse(date3String);
        }catch(ParseException pe) {
            System.out.println("Cannot parse date string");
        }
        System.out.println(date1);
    }
}
