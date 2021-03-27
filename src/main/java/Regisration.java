import java.util.Scanner;


public class Regisration {
    public static String login_for_sel;
    public static String password_for_sel;
    public static String timecontrol_for_sel;
    public static String timecontrol_page;
    public static int hour_start_for_sel;
    public static int minute_start_for_sel;
    public static int hour_pause_for_sel;
    public static int minute_pause_for_sel;

    public static void reg_user() {
        Scanner input = new Scanner(System.in);
        System.out.println("                                                                                                  \n"+
                           "                                                                                                  \n"+
                           " ▒█████  ▄▄▄█████▓ ██▀███       ██████  ▄████▄   ▄▄▄       ███▄ ▄███▓    ▄▄▄▄    ▒█████  ▄▄▄█████▓\n"+
                           "▒██▒  ██▒▓  ██▒ ▓▒▓██ ▒ ██▒   ▒██    ▒ ▒██▀ ▀█  ▒████▄    ▓██▒▀█▀ ██▒   ▓█████▄ ▒██▒  ██▒▓  ██▒ ▓▒\n"+
                           "▒██░  ██▒▒ ▓██░ ▒░▓██ ░▄█ ▒   ░ ▓██▄   ▒▓█    ▄ ▒██  ▀█▄  ▓██    ▓██░   ▒██▒ ▄██▒██░  ██▒▒ ▓██░ ▒░\n"+
                           "▒██   ██░░ ▓██▓ ░ ▒██▀▀█▄       ▒   ██▒▒▓▓▄ ▄██▒░██▄▄▄▄██ ▒██    ▒██    ▒██░█▀  ▒██   ██░░ ▓██▓ ░ \n"+
                           "░ ████▓▒░  ▒██▒ ░ ░██▓ ▒██▒   ▒██████▒▒▒ ▓███▀ ░ ▓█   ▓██▒▒██▒   ░██▒   ░▓█  ▀█▓░ ████▓▒░  ▒██▒ ░ \n"+
                           "░ ▒░▒░▒░   ▒ ░░   ░ ▒▓ ░▒▓░   ▒ ▒▓▒ ▒ ░░ ░▒ ▒  ░ ▒▒   ▓▒█░░ ▒░   ░  ░   ░▒▓███▀▒░ ▒░▒░▒░   ▒ ░░   \n"+
                           "  ░ ▒ ▒░     ░      ░▒ ░ ▒░   ░ ░▒  ░ ░  ░  ▒     ▒   ▒▒ ░░  ░      ░   ▒░▒   ░   ░ ▒ ▒░     ░    \n"+
                           "░ ░ ░ ▒    ░        ░░   ░    ░  ░  ░  ░          ░   ▒   ░      ░       ░    ░ ░ ░ ░ ▒    ░      \n"+
                           "    ░ ░              ░              ░  ░ ░            ░  ░       ░       ░          ░ ░           \n"+
                           "                                       ░                                      ░                   ");
        boolean TcString;
        System.out.println("Please enter timecontrol in format - \"TIMECONTROL-?????\"");
        while (true) {
            String timecontrol = input.nextLine();

            TcString = timecontrol.matches("[TIMECONTROL]+[-]+[0-9]+");

            if (TcString) {
                timecontrol_for_sel = timecontrol;
                break;

            } else {
                System.out.println("Please enter timecontrol in format - \"TIMECONTROL-16862\", try again! " + timecontrol);
            }
        }

        System.out.println("Please enter login:");
        String login = input.nextLine();
        System.out.println("Please enter password:");
        String password = input.nextLine();
        System.out.println("Please enter time to start in format - hour minute:");

        while (true) {
            int hour_start = input.nextInt();
            int minute_start = input.nextInt();


            if (hour_start <= 24 && minute_start <= 60) {
                hour_start_for_sel = hour_start;
                minute_start_for_sel = minute_start;
                break;

            } else {
                System.out.println("Please, try again! in format - hour minute: " + "Hour - " + hour_start + " and minute - " + minute_start);
            }
        }


        System.out.println("Please enter time to pause in format - hour minute:");
        while (true) {
            int hour_pause = input.nextInt();
            int minute_pause = input.nextInt();


            if (hour_pause <= 24 && minute_pause <= 60) {
                hour_pause_for_sel = hour_pause;
                minute_pause_for_sel = minute_pause;
                break;

            } else {
                System.out.println("Please, try again! in format - hour minute: " + "Hour - " + hour_pause + " and minute - " + minute_pause);
            }
        }

        System.out.println("Welcome, " + login_for_sel +". "+ timecontrol_for_sel + " was work every weekday!");
        System.out.println("For close press Ctrl + C");
        login_for_sel = login;
        password_for_sel = password;
        timecontrol_page = "https://asfk-support.ru/browse/" + timecontrol_for_sel;


    }


}


