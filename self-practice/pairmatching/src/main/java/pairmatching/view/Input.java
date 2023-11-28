package pairmatching.view;

import pairmatching.model.Function;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public String readFunction() {
        System.out.println("기능을 선택하세요.");
        Arrays.stream(Function.values()).forEach(System.out::println);
        return read();
    }

    public List<String> readMatchingInfo() {
        System.out.println("\n#############################################\n" +
                "과정: 백엔드 | 프론트엔드\n" +
                "미션:\n" +
                "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
                "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
                "  - 레벨3: \n" +
                "  - 레벨4: 성능개선 | 배포\n" +
                "  - 레벨5: \n" +
                "############################################\n" +
                "과정, 레벨, 미션을 선택하세요.\n" +
                "ex) 백엔드, 레벨1, 자동차경주");
        return convertToList(read());
    }

    private List<String> convertToList(String input) {
        return Arrays.stream(input.split(", "))
                .toList();
    }

    private String read() {
        return readLine();
    }
}
