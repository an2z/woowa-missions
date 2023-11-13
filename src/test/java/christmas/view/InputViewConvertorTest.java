package christmas.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class InputViewConvertorTest {
    InputViewConvertor convertor = new InputViewConvertor();

    @DisplayName("입력된 값을 Map(메뉴 이름:주문 개수) 형식으로 변환한다.")
    @Test
    void convertOrderInfo() {
        //given
        String input = "해산물파스타-1,레드와인-1,초코케이크-1";

        //whe
        Map<String, Integer> map = convertor.convertToValidatedOrderInfo(input);

        //then
        assertThat(map).hasSize(3);
        assertThat(map).contains(
                entry("해산물파스타", 1),
                entry("레드와인", 1),
                entry("초코케이크", 1)
        );
    }
}
