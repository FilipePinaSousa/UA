package aula05;

public class DateYMD  {
    private int day;
    private int month;
    private int year;

    public DateYMD(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean validMonth(int day,int month){
        return (day > 0 && day <= monthDays(day, month));
    }
    

    public static boolean validYear(int year) {
    return (year > 0);
}

public static boolean validDay(int day, int month, int year) {
    int daysInMonth = monthDays(month, year);
    return (day > 0 && day <= daysInMonth);
}

    public static int monthDays(int month, int year) {
        int[] daysMonth = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                daysMonth[1] = 29;
            } else {
                daysMonth[1] = 28;
            }
        }
        return daysMonth[month - 1];
    }

    public void increment() {
        int days = monthDays(month, year);
        if (day == days) {
            if (month == 12) {
                year++;
                month = 1;
                day = 1;
            } else {
                month++;
                day= 1;
            }
        } else {
            day++;
        }
    }

    public void decrement() {
        if (day == 1) {
            if (month == 1) {
                year--;
                month = 12;
                day = 31;
            } else {
                month--;
                day = monthDays(month, year);
            }
        } else {
            day--;
        }
    }

    public String toString() {
        return String.format("%02d-%02d-%04d", day, month, year);
    }
    public static DateYMD valueOf(String string) {
        return fromString(string);
    }
    


    public int year() {
        return year;
    }
    


    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    
    public int getWeekday() {
        int q = day;
        int m = month;
        int y = year;
        if (m < 3) {
            m += 12;
            y--;
        }
        int k = y % 100;
        int j = y / 100;
        int h = (q + 13*(m+1)/5 + k + k/4 + j/4 + 5*j) % 7;
        return (h + 5) % 7 + 1; 
    }
 
    

    
    public static DateYMD fromString(String dateStr) {
        String[] parts = dateStr.split("-");
        if (parts.length != 3) {
            return null;
        }
        int year = Integer.parseInt(parts[2]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[0]);
        if (!validMonth(day, month) || !validYear(year)) {
            return null;
        }
        return new DateYMD(year, month, day);
    }

    public static String validMonth(DateYMD dataNasc) {
        return null;
    }

}