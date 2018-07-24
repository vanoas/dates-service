package nl.matchinglink.showyourskills.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AstronomicalZodiacTest {


    @Test
    public void testConvertDateToEnum() {
        LocalDate date = LocalDate.of(1999, 4, 24);

        AstronomicalZodiac astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.ARIES, astronomicalZodiac);


        date = LocalDate.of(1999, 5, 14);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.TAURUS, astronomicalZodiac);


        date = LocalDate.of(1999, 7, 20);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.GEMINI, astronomicalZodiac);


        date = LocalDate.of(1999, 7, 21);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.CANCER, astronomicalZodiac);


        date = LocalDate.of(1999, 8, 10);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.LEO, astronomicalZodiac);


        date = LocalDate.of(1999, 9, 17);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.VIRGO, astronomicalZodiac);


        date = LocalDate.of(1999, 10, 31);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.LIBRA, astronomicalZodiac);

        date = LocalDate.of(1999, 11, 23);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.SCORPIUS, astronomicalZodiac);


        date = LocalDate.of(1999, 11, 30);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.OPHIUCHUS, astronomicalZodiac);

        date = LocalDate.of(1999, 12, 20);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.SAGITTARIUS, astronomicalZodiac);

        date = LocalDate.of(1999, 1, 20);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.CAPRICORNUS, astronomicalZodiac);

        date = LocalDate.of(1999, 2, 16);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.AQUARIUS, astronomicalZodiac);


        date = LocalDate.of(1999, 3, 12);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.PISCES, astronomicalZodiac);
    }

    @Test
    public void testConvertDateToEnumWhenLeapYear() {
        LocalDate date = LocalDate.of(1996, 4, 24);

        AstronomicalZodiac astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.ARIES, astronomicalZodiac);

        date = LocalDate.of(1996, 3, 11);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.AQUARIUS, astronomicalZodiac);

        date = LocalDate.of(1996, 3, 12);
        astronomicalZodiac = AstronomicalZodiac.toEnum(date);
        assertEquals(AstronomicalZodiac.PISCES, astronomicalZodiac);
    }
}