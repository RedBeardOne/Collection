package Phone;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;

public class Callog {
    private String number;
    private  LocalDateTime dateCall;
    private Duration time;

    public Callog(String number, LocalDateTime dateCall, Duration time) {
        this.number = number;
        this.dateCall = dateCall;
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getDateCall() {
        return dateCall;
    }

    public Duration getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Callog callog = (Callog) o;

        if (number != null ? !number.equals(callog.number) : callog.number != null) return false;
        if (dateCall != null ? !dateCall.equals(callog.dateCall) : callog.dateCall != null) return false;
        return time != null ? time.equals(callog.time) : callog.time == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result =  result + (dateCall != null ? dateCall.hashCode() : 0);
        result =  result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
