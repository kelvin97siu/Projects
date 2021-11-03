package ActivityTracker;

import java.sql.Date;
import java.sql.Timestamp;

public class DateTimeConverter {
    private String year;
    private String month;
    private String day;
    private String hour;
    private String min;
    private String sec;

    public DateTimeConverter(Object value, String type) throws IllegalArgumentException {
        String date = String.valueOf(value);

        if (type != "date" && type != "timestamp"){
            throw new IllegalArgumentException("Invalid Argument type");
        }

        if (value == null){
            year = "0";
            month = "0";
            day = "0";
            hour = "0";
            min = "0";
            sec = "0";
        } else {
            if (type == "date" || type == "timestamp") {
                year = date.substring(0, 4);
                month = date.substring(4, 6);
                day = date.substring(6, 8);
            }
            if (type == "timestamp") {
                hour = date.substring(9, 11);
                min = date.substring(11, 13);
                sec = date.substring(13, 15);
            }
        }
    }

    public Date DateConvert(){
        String dateFormat = String.format("%s-%s-%s", year, month, day);
        Date result = Date.valueOf(dateFormat);
        return result;
    }

    public Timestamp DateTimeConvert(){
        String dateTimeFormat = String.format("%s-%s-%s %s:%s:%s", year, month, day, hour, min, sec);
        Timestamp result = Timestamp.valueOf(dateTimeFormat);
        return result;
    }
}
