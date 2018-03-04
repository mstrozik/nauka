package str.mat;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.Iterator;
import str.mat.model.Calendar;
import static org.testng.Assert.assertEquals;

public class CalendarTest {

    private Calendar calendar;

    @BeforeTest
    public void setup(){
        LocalDate startLocalDate = LocalDate.of(2016, 9,19);
        LocalDate endLocalDate = LocalDate.of(2016, 9,30);
        calendar = new Calendar(startLocalDate, endLocalDate);
    }

    @Test
    public void calendarIteratorTest(){
        Iterator<LocalDate> it = calendar.iterator();

        assertEquals(it.next(), LocalDate.of(2016, 9,20));
        assertEquals(it.next(), LocalDate.of(2016, 9,23));
        assertEquals(it.next(), LocalDate.of(2016, 9,27));
        assertEquals(it.next(), LocalDate.of(2016, 9,30));

        assertEquals(it.hasNext(), false);
    }
}
