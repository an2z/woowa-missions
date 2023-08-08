package menu;

import static menu.Input.inputCoachName;
import static menu.Output.outputCoachNameInputPhrase;
import static menu.Output.outputStartPhrase;

public class LunchDecideController {

    public void run() {
        outputStartPhrase();
        outputCoachNameInputPhrase();
        inputCoachName();
    }
}
