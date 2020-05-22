package day_calculator;
import java.util.Scanner;

public class day_calculator {
    public static void main(String[] args) {
        int year, day, month;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("당신이 알고싶은 날짜의 년도는? : ");
            year = scanner.nextInt();
        } while (year < 1900);
        do {
            System.out.println("당신이 알고싶은 날짜의 달은? : ");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);
        do {
            System.out.println("당신이 알고싶은 날짜의 일은? : ");
            day = scanner.nextInt();
        } while (day < 1 || day > 31);
        
        day_day(year, month, day);
    }
    public static void day_day(int year, int month, int day) {
        char day_week = DayofDate(year, month, day);
        System.out.println(year + "년 " + month + "월 " + day + "일은 " + day_week + "요일이다." );
        
    }
    public static int day_month(int year, int month) {
        int day_month = 0;
        Boolean isLeapYear = ((year % 4 == 0) && (year % 100 !=0)) || year % 400 == 0;
        Boolean is31 = (month == 1) || (month == 3) || (month == 5) || (month == 7)
 || (month == 8) || (month == 10) || (month == 12);
        
        if (isLeapYear && month == 2) {
            day_month = 29;
        } else if (!isLeapYear && month == 2) {
            day_month = 28;
        } else if (is31) {
            day_month = 31;
        } else {
            day_month = 30;
        }
        return day_month;
    }
    public static char DayofDate(int year, int month, int day) {
        char day_week = 0;
        int totalDay = 0;
        for(int i = 1900; i <= year; i++) {
            if (i < year) {
                for(int j = 1; j <= 12; j++) {
                    totalDay += day_month(i, j);
                }
            } else {
                for(int j = 1; j < month; j++) {
                    totalDay += day_month(i, j);
                }
            }
        }
        totalDay += day;
        switch (totalDay % 7) {
        case 0:
            day_week = '일';
            break;
        case 1:
            day_week = '월';
            break;
        case 2:
            day_week = '화';
            break;
        case 3:
            day_week = '수';
            break;    
        case 4:
            day_week = '목';
            break;
        case 5:
            day_week = '금';
            break;
        case 6:
            day_week = '토';
            break;    
        }
        return day_week;
    }
}

