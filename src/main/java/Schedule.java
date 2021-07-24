import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;


public class Schedule extends TimerTask {


    @Override
    public void run() {
        CalendarValid.dateVal();
        System.out.println(CalendarValid.parse_hour_of_day + " " + CalendarValid.parse_min_of_day);
        System.out.print(new Date());
        if (CalendarValid.parse_hour_of_day == Regisration.hour_start_for_sel && CalendarValid.parse_min_of_day == Regisration.minute_start_for_sel) {
            if (CalendarValid.parse_week_day < 7 && CalendarValid.parse_week_day > 1) {
                System.out.println(" Start");
                SeleniumMove.setup();
                SeleniumMove.loginAndStart();

            } else {
                System.out.println(" Today is weekend");
            }

        } else {
            if (CalendarValid.parse_week_day < 7 && CalendarValid.parse_week_day > 1) {
                System.out.println(" Pause");
                SeleniumMove.setup();
                SeleniumMove.loginAndPause();

            } else {
                System.out.println(" Today is weekend");
            }
        }

    }

}

class CalendarValid {
    public static int parse_hour_of_day;
    public static int parse_min_of_day;
    public static int parse_week_day;

    public static void dateVal() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        parse_hour_of_day = now.get(Calendar.HOUR_OF_DAY);
        parse_min_of_day = now.get(Calendar.MINUTE);
        parse_week_day = now.get(Calendar.DAY_OF_WEEK);
    }


    public static void start() {
        CalendarValid.dateVal();
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR_OF_DAY, Regisration.hour_start_for_sel);
        date.set(Calendar.MINUTE, Regisration.minute_start_for_sel);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        if (Regisration.hour_start_for_sel < parse_hour_of_day && Regisration.minute_start_for_sel < parse_min_of_day) {
            if (parse_week_day == 7){
                date.set(Calendar.DAY_OF_WEEK, 2);
            }else {
                date.set(Calendar.DAY_OF_WEEK, parse_week_day + 1);

            }
        }
        timer.schedule(new Schedule(), date.getTime(), 1000 * 60 * 60 * 24);

    }

    public static void pause() {
        CalendarValid.dateVal();
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR_OF_DAY, Regisration.hour_pause_for_sel);
        date.set(Calendar.MINUTE, Regisration.minute_pause_for_sel);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        if (Regisration.hour_start_for_sel < parse_hour_of_day && Regisration.minute_start_for_sel < parse_min_of_day) {
            if (parse_week_day == 7){
                date.set(Calendar.DAY_OF_WEEK, 2);
            }else {
                date.set(Calendar.DAY_OF_WEEK, parse_week_day + 1);

            }
        }
        timer.schedule(new Schedule(), date.getTime(), 1000 * 60 * 60 * 24);
    }

}


