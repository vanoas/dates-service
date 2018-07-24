package nl.matchinglink.showyourskills;

import nl.matchinglink.showyourskills.domain.AstronomicalZodiac;
import nl.matchinglink.showyourskills.domain.ChristmasDto;
import nl.matchinglink.showyourskills.service.DatesService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class DatesServiceTest {

    private DatesService datesService;

    @Before
    public void setUp() {
        datesService = new DatesService();
    }

    @Test
    public void isLeapYear() {
        assertTrue(datesService.isLeapYear(LocalDate.now().withYear(1996)));
        assertFalse(datesService.isLeapYear(LocalDate.now().withYear(1999)));
    }

    @Test
    public void getDayNumberOfYear() {
        LocalDate theDate = LocalDate.now().withYear(2000).withDayOfYear(3);
        assertEquals(3, datesService.getDayNumberOfYear(theDate));

        theDate = LocalDate.now().withYear(2000).withDayOfYear(356);
        assertEquals(356, datesService.getDayNumberOfYear(theDate));
    }

    @Test
    public void getWeekNumberInGregorianCalendar() {
        LocalDate theDate = LocalDate.now().withYear(2018).withMonth(1).withDayOfMonth(1);
        assertEquals(1, datesService.getWeekNumberInGregorianCalendar(theDate));

        theDate = LocalDate.now().withYear(2018).withMonth(12).withDayOfMonth(1);
        assertEquals(48, datesService.getWeekNumberInGregorianCalendar(theDate));
    }

    @Test
    public void getDaysNumberBetweenNow() {
        LocalDate theDate = LocalDate.now().minusDays(10);
        LocalDate now = LocalDate.now();

        assertEquals(ChronoUnit.DAYS.between(theDate, now), datesService.getDaysNumberBetweenNow(theDate));
    }

    @Test
    public void getChristmasInfos() {
        LocalDate theDate = LocalDate.now().withYear(2000).withMonth(12).withDayOfMonth(1);

        ChristmasDto christmasInfos = datesService.getChristmasInfos(theDate);
        assertEquals(24, christmasInfos.getDaysUntilToCatholic());
        assertEquals(37, christmasInfos.getDaysUntilToOrthodox());
    }

    @Test
    public void getAstronomicalZodiac() {
        LocalDate theDate = LocalDate.now().withMonth(10).withDayOfMonth(17);
        assertEquals(AstronomicalZodiac.VIRGO, datesService.getAstronomicalZodiac(theDate));
    }
}