# ScheduleCreator
## This repository has my solution for my mom's scheduling problem

This code is designed to solve my mom's scheduling problem. Below, I will explain the constraints.

There are two main types of main.staff my mom has to create schedules for:
  * Medical Assistants
  * Auxiliary Staff (Janitor, Nurses, Stretch Bearers)

Stretch Bearers can work only during the day shift. 
Medical Assistants must work at least 3 night shifts and at least 3 afternoon shifts.

During weekdays, there are three shifts of 8 hours:
  * morning shift 6AM-2PM
  * afternoon shift 2PM-10PM
  * night shift 10PM-6APM

During weekends, there are only 2 shifts of 12 hours:
  * morning shift 7AM-7PM
  * night shift 7PM-7AM
  
During every morning shift, there has to be:
  * 5 auxiliary main.staff members 
  * 7 nurses

During every afternoon shift, there has to be: 
  * 4 auxiliary main.staff members 
  * 4 nurses

During every night shift, there has to be:
  * 2 auxiliary main.staff members 
  * 2 nurses


If any main.staff, auxiliary or a medical assistant, worked a night shift, then the next two days are free (meaning the day they finish their shift and the following one). 
