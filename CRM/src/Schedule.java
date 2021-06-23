package src;
import java.util.Date;
import java.util.Objects;

public class Schedule implements Comparable<Schedule> {

    private Date date;
    private String process;


    public Schedule(Date date, String process) {
        this.date = date;
        this.process = process;
    }

    @Override
    public int compareTo(Schedule o) {
        if(date.compareTo(o.date) == 0)
            return 0;
        if(date.compareTo(o.date) > 0)
            return 1;
        else
            return -1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return date.equals(schedule.getDate()) && process.equals(schedule.getProcess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, process);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }


}
