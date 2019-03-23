package main;

import java.util.ArrayList;
import java.util.Scanner;

import main.schedulemaker.*;
import main.staff.*;

/**
 * @author Ioana Iulia Lucaci
 */
class Main
{
    public static void main(String[] args)
    {
        Scanner userinput = new Scanner(System.in);

        ArrayList<Staff> staff = new ArrayList<Staff>();
        ArrayList<MedicalAssistant> mastaff = new ArrayList<MedicalAssistant>();

        //this just populates the main.staff and medical assistant main.staff array
        for (int i = 0; i <= 19; i++)
            if (i < 9) staff.add(new Nurse(i));
            else if (i < 14) staff.add(new StretcherBearer(i));
            else staff.add(new Janitor(i));

        for(int i = 0; i < 20; i++)
            mastaff.add(new MedicalAssistant(i));

        MonthSchedule month = getmonth(userinput);
        ScheduleMaker schedule = new ScheduleMaker();
        ScheduleMakerMA scheduleMA = new ScheduleMakerMA();

        schedule.staffSchedule(staff, month);
        scheduleMA.scheduleMA(mastaff, month);

        System.out.println("Schedules are finished! What would you like to print?");
        while(true)
        {
            String input = userinput.nextLine();
            if (input.equals("exit")) System.exit(0);
            else if(input.equals("1")) System.out.println(month.staffString());
            else if(input.equals("2")) System.out.println(month.maString());
            else if(input.equals("3")) System.out.println(month.toString());
            else System.out.println("\n 1) Auxiliary Staff Schedule \n 2) Medical Assistant Schedule \n 3) Both Schedules \nInput 'exit' if you want to finish.\n ");
        }
    }

    /**
     * This method is used to take the user input to decide how to create the month, based on how many days it has and the first day of the month.
     * @param userinput is the scanner that records the user input
     * @return MonthSchedule this returns the month created based on the user input
     */
    public static MonthSchedule getmonth(Scanner userinput)
    {
        int i = 0;
        int n = 30;

        String [] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        while(true)
        {
            System.out.println("Please input the first day of the month: ");
            String startday = userinput.nextLine();
            if(startday.equals("exit")) System.exit(0);
            for(i = 0; i < 7; i ++)
                if(week[i].equals(startday))
                    break;
            if( i < 7) break;
            System.out.println("Invalid name. Please try again. Input 'exit' to leave the application. ");
        }

        System.out.println("Please input the number of days this month has: ");

        if(userinput.hasNextInt())
        {
            n = userinput.nextInt();
            if(!(n == 30 || n == 28 || n == 31))
                n = recursivenumber(userinput);
        }
        return new MonthSchedule(i, n);
    }

    /**
     * This function is used to continuously asks the user for an adequate number of days in a month.
     * @param userinput is the scanner that records the user input
     * @return int this is the number of days in the month
     */
    public static int recursivenumber(Scanner userinput)
    {
        int n;
        while(true)
        {
            System.out.println("Please try again. Input 'exit' to leave the application.  ");
            String numofdays = userinput.nextLine();
            if(numofdays.equals("exit")) System.exit(0);
            if(userinput.hasNextInt())
            {
                n = userinput.nextInt();
                if(n == 30 || n == 28 || n == 31) break;
            }
        }
        return n;
    }
}