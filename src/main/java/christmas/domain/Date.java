package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Date {
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 31;
    private static final String DAY_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private int day;

    public Date(int day) {
        validate(day);
        this.day = day;
    }

    private void validate(int day) {
        if (day < FIRST_DAY || day > LAST_DAY) {
            throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
        }
    }

    public boolean isEventPeriod(int startDate, int endDate) {
        return day >= startDate && day <= endDate;
    }

    public boolean isSpecialDay(List<Integer> specialDays) {
        return specialDays.contains(day);
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = LocalDate.of(2023, 12, day).getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public int getDayGap(int day) {
        return this.day - day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }

    public int getDay() {
        return day;
    }
}
