package menu;

import static menu.Input.inputCoachName;
import static menu.Output.outputCoachNameInputPhrase;
import static menu.Output.outputStartPhrase;

public class LunchDecideController {

    private final LunchDecideService lunchDecideService = new LunchDecideService();

    public void run() {
        outputStartPhrase();
        outputCoachNameInputPhrase();
        lunchDecideService.makeLunchTeam(inputCoachName());
    }
}
