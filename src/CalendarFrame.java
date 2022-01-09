//Berke Altiparmak
//October 20, 2019
//Calendar

/*This class uses every other class except, of course, tester.
 * It first creates a frame.
 * Then, it creates the month buttons and puts them in this frame
 * along with some option buttons (like choose year and exit).
 * After the month is chosen, it shows the days of that month
 * like a calendar. After that, if a day button is pressed,
 * it creates two frames (daily and monthly) for the user to type
 * in their notes with SaveCalendar and SaveMonthly.
 * */
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;

public class CalendarFrame {
  
  JFrame frame; //creates the frame
  private int chosenMonth = -1; //will show which month the user chose. 
  //Initial value of the chosen month is -1, so that no progress is made without choosing a month.
  private int chosenYear = 2019; //will show which year the user chose.
  //Initial value of the chosen year is 2019 just in case the user forgets to enter a year.
  
  JPanel mainPanel = new JPanel(); //the panel that will be consist of all the other panels (not simultaneously).
  JPanel dailyPanel = new JPanel(new GridLayout(7,7));
  JPanel monthlyPanel = new JPanel(new GridLayout(4,7));
  JPanel top = new JPanel(); //top of the frame that has some option buttons (like choose year and exit).
  JPanel mid = new JPanel(); //middle of the frame that either shows the months or the days of a month.
  JPanel bottom = new JPanel(); //bottom of the frame that shows the chosen date.
  
  JTextArea yearTA = new JTextArea("Year", 1, 4); //enables the user to choose a year
  JButton yearGetter = new JButton("Enter Year"); //enables the user to enter that year
  JScrollPane yearSP = new JScrollPane(yearTA); //puts the year text area into a scroll pane.
  
