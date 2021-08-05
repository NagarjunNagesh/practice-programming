package hackerrank.timeconversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock. -
 * 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock. Example
 * 
 * Return '12:01:00'.
 * 
 * Return '00:01:00'. Function Description Complete the timeConversion function
 * in the editor below. It should return a new string representing the input
 * time in 24 hour format. timeConversion has the following parameter(s): string
 * s: a time in hour format Returns string: the time in hour format Input Format
 * A single string that represents a time in -hour clock format (i.e.: or ).
 * Constraints All input times are valid Sample Input 07:05:45PM Sample Output
 * 19:05:45
 * 
 * Time Complexity O(1)
 */
public class TimeConversion {
    public static void main(String[] args) {
        String militaryFormat = timeConversion("12:01:45PM");
        System.out.printf("%s%n", militaryFormat);
        String militaryFormat2 = timeConversion("12:01:45AM");
        System.out.printf("%s%n", militaryFormat2);
        String militaryFormat3 = timeConversion("1:01:45AM");
        System.out.printf("%s%n", militaryFormat3);
    }

    public static String timeConversion(String s) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        Date inputDate;
        try {
            inputDate = inputFormat.parse(s);
            String militaryFormat = displayFormat.format(inputDate);
            return militaryFormat;
        } catch (ParseException e) {
            System.out.printf("%s%n", e);
        }

        return "";
    }
}
