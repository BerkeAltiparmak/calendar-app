//Berke Altiparmak
//October 20, 2019
//Calendar

/*In this class, I create the buttons 
 * which will be demonstrated in the CalendarFrame.
 * The first array of buttons consists of the 
 * months of the year for the user to
 * choose which month they want to see.
 * The second array of buttons consists of the
 * days of that month along with which day of the
 * week they belong to (ex. under the Thursday column).
 * */
import java.util.*; 
import java.text.*;

public class Month{
  
  private String[] days; //array that consists of the day of the month in an order
  private String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", 
    "Saturday", "Sunday"}; //days of the week in order
  public int lengthOfMonth; //this will have the value of the length of the month chosen
  public int firstDay; //this will be used to determine what is the first day of the month chosen (ex. Thursday).
  //These three will be used to create the date (will be elaborated later):
  public int myDay;
  public int myMonth;
  public int myYear;
  
  public Month() {
    
    days = new String[49];
    
  }
  
  public String[] getDay(int theChosenMonth, int theChosenYear) {
    
    
    for(int i=0; i<49; i++)
    {
      myMonth = theChosenMonth; //gets the value of the chosen month
      myYear = theChosenYear; //gets the value of the chosen year
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.DATE, myDay);
      cal.set(Calendar.MONTH, myMonth); //january 0
      cal.set(Calendar.YEAR, myYear);
      
      //these four lines of code are used to determine the first day of the month in string
      cal.set(Calendar.DAY_OF_MONTH, 1);
      Date firstDayOfMonth = cal.getTime();  
      DateFormat sdf = new SimpleDateFormat("EEEEEEEE");
      String sfirstDay = sdf.format(firstDayOfMonth);
      //now, the string value is transformed to an integer value to be used in CalendarFrame:
      if(sfirstDay.equals("Monday")) {firstDay = 0;}
      if(sfirstDay.equals("Tuesday")) {firstDay = 1;}
      if(sfirstDay.equals("Wednesday")) {firstDay = 2;}
      if(sfirstDay.equals("Thursday")) {firstDay = 3;}
      if(sfirstDay.equals("Friday")) {firstDay = 4;}
      if(sfirstDay.equals("Saturday")) {firstDay = 5;}
      if(sfirstDay.equals("Sunday")) {firstDay = 6;}
      
      lengthOfMonth = cal.getActualMaximum(Calendar.DATE); //length of the chosen month is now gotten (ex. 30).
      
      if(i <7)
      { 
        days[i] = daysOfWeek[i]; //first 7 elements of days array consists of Monday, Tuesday...
      }
      if(i >= 7 && i < getFirstDay() + 7)
      { 
        days[i] = ""; //the elements are empty until the first day of the month is reached
        //for example, if the first day of the month is Thursday, then first row of Monday, Tuesday, Wednesday are empty
      }
      if(i >= getFirstDay() + 7 && i <= getMonthLength() + getFirstDay() + 6 )
      { 
        days[i] = String.valueOf(i-getFirstDay() - 6); //this part of the days array consists of the days of the month (1->lengthOfMonth)
      }
      if(i > getMonthLength() + getFirstDay() + 7)
      { 
        days[i] = ""; //last elements are empty (they exist just in case).
      }
    }
    return days; //returns the days array
  }
  
  public int getMonthLength() {
    return lengthOfMonth; //returns the length of the month
  }
  
  public int getFirstDay() {
    return firstDay; //returns the first day of the chosen month
  }
  
}
