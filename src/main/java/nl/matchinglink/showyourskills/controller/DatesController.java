package nl.matchinglink.showyourskills.controller;

import nl.matchinglink.showyourskills.domain.AstronomicalZodiac;
import nl.matchinglink.showyourskills.domain.ChristmasDto;
import nl.matchinglink.showyourskills.service.DatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SuppressWarnings("unused")
@RequestMapping("/api/dates/")
@RestController
public class DatesController {

    @Autowired
    private DatesService datesService;

    @GetMapping("checkLeapYear")
    public ResponseEntity<Boolean> checkLeapYearDate(@RequestParam(name = "date")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate theDate) {
        return ResponseEntity.ok(datesService.isLeapYear(theDate));
    }

    @GetMapping("getDayOfTheYear")
    public ResponseEntity<Integer> getDayNumber(@RequestParam(name = "date")
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate theDate) {
        return ResponseEntity.ok(datesService.getDayNumberOfYear(theDate));
    }

    @GetMapping("getWeekNumber")
    public ResponseEntity<Integer> getWeekNumberInGregorianCalendar(@RequestParam(name = "date")
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate theDate) {
        int weekNumber = datesService.getWeekNumberInGregorianCalendar(theDate);
        return ResponseEntity.ok(weekNumber);
    }

    @GetMapping("getDaysUntilNow")
    public ResponseEntity<Long> getDaysNumberUntilNow(@RequestParam(name = "date")
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate theDate) {

        long between = datesService.getDaysNumberBetweenNow(theDate);
        return ResponseEntity.ok(between);
    }

    @GetMapping("getDaysToEasters")
    public ResponseEntity<ChristmasDto> getCountDaysToEasters(@RequestParam(name = "date")
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate theDate) {

        ChristmasDto christmasDto = datesService.getChristmasInfos(theDate);
        return ResponseEntity.ok(christmasDto);
    }

    @GetMapping("getAstronomicalZodiac")
    public ResponseEntity<AstronomicalZodiac> getAstronomicalZodiac(@RequestParam(name = "date")
                                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate theDate) {

        AstronomicalZodiac astronomicalZodiac = datesService.getAstronomicalZodiac(theDate);
        return ResponseEntity.ok(astronomicalZodiac);
    }

}
