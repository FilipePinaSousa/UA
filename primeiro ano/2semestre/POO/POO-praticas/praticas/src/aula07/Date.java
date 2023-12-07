package aula07;

public abstract class Date {
    protected int year = 0;
    protected int month = 0;
    protected int day = 0;
    public abstract void Increment(int increment);
    public abstract void Decrement(int decrement);

    public static boolean ValidDate(int day, int month, int year) {
        if (ValidMonth(month) && day < GetDays(month, year) && year > 0)
            return true;
        else
            return false;
    }

    public static boolean ValidMonth(int month) {
        if (month <= 0 || month > 12)
            return true; // return is swapped because of the do while in DateMain
        else
            return false;
    }
    public static int GetDays(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = daysInMonth[month];
        if (month == 2 && LeapYear(year)) {
            days = 29;
        }
        return days;
    }
    
    public static boolean LeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    


    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public void setDay(int day){
        this.day = day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setYear(int year){
        this.year = year;
    }
}
