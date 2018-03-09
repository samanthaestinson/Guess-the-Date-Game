package GuessMaster;
import java.util.Scanner;

/**
*<h1>Guess Master!</h1>
*This is the class used by GuessMaster. 
* <p>
* 
*279 Assignment 1
* @author  Samantha Stinson 20009335
* @version 1.0
* @since   2018-02-11 
*/

public class Date
{	
	//instance variables
    private String month;
    private int day;
    private int year;

    //Constructor: initializes
    public Date()
    {
        month = "January";
        day = 1;
        year = 1000;
    }
    
    //Constructor: sets date
    public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

  //Constructor: sets date
    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    //Constructor: sets date
    public Date(int year)
    {
        setDate(1, 1, year);
    }

    //Constructor: sets date
    public Date(Date aDate)
    {
        if (aDate == null)
        {
             System.out.println("Fatal Error.\nNot a real date.");
             System.exit(0);
        }
        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }
    
    /**
    * This method splits the incoming string
    * @param strDate The string that will be split into 3 variables; day, month, year
    */
    public Date(String strDate) 
    {
	    	String date = strDate;
	    	
	    	//calls function to check how to split the string
	    	String splitMethod=howToSplitInput(date);    	
		String[] words = date.split(splitMethod);
		
		//if the length is greater than 2 characters then it must be a string 
		//the smallest string for month is May=3 characters
		if (words[0].length()>2) {
			String monthString= words[0];
			int daysInt =Integer.parseInt(words[1]);
			int yearsInt =Integer.parseInt(words[2]);
			setDate(monthString, daysInt, yearsInt);
		}
		else {
			int monthsInt =Integer.parseInt(words[0]);
			int daysInt =Integer.parseInt(words[1]);
			int yearsInt =Integer.parseInt(words[2]);
			setDate(monthsInt,daysInt,yearsInt);
		}
    }
    
    //mutator
    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error. \nNot a real date.");
            System.exit(0);
            
        }
    }
    
    //mutator
    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error. \nNot a real date.");
            System.exit(0);
        }
    }
    
    //mutator
    public void setDate(int year)
    {
        setDate(1, 1, year);
    }
    
  //mutator
    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error. \nNot a real year.");
            System.exit(0);
        }
        else
            this.year = year;
    }
    
  //mutator
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error. \nNot a real month.");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

  //mutator
    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error. \nNot a real day.");
            System.exit(0);
        }
        else
            this.day = day;
    }

    //Accessor
    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error.\n Not a real month, cant run cases 1.");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    //Accessor
    public int getDay( )
    {
        return day;
    }

    //Accessor
    public int getYear( )
    {
        return year;
    }
    
    public String toString( )
    {
        return (month + " " + day + ", " + year);

    }
    
    public boolean equals(Date otherDate)
    {
        return ( (month.equals(otherDate.month))
                  && (day == otherDate.day) && (year == otherDate.year) );
    }
    
    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

    //told not to use
    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
            System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
    }
    
    /**
     * This method checks if valid date
     * @param monthInt integer value for month
     * @param dayInt integer value for day
     * @param yearInt integer value for year
     * @return boolean
     */
    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }
    
    /**
     * This method checks if valid date. 
     * Calls monthOk to check if month string is valid
     * @param monthString string value for month
     * @param dayInt integer value for day
     * @param yearInt integer value for year
     * @return boolean
     */
    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }
    
    /**
     * This method checks if valid month. 
     * @param month string value for month
     * @return boolean
     */
    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December"));
    }
    
    /**
     * This method returns string for month. 
     * @param monthNumber integer value for month
     * @return string
     */
    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error. \n Not a real month, cant run cases.");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }

/**
 * This splits the date based on specific formatting 
 * @param date string containing year, month and day
 * @return splitWith the character to split by
 */
public String howToSplitInput (String date){
	String splitWith= "/";
	if (date.contains("/")) {
		splitWith= "/";
	}
	if (date.contains(",")){
		splitWith=  ",";
	}
	if (date.contains(".")){
		splitWith=  "\\.";
	}
	if (date.contains(" ")){
		splitWith=  " ";
	}
    return splitWith;
	}
}
