package src;
import java.util.Date;

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
