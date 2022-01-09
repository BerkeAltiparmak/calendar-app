//Berke Altiparmak
//October 20, 2019
//Calendar

/*
 * In this class, I get the current date by
 * using GregorianCalendar.
 * Then, I pass the date to the 
 * CalendarFrame class
 * */
import java.util.*;

public class CalendarDay {
  int[] dates = new int[3]; //creating an array to have the current day, month, and year.
  
  public CalendarDay() {
    
        Calendar gCalendar = new GregorianCalendar();
        
        //getting the current date as such:
        int thisYear = gCalendar.get(Calendar.YEAR);
        int thisMonth = gCalendar.get(Calendar.MONTH);
        int thisDay = gCalendar.get(Calendar.DAY_OF_MONTH);
        
        dates[0]=thisDay; //first element in my date array is the current day
        dates[1]=thisMonth; //second element in my date array is the current month
        dates[2]=thisYear; //third element in my date array is the current year
        
    
  }
  public int[] theDates()  
    { 
        return dates; //returning the date array with this method, which will be used in CalendarFrame.
    } 
  
  
}