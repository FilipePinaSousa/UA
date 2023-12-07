package aula05;

import java.util.Arrays;

public class calendario {
    private int year;
    private int firstWeekdayOfYear;
    int[][] events;

    public calendario(int year, int firstWeekdayOfYear) {
        this.year = year;
        this.firstWeekdayOfYear = firstWeekdayOfYear;
        this.events = new int[12][];
        for (int i = 0; i < 12; i++) {
            this.events[i] = new int[DateYMD.monthDays(i + 1, year)];
        }
    }

    public int year() {
        return year;
    }

    public int firstWeekdayOfYear() {
        return firstWeekdayOfYear;
    }

    public int firstWeekdayOfMonth(int month) {
        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += DateYMD.monthDays(i + 1, year);
        }
        return (firstWeekdayOfYear + totalDays) % 7;
    }

    public void addEvent(DateYMD date) {
        if (date != null && date.year() == year) {
            int month = date.getMonth() - 1;
            int day = date.getDay() - 1;
            events[month][day]++;
        }
    }
    

    public void removeEvent(DateYMD date) {
        if (date.year() == year) {
            int month = date.getMonth() - 1;
            int day = date.getDay() - 1;
            events[month][day]--;
            if (events[month][day] < 0) {
                events[month][day] = 0;
            }
        }
    }

    public String printMonth(int month) {
        StringBuilder sb = new StringBuilder();
        sb.append(getMonthName(month)).append(" ").append(year).append("\n");
        sb.append("Su Mo Tu We Th Fr Sa\n");
        int firstWeekday = firstWeekdayOfMonth(month);
        char[] spaces = new char[firstWeekday * 3];
        Arrays.fill(spaces, ' ');
        sb.append(spaces);
        int numDays = DateYMD.monthDays(month, year);
        
        
        for (int i = 1; i <= numDays; i++) {
            int numEvents = events[month - 1][i - 1];
            if (numEvents > 0) {
                sb.append("*");
            } else {
                sb.append(" ");
            }
            sb.append(String.format("%2d", i));
            sb.append(" ");
            if ((i + firstWeekday) % 7 == 0 || i == numDays) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }


    public void printCalendario() {
        for (int month = 1; month <= 12; month++) {
            printMonth(year);
            System.out.println();
        }
    }
   
    public static String getMonthName(int month) {
        switch (month) {
            case 1: return "Janeiro";
            case 2: return "Fevereiro";
            case 3: return "Março";
            case 4: return "Abril";
            case 5: return "Maio";
            case 6: return "Junho";
            case 7: return "Julho";
            case 8: return "Agosto";
            case 9: return "Setembro";
            case 10: return "Outubro";
            case 11: return "Novembro";
            case 12: return "Dezembro";
            default: return null;
        }
    }
    
    
    public static int getMonthDays(int month, int year) {
        return DateYMD.monthDays(month, year);
    }
}