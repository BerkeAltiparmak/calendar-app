//Berke Altiparmak
//October 20, 2019
//Calendar

/*This class, when triggered by CalendarFrame, creates a frame
 * that has a text area, a DAILY save button, and a delete button.
 * Text area allows the user to enter a note for daily,
 * the save button allows the user to save that to
 * open that note later (even after closing the app), and
 * delete button allows the user delete that note.
 * The saved note will be demonstrated for that and only that day.
 * */
import javax.swing.*;
import java.awt.*;
import java.lang.String;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class SaveCalendar 
{
  JFrame noteFrame; //creating the frame
  StringBuilder name = new StringBuilder(); //will be elaborated later
  JButton sbDaily = new JButton("Save Note Daily"); //save button
  JButton dbDaily = new JButton("Delete"); //delete button
  JPanel mainPanel = new JPanel(); //the main panel that consists of "bottom" and "textPanel".
  JPanel bottom = new JPanel(); //this panel has the save and delete buttons
  JPanel textPanel = new JPanel(); //this panel has the text area.
  String savedNotes = ""; //will be elaborated later
  public SaveCalendar(int pop, int day, int month, int year) 
  {
    try{ //using Try since IOException may happen
      noteName( day,  month,  year); //using noteName method (will be elaborated)
      int realMonth = month + 1; //doing this since Calendar library calculates the month one less than its integer value
      noteFrame = new JFrame("Notes for " + day + "." + realMonth + "." + year + "."); //shows which day the user types the note for
      noteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //allowing the user to close the note frame without closing calendar.
      noteFrame.add(mainPanel); //only adding the main panel to the frame as it has the other two panels.
      noteFrame.setSize(300,600); //setting the size of the frame
      if(pop==1)
      {
        noteFrame.setVisible(true); //if CalendarFrame wants the frame to pop up, it will say pop=1, otherwise pop=0
                //CalendarFrame wants the frame to pop up when it wants to user to input the note
                //CalendarFrame does not want the frame to pop up when it only wants to check 
                //if a note was saved on a particular day to make that day yellow.
      }
      
      JTextArea stDaily= new JTextArea(fileOpener(), 65, 20); //creating the text area that the user will input their notes
      JScrollPane scrollPane = new JScrollPane(stDaily); //adding this text area to a scroll pane
      
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); //main panel will list its elements vertically
      mainPanel.add(textPanel); //main panel now has the text panel at the top/center
      mainPanel.add(bottom); //main panel now has the bottom panel at the bottom
      
      textPanel.add(scrollPane); //adding the scroll pane
      bottom.add(sbDaily); //adding the save button
      bottom.add(dbDaily); //adding the delete button
      
      sbDaily.setPreferredSize(new Dimension(150, 50)); //setting the dimensions of save button
      dbDaily.setPreferredSize(new Dimension(100, 50)); //setting the dimensions of delete button
      sbDaily.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) //save button action listener
        {
        try{
          fileConvertor(stDaily.getText()); //method that converts the date into a file and saves notes in it
        }
        catch(IOException exc) //prevents the program to crash if IOException happens, and allows it to be compiled
        {
          System.out.println(exc.getStackTrace()); //shows that IOException happened
        }
      }});
      dbDaily.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) //delete button action listener
        {
        try{
          fileDeleter(); //method that deletes the note
        }
        catch(IOException exc) //prevents the program to crash if IOException happens, and allows it to be compiled
        {
          System.out.println(exc.getStackTrace()); //shows that IOException happened
        }
      }});
      
    }
    catch(IOException exc) //prevents the program to crash if IOException happens, and allows it to be compiled
    {
      System.out.println(exc.getStackTrace()); //shows that IOException happened
    }
    
  }
  public String noteName(int day, int month, int year) {
    //what this method does is basically it creates the name of the file the note will be saved in
    //according to the which date was selected. For example, if the user has chosen June 9, 2016
    //the name of the file will be 9.5.2016 (notice that it's not 9.6.2016 due to Calendar library)
    StringBuilder empty = new StringBuilder();
    name = empty; //make sure the name of the file starts with an empty name.
    for (int i = 0; i < String.valueOf(day).length(); i++) 
    { 
      name.append(String.valueOf(day).charAt(i)); //the first part of the name of the consists of the day
    } 
    name.append(".");
    for (int i = 0; i < String.valueOf(month).length(); i++) 
    { 
      name.append(String.valueOf(month).charAt(i)); //the second part of the name of the consists of the month
    } 
    name.append(".");
    for (int i = 0; i < String.valueOf(year).length(); i++) 
    { 
      name.append(String.valueOf(year).charAt(i)); //the third part of the name of the consists of the year
    } 
    
    return name.toString(); //returns the name of the file
  }
  public String noteNametxt() {
    //this method add .txt at the end of the name of the file, since the program recognize the file as such.
    StringBuilder nametxt = new StringBuilder();
    for (int i = 0; i < name.length(); i++) 
    { 
      nametxt.append(name.charAt(i)); 
    } 
    nametxt.append(".txt"); //add .txt at the end of the name of the file (ex. 9.5.2016.txt)
    
    return nametxt.toString();
  }
  public String fileOpener() throws IOException {
    //this method checks if a note has already exists for this day, and if it has, it demonstrates the note in text area
    try{
      //this find the note already saved,
      StringTokenizer tokenizer;
      BufferedReader inFile = new BufferedReader(new FileReader(noteNametxt()));
      String savedLines;
      while ((savedLines = inFile.readLine()) != null) 
      {
        savedNotes = savedNotes + savedLines + "\n";
      }
      return savedNotes; //and returns what was saved with savedNotes
    }
    catch(Exception exc)
    {
      //if no note exists,
      savedNotes = "";
      return savedNotes; //it returns empty
    }
  }
  public void fileConvertor(String content)throws IOException {
    //this method saves the file and closes the frame
    PrintWriter outFile =  new PrintWriter(new FileWriter(noteNametxt()));
    outFile.println(content); //gets what was written in text area
    outFile.close();
    noteFrame.setVisible(false);
    CalendarFrame calFra = new CalendarFrame();
    calFra.refresh(); //refreshes the CalendarFrame to show that day yellow
  }
  public void fileDeleter()throws IOException {
    //this method deletes the file (it actually only deletes the note, not the file) and closes the frame
    PrintWriter deleter = new PrintWriter(noteNametxt());
    deleter.print("");
    deleter.close();
    noteFrame.setVisible(false);
    CalendarFrame calFra = new CalendarFrame();
    calFra.refresh(); //refreshes the CalendarFrame to show that day not yellow anymore.
  }
}