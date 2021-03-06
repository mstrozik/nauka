package str.mat;

import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

import str.mat.model.Calendar;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class CalendarTest {

    @Test
    public void iteratorTest(){
        Iterator<LocalDate> it = getIterator(19);

        assertEquals(it.next(), getLocalDate(20));
        assertEquals(it.next(), getLocalDate(23));
        assertEquals(it.next(), getLocalDate(27));
        assertEquals(it.next(), getLocalDate(30));
    }

    @Test
    public void marginalValuesTest(){
        Iterator<LocalDate> it = getIterator(19, 19);
        assertFalse(it.hasNext());

        it = getIterator(24, 26);
        assertFalse(it.hasNext());

        it = getIterator(20, 20);
        assertEquals(it.next(), getLocalDate(20));
        assertFalse(it.hasNext());

        it = getIterator(20, 23);
        assertEquals(it.next(), getLocalDate(20));
        assertEquals(it.next(), getLocalDate(23));
        assertFalse(it.hasNext());

        it = getIterator(19, 24);
        assertEquals(it.next(), getLocalDate(20));
        assertEquals(it.next(), getLocalDate(23));
        assertFalse(it.hasNext());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void noSuchElementTest(){
        Iterator<LocalDate> it = getIterator(19, 19);
        it.next();
    }

    private Iterator<LocalDate> getIterator(int fromDayOfMonth){
        Calendar calendar = new Calendar(getLocalDate(fromDayOfMonth));
        return calendar.iterator();
    }

    private Iterator<LocalDate> getIterator(int fromDayOfMonth, int toDayOfMonth){
        Calendar calendar = new Calendar(getLocalDate(fromDayOfMonth), getLocalDate(toDayOfMonth));
        return calendar.iterator();
    }

    private LocalDate getLocalDate(int day){
        return LocalDate.of(2016, 9, day);
    }
}
