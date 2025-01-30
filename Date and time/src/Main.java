import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // ways of getting dates

       /*
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String newDate = now.format(formatter);
        System.out.println(newDate);
        */

        /*
        LocalDateTime date1 = LocalDateTime.of(2024,12,25,12,0,0);
        LocalDateTime date2 = LocalDateTime.of(2025,1,1,0,0,0);

        if (date1.isBefore(date2)) {
            System.out.println(date1 +" " + "is before " + date2);
        }
        else if (date1.isAfter(date2)) {
            System.out.println(date1 +" " + "is after " + date2);
        }
         */
    }
}