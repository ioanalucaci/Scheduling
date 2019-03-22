package main;

import java.util.ArrayList;
import java.util.Scanner;

import main.schedulemaker.*;
import main.staff.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner userinput = new Scanner(System.in);

        ArrayList<AuxStaff> staff = new ArrayList<AuxStaff>();
        ArrayList<MedicalAssistant> mastaff = new ArrayList<MedicalAssistant>();

        //this just populates the main.staff and medical assistant main.staff array
        for (int i = 0; i <= 19; i++)
            if (i < 9) staff.add(new Nurse(i));
            else if (i < 14) staff.add(new StretcherBearer(i));
            else staff.add(new Janitor(i));

        for(int i = 0; i < 18; i++)
            mastaff.add(new MedicalAssistant(i));

        MonthSchedule month = getmonth(userinput);
        ScheduleMaker schedule = new ScheduleMaker();
        ScheduleMakerMA scheduleMA = new ScheduleMakerMA();

        schedule.staffSchedule(staff, month);
        scheduleMA.ma_schedule(mastaff, month);

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

    public static MonthSchedule getmonth(Scanner userinput)
    {
        int i;
        int n;

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

        if(userinput.hasNextInt()) n = userinput.nextInt();
        else
            while(true)
            {
                System.out.println("Invalid format. Please try again. Input 'exit' to leave the application.  ");
                String numofdays = userinput.nextLine();
                if(numofdays.equals("exit")) System.exit(0);
                if(userinput.hasNextInt())
                {
                    n = userinput.nextInt();
                    break;
                }
            }
        return new MonthSchedule(i, n);
    }
}