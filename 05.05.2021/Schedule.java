import java.util.Date;

public class Schedule implements Comparable<Schedule>{
    private Date date;
    private String process;

    public Schedule(Date date, String process){}

    @Override
    public int compareTo(Schedule o) {
        return 0;
    }
}
