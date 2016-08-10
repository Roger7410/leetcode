import java.util.HashMap;

/**
 * Created by JOKER on 8/1/16.
 */
public class CodeFightsFirstCompany {
    public static String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
        String[] result = new String[n];
        HashMap<String,Integer> days = new HashMap<>();
        days.put("Sunday",     0);
        days.put("Monday",     1);
        days.put("Tuesday",    2);
        days.put("Wednesday",  3);
        days.put("Thursday",   4);
        days.put("Friday",     5);
        days.put("Saturday",   6);
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] daysInWeeks = {"Monday","Tuesday","Wednesday","Thursday",
                "Friday","Saturday","Sunday"};
        String firstDay = firstDate.substring(0,2);
        String firstMonth = firstDate.substring(3,5);
        String firstYear = firstDate.substring(6);

        //get first data is which day in a week
        //01/01/1900 is Monday
        //deal with years
        int defaultYear = 1900;
        int thisYear    = Integer.parseInt(firstYear);
        int thisMonth   = Integer.parseInt(firstMonth);
        int thisDay     = Integer.parseInt(firstDay);
        int years       = thisYear-defaultYear;
        int totalDays   = 0;

        totalDays     = years*365;
        int leapYears = years/4;
        int tmpYear   = 2000;
        while(thisYear>=tmpYear){
            leapYears--;
            tmpYear+=100;
            if(tmpYear%400 == 0){
                leapYears++;
            }
        }
        totalDays    += leapYears;

        boolean isLeapYear = thisYear%400 == 0 || thisYear%4 == 0 && thisYear%100 !=0;
        //if it is before Feb and is leap year, total --
        if(Integer.parseInt(firstMonth)<=2 && isLeapYear){
            totalDays--;
        }
        //deal with months
        for(int m=0; m<thisMonth-1; m++){
            totalDays += monthDays[m];
        }
        //deal with days
        totalDays += thisDay;

        int firstDaysOfWeek = totalDays%7;
        String today = daysInWeeks[firstDaysOfWeek];

        //re-order the daysOfTheWeeks use nums instead of Strings
        int start = 0;
        for(int d=0; d<daysOfTheWeek.length; d++){
            if(daysOfTheWeek[d].equals(today)){
                start = d;
            }
        }
        //init int days of the weeks, if before today + 7
        int[] intDOTW = new int[daysOfTheWeek.length];
        for(int i = 0; i<intDOTW.length-start; i++){
            intDOTW[i] = days.get(daysOfTheWeek[start+i]);
        }
        for(int i = intDOTW.length-start;i<intDOTW.length;i++){
            intDOTW[i] = days.get(daysOfTheWeek[(start+i)%intDOTW.length])+7;
        }
        //init int gap days of the days in intDOTW
        int[] gapDOTW = new int[intDOTW.length-1];
        for(int i = 0; i<intDOTW.length-1; i++){
            gapDOTW[i] = intDOTW[i+1]-intDOTW[0];
        }

        // deal with n output
        int skipWeeks = k * 7;
        int skipWeeksSum = 0;
        int monthCarry   = 0;
        int yearCarry    = 0;
        int index = 0;
        while(index<n){
            //firstDate + skipWeeksSum   once!
            int firstintday = thisDay+skipWeeksSum;
            int firstIM     = thisMonth;
            int firstIY     = thisYear;
            //if days > this month days for.ex 30
            //not consider more than 1 leap years now
            isLeapYear = thisYear%400 == 0 || thisYear%4 == 0 && thisYear%100 !=0;
            if(isLeapYear){
                monthDays[1] = 29;
            }else{
                monthDays[1] = 28;
            }
            while(firstintday > monthDays[firstIM-1]){
                firstintday -= monthDays[firstIM-1];
                firstIM++;
                while(firstIM > 12){
                    firstIM -= 12;
                    firstIY++;
                }
            }

            String firststrday;
            String fM;
            String fY;
            if(firstintday < 10){
                firststrday = "0"+Integer.toString(firstintday);
            }else{
                firststrday = Integer.toString(firstintday);
            }
            if(firstIM < 10){
                fM = "0"+Integer.toString(firstIM);
            }else{
                fM = Integer.toString(firstIM);
            }
            fY = Integer.toString(firstIY);
            result[index] = firststrday+"/"+fM+"/"+fY;
            index++;
            //first Date + gap  gap.length times
            for(int i=0; i<gapDOTW.length;i++){
                firstintday = thisDay+skipWeeksSum+gapDOTW[i];
                firstIM     = thisMonth;
                firstIY     = thisYear;
                //if days > this month days for.ex 30
                //not consider leap years now
                while(firstintday > monthDays[firstIM-1]){
                    firstintday -= monthDays[firstIM-1];
                    firstIM++;
                }
                while(firstIM > 12){
                    firstIM -= 12;
                    firstIY++;
                }
                if(firstintday < 10){
                    firststrday = "0"+Integer.toString(firstintday);
                }else{
                    firststrday = Integer.toString(firstintday);
                }
                if(firstIM < 10){
                    fM = "0"+Integer.toString(firstIM);
                }else{
                    fM = Integer.toString(firstIM);
                }
                fY = Integer.toString(firstIY);
                result[index] = firststrday+"/"+fM+"/"+fY;
                index++;
            }
            skipWeeksSum += skipWeeks;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] days = {"Tuesday"};
        recurringTask("31/12/2999",1,days,2);
//        String[] days = {"Monday","Wednesday","Friday","Saturday"};
//        recurringTask("31/12/2014",2,days,4);

    }

}
