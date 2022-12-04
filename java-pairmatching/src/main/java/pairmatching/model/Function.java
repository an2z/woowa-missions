package pairmatching.model;

public enum Function {
    MATCHING("1"),
    FIND("2"),
    INIT("3"),
    QUIT("Q");

    private String sign;

    Function(String sign) {
        this.sign = sign;
    }
}
