package nl.matchinglink.showyourskills.service;

import nl.matchinglink.showyourskills.domain.AstronomicalZodiac;
import nl.matchinglink.showyourskills.domain.ChristmasDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class DatesService {
    public boolean isLeapYear(LocalDate theDate) {
        return theDate.isLeapYear();
    }

    public int getDayNumberOfYear(LocalDate theDate) {
        return theDate.getDayOfYear();
    }

    public int getWeekNumberInGregorianCalendar(LocalDate theDate) {
        GregorianCalendar calendar =
                new GregorianCalendar(theDate.getYear(), theDate.getMonthValue()-1, theDate.getDayOfMonth());
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public long getDaysNumberBetweenNow(LocalDate theDate) {
        LocalDate now = LocalDate.now();
        return ChronoUnit.DAYS.between(theDate, now);
    }

    public ChristmasDto getChristmasInfos(LocalDate theDate) {
        LocalDate catholicChristmas = LocalDate.of(theDate.getYear(), 12, 25);

        if(theDate.isAfter(catholicChristmas)) {
            catholicChristmas = catholicChristmas.withYear(theDate.getYear() + 1);
        }

        LocalDate orthodoxChristmas = LocalDate.of(theDate.getYear(), 1, 7);
        if(theDate.isAfter(orthodoxChristmas)) {
            orthodoxChristmas = orthodoxChristmas.withYear(theDate.getYear() + 1);
        }

        return new ChristmasDto(ChronoUnit.DAYS.between(theDate, catholicChristmas),
                ChronoUnit.DAYS.between(theDate, orthodoxChristmas));
    }

    public AstronomicalZodiac getAstronomicalZodiac(LocalDate theDate) {
        return AstronomicalZodiac.toEnum(theDate);
    }
}
