package nl.matchinglink.showyourskills.domain;

import java.time.LocalDate;

public enum AstronomicalZodiac {

    ARIES(toDate(4, 19), toDate(5,13)),
    TAURUS(toDate(5,14), toDate(5,19)),

    GEMINI(toDate(6,20), toDate(7,20)),
    CANCER(toDate(7,21), toDate(8,9)),

    LEO(toDate(8,10), toDate(9,15)),
    VIRGO(toDate(9,16), toDate(10,30)),

    LIBRA(toDate(10,31), toDate(11,22)),
    SCORPIUS(toDate(11,23), toDate(11,29)),

    OPHIUCHUS(toDate(11,30), toDate(12,17)),
    SAGITTARIUS(toDate(12,18), toDate(1,18)),
    CAPRICORNUS(toDate(1,19), toDate(2,15)),

    AQUARIUS(toDate(2,16), toDate(3,11)), // check leap year
    PISCES(toDate(3,12), toDate(4,18));

    private LocalDate from;
    private LocalDate to;

    AstronomicalZodiac(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    private static LocalDate toDate(int monthOfYear, int dayOfMonth) {
        return LocalDate.of(2000, monthOfYear, dayOfMonth);
    }

    public static AstronomicalZodiac toEnum(LocalDate theDate) {

        for (AstronomicalZodiac astronomicalZodiac: values()) {
            LocalDate fromWithYear = astronomicalZodiac.from.withYear(theDate.getYear());
            LocalDate toWithYear = astronomicalZodiac.to.withYear(theDate.getYear());

            if (theDate.getMonthValue() == 12 && AstronomicalZodiac.SAGITTARIUS.equals(astronomicalZodiac)) {
                toWithYear = toWithYear.plusYears(1);
            } else if (theDate.getMonthValue() == 1 && AstronomicalZodiac.SAGITTARIUS.equals(astronomicalZodiac)) {
                fromWithYear = fromWithYear.minusYears(1);
            }

            if ((fromWithYear.isBefore(theDate) || fromWithYear.isEqual(theDate))
                    && (toWithYear.isAfter(theDate) || toWithYear.isEqual(theDate))) {
                return astronomicalZodiac;
            }
        }

        throw new IllegalArgumentException("Invalid argument: " + theDate);
    }

}
