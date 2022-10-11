package baseball;

import baseball.domain.Judgement;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // NumberGenerator numberGenerator = new NumberGenerator();
        // List<Integer> numbers = numberGenerator.createRandomNumbers();
        // System.out.println("numbers = " + numbers);

        Judgement judgement = new Judgement();
        int count = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        System.out.println("count = " + count); // 3
    }
}