  public CalendarFrame() {
    
    frame = new JFrame("Calendar"); //creates the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //enables the user to close the frame.
    
    Month monthGUI = new Month(); //calls the CalendarMonth class
    CalendarDay dayGUI = new CalendarDay(); //calls the CalendarDay class
    
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //the panels in main panel will be listed vertically.
    
    //creating the month buttons, could not find a shorter frame.
    JButton jan = new JButton("January"); //creates the first month as a button
    jan.setPreferredSize(new Dimension(315, 140)); //sets the size of the button
    //this checks if a note exists for that month, and if it does, make this month button yellow:
    try{SaveMonthly saveMon = new SaveMonthly(0, 0);
      if(saveMon.fileOpener()!="") //if the note file of that month is not empty,
      {jan.setBackground(Color.YELLOW);jan.setOpaque(true);}} //make the button yellow
    catch(Exception exc)
    {jan.setBackground(Color.WHITE);jan.setOpaque(true);} //if the note file does not exist, make the month white.
    //action listener for this month. sets a value for the chosen month, and the refreshes the frame with the day buttons (will be elaborated later).
    jan.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 0;refresh();}});
    monthlyPanel.add(jan); //adds the month button to the month panel.
    
    //all the other month buttons follow the same logic:
    JButton feb = new JButton("February");
    feb.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 1);
      if(saveMon.fileOpener()!="")
      {feb.setBackground(Color.YELLOW);feb.setOpaque(true);}}
    catch(Exception exc)
    {feb.setBackground(Color.WHITE);feb.setOpaque(true);}
    feb.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 1;refresh();}});
    monthlyPanel.add(feb);
    
    JButton mar = new JButton("March");
    mar.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 2);
      if(saveMon.fileOpener()!="")
      {mar.setBackground(Color.YELLOW);mar.setOpaque(true);}}
    catch(Exception exc)
    {mar.setBackground(Color.WHITE);mar.setOpaque(true);}
    mar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 2;refresh();}});
    monthlyPanel.add(mar);
    
    JButton apr = new JButton("April");
    apr.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 3);
      if(saveMon.fileOpener()!="")
      {apr.setBackground(Color.YELLOW);apr.setOpaque(true);}}
    catch(Exception exc)
    {apr.setBackground(Color.WHITE);apr.setOpaque(true);}
    apr.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 3;refresh();}});
    monthlyPanel.add(apr);
    
    JButton may = new JButton("May");
    may.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 4);
      if(saveMon.fileOpener()!="")
      {may.setBackground(Color.YELLOW);may.setOpaque(true);}}
    catch(Exception exc)
    {may.setBackground(Color.WHITE);may.setOpaque(true);}
    may.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 4;refresh();}});
    monthlyPanel.add(may);
    
    JButton jun = new JButton("June");
    jun.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 5);
      if(saveMon.fileOpener()!="")
      {jun.setBackground(Color.YELLOW);jun.setOpaque(true);}}
    catch(Exception exc)
    {jun.setBackground(Color.WHITE);jun.setOpaque(true);}
    jun.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 5;refresh();}});
    monthlyPanel.add(jun);
    
    JButton jul = new JButton("July");
    jul.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 6);
      if(saveMon.fileOpener()!="")
      {jul.setBackground(Color.YELLOW);jul.setOpaque(true);}}
    catch(Exception exc)
    {jul.setBackground(Color.WHITE);jul.setOpaque(true);}
    jul.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 6;refresh();}});
    monthlyPanel.add(jul);
    
    JButton aug = new JButton("August");
    aug.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 7);
      if(saveMon.fileOpener()!="")
      {aug.setBackground(Color.YELLOW);aug.setOpaque(true);}}
    catch(Exception exc)
    {aug.setBackground(Color.WHITE);aug.setOpaque(true);}
    aug.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 7;refresh();}});
    monthlyPanel.add(aug);
    
    JButton sep = new JButton("September");
    sep.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 8);
      if(saveMon.fileOpener()!="")
      {sep.setBackground(Color.YELLOW);sep.setOpaque(true);}}
    catch(Exception exc)
    {sep.setBackground(Color.WHITE);sep.setOpaque(true);}
    sep.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 8;refresh();}});
    monthlyPanel.add(sep);
    
    JButton oct = new JButton("October");
    oct.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 9);
      if(saveMon.fileOpener()!="")
      {oct.setBackground(Color.YELLOW);oct.setOpaque(true);}}
    catch(Exception exc)
    {oct.setBackground(Color.WHITE);oct.setOpaque(true);}
    oct.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 9;refresh();}});
    monthlyPanel.add(oct);
    
    JButton nov = new JButton("November");
    nov.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 10);
      if(saveMon.fileOpener()!="")
      {nov.setBackground(Color.YELLOW);nov.setOpaque(true);}}
    catch(Exception exc)
    {nov.setBackground(Color.WHITE);nov.setOpaque(true);}
    nov.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 10;refresh();}});
    monthlyPanel.add(nov);
    
    JButton dec = new JButton("December");
    dec.setPreferredSize(new Dimension(315, 140));
    try{SaveMonthly saveMon = new SaveMonthly(0, 11);
      if(saveMon.fileOpener()!="")
      {dec.setBackground(Color.YELLOW);dec.setOpaque(true);}}
    catch(Exception exc)
    {dec.setBackground(Color.WHITE);dec.setOpaque(true);}
    dec.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = 11;refresh();}});
    monthlyPanel.add(dec);
    
    
    
    
    JButton previous = new JButton("Previous"); //creates a previous month button
    previous.setPreferredSize(new Dimension(100, 50));
    previous.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {previousM();}}); //calls the "previous" method that
    //decreases the chosen month value by 1.
    JButton next = new JButton("Next"); //creates a next month button
    next.setPreferredSize(new Dimension(100, 50));
    next.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {nextM();}});//calls the "next" method that
    //increases the chosen month value by 1.
    JButton today = new JButton("Today"); //creates a today button
    today.setPreferredSize(new Dimension(100, 50));
    today.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenMonth = dayGUI.theDates()[1]; chosenYear = dayGUI.theDates()[2]; refresh();}});
    //opens the calendar according to the current date.
    JButton changeMonth = new JButton("Months"); //creates a go back to month panel button
    changeMonth.setPreferredSize(new Dimension(100, 50));
    changeMonth.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {changeMonthM();}}); //calls the "change month" method that
    //enables the user to go back to the month buttons to choose another month.
    JButton exit = new JButton("X"); //creates an exit button
    exit.setPreferredSize(new Dimension(30, 30));
    exit.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {exitM();}}); //calls the "exit" method that
    //exits the program.
    yearGetter.setPreferredSize(new Dimension(100, 50));
    //this action listener enables the program to get the chosen year by the user.
    yearGetter.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {chosenYear = Integer.valueOf(yearTA.getText());System.out.println(chosenYear);refresh();}});
    
    //adding all these buttons to the top panel, which will be demonstrated at the top of the screen.
    top.add(previous);
    top.add(today);
    top.add(changeMonth);
    top.add(yearSP);
    top.add(yearGetter);
    top.add(next);
    top.add(exit);
    
    //shows the current date at the top/middle of the screen
    int actualMonth = dayGUI.theDates()[1] + 1; //first month of the year is 0 instead of 1, so we add 1.
    JLabel currentDate = new JLabel("Current Date in D.M.Y: " + dayGUI.theDates()[0] + "." + actualMonth + "." + dayGUI.theDates()[2]);
    mid.add(currentDate);
    
    //adding all these panels to the main panel.
    mainPanel.add(top);
    mainPanel.add(mid);
    mainPanel.add(monthlyPanel);
    
    frame.add(mainPanel); //only adding the main panel to the frame as it has all the other panels.
    frame.pack(); //enables the user to change the size of the frame
    frame.setLocationRelativeTo(null); //creates the frame at the center of the window.
    frame.setVisible(true); //shows the frame
    
  }
  
  
  
  public void create() 
  {
    //this method creates the day buttons of the chosen month and year according to the logic in Month class
    CalendarDay dayGUI = new CalendarDay();
    Month monthGUI = new Month();
    System.out.println("creating");
    for(int i = 0 ; i < 49 ; i++)
    {
      JButton btn = new JButton(monthGUI.getDay(chosenMonth,chosenYear)[i]); //creating the day buttons.
      btn.setPreferredSize(new Dimension(180, 80)); //setting the size of the buttons.
      if(i<7)
      {
        //the names of the days of the week (like Thursday) are shown in green:
        btn.setBackground(Color.GREEN);
        btn.setOpaque(true);
      }
      else if(i%7 == 5 && i>=7 && !"".equals(monthGUI.getDay(chosenMonth,chosenYear)[i]) && i!=monthGUI.getMonthLength()+monthGUI.getFirstDay()+7)
      {
        //Saturdays are in pink:
        btn.setBackground(Color.PINK);
        btn.setOpaque(true);
      }
      else if(i%7 == 6  && i>=7 && !"".equals(monthGUI.getDay(chosenMonth,chosenYear)[i]) && i!=monthGUI.getMonthLength()+monthGUI.getFirstDay()+7)
      {
        //Sundays are in pink:
        btn.setBackground(Color.PINK);
        btn.setOpaque(true);
      }
      else
      {
        //other days are white:
        btn.setBackground(Color.WHITE);
        btn.setOpaque(true);
      }
      if(dayGUI.theDates()[2]==chosenYear && dayGUI.theDates()[1]==chosenMonth && i-monthGUI.getFirstDay()-6 ==dayGUI.theDates()[0])
      {
        //the current date is shown in red.
        btn.setBackground(Color.RED);
        btn.setOpaque(true);
      }
      try
      {
        //checks if a note exists for that date, and if it does, show it in yellow.
        SaveCalendar saveCal = new SaveCalendar(0,i-monthGUI.getFirstDay()-6, chosenMonth, chosenYear);
        if(saveCal.fileOpener()!="") //if a file exists for that day that is not empty
        {
          btn.setBackground(Color.YELLOW); //show that day in yellow.
          btn.setOpaque(true);
        }
      }
      catch(Exception exc)
      {
        System.out.print(""); //if no file exists, then do not let the program crash.
      }
      //btn.setBorderPainted(false); //depends on the user preference, I personally do want to have borders between buttons/days.
      btn.addActionListener(new ActionListener() { //action listener for the day button that enables the user to enter notes via SaveMonthly and SaveCalendar.
        public void actionPerformed(ActionEvent e) {
          JButton b = (JButton)e.getSource();
          if(!"".equals(b.getText()) && !"Monday".equals(b.getText()) && !"Tuesday".equals(b.getText()) && !"Wednesday".equals(b.getText()) && !"Thursday".equals(b.getText()) 
               && !"Friday".equals(b.getText()) && !"Saturday".equals(b.getText()) && !"Sunday".equals(b.getText())) //if the pressed button is an actual day
          {
            int chosenDay = Integer.valueOf(b.getText()); //get the chosen day
            passDate(chosenDay, chosenMonth, chosenYear); //and trigger the passDate method, which triggers SaveMonthly and SaveCalendar.
          }
        }
      });
      dailyPanel.add(btn); //add these buttons to the day panel.
    }
    //for Mac users, these two lines of code must exist for the buttons to be colored:
    try{UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());}
    catch(Exception e){e.printStackTrace();}
    
    mainPanel.add(dailyPanel); //add the day panel to the main panel
    int realMonth = chosenMonth + 1; //doing this because Calendar library calcultes 1 less than the month chosen.
    JLabel chosenDate = new JLabel("Chosen Date in M.Y: " + realMonth + "." + chosenYear); //shows the chosen date.
    bottom.add(chosenDate); //add the chosen date to the bottom of the frame.
    mainPanel.add(bottom);
  }
  public void refresh() {
    //this refresh method enables me to refresh the frame everytime a button is pressed.
    if(chosenMonth != -1)
    {
      //this closes the month buttons and opens the day buttons
      mainPanel.remove(monthlyPanel);
      monthlyPanel.setVisible(false);
      dailyPanel.removeAll();
      bottom.removeAll();
      create();
      frame.revalidate();
      frame.repaint();
      System.out.println("Refreshing");
    }
  }
  public void previousM() {
    //this method shows the previous month.
    if(chosenMonth != -1 && chosenMonth != 0)
    {
      chosenMonth = chosenMonth -1; //decreases the chosen month by one.
      refresh();
      System.out.println("Previous");
    }
    else if(chosenMonth == 0) //if it is the first month of the year,
    {
      chosenYear = chosenYear -1;  //decrease the year by one,
      chosenMonth = 11; //and make it December
      refresh();
      System.out.println("Previous");
    }
  }
  public void nextM() {
    //this method shows the next month.
    if(chosenMonth != -1 && chosenMonth != 11)
    {
      chosenMonth = chosenMonth +1; //increases the chosen month by one.
      refresh();
      System.out.println("Next");
    }
    else if(chosenMonth == 11) //if it is the last month of the year,
    {
      chosenYear = chosenYear + 1;  //increase the year by one,
      chosenMonth = 0; //and make it January
      refresh();
      System.out.println("Next");
    }
  }
  public void changeMonthM() {
    //enables the user to go back to the month buttons so that the user can change the month to what they want.
    dailyPanel.removeAll();
    bottom.removeAll();
    monthlyPanel.setVisible(true);
    mainPanel.add(monthlyPanel);
    chosenMonth = -1;
    frame.revalidate();
    frame.repaint();
  }
  public void exitM() {
    //exists the program.
    System.exit(0);
  }
  public void passDate(int day, int month, int year) {
    //this method triggers the SaveCalendar and SaveMonthly classes, and they enable the user to enter a note daily and monthly.
    System.out.print(day + "." + month + "." + year);
    SaveCalendar saveCal = new SaveCalendar(1, day, month, year);
    SaveMonthly saveMon = new SaveMonthly(1, month);
    refresh();
  }
  
  
}