class DayOutOfBound extends Exception {
    public DayOutOfBound(String message) {
        super(message);
    }
}

public class App {
    private static final boolean DEV_MODE = false;

    public static void main(String[] args) throws DayOutOfBound {
//        dayInWeek must less than 26: A~Z.

//        Given data:
        int dayInYear = new Integer(args[0]);
        int dayInMonth = new Integer(args[1]);
        int dayInWeek = new Integer(args[2]);
        String[] date = args[3].split("-");

        if (dayInWeek > 26) throw new DayOutOfBound("Day in a week can not be more than 26");


//        parsed date:
        int year = new Integer(date[0]);
        int month = new Integer(date[1]);
        int day = new Integer(date[2]);

        //
        int monthInYear = dayInYear / dayInMonth;

        int remain = dayInYear - monthInYear * dayInMonth;
        int remainInyYearX = ((remain * (year - 1) % dayInMonth) + dayInMonth) % dayInMonth;


        if ((remainInyYearX + remain) >= dayInMonth)
            monthInYear++;

        if (day > dayInMonth || month > monthInYear) {
            System.out.println("-1");
            if (DEV_MODE) {
                System.out.println("dayInMonth: " + dayInMonth);
                System.out.println("monthInYear: " + monthInYear);
            }
            return;
        }

        int numOfDay = (year - 1) * dayInYear + (month - 1) * dayInMonth + day - 1;
        numOfDay -= remainInyYearX;
        int weekDayNum = ((numOfDay % dayInWeek) + dayInWeek) % dayInWeek;
        char weekDayName = (char) ((int) 'A' + weekDayNum);

        System.out.println(weekDayName);
        if (DEV_MODE) System.out.println("weekDayNum = " + weekDayNum);

    }
}