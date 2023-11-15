package christmas.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewConvertorTest {
    InputViewConvertor convertor = new InputViewConvertor();

    @DisplayName("입력된 값을 숫자 형식으로 변환한다.")
    @Test
    void convertDate() {
        int result = convertor.convertToValidatedDate("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("입력된 값을 주문 정보 리스트 형식으로 변환한다.")
    @Test
    void convertOrderInfo() {
        List<String[]> result = convertor.convertToValidatedOrderInfos("해산물파스타-1,레드와인-1,초코케이크-1");
        assertThat(result).hasSize(3)
                .containsExactly(
                        new String[]{"해산물파스타", "1"},
                        new String[]{"레드와인", "1"},
                        new String[]{"초코케이크", "1"}
                );
    }
}
