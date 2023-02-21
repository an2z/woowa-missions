package domain;

import java.util.Objects;

public class Height {
    public static final int MIN_HEIGHT = 1;
    public static final String HEIGHT_ERROR = String.format("최소 %d개 이상의 높이가 필요합니다.", MIN_HEIGHT);

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Height that = (Height) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    public int getHeight() {
        return height;
    }
}
