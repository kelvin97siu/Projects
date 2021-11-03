package ActivityTracker.Records;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Records {
    private LocalDate date;
    private int calorieIdle;
    private Timestamp lastupdate;

    public Records(LocalDate date, int calorieIdle, Timestamp lastupdate) {
        this.date = date;
        this.calorieIdle = calorieIdle;
        this.lastupdate = lastupdate;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCalorieIdle() {
        return calorieIdle;
    }

    public Timestamp getLastupdate() {
        return lastupdate;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCalorieIdle(int calorieIdle) {
        this.calorieIdle = calorieIdle;
    }

    public void setLastupdate(Timestamp lastupdate) {
        this.lastupdate = lastupdate;
    }

    @Override
    public String toString() {
        return "Records{" +
                "date=" + date +
                ", calorieIdle=" + calorieIdle +
                ", lastupdate=" + lastupdate +
                '}';
    }
}

