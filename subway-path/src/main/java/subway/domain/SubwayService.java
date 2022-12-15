package subway.domain;

public class SubwayService {
    public boolean isStart(String command) {
        return MainCommand.find(command).isLookup();
    }
}
