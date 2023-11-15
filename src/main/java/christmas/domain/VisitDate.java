package christmas.domain;

import christmas.utils.Constants;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class VisitDate {
    private static final String DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final LocalDate date;

    private VisitDate(int year, int month, int day) {
        try {
            this.date = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(DATE_ERROR_MESSAGE);
        }
    }

    public static VisitDate makeEventVisitDate(int day) {
        return new VisitDate(Constants.EVENT_YEAR, Constants.EVENT_MONTH, day);
    }

    public boolean isSpecialDay(List<Integer> specialDays) {
        return specialDays.contains(date.getDayOfMonth());
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public int getDaysSinceStart(LocalDate startDate) {
        return date.compareTo(startDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitDate visitDate = (VisitDate) o;
        return Objects.equals(date, visitDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    public LocalDate getDate() {
        return date;
    }
}
