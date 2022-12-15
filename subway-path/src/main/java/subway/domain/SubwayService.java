package subway.domain;

public class SubwayService {
    private StandardCommand standard;

    public boolean isStart(String command) {
        return MainCommand.find(command).isLookup();
    }

    public void choiceStandard(String command) {
        standard = StandardCommand.find(command);
    }
}
