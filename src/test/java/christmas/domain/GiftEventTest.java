package christmas.domain;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

class GiftEventTest {
    GiftEvent giftEvent;

    @BeforeEach
    void setUp() {
        giftEvent = new GiftEvent(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 31)
        );
    }
}
