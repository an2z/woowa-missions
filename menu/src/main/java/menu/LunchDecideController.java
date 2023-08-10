package menu;

import static menu.Input.inputCoachName;
import static menu.Input.inputHateMenu;
import static menu.Output.*;

public class LunchDecideController {

    private final LunchDecideService lunchDecideService = new LunchDecideService();

    public void run() {
        outputStartPhrase();
        outputCoachNameInputPhrase();
        lunchDecideService.makeLunchTeam(inputCoachName());

        for (String coachName : lunchDecideService.findCoachNamesOfTeam()) {
            outputHateMenuInputPhrase(coachName);
            String[] hateMenu = inputHateMenu();
            lunchDecideService.addHateMenu(coachName, hateMenu);
        }

        lunchDecideService.decideCategory();
        lunchDecideService.decideLunch();
    }
}
