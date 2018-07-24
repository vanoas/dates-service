package nl.matchinglink.showyourskills.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatesControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void checkLeapYearDate() throws Exception {
        mockMvc.perform(get("/api/dates/checkLeapYear")
                .param("date", formatDate(2000, 1, 1))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(true)));
    }

    @Test
    public void getDayNumber() throws Exception {
        mockMvc.perform(get("/api/dates/getDayOfTheYear")
                .param("date", formatDate(2000, 1, 5))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(5)));
    }

    @Test
    public void getWeekNumberInGregorianCalendar() throws Exception {
        mockMvc.perform(get("/api/dates/getWeekNumber")
                .param("date", formatDate(2018, 12, 30))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(1)));
    }

    @Test
    public void getDaysNumberUntilNow() throws Exception {

        LocalDate now = LocalDate.now();
        LocalDate theDate = LocalDate.of(2000, 1, 5);

        mockMvc.perform(get("/api/dates/getDaysUntilNow")
                .param("date", formatDate(2000, 1, 5))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is((int)ChronoUnit.DAYS.between(theDate, now))));
    }

    @Test
    public void getCountDaysToEasters() throws Exception {
        mockMvc.perform(get("/api/dates/getDaysToEasters")
                .param("date", formatDate(2018, 12, 1))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.daysUntilToCatholic", Matchers.is(24)))
                .andExpect(jsonPath("$.daysUntilToOrthodox", Matchers.is(37)));
    }

    @Test
    public void getAstronomicalZodiac() throws Exception {
        mockMvc.perform(get("/api/dates/getAstronomicalZodiac")
                .param("date", formatDate(2000, 1, 5))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is("SAGITTARIUS")));
    }

    private static String formatDate(int year, int month, int dayOfMonth) {
        LocalDate date = LocalDate.now().withYear(year).withMonth(month).withDayOfMonth(dayOfMonth);
        return date.format(DateTimeFormatter.ISO_DATE);
    }
}