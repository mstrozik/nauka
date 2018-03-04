package str.mat.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Calendar implements Iterable<LocalDate> {

    private final LocalDate startDate, endDate;
    private LocalDate lastReturnedDate;

    private static final int NEXT_DAY = 1;
    private static final List<DayOfWeek> DAYS = Arrays.asList(DayOfWeek.TUESDAY, DayOfWeek.FRIDAY);

    public Calendar(LocalDate startDate){
        this.startDate = startDate;
        this.endDate = LocalDate.now();
    }

    public Calendar(LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Iterator<LocalDate> iterator() {
        return new Iterator<LocalDate>() {
            @Override
            public boolean hasNext() {
                return getNextDay().isBefore(endDate.plusDays(NEXT_DAY));
            }
            @Override
            public LocalDate next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                lastReturnedDate = getNextDay();
                return lastReturnedDate;
            }
        };
    }

    private LocalDate getNextDay(){
        LocalDate nextDate = (lastReturnedDate != null) ? lastReturnedDate.plusDays(NEXT_DAY) : startDate;
        while (!(DAYS.contains(nextDate.getDayOfWeek()))){
            nextDate = nextDate.plusDays(NEXT_DAY);
        }
        return nextDate;
    }
}