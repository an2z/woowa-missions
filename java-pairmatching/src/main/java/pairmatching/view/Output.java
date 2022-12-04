package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Function;
import pairmatching.model.Level;

public class Output {
    private static final String FUNCTION_SELECTION = "기능을 선택하세요.";
    private static final String OPTION_SELECTION = "과정, 레벨, 미션을 선택하세요.";
    private static final String OPTION_SELECTION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String COURSE = "과정";
    private static final String MISSION = "미션";
    private static final String LIST = "  - ";
    private static final String COLON = ": ";
    private static final String SEPARATOR = " | ";
    private static final String SEPARATE_LINE = "#############################################";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printFunctionSelection() {
        System.out.println(FUNCTION_SELECTION);
    }

    public void printFunctionList() {
        for (Function value : Function.values()) {
            System.out.println(value);
        }
    }

    public void printCourse() {
        System.out.println(SEPARATE_LINE);
        System.out.println(COURSE + COLON + makeCourseOutput());
    }

    public void printMission() {
        System.out.println(MISSION + COLON);
        for (Level level : Level.values()) {
            String output = makeMissionOutput(level);
            System.out.println(LIST + output);
        }
        System.out.println(SEPARATE_LINE);
    }

    public void printOptionSelection() {
        System.out.println(OPTION_SELECTION);
        System.out.println(OPTION_SELECTION_EXAMPLE);
    }

    private String makeMissionOutput(Level level) {
        StringBuilder output = new StringBuilder();
        appendLevel(output, level);
        appendMission(output, level);
        return output.toString();
    }

    private void appendLevel(StringBuilder output, Level level) {
        output.append(level.getName()).append(COLON);
    }

    private void appendMission(StringBuilder output, Level level) {
        int count = 0;
        for (String mission : level.getMissions()) {
            if (count != 0) {
                output.append(SEPARATOR);
            }
            output.append(mission);
            count++;
        }
    }

    private String makeCourseOutput() {
        StringBuilder output = new StringBuilder();
        int count = 0;
        for (Course course : Course.values()) {
            if (count != 0) {
                output.append(SEPARATOR);
            }
            output.append(course);
            count++;
        }
        return output.toString();
    }
}
