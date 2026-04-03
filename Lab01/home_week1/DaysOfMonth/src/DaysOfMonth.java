import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = -1, year = -1;

        while (true) {
            System.out.print("Enter month: ");
            String mInput = sc.next().trim();
            System.out.print("Enter year: ");
            String yInput = sc.next().trim();

            month = getMonth(mInput);
            try {
                year = Integer.parseInt(yInput);
            } catch (Exception e) { year = -1; }

            if (month != -1 && year >= 0) break;
            System.out.println("Invalid month/year. Try again!");
        }

        int days = getDaysInMonth(month, year);
        System.out.println("Days: " + days);
        sc.close();
    }

    private static int getMonth(String input) {
        String[][] data = {
            {"1", "January", "Jan.", "Jan"},
            {"2", "February", "Feb.", "Feb"},
            {"3", "March", "Mar.", "Mar"},
            {"4", "April", "Apr.", "Apr"},
            {"5", "May", "May", "May"},
            {"6", "June", "June", "Jun"},
            {"7", "July", "July", "Jul"},
            {"8", "August", "Aug.", "Aug"},
            {"9", "September", "Sept.", "Sep"},
            {"10", "October", "Oct.", "Oct"},
            {"11", "November", "Nov.", "Nov"},
            {"12", "December", "Dec.", "Dec"}
        };
        for (int i = 0; i < 12; i++) {
            for (String s : data[i]) {
                if (input.equalsIgnoreCase(s)) return i + 1;
            }
        }
        return -1;
    }

    private static int getDaysInMonth(int m, int y) {
        switch (m) {
            case 4: case 6: case 9: case 11: return 30;
            case 2:
                if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) return 29;
                else return 28;
            default: return 31;
        }
    }
}