package domain;

public class LadderHeight {
    public static final int MIN_HEIGHT = 1;
    public static final String HEIGHT_ERROR = String.format("최소 %d개 이상의 높이가 필요합니다.", MIN_HEIGHT);

    private final int height;

    public LadderHeight(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR);
        }
    }
}
